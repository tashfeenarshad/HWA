DROP TABLE IF EXISTS `cars`;

CREATE TABLE `cars` (
	`id` BIGINT AUTO_INCREMENT,
	`car_make` VARCHAR(255) NOT NULL,
	`Bhp` INT NOT NULL,
	PRIMARY KEY(`id`)
);