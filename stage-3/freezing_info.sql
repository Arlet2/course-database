CREATE TABLE IF NOT EXISTS freezing_info(
    batch_id INT REFERENCES batches ON DELETE CASCADE,
    section_id INT REFERENCES sections ON DELETE CASCADE,
    temperature INT NOT NULL,
    load_date DATE NOT NULL,
    unload_date DATE CHECK(unload_date IS NULL OR unload_date > load_date),
    PRIMARY KEY(batch_id, section_id)
)

INSERT INTO freezing_info
(batch_id, section_id, temperature, load_date, unload_date)
VALUES
(0, 0, -20, '2023-01-01', '2023-01-02'),
(1, 2, -10, '2023-02-03', '2023-04-06'),
(3, 0, -10, '2023-01-03', NULL);