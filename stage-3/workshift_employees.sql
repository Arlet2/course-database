CREATE TABLE IF NOT EXISTS workshift_employees(
    employee_id INT REFERENCES employees ON DELETE CASCADE,
    shift_id INT REFERENCES workshifts ON DELETE CASCADE,
    shift_manager BOOLEAN,
    PRIMARY KEY(employee_id, shift_id)
);

INSERT INTO workshift_employees
(employee_id, shift_id, shift_manager)
VALUES
(0, 0, true),
(1, 0, NULL),
(2, 0, NULL);