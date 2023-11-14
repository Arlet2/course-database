CREATE TABLE IF NOT EXISTS delivery_points(
    id INT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
    address VARCHAR(255) NOT NULL,
    point_type VARCHAR(255)
        REFERENCES delivery_point_types(name)
        ON DELETE SET NULL,
    packs_capacity INT NOT NULL
);

INSERT INTO delivery_point_types 
    (address, point_type, packs_capacity) 
VALUES
    ("г. Санкт-Петербург, ул. Белорусская, д. 6", "Склад владельца", 150000), 
    ("г. Санкт-Петербург, ул. Ленсовета, д. 23", "Склад партнёра", 60000), 
    ("г. Санкт-Петербург, Вяземский пер., д. 5-7", "Магазин-партнёр", 10000);
