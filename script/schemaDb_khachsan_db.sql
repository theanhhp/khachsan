--
-- Database: `khachsan_db`
--

CREATE DATABASE IF NOT EXISTS `khachsan_db`;
USE `khachsan_db`;


-- ENTITIES

--
-- Struttura della tabella `user`
--

CREATE TABLE IF NOT EXISTS `user` (
	`employess` int ,
	`mail` varchar(130) ,
	`name` varchar(130) ,
	`password` varchar(130)  NOT NULL,
	`roles` varchar(130) ,
	`surname` varchar(130) ,
	`username` varchar(130)  NOT NULL,
	
	`_id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT 

);


-- Security

ALTER TABLE `user` MODIFY COLUMN `password` varchar(128)  NOT NULL;

INSERT INTO `khachsan_db`.`user` (`username`, `password`, `_id`) VALUES ('admin', '62f264d7ad826f02a8af714c0a54b197935b717656b80461686d450f7b3abde4c553541515de2052b9af70f710f0cd8a1a2d3f4d60aa72608d71a63a9a93c0f5', 1);

CREATE TABLE IF NOT EXISTS `roles` (
	`role` varchar(30) ,
	
	-- RELAZIONI

	`_user` int(11)  NOT NULL REFERENCES user(_id),
	`_id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT 

);
INSERT INTO `khachsan_db`.`roles` (`role`, `_user`, `_id`) VALUES ('ADMIN', '1', 1);


--
-- Struttura della tabella `bill`
--

CREATE TABLE IF NOT EXISTS `bill` (
	`date` date ,
	`employessid` int ,
	`roomid` int ,
	`salarybill` decimal(6,2) ,
	
	`_id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT 

);


--
-- Struttura della tabella `costomer`
--

CREATE TABLE IF NOT EXISTS `costomer` (
	`age` numeric ,
	`card` numeric ,
	`coderoom` int ,
	`gender` varchar(130) ,
	`namcostomer` varchar(130) ,
	`nationality` varchar(130) ,
	`phonenumber` numeric ,
	
	`_id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT 

);


--
-- Struttura della tabella `employess`
--

CREATE TABLE IF NOT EXISTS `employess` (
	`disc` varchar(130) ,
	`gender` varchar(130) ,
	`name` varchar(130) ,
	`position` varchar(130) ,
	`salary` decimal(6,2) ,
	
	`_id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT 

);


--
-- Struttura della tabella `room`
--

CREATE TABLE IF NOT EXISTS `room` (
	`employessid` int ,
	`idservise` int ,
	`note` varchar(130) ,
	`roomname` varchar(130) ,
	`roomstauts` varchar(130) ,
	`roomtype` varchar(130) ,
	`salary` decimal(6,2) ,
	
	`_id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT 

);


--
-- Struttura della tabella `servise`
--

CREATE TABLE IF NOT EXISTS `servise` (
	`nameservise` varchar(130) ,
	`salary` numeric ,
	
	`_id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT 

);





-- relation 1:m employessid employess - bill
ALTER TABLE `employess` ADD COLUMN `employessid` int(11)  REFERENCES bill(_id);

-- relation 1:m employessid employess - room
ALTER TABLE `employess` ADD COLUMN `employessid` int(11)  REFERENCES room(_id);

-- relation 1:m coderoom room - costomer
ALTER TABLE `room` ADD COLUMN `coderoom` int(11)  REFERENCES costomer(_id);

-- relation 1:m roomid room - bill
ALTER TABLE `room` ADD COLUMN `roomid` int(11)  REFERENCES bill(_id);

-- relation 1:m idservise servise - room
ALTER TABLE `servise` ADD COLUMN `idservise` int(11)  REFERENCES room(_id);


