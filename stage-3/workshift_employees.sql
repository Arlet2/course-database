CREATE TABLE IF NOT EXISTS workshift_employees(
    employee_id INT REFERENCES employees ON DELETE CASCADE,
    shift_id INT REFERENCES workshifts ON DELETE CASCADE,
    shift_manager BOOLEAN,
    PRIMARY KEY(employee_id, shift_id)
);

CREATE FUNCTION manager_check() RETURNS trigger AS $manager_check$
    BEGIN
        IF NEW.shift_manager = TRUE AND 
            (SELECT COUNT(*) FROM workshift_employees WHERE shift_id = NEW.shift_id AND shift_manager = TRUE) != 0 THEN
            RAISE EXCEPTION 'on one workshift can be only one manager';
        END IF;
        
        RETURN NEW;
    END;
$manager_check$ LANGUAGE plpgsql;

CREATE TRIGGER manager_tr BEFORE INSERT OR UPDATE ON workshift_employees
    FOR EACH ROW EXECUTE PROCEDURE manager_check();

INSERT INTO workshift_employees
(employee_id, shift_id, shift_manager)
VALUES
(1, 1, true),
(2, 1, NULL),
(3, 1, NULL);
