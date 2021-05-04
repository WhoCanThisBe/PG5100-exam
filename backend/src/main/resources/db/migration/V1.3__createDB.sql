insert into movie(id,director,title,year_of_release)
Values(1,'Georg Lucas','Star Wars Episode IV – A New Hope','1977-05-25');

insert into movie(id,director,title,year_of_release)
Values(2,'Irvin Kershner','Star Wars Episode V – The Empire Strikes Back', '1977-05-25');

insert into users(username,email,enabled, firstname,password,surname)
values('Anonymous', 'anonymous@mail.com',true,'Anonymous','bestsecretpasswordever','Anonymous');


insert into reviews(id, rating, review_date, review_text, author_username, target_movie_id)
values(1,5,'2021-04-05 12:01:31-08','rich review','Anonymous',1);

insert into reviews(id, rating, review_date, review_text, author_username, target_movie_id)
values(2,3,'2021-04-05 12:01:31-08','rich review','Anonymous',1);

insert into reviews(id, rating, review_date, review_text, author_username, target_movie_id)
values(3,4,'2021-04-05 12:01:31-08','rich review','Anonymous',2);

insert into reviews(id, rating, review_date, review_text, author_username, target_movie_id)
values(4,5,'2021-04-05 12:01:31-08','rich review','Anonymous',2);