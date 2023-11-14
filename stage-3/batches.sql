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