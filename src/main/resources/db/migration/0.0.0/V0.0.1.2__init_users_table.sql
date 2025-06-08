CREATE TABLE IF NOT EXISTS users
(
    id             BIGINT AUTO_INCREMENT PRIMARY KEY,
    name           VARCHAR(32),
    username       VARCHAR(32) NOT NULL UNIQUE,
    email          VARCHAR(32) NOT NULL UNIQUE,
    created_date   TIMESTAMP WITHOUT TIME ZONE,

    CONSTRAINT PKUsers PRIMARY KEY (id)
);