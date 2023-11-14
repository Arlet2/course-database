CREATE TABLE IF NOT EXISTS documents(
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name VARCHAR(256) NOT NULL,
    data_url VARCHAR(256) NOT NULL,
    owner_id INT,
    signed BOOLEAN
);

ALTER TABLE ONLY documents
    ADD FOREIGN KEY(owner_id) REFERENCES employees ON DELETE NULL;

INSERT INTO documents 
(name, owner_id, signed) 
VALUES('agreement', "http://unblockfolio.ru/docs/a41ghdf1", NULL, TRUE);