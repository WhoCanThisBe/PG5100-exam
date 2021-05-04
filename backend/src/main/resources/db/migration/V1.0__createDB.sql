

create table user_roles
(
    user_username varchar(255) not null,
    roles varchar(255)
);
create table users
(
    username varchar(32) not null,
    email varchar(255),
    enabled boolean not null,
    name varchar(64),
    password varchar(255),
    surname varchar(64),
    primary key (username));

alter table user_roles
    add constraint user_constraint_fk foreign key (user_username) references users;

create sequence movie_id_sequence start with 1 increment by 1;

create table movie
(
    id bigint not null,
    director varchar(128) not null,
    title varchar(128),
    year_of_release integer not null,
    primary key (id)
);

create sequence review_id_sequence start with 1 increment by 1;

create table reviews
(
    id bigint not null,
    rating integer not null check (rating<=5 AND rating>=1),
    review_date varchar(255),
    review_text varchar(255),
    author_username varchar(255) not null,
    target_movie_id bigint not null, primary key (id)
);


alter table reviews
    add constraint review_user_fk foreign key (author_username) references users;

alter table reviews
    add constraint review_movie_fk foreign key (target_movie_id) references movie