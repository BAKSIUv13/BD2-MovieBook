-- MySQL Workbench Synchronization
-- Generated: 2018-12-17 21:12
-- Model: New Model
-- Version: 1.0
-- Project: Name of the project
-- Author: BAKSIUv13

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

CREATE SCHEMA IF NOT EXISTS `MovieBookDataBase` DEFAULT CHARACTER SET utf8 ;

CREATE TABLE IF NOT EXISTS `MovieBookDataBase`.`Show` (
  `idShow` INT(11) NOT NULL AUTO_INCREMENT,
  `dateTime` DATETIME NOT NULL,
  `Cinema_idCinema` INT(11) NOT NULL,
  `Movie_idMovie` INT(11) NOT NULL,
  PRIMARY KEY (`idShow`),
  INDEX `fk_Show_Cinema_idx` (`Cinema_idCinema` ASC) VISIBLE,
  INDEX `fk_Show_Movie1_idx` (`Movie_idMovie` ASC) INVISIBLE,
  INDEX `date` (`dateTime` ASC) VISIBLE,
  CONSTRAINT `fk_Show_Cinema`
    FOREIGN KEY (`Cinema_idCinema`)
    REFERENCES `MovieBookDataBase`.`Cinema` (`idCinema`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Show_Movie1`
    FOREIGN KEY (`Movie_idMovie`)
    REFERENCES `MovieBookDataBase`.`Movie` (`idMovie`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `MovieBookDataBase`.`Cinema` (
  `idCinema` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `city` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idCinema`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `MovieBookDataBase`.`Artist` (
  `idArtist` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `origin` VARCHAR(45) NULL DEFAULT NULL,
  `birthDate` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idArtist`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `MovieBookDataBase`.`ArtistType` (
  `name` VARCHAR(64) NOT NULL,
  PRIMARY KEY (`name`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `MovieBookDataBase`.`Artist_has_ArtistType` (
  `Artist_idArtist` INT(11) NOT NULL,
  `ArtistType_name` VARCHAR(64) NOT NULL,
  INDEX `fk_Artist_has_ArtistType_ArtistType1_idx` (`ArtistType_name` ASC) VISIBLE,
  INDEX `fk_Artist_has_ArtistType_Artist1_idx` (`Artist_idArtist` ASC) VISIBLE,
  CONSTRAINT `fk_Artist_has_ArtistType_Artist1`
    FOREIGN KEY (`Artist_idArtist`)
    REFERENCES `MovieBookDataBase`.`Artist` (`idArtist`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Artist_has_ArtistType_ArtistType1`
    FOREIGN KEY (`ArtistType_name`)
    REFERENCES `MovieBookDataBase`.`ArtistType` (`name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `MovieBookDataBase`.`Movie` (
  `idMovie` INT(11) NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NOT NULL,
  `language` VARCHAR(45) NOT NULL,
  `dateOfPremiere` DATETIME NOT NULL,
  `boxOffice` INT(11) NULL DEFAULT NULL,
  `country` VARCHAR(45) NULL DEFAULT NULL,
  `description` VARCHAR(256) NULL DEFAULT NULL,
  `pictureUrl` VARCHAR(256) NULL DEFAULT NULL,
  PRIMARY KEY (`idMovie`),
  INDEX `title` (`title` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8 PARTITION BY KEY(idMovie) PARTITIONS 8 ;

CREATE TABLE IF NOT EXISTS `MovieBookDataBase`.`Genre` (
  `name` VARCHAR(32) NOT NULL,
  PRIMARY KEY (`name`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `MovieBookDataBase`.`Movie_has_Genre` (
  `Movie_idMovie` INT(11) NOT NULL,
  `Genre_name` VARCHAR(32) NOT NULL,
  INDEX `fk_Movie_has_Genre_Genre1_idx` (`Genre_name` ASC) VISIBLE,
  INDEX `fk_Movie_has_Genre_Movie1_idx` (`Movie_idMovie` ASC) VISIBLE,
  CONSTRAINT `fk_Movie_has_Genre_Movie1`
    FOREIGN KEY (`Movie_idMovie`)
    REFERENCES `MovieBookDataBase`.`Movie` (`idMovie`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Movie_has_Genre_Genre1`
    FOREIGN KEY (`Genre_name`)
    REFERENCES `MovieBookDataBase`.`Genre` (`name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `MovieBookDataBase`.`Prize` (
  `idPrize` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `whatFor` VARCHAR(45) NOT NULL,
  `date` DATETIME NOT NULL,
  `Artist_idArtist` INT(11) NULL DEFAULT NULL,
  `Movie_idMovie` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`idPrize`),
  INDEX `fk_Price_Artist1_idx` (`Artist_idArtist` ASC) VISIBLE,
  INDEX `fk_Price_Movie1_idx` (`Movie_idMovie` ASC) VISIBLE,
  CONSTRAINT `fk_Price_Artist1`
    FOREIGN KEY (`Artist_idArtist`)
    REFERENCES `MovieBookDataBase`.`Artist` (`idArtist`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Price_Movie1`
    FOREIGN KEY (`Movie_idMovie`)
    REFERENCES `MovieBookDataBase`.`Movie` (`idMovie`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `MovieBookDataBase`.`TvProgram` (
  `idTvProgram` INT(11) NOT NULL AUTO_INCREMENT,
  `station` VARCHAR(45) NOT NULL,
  `dateTime` DATETIME NOT NULL,
  `Movie_idMovie` INT(11) NOT NULL,
  PRIMARY KEY (`idTvProgram`),
  INDEX `fk_ProgramTV_Movie1_idx` (`Movie_idMovie` ASC) VISIBLE,
  INDEX `station` (`station` ASC) VISIBLE,
  CONSTRAINT `fk_ProgramTV_Movie1`
    FOREIGN KEY (`Movie_idMovie`)
    REFERENCES `MovieBookDataBase`.`Movie` (`idMovie`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `MovieBookDataBase`.`User` (
  `login` VARCHAR(32) NOT NULL,
  `password` VARCHAR(256) NOT NULL,
  `UserType_name` VARCHAR(32) NOT NULL,
  PRIMARY KEY (`login`),
  INDEX `fk_User_UserType1_idx` (`UserType_name` ASC) VISIBLE,
  CONSTRAINT `fk_User_UserType1`
    FOREIGN KEY (`UserType_name`)
    REFERENCES `MovieBookDataBase`.`UserType` (`name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8 PARTITION BY KEY(login) PARTITIONS 8 ;

CREATE TABLE IF NOT EXISTS `MovieBookDataBase`.`UserType` (
  `name` VARCHAR(32) NOT NULL,
  PRIMARY KEY (`name`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `MovieBookDataBase`.`QuizScore` (
  `score` INT(11) NOT NULL,
  `dateTime` DATETIME NULL DEFAULT NULL,
  `User_login` VARCHAR(32) NOT NULL,
  `Quiz_idQuiz` INT(11) NOT NULL,
  INDEX `fk_QuizScore_User1_idx` (`User_login` ASC) VISIBLE,
  INDEX `fk_QuizScore_Quiz1_idx` (`Quiz_idQuiz` ASC) VISIBLE,
  CONSTRAINT `fk_QuizScore_User1`
    FOREIGN KEY (`User_login`)
    REFERENCES `MovieBookDataBase`.`User` (`login`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_QuizScore_Quiz1`
    FOREIGN KEY (`Quiz_idQuiz`)
    REFERENCES `MovieBookDataBase`.`Quiz` (`idQuiz`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `MovieBookDataBase`.`Quiz` (
  `idQuiz` INT(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idQuiz`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `MovieBookDataBase`.`Question` (
  `idQuestion` INT(11) NOT NULL AUTO_INCREMENT,
  `content` VARCHAR(1024) NOT NULL,
  PRIMARY KEY (`idQuestion`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `MovieBookDataBase`.`Quiz_has_Question` (
  `Question_idQuestion` INT(11) NOT NULL,
  `Quiz_idQuiz` INT(11) NOT NULL,
  INDEX `fk_Question_has_Quiz_Quiz1_idx` (`Quiz_idQuiz` ASC) VISIBLE,
  INDEX `fk_Question_has_Quiz_Question1_idx` (`Question_idQuestion` ASC) VISIBLE,
  CONSTRAINT `fk_Question_has_Quiz_Question1`
    FOREIGN KEY (`Question_idQuestion`)
    REFERENCES `MovieBookDataBase`.`Question` (`idQuestion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Question_has_Quiz_Quiz1`
    FOREIGN KEY (`Quiz_idQuiz`)
    REFERENCES `MovieBookDataBase`.`Quiz` (`idQuiz`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `MovieBookDataBase`.`Answer` (
  `idAnswer` INT(11) NOT NULL AUTO_INCREMENT,
  `content` VARCHAR(256) NULL DEFAULT NULL,
  PRIMARY KEY (`idAnswer`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `MovieBookDataBase`.`Answer_has_Question` (
  `Answer_idAnswer` INT(11) NOT NULL,
  `Question_idQuestion` INT(11) NOT NULL,
  INDEX `fk_Answer_has_Question_Question1_idx` (`Question_idQuestion` ASC) VISIBLE,
  INDEX `fk_Answer_has_Question_Answer1_idx` (`Answer_idAnswer` ASC) VISIBLE,
  CONSTRAINT `fk_Answer_has_Question_Answer1`
    FOREIGN KEY (`Answer_idAnswer`)
    REFERENCES `MovieBookDataBase`.`Answer` (`idAnswer`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Answer_has_Question_Question1`
    FOREIGN KEY (`Question_idQuestion`)
    REFERENCES `MovieBookDataBase`.`Question` (`idQuestion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `MovieBookDataBase`.`Issue` (
  `idIssue` INT(11) NOT NULL AUTO_INCREMENT,
  `dateTime` DATETIME NOT NULL,
  `desprition` VARCHAR(256) NOT NULL,
  `Movie_idMovie` INT(11) NOT NULL,
  `User_login` VARCHAR(32) NOT NULL,
  PRIMARY KEY (`idIssue`),
  INDEX `fk_Issue_Movie1_idx` (`Movie_idMovie` ASC) VISIBLE,
  INDEX `fk_Issue_User1_idx` (`User_login` ASC) VISIBLE,
  INDEX `date` (`dateTime` ASC) VISIBLE,
  CONSTRAINT `fk_Issue_Movie1`
    FOREIGN KEY (`Movie_idMovie`)
    REFERENCES `MovieBookDataBase`.`Movie` (`idMovie`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Issue_User1`
    FOREIGN KEY (`User_login`)
    REFERENCES `MovieBookDataBase`.`User` (`login`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `MovieBookDataBase`.`Review` (
  `idReview` INT(11) NOT NULL AUTO_INCREMENT,
  `content` VARCHAR(1024) NOT NULL,
  `Movie_idMovie` INT(11) NOT NULL,
  `User_login` VARCHAR(32) NOT NULL,
  PRIMARY KEY (`idReview`),
  INDEX `fk_Review_Movie1_idx` (`Movie_idMovie` ASC) VISIBLE,
  INDEX `fk_Review_User1_idx` (`User_login` ASC) VISIBLE,
  CONSTRAINT `fk_Review_Movie1`
    FOREIGN KEY (`Movie_idMovie`)
    REFERENCES `MovieBookDataBase`.`Movie` (`idMovie`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Review_User1`
    FOREIGN KEY (`User_login`)
    REFERENCES `MovieBookDataBase`.`User` (`login`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `MovieBookDataBase`.`Like` (
  `Review_idReview` INT(11) NOT NULL,
  `User_login` VARCHAR(32) NOT NULL,
  INDEX `fk_Like_Review1_idx` (`Review_idReview` ASC) VISIBLE,
  INDEX `fk_Like_User1_idx` (`User_login` ASC) VISIBLE,
  CONSTRAINT `fk_Like_Review1`
    FOREIGN KEY (`Review_idReview`)
    REFERENCES `MovieBookDataBase`.`Review` (`idReview`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Like_User1`
    FOREIGN KEY (`User_login`)
    REFERENCES `MovieBookDataBase`.`User` (`login`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `MovieBookDataBase`.`ToWatch` (
  `User_login` VARCHAR(32) NOT NULL,
  `Movie_idMovie` INT(11) NOT NULL,
  INDEX `fk_towatch_User1_idx` (`User_login` ASC) VISIBLE,
  INDEX `fk_towatch_Movie1_idx` (`Movie_idMovie` ASC) VISIBLE,
  CONSTRAINT `fk_towatch_User1`
    FOREIGN KEY (`User_login`)
    REFERENCES `MovieBookDataBase`.`User` (`login`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_towatch_Movie1`
    FOREIGN KEY (`Movie_idMovie`)
    REFERENCES `MovieBookDataBase`.`Movie` (`idMovie`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `MovieBookDataBase`.`Movie_has_Artist` (
  `Movie_idMovie` INT(11) NOT NULL,
  `Artist_idArtist` INT(11) NOT NULL,
  INDEX `fk_Movie_has_Artist_Artist1_idx` (`Artist_idArtist` ASC) VISIBLE,
  INDEX `fk_Movie_has_Artist_Movie1_idx` (`Movie_idMovie` ASC) VISIBLE,
  CONSTRAINT `fk_Movie_has_Artist_Movie1`
    FOREIGN KEY (`Movie_idMovie`)
    REFERENCES `MovieBookDataBase`.`Movie` (`idMovie`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Movie_has_Artist_Artist1`
    FOREIGN KEY (`Artist_idArtist`)
    REFERENCES `MovieBookDataBase`.`Artist` (`idArtist`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `MovieBookDataBase`.`Rating` (
  `User_login` VARCHAR(32) NOT NULL,
  `Movie_idMovie` INT(11) NOT NULL,
  `rate` INT(11) NOT NULL,
  PRIMARY KEY (`User_login`, `Movie_idMovie`),
  INDEX `fk_User_has_Movie_Movie1_idx` (`Movie_idMovie` ASC) VISIBLE,
  INDEX `fk_User_has_Movie_User1_idx` (`User_login` ASC) VISIBLE,
  CONSTRAINT `fk_User_has_Movie_User1`
    FOREIGN KEY (`User_login`)
    REFERENCES `MovieBookDataBase`.`User` (`login`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_User_has_Movie_Movie1`
    FOREIGN KEY (`Movie_idMovie`)
    REFERENCES `MovieBookDataBase`.`Movie` (`idMovie`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
