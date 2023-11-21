CREATE TABLE IF NOT EXISTS pelmeni_sizes (
    name VARCHAR(255) PRIMARY KEY
);

INSERT INTO pelmeni_sizes 
    (name) 
VALUES
    ('маленькие'),
    ('средние'),
    ('крупные'),
    ('гигантские');

