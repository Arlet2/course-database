CREATE TABLE IF NOT EXISTS batches(
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    shift_id INT REFERENCES workshifts ON DELETE SET NULL,
    pelmeni_type INT REFERENCES pelmeni_types ON DELETE SET NULL,
    pelmeni_size VARCHAR(50) REFERENCES pelmeni_sizes ON DELETE SET NULL,
    summary_mass REAL NOT NULL CHECK(summary_mass >= 0),
    created TIMESTAMP NOT NULL,
    factory_id INT REFERENCES factories ON DELETE SET NULL,
    package_time TIMESTAMP,
    packs_count INT CHECK(packs_count IS NULL OR packs_count >= 0),
    mass_of_defective REAL CHECK(mass_of_defective IS NULL OR mass_of_defective >= 0)
);

INSERT INTO batches
(
    shift_id, pelmeni_type, pelmeni_size, 
    summary_mass, created, factory_id, 
    package_time, packs_count, mass_of_defective
)
VALUES
(
    0, 0, 'маленькие', 
    2000, TIMESTAMP '2023-01-01 02:05:10+02', 0, 
    '2023-01-01 02:05:10+02', 2000, 0
),
(
    1, 0, 'средние',
    1599, TIMESTAMP '2023-02-01 05:05:10+03', 1,
    '2023-03-03 06:02:10+03', 1400, 20
),
(
    2, 1, 'маленькие',
    200, TIMESTAMP '2023-03-03 06:02:10+03', 3,
    NULL, NULL, NULL
);


CREATE INDEX ON batches USING HASH (factory_id);