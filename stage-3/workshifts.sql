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

INSERT INTO workshifts
(batch_id, conveyor_id, time_start, time_end)
VALUES
(0, 0, TIMESTAMP '2023-03-03 10:23:54+03', NULL),
(1, 0, TIMESTAMP '2023-01-01 10:23:54+03', NULL),
(2, 1, NULL, NULL);