CREATE TABLE IF NOT EXISTS batch_delivery(
    delivery_id INT
        REFERENCES deliveries(id)
        ON DELETE CASCADE,
    batch_id INT 
        REFERENCES batches(id)
        ON DELETE CASCADE,
    amount INT NOT NULL CHECK(amount >= 0),
    mass REAL CHECK(mass IS NULL OR mass >= 0),
    PRIMARY KEY(delivery_id, batch_id)
);

CREATE OR REPLACE FUNCTION check_batch_delivery_correct_amount() 
RETURNS trigger AS $batch_delivery_check$
BEGIN
    IF (
        SELECT packs_count FROM batches WHERE id = NEW.batch_id
    ) IS NULL 
    THEN
        RAISE EXCEPTION 'Batch packs_count should be not NULL!';
    END IF;

    IF (
        SELECT packs_count FROM batches WHERE id = NEW.batch_id
    ) - (
        SELECT SUM(amount) as packs_count FROM batch_delivery WHERE batch_id = NEW.batch_id
    ) < NEW.amount 
    THEN
       RAISE EXCEPTION 'There is no such amount packs in this batch!';
    END IF;

    IF (
        SELECT t.packs_capacity FROM deliveries d JOIN transports t 
            ON d.transport_number = t.transport_number 
        WHERE d.id = NEW.delivery_id
    ) - (
        SELECT SUM(amount) as packs_count FROM batch_delivery WHERE delivery_id = NEW.delivery_id
    ) < NEW.amount 
    THEN
       RAISE EXCEPTION 'There is not enought transport capacity!';
    END IF;

    RETURN NEW;
END;
$batch_delivery_check$ LANGUAGE 'plpgsql';

CREATE OR REPLACE FUNCTION update_delivery_packs_count()
RETURNS trigger AS $delivery_packs_count$
BEGIN
    UPDATE deliveries 
    SET packs_count = (
        SELECT SUM(amount) as packs_count FROM batch_delivery WHERE delivery_id = NEW.delivery_id
    ) WHERE id = NEW.delivery_id;
    RETURN NEW;
END;
$delivery_packs_count$ LANGUAGE 'plpgsql';


CREATE OR REPLACE TRIGGER batch_delivery_update_trigger
    BEFORE INSERT OR UPDATE OF amount ON batch_delivery
    FOR EACH ROW
    EXECUTE FUNCTION check_batch_delivery_correct_amount();

CREATE OR REPLACE TRIGGER delivery_packs_count_trigger
    AFTER INSERT OR DELETE OR UPDATE OF amount ON batch_delivery
    FOR EACH ROW
    EXECUTE FUNCTION update_delivery_packs_count();

INSERT INTO batch_delivery 
    (delivery_id, batch_id, amount, mass) 
VALUES
    (4, 1, 400, NULL),
   -- (0, 2, 250, 200),
    (5, 2, 230, 190),
    --(1, 2, 100, NULL),
    (6, 2, 423, NULL);
    --(4, 1, 800, 700),
    --(5, 2, 230, 200);
   -- (4, 2, 530, 450);

# Test checks


# Not set in batch
INSERT INTO batch_delivery (delivery_id, batch_id, amount, mass) VALUES (4, 3, 400, NULL);
# Not enought in batch
INSERT INTO batch_delivery (delivery_id, batch_id, amount, mass) VALUES (4, 2, 700, 100);
# Not enough in transport
INSERT INTO batch_delivery (delivery_id, batch_id, amount, mass) VALUES (4, 2, 500, 1000);

# Check packs_counts updates (should be equal)
SELECT packs_count, (SELECT SUM(amount) FROM batch_delivery WHERE delivery_id = 4) as packs_count_sum FROM deliveries WHERE id = 4;