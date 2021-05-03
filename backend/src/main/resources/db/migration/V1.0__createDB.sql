create sequence hibernate_sequence start with 1 increment by 1;

create table user_roles
(
    user_username varchar(255) not null,
    roles varchar(255)
);
create table users
(
    username varchar(255) not null,
    enabled boolean not null,
    password varchar(255) not null, primary key (username));

alter table user_roles
    add constraint userConstraint foreign key (user_username) references users;

create sequence movie_id_sequence start with 1 increment by 1;

create table movie
(
    id bigint not null,
    director varchar(128) not null,
    title varchar(128),
    year_of_release integer not null,
    primary key (id)
);