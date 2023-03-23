insert into book (title)
values ('Bible'),
       ('The Decameron'),
       ('The Life of Dante'),
       ('The Great Gatsby'),
       ('Harry Potter and the sorcerers stone'),
       ('The Witcher 1'),
       ('The Witcher 2'),
       ('The Witcher 3'),
       ('The Witcher 4'),
       ('The Curious Case of Benjamin Buttons');

insert into author (name)
values ('Giovanni Bocacchio'),
       ('J.K. Rowling'),
       ('Andrzej Sapkowski'),
       ('F. Scott Fitzgerald');

insert into author_book (author_id, book_id)
values (4, 4),
       (1, 2),
       (2, 5),
       (3, 6),
       (3, 7),
       (3, 8),
       (3, 9),
       (3, 4);