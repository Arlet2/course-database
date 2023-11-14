-- Active: 1698966099613@@127.0.0.1@5432@studs@s338861
CREATE TABLE IF NOT EXISTS payments_info(
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    salary INT NOT NULL CHECK (salary >= 0),
    bank_name VARCHAR(100) NOT NULL,
    account_number VARCHAR(50) NOT NULL,
    bik VARCHAR(50),
    corr_account VARCHAR(50),
    inn VARCHAR(50),
    kpp VARCHAR(50)
);

INSERT INTO payments_info
(salary, bank_name, account_number, bik, inn, kpp)
VALUES
(10000000, 'Alfa Bank', 5536913784868685, 044525974, 7710140679, 771301001),
(0, 'Tinkoff Bank', 2222222, NULL, NULL, 101),
(10, 'Sber Bank', 12351, NULL, NULL, NULL);