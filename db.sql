-- drop database if exists.
DROP DATABASE IF EXISTS questionbank;

-- create database named as questionbank.
CREATE DATABASE questionbank;

-- use questionbank database.
USE questionbank;

-- create table named as usertable

CREATE  TABLE `questionbank`.`users` (

  `user_id` INT(8) NOT NULL AUTO_INCREMENT ,

  `email` VARCHAR(45) NOT NULL ,

  `name` VARCHAR(25) NOT NULL ,

  `password` VARCHAR(15) NOT NULL ,

  `dob` DATE NULL ,

  `gender` VARCHAR(10),

  `about_me` VARCHAR(255) NULL ,

  `rating` INT(3) NOT NULL DEFAULT 0 ,

  `status` TINYINT(1) NOT NULL DEFAULT 1 ,

  PRIMARY KEY (`user_id`) ,

  UNIQUE INDEX `email_UNIQUE` (`email` ASC) );


-- create rable named as questions

CREATE  TABLE `questionbank`.`questions` (

  `ques_id` INT(8) NOT NULL AUTO_INCREMENT ,

  `ques_title` VARCHAR(255) NOT NULL ,

  `ques_desc` VARCHAR(5000) NOT NULL ,

  `user_id` INT(8) NULL ,

  `ques_date` TIMESTAMP NOT NULL DEFAULT now(),

  `closing_date` DATE NOT NULL ,     				-- DATE_ADD(CURDATE(),INTERVAL 30 DAY)
  
  `isclosed` BIT(1) NOT NULL DEFAULT 0 ,

  PRIMARY KEY (`ques_id`) ,
  FOREIGN KEY (`user_id`) REFERENCES users(`user_id`) ON DELETE CASCADE );

-- create table named as answers
CREATE  TABLE `questionbank`.`answers` (

  `answer_id` INT(8) NOT NULL AUTO_INCREMENT ,

  `answer` VARCHAR(5000) NOT NULL ,

  `user_id` INT(8) NOT NULL ,

  `ques_id` INT(8) NOT NULL ,

  `answer_date` TIMESTAMP NOT NULL DEFAULT now() ,

  PRIMARY KEY (`answer_id`) ,
  FOREIGN KEY (`user_id`) REFERENCES users(`user_id`) ON DELETE CASCADE ,
  FOREIGN KEY (`ques_id`) REFERENCES questions(`ques_id`) ON DELETE CASCADE );

-- create table as tags
CREATE  TABLE `questionbank`.`tags` (

  `tag_id` INT(2) NOT NULL AUTO_INCREMENT ,

  `tag_name` VARCHAR(20) NOT NULL ,

  `tag_desc` VARCHAR(255) NULL ,

  PRIMARY KEY (`tag_id`) );

-- create tabl as questiontags
CREATE  TABLE `questionbank`.`questionTags` (

  `tag_id` INT(2) NOT NULL ,

  `ques_id` INT(8) NOT NULL ,

  PRIMARY KEY (`tag_id`, `ques_id`) ,
  FOREIGN KEY (`tag_id`) REFERENCES tags(`tag_id`) ON DELETE CASCADE ,
  FOREIGN KEY (`ques_id`) REFERENCES questions(`ques_id`) ON DELETE CASCADE );

-- create table as vaotes
CREATE  TABLE `questionbank`.`votes` (

  `answer_id` INT(8) NOT NULL ,

  `user_id` INT(8) NOT NULL ,

  `upvote_status` INT(1) NOT NULL DEFAULT 0 ,

  PRIMARY KEY (`answer_id`, `user_id`) ,
  FOREIGN KEY (`answer_id`) REFERENCES answers(`answer_id`) ON DELETE CASCADE ,
  FOREIGN KEY (`user_id`) REFERENCES users(`user_id`) ON DELETE CASCADE );


-- insert some dummy data
INSERT INTO users(email, name, password) VALUES('rajeev.sharma@metacube.com', 'Rajeev Kumar Sharma', 'admin');
INSERT INTO users(email, name, password) VALUES('ankit.jain@metacube.com', 'Ankit Sunil Kumar Jain', 'admin');
INSERT INTO users(email, name, password) VALUES('laveena.bachani@metacube.com', 'Laveena Bachani', 'admin');
INSERT INTO users(email, name, password) VALUES('govind.sharma@metacube.com', 'Govind Sharma', 'admin');
INSERT INTO users(email, name, password) VALUES('babita.dadarwal@metacube.com', 'Babita Dadarwal', 'admin');

INSERT INTO `questionbank`.`tags` (`tag_name`) VALUES ('SharePoint');

INSERT INTO `questionbank`.`tags` (`tag_name`) VALUES ('ASP.NET');

INSERT INTO `questionbank`.`tags` (`tag_name`) VALUES ('.NET Framework');

INSERT INTO `questionbank`.`tags` (`tag_name`) VALUES ('Java');

INSERT INTO `questionbank`.`tags` (`tag_name`) VALUES ('JavaScript');

INSERT INTO `questionbank`.`tags` (`tag_name`) VALUES ('MySQL');

INSERT INTO `questionbank`.`tags` (`tag_name`) VALUES ('CSharp');

INSERT INTO `questionbank`.`tags` (`tag_name`) VALUES ('Spring');

INSERT INTO `questionbank`.`tags` (`tag_name`) VALUES ('jQuery');

INSERT INTO `questionbank`.`tags` (`tag_name`) VALUES ('PHP');

INSERT INTO `questionbank`.`tags` (`tag_name`) VALUES ('Servlet');

INSERT INTO `questionbank`.`tags` (`tag_name`) VALUES ('Windows');

INSERT INTO `questionbank`.`tags` (`tag_name`) VALUES ('SalesForce');

INSERT INTO `questionbank`.`tags` (`tag_name`) VALUES ('C');

INSERT INTO `questionbank`.`tags` (`tag_name`) VALUES ('C++');

INSERT INTO `questionbank`.`tags` (`tag_name`) VALUES ('MVC');

INSERT INTO `questionbank`.`tags` (`tag_name`) VALUES ('SQL Server');

INSERT INTO `questionbank`.`tags` (`tag_name`) VALUES ('Linux');

INSERT INTO `questionbank`.`tags` (`tag_name`) VALUES ('VB');

INSERT INTO `questionbank`.`tags` (`tag_name`) VALUES ('Hibernate');

INSERT INTO `questionbank`.`tags` (`tag_name`) VALUES ('Azure');

INSERT INTO `questionbank`.`tags` (`tag_name`) VALUES ('Amazon Web Services');

INSERT INTO `questionbank`.`tags` (`tag_name`) VALUES ('Dynamic CRM');

INSERT INTO `questionbank`.`tags` (`tag_name`) VALUES ('MVC');

INSERT INTO `questionbank`.`tags` (`tag_name`) VALUES ('Windows Store App');

INSERT INTO `questionbank`.`tags` (`tag_name`) VALUES ('Android');

INSERT INTO `questionbank`.`tags` (`tag_name`) VALUES ('iOS');
INSERT INTO `questionbank`.`tags` (`tag_name`) VALUES ('AngularJS');

INSERT INTO `questionbank`.`tags` (`tag_name`) VALUES ('Bootstrap');

INSERT INTO `questionbank`.`tags` (`tag_name`) VALUES ('Design Pattern');



INSERT INTO `questionbank`.`questions`(`ques_title`,`ques_desc`,`user_id`, `closing_date`) VALUES ('DATABSE','what is DATABASE',1,DATE_ADD(CURDATE(),INTERVAL 30 DAY));
INSERT INTO `questionbank`.`questions`(`ques_title`,`ques_desc`,`user_id`, `closing_date`) VALUES ('OOP','what does oop means?',2,DATE_ADD(CURDATE(),INTERVAL 30 DAY));
INSERT INTO `questionbank`.`questions`(`ques_title`,`ques_desc`,`user_id`, `closing_date`) VALUES ('DATABASE','How to use add date in insert query?',3,DATE_ADD(CURDATE(),INTERVAL 30 DAY));
INSERT INTO `questionbank`.`questions`(`ques_title`,`ques_desc`,`user_id`, `closing_date`) VALUES ('JAva','How to handle  sessions?',3,DATE_ADD(CURDATE(),INTERVAL 30 DAY));




INSERT INTO `questionbank`.`answers`(`answer`, `user_id`,`ques_id`) VALUES ('a structured set of data held in a computer, especially one that is accessible in various ways.',2,1);
INSERT INTO `questionbank`.`answers`(`answer`, `user_id`,`ques_id`) VALUES ('Object-oriented programming (OOP) is a programming language model organized around objects rather than "actions" and data rather than logic. Historically, a program has been viewed as a logical procedure that takes input data, processes it, and produces output data.',3,2);
INSERT INTO `questionbank`.`answers`(`answer`, `user_id`,`ques_id`) VALUES ('Object-oriented programming (OOP) is a programming language model organized around objects rather than "actions" and data rather than logic. Historically, a program has been viewed as a logical procedure that takes input data, processes it, and produces output data.',3,4);


INSERT INTO `questionbank`.`votes`(`answer_id`, `user_id`,`upvote_status`) VALUES(1,1,1);
INSERT INTO `questionbank`.`votes`(`answer_id`, `user_id`,`upvote_status`) VALUES(1,2,1);
INSERT INTO `questionbank`.`votes`(`answer_id`, `user_id`,`upvote_status`) VALUES(2,1,-1);
INSERT INTO `questionbank`.`votes`(`answer_id`, `user_id`,`upvote_status`) VALUES(2,2,1);
INSERT INTO `questionbank`.`votes`(`answer_id`, `user_id`,`upvote_status`) VALUES(1,3,1);
INSERT INTO `questionbank`.`votes`(`answer_id`, `user_id`,`upvote_status`) VALUES(3,2,1);