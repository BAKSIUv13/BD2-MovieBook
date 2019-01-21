DELIMITER $$

CREATE TRIGGER remove_Review_trigger BEFORE DELETE on `Review`
FOR EACH ROW
BEGIN
DELETE FROM `Like`
    WHERE `Like`.Review_idReview = old.idReview;

END $$

DELIMITER ;

DELIMITER $$


DELIMITER $$

CREATE TRIGGER remove_User_trigger BEFORE DELETE on `User`
FOR EACH ROW
BEGIN

DELETE FROM `Rating`
    WHERE `Rating`.User_login = old.login;

DELETE FROM `ToWatch`
    WHERE `ToWatch`.User_login = old.login;

DELETE FROM `Review`
    WHERE `Review`.User_login = old.login; 

DELETE FROM `Issue`
    WHERE `Issue`.User_login = old.login; 

DELETE FROM `Like`
    WHERE `Like`.User_login = old.login;

DELETE FROM `QuizScore`
    WHERE `QuizScore`.User_login = old.login;

END $$

DELIMITER ;

DELIMITER $$
