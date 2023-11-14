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
)