CREATE TABLE IF NOT EXISTS conveyor_pelmeni(
    conveyor_id INT
        REFERENCES conveyors(id)
        ON DELETE CASCADE,
    type_id INT
        REFERENCES pelmeni_types(type_id)
        ON DELETE CASCADE,
    size_name VARCHAR(255)
        REFERENCES pelmeni_sizes(name)
        ON DELETE CASCADE,
    PRIMARY KEY(conveyor_id, type_id, size_name)
);

INSERT INTO conveyor_pelmeni
    (conveyor_id, type_id, size_name)  
VALUES
    (0, 0, "маленькие"),
    (0, 0, "средние"),
    (0, 1, "маленькие"),
    (0, 1, "средние"),
    (0, 1, "крупные"),
    (1, 0, "средние"),
    (1, 0, "крупные"),
    (1, 1, "средние"),
    (1, 1, "крупные"),
    (1, 2, "средние"),
    (1, 2, "крупные"),
    (1, 2, "гигантские"),
    (2, 0, "маленькие"),
    (2, 0, "средние"),
    (2, 0, "крупные"),
    (2, 1, "маленькие"),
    (2, 1, "средние"),
    (2, 1, "крупные"),
    (2, 2, "маленькие"),
    (2, 2, "средние"),
    (2, 2, "крупные");
