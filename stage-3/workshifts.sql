CREATE TABLE IF NOT EXISTS workshifts (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    batch_id INT NOT NULL,
    conveyor_id INT NOT NULL,
    time_start TIMESTAMP,
    time_end TIMESTAMP
);

ALTER TABLE ONLY workshifts
    ADD FOREIGN KEY(batch_id) REFERENCES batches ON DELETE CASCADE;

ALTER TABLE ONLY workshifts
    ADD FOREIGN KEY(conveyor_id) REFERENCES conveyors ON DELETE CASCADE;

