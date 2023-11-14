CREATE TABLE IF NOT EXISTS freezing_info(
    batch_id INT REFERENCES batches ON DELETE CASCADE,
    section_id INT REFERENCES sections ON DELETE CASCADE,
    temperature INT NOT NULL,
    load_date DATE NOT NULL,
    unload_date DATE,
    PRIMARY KEY(batch_id, section_id)
)