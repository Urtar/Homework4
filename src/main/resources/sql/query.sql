-- -----------------------------------------------------
-- Schema Homework4
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Homework4` DEFAULT CHARACTER SET utf8;
USE `scrumlab`;

-- -----------------------------------------------------
-- Table `Homework4`.`newsletter_users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS 'Homework4'.'newsletter_users'
(
  'id'    int                 not null auto_increment primary key,
  'name'  varchar(255)        not null,
  'email' varchar(255) unique not null
);

-- -----------------------------------------------------
-- Table `Homework4`.`newsletter_users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS 'Homework4'.'guest_book'
(
  'id'    int                 not null auto_increment primary key,
  'description'  varchar(255)        not null
);
