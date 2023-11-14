CREATE TABLE IF NOT EXISTS delivery_point_types(
    name VARCHAR(255) PRIMARY KEY
);

INSERT INTO delivery_point_types (name) VALUES
    ("Склад владельца"), 
    ("Склад партнёра"), 
    ("Магазин-партнёр");

