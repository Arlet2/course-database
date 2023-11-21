CREATE TABLE IF NOT EXISTS transports(
    transport_number VARCHAR(10) PRIMARY KEY,
    packs_capacity INT NOT NULL CHECK(packs_capacity >= 0),
    max_weight REAL CHECK(max_weight IS NULL OR max_weight >= 0)
);

INSERT INTO transports 
    (transport_number, packs_capacity, max_weight) 
VALUES
    ('Х999УУ93', 2000, 1500), 
    ('К123ЕК93', 1234, 1000),
    ('В888ВС', 2500, 3000);

CREATE INDEX ON transports BTREE(packs_capacity);