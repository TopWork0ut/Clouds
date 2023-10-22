DROP SCHEMA IF EXISTS `sport_supplements` ;

CREATE SCHEMA IF NOT EXISTS `sport_supplements` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `sport_supplements` ;

CREATE TABLE IF NOT EXISTS `sport_supplements`.`dish` (
                                                          `id` INT NOT NULL AUTO_INCREMENT,
                                                          `name` VARCHAR(50) NOT NULL,
    `components` VARCHAR(300) NULL DEFAULT NULL,
    `calories` INT NOT NULL,
    `manufacturer` VARCHAR(50) NULL DEFAULT NULL,
    `production_date` DATE NOT NULL,
    `consumption_date` DATE NOT NULL,
    PRIMARY KEY (`id`))
    ENGINE = InnoDB
    AUTO_INCREMENT = 31
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `sport_supplements`.`schedule`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sport_supplements`.`schedule` (
                                                              `id` INT NOT NULL AUTO_INCREMENT,
                                                              `start_dieting` DATE NULL DEFAULT NULL,
                                                              `end_dieting` DATE NULL DEFAULT NULL,
                                                              `description` VARCHAR(300) NULL DEFAULT NULL,
    PRIMARY KEY (`id`))
    ENGINE = InnoDB
    AUTO_INCREMENT = 31
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `sport_supplements`.`schedule_dish`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sport_supplements`.`schedule_dish` (
                                                                   `dish_id` INT NOT NULL,
                                                                   `schedule_id` INT NOT NULL,
                                                                   PRIMARY KEY (`dish_id`, `schedule_id`),
    INDEX `schedule_dishies_schedule` (`schedule_id` ASC) VISIBLE,
    CONSTRAINT `schedule_dishies_dishies`
    FOREIGN KEY (`dish_id`)
    REFERENCES `sport_supplements`.`dish` (`id`) on delete cascade on update cascade,
    CONSTRAINT `schedule_dishies_schedule`
    FOREIGN KEY (`schedule_id`)
    REFERENCES `sport_supplements`.`schedule` (`id`) on delete cascade on update cascade)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `sport_supplements`.`supplement`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sport_supplements`.`supplement` (
                                                                `id` INT NOT NULL AUTO_INCREMENT,
                                                                `name` VARCHAR(50) NOT NULL,
    `components` VARCHAR(300) NOT NULL,
    `calories` INT NOT NULL,
    `manufacturer` VARCHAR(50) NOT NULL,
    `production_date` DATE NOT NULL,
    `consumption_date` DATE NOT NULL,
    PRIMARY KEY (`id`))
    ENGINE = InnoDB
    AUTO_INCREMENT = 31
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `sport_supplements`.`schedule_supplement`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sport_supplements`.`schedule_supplement` (
                                                                         `schedule_id` INT NOT NULL,
                                                                         `supplement_id` INT NOT NULL,
                                                                         PRIMARY KEY (`schedule_id`, `supplement_id`),
    INDEX `Table_11_supplements` (`supplement_id` ASC) VISIBLE,
    CONSTRAINT `Table_11_schedule`
    FOREIGN KEY (`schedule_id`)
    REFERENCES `sport_supplements`.`schedule` (`id`) on delete cascade on update cascade,
    CONSTRAINT `Table_11_supplements`
    FOREIGN KEY (`supplement_id`)
    REFERENCES `sport_supplements`.`supplement` (`id`) on delete cascade on update cascade)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;



CREATE TABLE IF NOT EXISTS `sport_supplements`.`doctor` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL,
    `surname` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`))
    ENGINE = InnoDB;
-- -----------------------------------------------------
-- Table `sport_supplements`.`sportsman`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sport_supplements`.`sportsman` (
                                                               `id` INT NOT NULL AUTO_INCREMENT,
                                                               `kind_of_sport` VARCHAR(50) NOT NULL,
    `name` VARCHAR(50) NOT NULL,
                                                               `surname` VARCHAR(50) NOT NULL,
    `height` INT NOT NULL,
    `weight` INT NOT NULL,
    `schedule_id` INT NOT NULL,
    `doctor_id` INT NOT NULL,
    PRIMARY KEY (`id`, `schedule_id`),
    INDEX `fk_sportsman_schedule1_idx` (`schedule_id` ASC) VISIBLE,
    CONSTRAINT `fk_sportsman_schedule1`
    FOREIGN KEY (`schedule_id`)
    REFERENCES `sport_supplements`.`schedule` (`id`) on delete cascade on update cascade)
    ENGINE = InnoDB
    AUTO_INCREMENT = 31
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;

insert into dish(name, components, calories, manufacturer, production_date, consumption_date) values('Tomato','-',120,'-','2020-01-01','2020-02-02');
insert into dish(name, components, calories, manufacturer, production_date, consumption_date) values('Spagetti','Pasta, Ketchup',410,'Italiano','2021-02-01','2021-04-02');
insert into dish(name, components, calories, manufacturer, production_date, consumption_date) values('Pizza','milk,salt,meat',832,'Italiano','2020-01-01','2020-02-01');
insert into dish(name, components, calories, manufacturer, production_date, consumption_date) values('Coffee','nuts',100,'China','2020-01-01','2020-10-01');
insert into dish(name, components, calories, manufacturer, production_date, consumption_date) values('Boom','-',1000,'-','2021-01-01','2022-02-14');
insert into dish(name, components, calories, manufacturer, production_date, consumption_date) values('Tea','leafs',12,'Chine','2020-01-01','2022-01-01');
insert into dish(name, components, calories, manufacturer, production_date, consumption_date) values('Greeny','-',670,'-','2021-01-01','2021-05-08');
insert into dish(name, components, calories, manufacturer, production_date, consumption_date) values('Meat','-',311,'-','2020-01-01','2020-01-10');
insert into dish(name, components, calories, manufacturer, production_date, consumption_date) values('Fish','-',410,'-','2021-01-01','2021-02-02');
insert into dish(name, components, calories, manufacturer, production_date, consumption_date) values('Chunks','-',310,'-','2020-01-01','2020-09-02');

insert into schedule(start_dieting, end_dieting, description) values('2020-01-07','2020-04-09','Two times a week');
insert into schedule(start_dieting, end_dieting, description) values('2020-02-07','2020-05-01','Each day, two times a day');
insert into schedule(start_dieting, end_dieting, description) values('2021-09-10','2021-10-09','Five rimes a week');
insert into schedule(start_dieting, end_dieting, description) values('2020-01-01','2020-04-01','Six times a week');
insert into schedule(start_dieting, end_dieting, description) values('2022-01-07','2022-04-09','One time a week');
insert into schedule(start_dieting, end_dieting, description) values('2022-01-01','2020-08-01','Three times a day');
insert into schedule(start_dieting, end_dieting, description) values('2020-04-03','2020-08-01','Two times a week');
insert into schedule(start_dieting, end_dieting, description) values('2020-09-23','2020-12-23','Two times a week');
insert into schedule(start_dieting, end_dieting, description) values('2020-01-07','2020-04-09','Four times a week');
insert into schedule(start_dieting, end_dieting, description) values('2021-01-07','2022-01-07','Two times a week');

insert into supplement(name, components, calories, manufacturer, production_date, consumption_date) values('Protein','-',240,'Ukraine','2020-03-01','2020-02-10');
insert into supplement(name, components, calories, manufacturer, production_date, consumption_date) values('Gainer','-',510,'Ukraine','2021-02-01','2021-04-02');
insert into supplement(name, components, calories, manufacturer, production_date, consumption_date) values('Creatine','-',782,'Italiano','2020-05-01','2020-02-08');
insert into supplement(name, components, calories, manufacturer, production_date, consumption_date) values('Vitamins','A1,A2,C,E',120,'China','2020-02-01','2020-10-01');
insert into supplement(name, components, calories, manufacturer, production_date, consumption_date) values('Izotonick','-',900,'Ukraine','2021-02-01','2022-02-14');
insert into supplement(name, components, calories, manufacturer, production_date, consumption_date) values('Juice','Fruits,vegetables',421,'Ukraine','2020-01-10','2022-01-01');
insert into supplement(name, components, calories, manufacturer, production_date, consumption_date) values('GymMAss','-',110,'USA','2021-01-01','2021-05-09');
insert into supplement(name, components, calories, manufacturer, production_date, consumption_date) values('Greely','-',831,'USA','2020-01-01','2020-01-10');
insert into supplement(name, components, calories, manufacturer, production_date, consumption_date) values('Countins','-',933,'USA','2021-02-01','2021-02-02');
insert into supplement(name, components, calories, manufacturer, production_date, consumption_date) values('Lities','-',123,'USA','2020-08-01','2020-09-02');


insert into schedule_supplement(schedule_id, supplement_id) values(31,31);
insert into schedule_supplement(schedule_id, supplement_id) values(31,33);
insert into schedule_supplement(schedule_id, supplement_id) values(31,39);
insert into schedule_supplement(schedule_id, supplement_id) values(32,33);
insert into schedule_supplement(schedule_id, supplement_id) values(32,35);
insert into schedule_supplement(schedule_id, supplement_id) values(35,34);
insert into schedule_supplement(schedule_id, supplement_id) values(36,33);
insert into schedule_supplement(schedule_id, supplement_id) values(38,37);
insert into schedule_supplement(schedule_id, supplement_id) values(38,39);
insert into schedule_supplement(schedule_id, supplement_id) values(39,39);

insert into schedule_dish(dish_id,schedule_id) values(31,31);
insert into schedule_dish(dish_id,schedule_id) values(32,33);
insert into schedule_dish(dish_id,schedule_id) values(32,37);
insert into schedule_dish(dish_id,schedule_id) values(33,35);
insert into schedule_dish(dish_id,schedule_id) values(34,31);
insert into schedule_dish(dish_id,schedule_id) values(36,32);
insert into schedule_dish(dish_id,schedule_id) values(37,36);
insert into schedule_dish(dish_id,schedule_id) values(37,31);
insert into schedule_dish(dish_id,schedule_id) values(39,37);
insert into schedule_dish(dish_id,schedule_id) values(39,38);

insert into doctor(name, surname) values('A1','1');
insert into doctor(name, surname) values('A2','12');
insert into doctor(name, surname) values('A3','13');
insert into doctor(name, surname) values('A4','14');
insert into doctor(name, surname) values('A5','15');
insert into doctor(name, surname) values('A6','16');
insert into doctor(name, surname) values('A7','17');
insert into doctor(name, surname) values('A8','18');
insert into doctor(name, surname) values('A9','19');
insert into doctor(name, surname) values('A10','20');

insert into sportsman(name, surname, kind_of_sport,height,weight,schedule_id,doctor_id) values('Oleg1','M1','''powerlifting',172,81,31,1);
insert into sportsman(name, surname, kind_of_sport,height,weight,schedule_id,doctor_id) values('Oleg2','M2','powerlifting',179,89,33,2);
insert into sportsman(name, surname, kind_of_sport,height,weight,schedule_id,doctor_id) values('Oleg3','M3','crossfit',182,83,38,1);
insert into sportsman(name, surname, kind_of_sport,height,weight,schedule_id,doctor_id) values('Oleg4','M4','powerlifting',73,81,36,4);
insert into sportsman(name, surname, kind_of_sport,height,weight,schedule_id,doctor_id) values('Oleg5','M5','crossfit',173,91,34,5);
insert into sportsman(name, surname, kind_of_sport,height,weight,schedule_id,doctor_id) values('Oleg6','M6','swimming',162,61,38,2);
insert into sportsman(name, surname, kind_of_sport,height,weight,schedule_id,doctor_id) values('Oleg7','M7','powerlifting',186,101,32,2);
insert into sportsman(name, surname, kind_of_sport,height,weight,schedule_id,doctor_id) values('Oleg8','M8','powerlifting',189,91,31,9);
insert into sportsman(name, surname, kind_of_sport,height,weight,schedule_id,doctor_id) values('Oleg9','M9','crossfit',191,82,39,7);
insert into sportsman(name, surname, kind_of_sport,height,weight,schedule_id,doctor_id) values('Oleg10','M10','swimming',198,93,38,4);

-- insert into sportsman(name, surname, kind_of_sport,height,weight,schedule_id) values('Oleg1','M1','''powerlifting',172,81,31);
-- insert into sportsman(name, surname, kind_of_sport,height,weight,schedule_id) values('Oleg2','M2','powerlifting',179,89,33);
-- insert into sportsman(name, surname, kind_of_sport,height,weight,schedule_id) values('Oleg3','M3','crossfit',182,83,38);
-- insert into sportsman(name, surname, kind_of_sport,height,weight,schedule_id) values('Oleg4','M4','powerlifting',73,81,36);
-- insert into sportsman(name, surname, kind_of_sport,height,weight,schedule_id) values('Oleg5','M5','crossfit',173,91,34);
-- insert into sportsman(name, surname, kind_of_sport,height,weight,schedule_id) values('Oleg6','M6','swimming',162,61,38);
-- insert into sportsman(name, surname, kind_of_sport,height,weight,schedule_id) values('Oleg7','M7','powerlifting',186,101,32);
-- insert into sportsman(name, surname, kind_of_sport,height,weight,schedule_id) values('Oleg8','M8','powerlifting',189,91,31);
-- insert into sportsman(name, surname, kind_of_sport,height,weight,schedule_id) values('Oleg9','M9','crossfit',191,82,39);
-- insert into sportsman(name, surname, kind_of_sport,height,weight,schedule_id) values('Oleg10','M10','swimming',198,93,38);

