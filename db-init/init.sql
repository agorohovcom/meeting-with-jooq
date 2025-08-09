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
