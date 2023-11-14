CREATE TABLE IF NOT EXISTS conveyors (
    id INT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
    manager_id INT
        REFERENCES employees(id)
        ON DELETE SET NULL,
    name VARCHAR(50),
    commissioning_date DATE,
    decommissioning_date DATE
)