CREATE TABLE IF NOT EXISTS sections (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    mass_capacity REAL NOT NULL CHECK (mass_capacity > 0),
    temperature REAL NOT NULL
);

INSERT INTO sections
(mass_capacity, temperature)
VALUES
(2500, -21.5),
(3400, -15.2),
(3000, -17),
(1800, -12.8);
