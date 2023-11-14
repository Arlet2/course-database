CREATE TABLE IF NOT EXISTS batch_delivery(
    delivery_id INT
        REFERENCES delivery(id)
        ON DELETE CASCADE,
    batch_id INT 
        REFERENCES batches(id)
        ON DELETE CASCADE,
    amount INT NOT NULL CHECK(amount >= 0),
    mass REAL CHECK(mass IS NULL OR mass >= 0),
    PRIMARY KEY(delivery_id, batch_id)
)