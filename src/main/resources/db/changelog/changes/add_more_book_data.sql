--liquibase formatted sql

--changeset mihaijulien:add-more-book-data
INSERT INTO book (title, description, copies, copies_available, category, img)
VALUES
    ('The Fellowship of the Ring', 'Frodo begins a perilous journey to destroy the One Ring.', 4, 4, 'FANTASY', 'https://covers.openlibrary.org/b/isbn/9780547928210-L.jpg'),
    ('The Catcher in the Rye', 'Holden Caulfield recounts a few turbulent days in New York City.', 3, 3, 'FICTION', 'https://covers.openlibrary.org/b/isbn/9780316769488-L.jpg'),
    ('To Kill a Mockingbird', 'Scout Finch witnesses her father defend a Black man in the Deep South.', 5, 5, 'FICTION', 'https://covers.openlibrary.org/b/isbn/9780061120084-L.jpg'),
    ('The Great Gatsby', 'Jay Gatsby pursues wealth and a lost love in 1920s Long Island.', 4, 4, 'FICTION', 'https://covers.openlibrary.org/b/isbn/9780743273565-L.jpg'),
    ('Dune', 'Paul Atreides navigates political conflict on the desert planet Arrakis.', 3, 3, 'SCIENCE_FICTION', 'https://covers.openlibrary.org/b/isbn/9780441172719-L.jpg');
