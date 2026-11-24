--liquibase formatted sql

--changeset mihaijulien:update-book-cover-images
UPDATE book
SET img = CASE title
    WHEN 'The Hobbit' THEN 'https://covers.openlibrary.org/b/isbn/9780547928227-L.jpg'
    WHEN 'Pride and Prejudice' THEN 'https://covers.openlibrary.org/b/isbn/9780141439518-L.jpg'
    WHEN 'A Brief History of Time' THEN 'https://covers.openlibrary.org/b/isbn/9780553380163-L.jpg'
    ELSE img
END
WHERE title IN ('The Hobbit', 'Pride and Prejudice', 'A Brief History of Time');
