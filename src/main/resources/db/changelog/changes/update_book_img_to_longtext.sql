--liquibase formatted sql

--changeset mihaijulien:update-book-img-to-longtext
ALTER TABLE book MODIFY img LONGTEXT;
