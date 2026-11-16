--liquibase formatted sql

--changeset mihaijulien:add-book-data
INSERT INTO book (title, description, copies, copies_available, category, img)
VALUES
    ('The Hobbit', 'Bilbo Baggins sets out on an unexpected adventure.', 5, 5, 'FANTASY', NULL),
    ('Pride and Prejudice', 'Elizabeth Bennet navigates love and social expectations.', 4, 4, 'ROMANCE', NULL),
    ('A Brief History of Time', 'An introduction to the origins and structure of the universe.', 3, 3, 'NON_FICTION', NULL);
