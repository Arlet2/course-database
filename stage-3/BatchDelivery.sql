CREATE TABLE IF NOT EXISTS batch_delivery(
    delivery_id INT
        REFERENCES delivery(id)
        ON DELETE SET NULL,
    batch_id INT 
        REFERENCES batches(id)
        ON DELETE CASCADE,
    amount INT NOT NULL CHECK(amount >= 0),
    mass REAL,
    PRIMARY KEY(delivery_id, batch_id)
)