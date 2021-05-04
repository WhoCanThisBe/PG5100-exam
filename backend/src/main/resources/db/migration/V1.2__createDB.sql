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