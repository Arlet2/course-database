CREATE TABLE IF NOT EXISTS batches(
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    shift_id INT NOT NULL REFERENCES workshifts ON DELETE CASCADE,
    pelmeni_type INT NOT NULL REFERENCES pelmeni_types ON DELETE CASCADE,
    pelmeni_size VARCHAR(50) NOT NULL REFERENCES pelmeni_sizes ON DELETE CASCADE,
    summary_mass REAL NOT NULL CHECK(summary_mass > 0),
    created TIMESTAMP NOT NULL,
    factory_id INT NOT NULL REFERENCES factories ON DELETE CASCADE,
    package_time TIMESTAMP,
    packs_count INT CHECK(packs_count IS NULL OR packs_count > 0),
    mass_of_defective REAL CHECK(mass_of_defective IS NULL OR mass_of_defective > 0)
);