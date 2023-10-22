USE sport_supplements;


DROP TRIGGER if EXISTS forbid_supplement_updates;
DROP TRIGGER if EXISTS forbid_supplement_deletion;
DROP TRIGGER if EXISTS forbid_inserting_by_another_names;

DELIMITER //
CREATE TRIGGER forbid_supplement_updates BEFORE UPDATE ON supplement FOR EACH ROW
BEGIN
	IF TRUE THEN
         SIGNAL SQLSTATE '45000'
           SET MESSAGE_TEXT = 'You can not modify this table';
       END IF;
end //
DELIMITER //


DELIMITER //
CREATE TRIGGER forbid_supplement_deletion BEFORE DELETE ON supplement FOR EACH ROW
BEGIN
    IF TRUE THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'You can not delete this column';
    END IF;
end //
DELIMITER //

DELIMITER //
CREATE TRIGGER forbid_inserting_by_another_names BEFORE INSERT ON sportsman FOR EACH ROW
BEGIN
    IF !(NEW.name = 'Svitlana' or  NEW.name != 'Petro' or NEW.name != 'Olha' or NEW.name != 'Taras') THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'You can not insert supplement with this name';
    END IF;
    IF (NEW.doctor_id NOT IN (SELECT id from doctor)) THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'You can not insert supplement with this name';
    END IF;
end //
DELIMITER //