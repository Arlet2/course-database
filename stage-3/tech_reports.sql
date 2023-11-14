CREATE TABLE IF NOT EXISTS tech_reports (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    reported_id INT REFERENCES employees ON DELETE SET NULL,
    shift_id INT REFERENCES workshifts ON DELETE SET NULL,
    state INT NOT NULL CHECK(state BETWEEN 1 AND 5),
    created TIMESTAMP,
    description TEXT
);