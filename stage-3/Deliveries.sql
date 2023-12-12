CREATE TABLE IF NOT EXISTS deliveries (
    id INT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
    transport_number VARCHAR(10)
        REFERENCES transports(transport_number)
        ON DELETE SET NULL,
    delivery_point_id INT
        REFERENCES delivery_points(id)
        ON DELETE SET NULL,
    packs_count INT CHECK(packs_count IS NULL OR packs_count >= 0),
    factory_id INT
        REFERENCES factories(id)
        ON DELETE SET NULL,
    departure_date TIMESTAMP,
    arrival_date TIMESTAMP CHECK(arrival_date IS NULL OR departure_date IS NOT NULL AND arrival_date > departure_date)
);

CREATE OR REPLACE FUNCTION check_delivery_point_capacity()
RETURNS trigger AS $delivery_point_capacity$
BEGIN
    IF NEW.departure_date IS NOT NULL AND
        (SELECT packs_capacity FROM delivery_points WHERE id = NEW.delivery_point_id) < NEW.packs_count
    THEN
        RAISE EXCEPTION 'There is not enought space on delivery point!';
    END IF;

    RETURN NEW;
END;
$delivery_point_capacity$ LANGUAGE 'plpgsql';


CREATE OR REPLACE TRIGGER delivery_start_trigger
    BEFORE INSERT OR UPDATE OF departure_date ON deliveries
    FOR EACH ROW
    EXECUTE FUNCTION check_delivery_point_capacity();

CREATE INDEX ON deliveries USING HASH (delivery_point_id);
CREATE INDEX ON deliveries USING HASH (factory_id);

INSERT INTO deliveries 
    (transport_number, delivery_point_id, packs_count, factory_id) 
VALUES
    ('Х999УУ93', 1, 1300, 2), 
    ('К123ЕК93', 3, 258, 4),
    ('К123ЕК93', 2, 228, 3),
    ('В888ВС', 1, 1337, 5),
    ('Х999УУ93', 2, 1448, 1);
