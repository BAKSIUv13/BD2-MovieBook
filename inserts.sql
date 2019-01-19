INSERT INTO `Cinema`(`name`, `city`) VALUES ('Cinema City Bemowo','Warsaw');
INSERT INTO `Cinema`(`name`, `city`) VALUES ('Cinema City Arkadia','Warsaw');
INSERT INTO `Cinema`(`name`, `city`) VALUES ('Multikino Złote Tarasy','Warsaw');
INSERT INTO `Cinema`(`name`, `city`) VALUES ('Cinema City','Poznan');
INSERT INTO `Cinema`(`name`, `city`) VALUES ('Multikino','Poznan');
INSERT INTO `Cinema`(`name`, `city`) VALUES ('Cinema City','Wroclaw');
INSERT INTO `Cinema`(`name`, `city`) VALUES ('Multikino','Wroclaw');
INSERT INTO `Cinema`(`name`, `city`) VALUES ('Cinema City','Gdańsk');
INSERT INTO `Cinema`(`name`, `city`) VALUES ('Multikino','Gdańsk');
INSERT INTO `Cinema`(`name`, `city`) VALUES ('Cinema City','Cracow');
INSERT INTO `Cinema`(`name`, `city`) VALUES ('Multikino','Cracow');

INSERT INTO `ArtistType`(`name`) VALUES ('Writer');
INSERT INTO `ArtistType`(`name`) VALUES ('Director');
INSERT INTO `ArtistType`(`name`) VALUES ('Actor');
INSERT INTO `ArtistType`(`name`) VALUES ('Producer');
INSERT INTO `ArtistType`(`name`) VALUES ('Music');

INSERT INTO `Artist`(`name`, `surname`, `origin`, `birthDate`, `pictureUrl`) VALUES ('James','Cameron','Canada','1971-09-16','https://www.nyfa.edu/student-resources/wp-content/uploads/2014/06/James-Cameron.jpg');
INSERT INTO `Artist`(`name`, `surname`, `origin`, `birthDate`, `pictureUrl`) VALUES ('Leonardo','DiCaprio','USA','1974-11-11','http://www.cdn.ug.edu.pl/wp-content/uploads/2014/03/422817_original.jpg');
INSERT INTO `Artist`(`name`, `surname`, `origin`, `birthDate`, `pictureUrl`) VALUES ('Kate','Winslet','United Kingdom','1975-10-05','https://www.longines.pl/uploads/ambassador/part1/ambassador-kate-winslet-800x996.jpg');
INSERT INTO `Artist`(`name`, `surname`, `origin`, `birthDate`, `pictureUrl`) VALUES ('James','Horner','USA','1953-09-14', 'https://resources.wimpmusic.com/images/ed8604b9/9698/4c71/ba18/b7608c54887f/480x480.jpg');

INSERT INTO `Artist_has_ArtistType`(`Artist_idArtist`, `ArtistType_name`) VALUES (1, 'Director');
INSERT INTO `Artist_has_ArtistType`(`Artist_idArtist`, `ArtistType_name`) VALUES (2, 'Actor');
INSERT INTO `Artist_has_ArtistType`(`Artist_idArtist`, `ArtistType_name`) VALUES (3, 'Actor');
INSERT INTO `Artist_has_ArtistType`(`Artist_idArtist`, `ArtistType_name`) VALUES (1, 'Writer');
INSERT INTO `Artist_has_ArtistType`(`Artist_idArtist`, `ArtistType_name`) VALUES (1, 'Producer');
INSERT INTO `Artist_has_ArtistType`(`Artist_idArtist`, `ArtistType_name`) VALUES (4, 'Music');

INSERT INTO `Movie`(`title`, `language`, `dateOfPremiere`, `boxOffice`, `country`, `description`, `pictureUrl`) VALUES ('Titanic', 'English', '1997-11-01', 200000000, 'USA', ' A seventeen-year-old aristocrat falls in love with a kind but poor artist aboard the luxurious, ill-fated R.M.S. Titanic.', 'https://ssl-gfx.filmweb.pl/po/01/87/187/7451731.3.jpg');

INSERT INTO  `29209262_bd2`.`Movie` (
`title` ,
`language` ,
`dateOfPremiere` ,
`boxOffice` ,
`country` ,
`description` ,
`pictureUrl`
)
VALUES ('Deadpool',  'English',  '2016-01-21',  '783100000',  'USA', 'A fast-talking mercenary with a morbid sense of humor is subjected to a rogue experiment that leaves him with accelerated healing powers and a quest for revenge.', 'https://i.pinimg.com/originals/1a/70/6e/1a706e0021180f77cf766c219319045f.jpg'
);



INSERT INTO `UserType`(`name`) VALUES ('Administrator');
INSERT INTO `UserType`(`name`) VALUES ('Editor');
INSERT INTO `UserType`(`name`) VALUES ('Salesman');
INSERT INTO `UserType`(`name`) VALUES ('User');

INSERT INTO `Genre`(`name`) VALUES ('Action');
INSERT INTO `Genre`(`name`) VALUES ('Adventure');
INSERT INTO `Genre`(`name`) VALUES ('Animation');
INSERT INTO `Genre`(`name`) VALUES ('Biography');
INSERT INTO `Genre`(`name`) VALUES ('Comedy');
INSERT INTO `Genre`(`name`) VALUES ('Crime');
INSERT INTO `Genre`(`name`) VALUES ('Drama');
INSERT INTO `Genre`(`name`) VALUES ('Family');
INSERT INTO `Genre`(`name`) VALUES ('Fantasy');
INSERT INTO `Genre`(`name`) VALUES ('Film-Noir');
INSERT INTO `Genre`(`name`) VALUES ('History');
INSERT INTO `Genre`(`name`) VALUES ('Horror');
INSERT INTO `Genre`(`name`) VALUES ('Music');
INSERT INTO `Genre`(`name`) VALUES ('Musical');
INSERT INTO `Genre`(`name`) VALUES ('Mystery');
INSERT INTO `Genre`(`name`) VALUES ('Romance');
INSERT INTO `Genre`(`name`) VALUES ('Sci-Fi');
INSERT INTO `Genre`(`name`) VALUES ('Sport');
INSERT INTO `Genre`(`name`) VALUES ('Thriller');
INSERT INTO `Genre`(`name`) VALUES ('War');
INSERT INTO `Genre`(`name`) VALUES ('Western');

INSERT INTO `User`(`login`, `password`, `UserType_name`) VALUES ('admin', 'admin','Administrator');
INSERT INTO `User`(`login`, `password`, `UserType_name`) VALUES ('editor', 'editor', 'Editor');
INSERT INTO `User`(`login`, `password`, `UserType_name`) VALUES ('salesman', 'salesman', 'Salesman');
INSERT INTO `User`(`login`, `password`, `UserType_name`) VALUES ('user1', 'user1', 'User');
INSERT INTO `User`(`login`, `password`, `UserType_name`) VALUES ('user2', 'user2', 'User');
INSERT INTO `User`(`login`, `password`, `UserType_name`) VALUES ('user3', 'user3', 'User');
INSERT INTO `User`(`login`, `password`, `UserType_name`) VALUES ('user4', 'user4', 'User');
INSERT INTO `User`(`login`, `password`, `UserType_name`) VALUES ('user5', 'user5', 'User');

INSERT INTO `Movie_has_Artist`(`Movie_idMovie`, `Artist_has_ArtistType_id`) VALUES (1, 1);
INSERT INTO `Movie_has_Artist`(`Movie_idMovie`, `Artist_has_ArtistType_id`) VALUES (1, 4);
INSERT INTO `Movie_has_Artist`(`Movie_idMovie`, `Artist_has_ArtistType_id`) VALUES (1, 5);
INSERT INTO `Movie_has_Artist`(`Movie_idMovie`, `Artist_has_ArtistType_id`, `Role`) VALUES (1, 2, 'Jack Dawson');
INSERT INTO `Movie_has_Artist`(`Movie_idMovie`, `Artist_has_ArtistType_id`, `Role`) VALUES (1, 3, 'Rose DeWitt Bukater');
INSERT INTO `Movie_has_Artist`(`Movie_idMovie`, `Artist_has_ArtistType_id`) VALUES (1, 6);

INSERT INTO `Prize`(`name`, `whatFor`, `date`, `Artist_idArtist`, `Movie_idMovie`) VALUES ('Oscar', 'Best Director', '1998', 1, 1);
INSERT INTO `Prize`(`name`, `whatFor`, `date`, `Artist_idArtist`, `Movie_idMovie`) VALUES ('Oscar', 'Best Music', '1998', 4, 1);
INSERT INTO `Prize`(`name`, `whatFor`, `date`, `Artist_idArtist`, `Movie_idMovie`) VALUES ('Oscar', 'Best Actress in a Leading Role', '1998', 3, 1);
INSERT INTO `Prize`(`name`, `whatFor`, `date`, `Artist_idArtist`, `Movie_idMovie`) VALUES ('Golden Globe', 'Best Director - Motion Picture', '1998', 1, 1);

INSERT INTO `Show`(`dateTime`, `Cinema_idCinema`, `Movie_idMovie`) VALUES ('2019-02-03 10:00', 1,1);
INSERT INTO `Show`(`dateTime`, `Cinema_idCinema`, `Movie_idMovie`) VALUES ('2019-02-10 12:00', 7,1);

INSERT INTO `Station`(`name`) VALUES ('TVN');
INSERT INTO `Station`(`name`) VALUES ('Polsat');

INSERT INTO `TvProgram`(`Station_name`, `dateTime`, `Movie_idMovie`) VALUES ('TVN', '2019-02-03 10:00',1 );
INSERT INTO `TvProgram`(`Station_name`, `dateTime`, `Movie_idMovie`) VALUES ('Polsat', '2019-02-10 12:30', 1);

INSERT INTO `Movie_has_Genre`(`Movie_idMovie`, `Genre_name`) VALUES (1, 'Romance');
INSERT INTO `Movie_has_Genre`(`Movie_idMovie`, `Genre_name`) VALUES (1, 'Drama');
INSERT INTO  `29209262_bd2`.`Movie_has_Genre` (
`Movie_idMovie` ,
`Genre_name`
)
VALUES (
'2',  'Comedy'
);
INSERT INTO  `29209262_bd2`.`Movie_has_Genre` (
`Movie_idMovie` ,
`Genre_name`
)
VALUES (
'2',  'Action'
);
INSERT INTO  `29209262_bd2`.`Movie_has_Genre` (
`Movie_idMovie` ,
`Genre_name`
)
VALUES (
'2',  'Adventure'
);

INSERT INTO `Rating`(`User_login`, `Movie_idMovie`, `rate`, `date`) VALUES ('user1', 1, 7, '2019-01-01');
INSERT INTO `Rating`(`User_login`, `Movie_idMovie`, `rate`, `date`) VALUES ('user2', 1, 4, '2019-01-02');
INSERT INTO `Rating`(`User_login`, `Movie_idMovie`, `rate`, `date`) VALUES ('user3', 1, 6, '2019-01-03');
INSERT INTO `Rating`(`User_login`, `Movie_idMovie`, `rate`, `date`) VALUES ('user4', 1, 10, '2019-01-04');

INSERT INTO `Issue`(`dateTime`, `description`, `Movie_idMovie`, `User_login`) VALUES ('2018-12-11 10:00', 'lorem ipsum lorem ipsum', 1, 'user1');
INSERT INTO `Issue`(`dateTime`, `description`, `Movie_idMovie`, `User_login`) VALUES ('2018-12-17 17:45', 'ipsum ipsum lorem lorem', 1, 'user4');

INSERT INTO `ToWatch`(`User_login`, `Movie_idMovie`) VALUES ('user5', 1);

INSERT INTO `Review`(`content`, `Movie_idMovie`, `User_login`, `date`) VALUES ('cool film', 1, 'user1', '2019-01-08');
INSERT INTO `Review`(`content`, `Movie_idMovie`, `User_login`, `date`) VALUES ('interesting film', 1, 'user3', '2019-01-09');

INSERT INTO `Like`(`Review_idReview`, `User_login`, `date`) VALUES (1, 'user2', '2019-01-10');
INSERT INTO `Like`(`Review_idReview`, `User_login`, `date`) VALUES (1, 'user5','2019-01-12');
INSERT INTO `Like`(`Review_idReview`, `User_login`, `date`) VALUES (2, 'user2', '2019-01-13');

INSERT INTO `Answer`(`idAnswer`, `content`) VALUES (1,'15806 Sherpa lane 59096 rock way Alaska');
INSERT INTO `Answer`(`idAnswer`, `content`) VALUES (2, 'A. Hardwits 35 kangaroo way Nostrand');
INSERT INTO `Answer`(`idAnswer`, `content`) VALUES (3, 'P. Sherman 42 wallaby way Sydney');
INSERT INTO `Answer`(`idAnswer`, `content`) VALUES (4, '567 538');
INSERT INTO `Answer`(`idAnswer`, `content`) VALUES (5, '192 000');
INSERT INTO `Answer`(`idAnswer`, `content`) VALUES (6, '564 150');
INSERT INTO `Answer`(`idAnswer`, `content`) VALUES (7, '146 681');

INSERT INTO `Question`(`idQuestion`, `content`, `rightAnswer_idAnswer`) VALUES (1, 'Dory from "Finding Nemo" - What is the address she keeps repeating?', 3);
INSERT INTO `Question`(`idQuestion`, `content`, `rightAnswer_idAnswer`) VALUES (2, 'How many clones were present at the Battle Of Geonosis in Star Wars movie?', 5);

INSERT INTO `Answer_has_Question`(`Answer_idAnswer`, `Question_idQuestion`) VALUES (1,1);
INSERT INTO `Answer_has_Question`(`Answer_idAnswer`, `Question_idQuestion`) VALUES (2,1);
INSERT INTO `Answer_has_Question`(`Answer_idAnswer`, `Question_idQuestion`) VALUES (3,1);
INSERT INTO `Answer_has_Question`(`Answer_idAnswer`, `Question_idQuestion`) VALUES (4,2);
INSERT INTO `Answer_has_Question`(`Answer_idAnswer`, `Question_idQuestion`) VALUES (5,2);
INSERT INTO `Answer_has_Question`(`Answer_idAnswer`, `Question_idQuestion`) VALUES (6,2);
INSERT INTO `Answer_has_Question`(`Answer_idAnswer`, `Question_idQuestion`) VALUES (7,2);

INSERT INTO `Quiz`(`idQuiz`) VALUES (1);

INSERT INTO `Quiz_has_Question`(`Question_idQuestion`, `Quiz_idQuiz`) VALUES (1,1);
INSERT INTO `Quiz_has_Question`(`Question_idQuestion`, `Quiz_idQuiz`) VALUES (2,1);

INSERT INTO `QuizScore`(`score`, `dateTime`, `User_login`, `Quiz_idQuiz`) VALUES (2, '2018-12-24 12:00', 'user1', 1);
INSERT INTO `QuizScore`(`score`, `dateTime`, `User_login`, `Quiz_idQuiz`) VALUES (1, '2018-12-13 14:37', 'user4', 1);
