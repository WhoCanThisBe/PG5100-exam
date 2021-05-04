create sequence movie_id_sequence start with 1 increment by 1;

create table movie(
    id bigint not null,
    director varchar(128) not null,
    title varchar(128),
    year_of_release date not null,
    primary key (id));