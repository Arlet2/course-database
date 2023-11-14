CREATE TABLE IF NOT EXISTS transports(
    transport_number VARCHAR(10) PRIMARY KEY,
    packs_capacity INT NOT NULL CHECK(packs_capacity >= 0),
    max_weight REAL CHECK(max_weight IS NULL OR max_weight >= 0)
)