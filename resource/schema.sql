-- -----------------------------------------------------
-- Schema pjt5_f_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `pjt5_f_db` DEFAULT CHARACTER SET utf8 ;
USE `pjt5_f_db` ;

-- -----------------------------------------------------
-- Table `pjt5_f_db`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pjt5_f_db`.`User` (
  `user_id` VARCHAR(15) NOT NULL,
  `user_nickname` VARCHAR(24) NOT NULL,
  `user_password` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX `user_nickname_UNIQUE` (`user_nickname` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pjt5_f_db`.`Video`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pjt5_f_db`.`Video` (
  `video_id` INT NOT NULL AUTO_INCREMENT,
  `video_title` VARCHAR(45) NOT NULL,
  `video_part` VARCHAR(15) NOT NULL,
  `video_channel_name` VARCHAR(45) NOT NULL,
  `video_url` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`video_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pjt5_f_db`.`Review`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pjt5_f_db`.`Review` (
  `review_id` INT NOT NULL AUTO_INCREMENT,
  `user_id` VARCHAR(15) NULL,
  `video_id` INT NULL,
  `review_title` VARCHAR(45) NULL,
  `review_content` VARCHAR(200) NULL,
  `review_created_at` DATETIME NULL DEFAULT now(),
  `review_like_cnt` INT NULL DEFAULT 0,
  `review_dislike_cnt` INT NULL DEFAULT 0,
  PRIMARY KEY (`review_id`),
  INDEX `user_id_idx` (`user_id` ASC) VISIBLE,
  INDEX `video_id_idx` (`video_id` ASC) VISIBLE,
  CONSTRAINT `user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `pjt5_f_db`.`User` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `video_id`
    FOREIGN KEY (`video_id`)
    REFERENCES `pjt5_f_db`.`Video` (`video_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pjt5_f_db`.`WatchList`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pjt5_f_db`.`WatchList` (
  `user_id` VARCHAR(15) NOT NULL,
  `video_id` INT NOT NULL,
  `watchlist_added_date` DATETIME NULL DEFAULT now(),
  PRIMARY KEY (`user_id`, `video_id`),
  INDEX `video_id_idx` (`video_id` ASC) VISIBLE,
  CONSTRAINT `user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `pjt5_f_db`.`User` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `video_id`
    FOREIGN KEY (`video_id`)
    REFERENCES `pjt5_f_db`.`Video` (`video_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
