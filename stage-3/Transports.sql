CREATE TABLE IF NOT EXISTS transports(
    transport_number VARCHAR(255) PRIMARY KEY,
    packs_capacity INT NOT NULL CHECK(packs_capacity >= 0),
    max_weight REAL
)