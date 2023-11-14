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
);

INSERT INTO batch_delivery 
    (delivery_id, batch_id, amount, mass) 
VALUES
    (0, 1, 400, NULL),
    (0, 2, 250, 200),
    (1, 0, 230, 190),
    (1, 2, 100, NULL),
    (2, 0, 423, NULL),
    (3, 1, 800, 700),
    (4, 0, 230, 200),
    (4, 2, 530, 450);
