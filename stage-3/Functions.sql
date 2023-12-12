
CREATE OR REPLACE FUNCTION shiftRegister (manager INT, employeeIds INT[], conveyorId INT)
RETURNS INT AS $$
DECLARE
    shiftId INT;
    employee INT;
BEGIN
    # Create new shiift
    INSERT INTO workshifts (conveyor_id, time_start) VALUES(conveyorId, current_timestamp) RETURNING id INTO shiftId;
    # Insert manager
    INSERT INTO workshift_employees (employee_id, shift_id, shift_manager) VALUES(manager, shiftId, TRUE);

    FOREACH employee IN ARRAY employeeIds LOOP
        INSERT INTO workshift_employees (employee_id, shift_id) VALUES(employee, shiftId) ON CONFLICT DO NOTHING;
    END LOOP;

    RETURN shiftId;
END
$$ LANGUAGE 'plpgsql';

SELECT shiftRegister(1, '{1, 2, 4}', 3);
SELECT shiftRegister(2, '{2, 3, 4}', 2);

CREATE OR REPLACE FUNCTION getPackagingInfo (batchId INT)
RETURNS TABLE AS $$
BEGIN
    RETURN (
        SELECT 
            b.pelmeni_size, 
            b.summary_mass,
            t.name as pelmeni_name, 
            t.recipe, 
            b.created, 
            f.address as factory_address
        FROM batches b 
        JOIN pelmeni_types t ON b.id = t.type_id
        JOIN workshifts w ON b.shift_id = w.id
        JOIN conveyors c ON w.conveyor_id = c.id
        JOIN factories f ON c.factory_id = f.id
        WHERE b.id = batchId
    );
END
$$ LANGUAGE 'plpgsql';


CREATE OR REPLACE FUNCTION getEmployeesWorkHours(startDate DATE, endDate DATE)
RETURNS TABLE (employee_id INT, shifts_count INT, managered_shifts_count INT, worked_hours INT) 
AS $$
BEGIN   
    RETURN QUERY 
        SELECT 
            we.employee_id as employee_id,
            COUNT(we.shift_id)::INT as shifts_count,
            COALESCE(SUM(we.shift_manager::INT), 0)::INT as managered_shifts_count,
            ROUND(SUM(EXTRACT(EPOCH FROM (s.time_end - s.time_start))) / 3600)::INT as worked_hours
        FROM workshift_employees we
        JOIN workshifts s ON we.shift_id = s.id
        WHERE s.time_start IS NOT NULL
            AND startDate <= s.time_start::DATE 
            AND s.time_end IS NOT NULL 
            AND endDate >= s.time_end::DATE
        GROUP BY we.employee_id;
END 
$$ LANGUAGE 'plpgsql';

SELECT * FROM getEmployeesWorkHours('2023-12-11', '2023-12-12');
