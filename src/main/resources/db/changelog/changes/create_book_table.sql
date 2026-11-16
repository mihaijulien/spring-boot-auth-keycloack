--liquibase formatted sql

--changeset mihaijulien:create-book-table
CREATE TABLE book (
    id BIGINT NOT NULL AUTO_INCREMENT,
    title VARCHAR(255),
    description VARCHAR(255),
    copies INT NOT NULL,
    copies_available INT NOT NULL,
    category VARCHAR(255),
    img VARCHAR(255),
    PRIMARY KEY (id)
);
