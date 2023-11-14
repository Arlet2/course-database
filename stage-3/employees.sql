CREATE TABLE IF NOT EXISTS employees(
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    full_name VARCHAR(255) NOT NULL,
    job_title VARCHAR(50),
    employment_date DATE NOT NULL,
    dismissal_date DATE,
    payment_id INT REFERENCES payments_info ON DELETE SET NULL,
    agreement_id INT REFERENCES documents ON DELETE SET NULL
);