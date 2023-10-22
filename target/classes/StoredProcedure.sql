USE sport_supplements;

DROP PROCEDURE IF EXISTS dishInsertion;
DROP PROCEDURE IF EXISTS scheduleDishInsertion;
DROP PROCEDURE IF EXISTS insertionTenDishes;
DROP FUNCTION IF EXISTS getMinCountOfCalories;
DROP PROCEDURE IF EXISTS printMinCountOfCalories;
DROP PROCEDURE IF EXISTS createTables;


Delimiter //
CREATE PROCEDURE dishInsertion(
    IN name VARCHAR(255),
    IN components VARCHAR(255),
    IN calories INT,
    IN manufacturer VARCHAR(255),
    IN production_date DATE,
    IN consumption_date DATE
)
BEGIN
INSERT INTO dish(name, components, calories, manufacturer, production_date, consumption_date)
VALUES (name, components, calories, manufacturer, production_date, consumption_date);
end // DELIMITER ;

Delimiter //
CREATE PROCEDURE scheduleDishInsertion(
    IN dish_id  INT,
    IN schedule_id INT
)
BEGIN
INSERT INTO schedule_dish(dish_id, schedule_id)
VALUES (dish_id,schedule_id);
END // DELIMITER ;

Delimiter //
CREATE PROCEDURE insertionTenDishes(
)
BEGIN
    DECLARE i INT;
    SET i = 0;
    WHILE i < 10 DO
            INSERT INTO dish(name, components, calories, manufacturer, production_date, consumption_date) VALUES (CONCAT('Noname', i), components, calories, manufacturer, production_date, consumption_date);
            SET i = i + 1;
    END WHILE ;
END // DELIMITER ;


DELIMITER //
CREATE FUNCTION getMinCountOfCalories(

)RETURNS INT DETERMINISTIC
begin
    RETURN(SELECT min(calories) FROM dish);
end //

DELIMITER ;


DELIMITER //
CREATE PROCEDURE printMinCountOfCalories(
    OUT min_count_of_calories INT
)
BEGIN
    SET min_count_of_calories = getMinCountOfCalories();
    SELECT min_count_of_calories;
END //
DELIMITER ;



DELIMITER //
CREATE PROCEDURE createTables()
BEGIN
    DECLARE dishes_name VARCHAR(255);
    DECLARE random_number INT;
    DECLARE database_name VARCHAR(255);
    DECLARE x INT;
    DECLARE y INT;

    DECLARE St_Cursor10 CURSOR
        FOR SELECT name FROM dish;

    SET y = 1;
    SET database_name = 'sport_supplements';
    OPEN St_Cursor10;

    myLoop: LOOP
        FETCH St_Cursor10 INTO dishes_name;
        SELECT dishes_name;
        IF y = 6 THEN LEAVE myLoop;
        END IF;

        SET @table_name_var = CONCAT(dishes_name,'_',NOW());

        SET @drop_table = CONCAT('DROP TABLE If EXISTS ', dishes_name, ' ;');

        PREPARE table_deletions FROM @drop_table;
        EXECUTE table_deletions;
        DEALLOCATE PREPARE table_deletions;

        SET @create_table = CONCAT('CREATE TABLE ', dishes_name, ' (id int auto_increment primary key);');

        PREPARE table_creation FROM @create_table;
        EXECUTE table_creation;
        DEALLOCATE PREPARE table_creation;

        SET x = 1;
        SET y = y + 1;
        SET random_number = (SELECT FLOOR(RAND()*9+1));
        looping:LOOP
            SET @column_name = CONCAT('column', x);

            SET @table_name_var = CONCAT(dishes_name,'_', NOW());
            SELECT @table_name_var;
            SET @alter_table = CONCAT('ALTER TABLE ',database_name,'.',dishes_name,' ADD COLUMN ', @column_name, ' varchar(100);');

            PREPARE altering FROM @alter_table;
            EXECUTE altering;
            DEALLOCATE PREPARE altering;

            IF x = random_number THEN LEAVE looping;
            END IF;
            SET x = x+1;
        end loop;
    END LOOP;
    CLOSE St_Cursor10;
END //
DELIMITER ;



