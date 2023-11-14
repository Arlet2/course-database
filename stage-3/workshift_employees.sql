CREATE TABLE IF NOT EXISTS workshift_employees(
    employee_id INT REFERENCES employees ON DELETE CASCADE,
    shift_id INT REFERENCES workshifts ON DELETE CASCADE,
    shift_manager BOOLEAN,
    PRIMARY KEY(employee_id, shift_id)
);