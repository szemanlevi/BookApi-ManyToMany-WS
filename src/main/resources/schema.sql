drop table if exists author CASCADE;
drop table if exists book CASCADE;
drop table if exists author_book CASCADE;
create table author
(
    id   bigint generated by default as identity,
    name varchar(255),
    primary key (id)
);
create table book
(
    id    bigint generated by default as identity,
    title varchar(255),
    primary key (id)
);
create table author_book (
                             author_id bigint not null,
                             book_id bigint not null
);
alter table author_book
    add constraint FKn8665s8lv781v4eojs8jo3jao
        foreign key (book_id)
            references book;
alter table author_book
    add constraint FKg7j6ud9d32ll232o9mgo90s57
        foreign key (author_id)
            references author;