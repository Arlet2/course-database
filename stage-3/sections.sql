CREATE TABLE IF NOT EXISTS sections (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    size INT NOT NULL CHECK (size > 0)
);

INSERT INTO sections
(size)
VALUES
(100),
(90),
(50),
(60);