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


