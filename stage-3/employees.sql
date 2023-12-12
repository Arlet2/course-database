CREATE TABLE IF NOT EXISTS employees(
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    full_name VARCHAR(255) NOT NULL,
    job_title VARCHAR(50),
    employment_date DATE NOT NULL,
    dismissal_date DATE,
    payment_id INT REFERENCES payments_info ON DELETE SET NULL,
    agreement_id INT REFERENCES documents ON DELETE SET NULL
);

INSERT INTO employees
(full_name, job_title, employment_date, dismissal_date)
VALUES 
('Matthew Ivanov Sergeevich', 'director of factory', '2003-02-02', '2023-11-14'),
('Artem Shulga Igorevich', 'intern of production', '2003-02-02', '2023-11-14'),
('Artem Saidaev Bedrosovich', 'software developer', '2004-01-01', '2023-11-14');

INSERT INTO employees
(full_name, job_title, employment_date, dismissal_date, payment_id)
VALUES 
('Alice Mikulina Romanovna', 'senior django developer', '2023-11-15', NULL, 1);

CREATE INDEX ON employees USING HASH(full_name);