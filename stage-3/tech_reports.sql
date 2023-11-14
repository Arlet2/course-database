CREATE TABLE IF NOT EXISTS tech_reports (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    reporter_id INT REFERENCES employees ON DELETE SET NULL,
    shift_id INT REFERENCES workshifts ON DELETE SET NULL,
    state INT NOT NULL CHECK(state BETWEEN 1 AND 5),
    created TIMESTAMP,
    description TEXT
);

INSERT INTO tech_reports
(reporter_id, shift_id, state, created, description)
VALUES
(0, 0, 1, TIMESTAMP '2023-11-14 11:00:00+03', 'Conveyor exploded after 200 hours of work');


INSERT INTO tech_reports
(reporter_id, shift_id, state, created, description)
VALUES
(1, 1, 5, NULL, 'All good');