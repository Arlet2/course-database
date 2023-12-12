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
    (1, 1, 'маленькие'),
    (1, 1, 'средние'),
    (1, 2, 'маленькие'),
    (1, 2, 'средние'),
    (1, 2, 'крупные'),
    (2, 1, 'средние'),
    (2, 1, 'крупные'),
    (2, 2, 'средние'),
    (2, 2, 'крупные'),
    (2, 3, 'средние'),
    (2, 3, 'крупные'),
    (2, 3, 'гигантские'),
    (3, 1, 'маленькие'),
    (3, 1, 'средние'),
    (3, 1, 'крупные'),
    (3, 2, 'маленькие'),
    (3, 2, 'средние'),
    (3, 2, 'крупные'),
    (3, 3, 'маленькие'),
    (3, 3, 'средние'),
    (3, 3, 'крупные');
