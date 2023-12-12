CREATE TABLE IF NOT EXISTS freezing_info(
    batch_id INT REFERENCES batches ON DELETE CASCADE,
    section_id INT REFERENCES sections ON DELETE CASCADE,
    total_mass REAL NOT NULL CHECK(total_mass >= 0),
    load_date DATE NOT NULL,
    unload_date DATE CHECK(unload_date IS NULL OR unload_date > load_date),
    PRIMARY KEY(batch_id, section_id)
)


CREATE OR REPLACE FUNCTION check_enough_space ()
RETURNS TRIGGER AS $$
BEGIN
    IF (SELECT mass_capacity FROM sections WHERE id = NEW.section_id) -
        (SELECT SUM(total_mass) FROM freezing_info 
        WHERE section_id = NEW.section_id AND (unload_date IS NULL OR NEW.load_date < unload_date)) < NEW.total_mass
    THEN
        RAISE EXCEPTION 'Not enought space in section!';
    END IF;

    IF  (SELECT (summary_mass - mass_of_defective) as mass FROM batches WHERE id = NEW.batch_id) -
        (SELECT SUM(total_mass) FROM freezing_info WHERE batch_id = NEW.batch_id) < NEW.total_mass
    THEN
        RAISE EXCEPTION 'Not enought mass in batch stayed!';
    END IF;

    RETURN NEW;
END
$$ LANGUAGE 'plpgsql';

CREATE OR REPLACE TRIGGER new_freezing_info_trigger
    BEFORE INSERT OR UPDATE ON freezing_info
    FOR EACH ROW
    EXECUTE FUNCTION check_enough_space();

INSERT INTO freezing_info
(batch_id, section_id, total_mass, load_date, unload_date)
VALUES
(1, 1, 2000, '2023-01-01', '2023-01-02'),
(2, 2, 1599, '2023-01-03', '2023-01-06'),
(3, 1, 1900, '2023-01-03', NULL);