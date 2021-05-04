-- Movies

insert into movie(id,director,title,year_of_release)
Values(1,'Georg Lucas','Star Wars Episode IV – A New Hope','1977-05-25');

insert into movie(id,director,title,year_of_release)
Values(2,'Irvin Kershner','Star Wars Episode V – The Empire Strikes Back', '1977-05-25');

insert into movie(id,director,title,year_of_release)
Values(3,'The Wachowskis','The Matrix', '1999-03-31');

insert into movie(id,director,title,year_of_release)
Values(4,'Niki Caro','Mulan (2020 film)', '2020-09-04');

insert into movie(id,director,title,year_of_release)
Values(5,'Simon McQuiod','Mortal Kombat (2021 film)','2021-04-23');


--User
insert into users(username,email,enabled, firstname,password,surname)
values('Anonymous', 'anonymous@mail.com',true,'Anonymous','bestsecretpasswordever','Anonymous');


--Reviews
insert into reviews(id, rating, review_date, review_text, author_username, target_movie_id)
values(1,
       5,
       '2021-04-05 12:01:31-08',
       'this is a awesome movie',
       'Anonymous',
       1);

insert into reviews(id, rating, review_date, review_text, author_username, target_movie_id)
values(
       2,
       3,
       '2021-04-05 12:01:31-08',
       'this is all time favorite.',
       'Anonymous',
       1);

insert into reviews(id, rating, review_date, review_text, author_username, target_movie_id)
values(
       3,
       4,
       '2021-04-05 12:01:31-08',
       'they are siblings.....but good movie though',
       'Anonymous',
       2);

insert into reviews(id, rating, review_date, review_text, author_username, target_movie_id)
values(
       4,
       5,
       '2021-04-05 12:01:31-08',
       'star wars is going strong',
       'Anonymous',2);

insert into reviews(id, rating, review_date, review_text, author_username, target_movie_id)
values(
       5,
       4,
       '2021-04-05 12:01:31-08',
       'As for artistic inspiration for bullet time, ' ||
       'I would credit Otomo Katsuhiro, who co-wrote and directed Akira,' ||
       ' which definitely blew me away, along with director Michel Gondry. ',
       'Anonymous',
       2);


insert into reviews(id, rating, review_date, review_text, author_username, target_movie_id)
values(
       6,
       5,
       '2021-04-05 12:01:31-08',
        'The Matrix draws from and alludes to numerous cinematic and literary works, ' ||
        'and concepts from mythology, religion and philosophy, including the ideas of Buddhism,' ||
        ' Christianity, Gnosticism, Hinduism, and Judaism ',
        'Anonymous',
       3);

insert into reviews(id, rating, review_date, review_text, author_username, target_movie_id)
values(
        7,
        2,
        '2021-04-05 12:01:31-08',
        'Too much violence',
        'Anonymous',
        3);

insert into reviews(id, rating, review_date, review_text, author_username, target_movie_id)
values(
        8,
        2,
        '2021-04-05 12:01:31-08',
        'They did not want to add Moshu into the movie because it was too much fantasy.' ||
        'but they did add a witch in the story',
        'Anonymous',
        4);


insert into reviews(id, rating, review_date, review_text, author_username, target_movie_id)
values(
        9,
        1,
        '2021-04-05 12:01:31-08',
        'how did star wars come in to this movie?',
        'Anonymous',
        4);

insert into reviews(id, rating, review_date, review_text, author_username, target_movie_id)
values(
        10,
        4,
        '2021-04-05 12:01:31-08',
        'it was a ok movie, but the animated one was way better',
        'Anonymous',
        4);

insert into reviews(id, rating, review_date, review_text, author_username, target_movie_id)
values(
        11,
        3,
        '2021-04-05 12:01:31-08',
        'Viewers interested in martial-arts action are bound to find the combat-with-a-C to be lackluster in that way that hand-to-hand fighting tends to be ' ||
        'when it gets drowned out by digital effects',
        'Anonymous',
        5);

insert into reviews(id, rating, review_date, review_text, author_username, target_movie_id)
values(
        12,
        4,
        '2021-04-05 12:01:31-08',
        'Nostalgic, hope it will be more.',
        'Anonymous',
        5);


insert into reviews(id, rating, review_date, review_text, author_username, target_movie_id)
values(
        13,
        2,
        '2021-04-05 12:01:31-08',
        'Except from get over her .... it was the same as in 1995.',
        'Anonymous',
        5);

