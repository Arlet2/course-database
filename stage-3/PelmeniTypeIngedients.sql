CREATE TABLE IF NOT EXISTS pelmeni_type_ingredients (
    type_id INT
        REFERENCES pelmeni_types(type_id)
        ON DELETE CASCADE,
    ingredient_name VARCHAR(255) NOT NULL,
    weight REAL NOT NULL CHECK(weight >= 0),
    PRIMARY KEY(type_id, ingredient_name)
)