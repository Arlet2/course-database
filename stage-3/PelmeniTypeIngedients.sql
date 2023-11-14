CREATE TABLE IF NOT EXISTS pelmeni_type_ingredients (
    type_id INT
        REFERENCES pelmeni_types(type_id)
        ON DELETE CASCADE,
    ingredient_name VARCHAR(255) NOT NULL,
    weight REAL NOT NULL CHECK(weight >= 0),
    PRIMARY KEY(type_id, ingredient_name)
);


INSERT INTO pelmeni_type_ingredients 
    (type_id, ingredient_name, weight) 
VALUES
    (0, "Мука пшеничная просеянная", 500),
    (0, "Вода горячая (70-75 градусов)", 350),
    (0, "Яйцо", 1),
    (0, "Соль", 20),
    (0, "Масло растительное без запаха", 25),
    (0, "Мясо", 550),
    (0, "Лук репчатый", 200),
    (0, "Сало", 30),
    (0, "Перец чёрный молотый", 1.5),
    (0, "Лист лавровый", 1),
    (1, "Мука пшеничная просеянная", 400),
    (1, "Вода горячая (70-75 градусов)", 450),
    (1, "Яйцо", 2),
    (1, "Соль", 10),
    (1, "Масло растительное без запаха", 35),
    (1, "Мясо", 600),
    (1, "Лук репчатый", 150),
    (1, "Перец чёрный молотый", 1.5),
    (1, "Лист лавровый", 1),
    (2, "Мука пшеничная просеянная", 50),
    (2, "Вода горячая (70-75 градусов)", 50),
    (2, "Яйцо", 0.5),
    (2, "Соль", 2),
    (2, "Масло растительное без запаха", 10),
    (2, "Мясо", 1000),
    (2, "Лук репчатый", 50),
    (2, "Перец чёрный молотый", 1),
    (2, "Лист лавровый", 1);
