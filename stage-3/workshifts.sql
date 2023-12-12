CREATE TABLE IF NOT EXISTS workshifts (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    batch_id INT,
    conveyor_id INT,
    time_start TIMESTAMP,
    time_end TIMESTAMP
);

ALTER TABLE ONLY workshifts
    ADD FOREIGN KEY(batch_id) REFERENCES batches ON DELETE SET NULL;

ALTER TABLE ONLY workshifts
    ADD FOREIGN KEY(conveyor_id) REFERENCES conveyors ON DELETE SET NULL;

INSERT INTO workshifts
(conveyor_id, time_start, time_end)
VALUES
( 1, TIMESTAMP '2023-03-03 10:23:54+03', NULL),
( 1, TIMESTAMP '2023-01-01 10:23:54+03', NULL),
( 2, NULL, NULL);

CREATE INDEX ON workshifts USING HASH (batch_id);
CREATE INDEX ON workshifts USING HASH (conveyor_id);