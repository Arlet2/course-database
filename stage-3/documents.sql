CREATE TABLE IF NOT EXISTS documents(
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    data_url TEXT NOT NULL,
    owner_id INT,
    signed BOOLEAN
);

ALTER TABLE ONLY documents
    ADD FOREIGN KEY(owner_id) REFERENCES employees ON DELETE SET NULL;

INSERT INTO documents 
(name, data_url, owner_id, signed) 
VALUES
('agreement', 'http://unblockfolio.ru/docs/a41ghdf1', NULL, TRUE),
('passport', 'http://unblockfolio.ru/docs/412dffgs', 0, NULL),
('agreement', 'http://unblockfolio.ru/docs/asdf1d', 1, TRUE),
('passport', 'http://unblockfolio.ru/docs/gsa2saf', 1, NULL),
('agreement', 'http://unblockfolio.ru/docs/asdf1d', 2, TRUE),
('passport', 'http://unblockfolio.ru/docs/gasdgas', 2, NULL)