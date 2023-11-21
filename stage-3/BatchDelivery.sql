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
        WHERE d.delivery_id = NEW.delivery_id
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
    ) WHERE delivery_id = NEW.delivery_id;
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
    (0, 1, 400, NULL),
    (0, 2, 250, 200),
    (1, 0, 230, 190),
    (1, 2, 100, NULL),
    (2, 0, 423, NULL),
    (3, 1, 800, 700),
    (4, 0, 230, 200),
    (4, 2, 530, 450);
