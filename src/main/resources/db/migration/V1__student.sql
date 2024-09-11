CREATE TABLE student
(
    id        SERIAL PRIMARY KEY,    -- Auto-incremented ID for PostgreSQL, use AUTO_INCREMENT for MySQL
    firstname VARCHAR(255) NOT NULL, -- First name column, maximum 255 characters
    lastname  VARCHAR(255) NOT NULL, -- Last name column, maximum 255 characters
    email     VARCHAR(255) NOT NULL, -- Email column, maximum 255 characters
    password  VARCHAR(255) NOT NULL, -- Password column, maximum 255 characters
    address   TEXT                   -- Address column, allows longer strings
);