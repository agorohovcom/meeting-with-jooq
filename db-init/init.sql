CREATE SCHEMA IF NOT EXISTS myschema;

CREATE TABLE IF NOT EXISTS myschema.company (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    budget NUMERIC(15, 2) NOT NULL
);

CREATE TABLE IF NOT EXISTS myschema.users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    age INT,
    company_id INT,
    CONSTRAINT fk_company FOREIGN KEY (company_id) REFERENCES myschema.company(id) ON DELETE SET NULL
);

-- Добавляем записи в company
INSERT INTO myschema.company (name, budget) VALUES ('ABV Tech', 1000000.00);
INSERT INTO myschema.company (name, budget) VALUES ('Citrys', 50000000.00);

-- Добавляем записи в users
INSERT INTO myschema.users (name, age, company_id) VALUES ('Sasha', 35, 1);
INSERT INTO myschema.users (name, age, company_id) VALUES ('Dasha', 21, 1);
INSERT INTO myschema.users (name, age, company_id) VALUES ('Gena', 53, 2);