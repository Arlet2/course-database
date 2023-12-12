CREATE TABLE IF NOT EXISTS batches(
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    shift_id INT REFERENCES workshifts ON DELETE SET NULL,
    pelmeni_type INT REFERENCES pelmeni_types ON DELETE SET NULL,
    pelmeni_size VARCHAR(255) REFERENCES pelmeni_sizes ON DELETE SET NULL,
    summary_mass REAL NOT NULL CHECK(summary_mass >= 0),
    created TIMESTAMP NOT NULL,
    package_time TIMESTAMP,
    packs_count INT CHECK(packs_count IS NULL OR packs_count >= 0),
    mass_of_defective REAL CHECK(mass_of_defective IS NULL OR mass_of_defective >= 0)
);

CREATE OR REPLACE FUNCTION check_correct_work_shift ()
RETURNS TRIGGER AS $$
BEGIN
    IF (SELECT batch_id FROM workshifts WHERE id = NEW.shift_id) IS NOT NULL THEN
        RAISE EXCEPTION 'Batch alrady set for this workshift!';
    END IF;

    IF (
        SELECT COUNT(*) FROM conveyor_pelmeni WHERE 
            conveyor_id = (SELECT conveyor_id FROM workshifts WHERE id = NEW.shift_id)
            AND type_id = NEW.pelmeni_type
            AND size_name = NEW.pelmeni_size
    ) = 0 THEN 
        RAISE EXCEPTION 'This pelmeni type and size is not supported by given work shift conveyor!';
    END IF;

    RETURN NEW;
END
$$ LANGUAGE 'plpgsql';


CREATE OR REPLACE FUNCTION update_work_shift() 
RETURNS TRIGGER AS $$
BEGIN
    UPDATE workshifts SET batch_id = NEW.id, time_end = current_timestamp WHERE id = NEW.shift_id;
    RETURN NEW;
END
$$ LANGUAGE 'plpgsql';


CREATE OR REPLACE TRIGGER create_batch_trigger
    BEFORE INSERT OR UPDATE OF shift_id, pelmeni_type, pelmeni_size ON batches
    FOR EACH ROW
    EXECUTE FUNCTION check_correct_work_shift();


CREATE OR REPLACE TRIGGER update_workshift_batch
    AFTER INSERT OR UPDATE OF shift_id ON batches
    FOR EACH ROW
    EXECUTE PROCEDURE update_work_shift();

INSERT INTO batches
(
    shift_id, pelmeni_type, pelmeni_size, summary_mass, 
    created, package_time, 
    packs_count, mass_of_defective
)
VALUES
(
    1, 1, 'маленькие', 2000, 
    '2023-01-01 02:05:10+02', '2023-01-01 02:05:10+02', 
    2000, 0
),
(
    2, 1, 'средние', 1599, 
    '2023-01-03 05:05:10+03', '2023-03-03 06:02:10+03', 
    1400, 20
),
(
    3, 2, 'крупные', 1900, 
    '2023-01-03 06:02:10+03', NULL, 
    NULL, NULL
);


CREATE INDEX ON batches USING HASH (shift_id);
