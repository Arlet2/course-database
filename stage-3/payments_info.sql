-- Active: 1698966099613@@127.0.0.1@5432@studs@s338861
CREATE TABLE IF NOT EXISTS payments_info(
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    salary INT NOT NULL,
    bank_name VARCHAR(100) NOT NULL,
    account_number VARCHAR(50) NOT NULL,
    bik VARCHAR(50),
    corr_account VARCHAR(50),
    inn VARCHAR(50),
    kpp VARCHAR(50)
);