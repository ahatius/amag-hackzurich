CREATE TABLE `hackathon`.`Vehicle` (
  `vin` VARCHAR(17) NOT NULL,
  `commission` VARCHAR(45) NULL,
  `swiss_type_number` VARCHAR(10) NULL,
  `sale_type` VARCHAR(10) NULL,
  `exterior_color` VARCHAR(45) NULL,
  `interior_color` VARCHAR(45) NULL,
  `remarks` VARCHAR(1000) NULL,
  `additional_title` VARCHAR(1000) NULL,
  `added_value_description` VARCHAR(10000) NULL,
  `first_registration` VARCHAR(10) NULL,
  `guaranty` VARCHAR(250) NULL,
  `dealer` INT NOT NULL DEFAULT 0,
  `mileage` INT NOT NULL DEFAULT 0,
  `price` INT NOT NULL DEFAULT 0,
  `seats` INT NOT NULL DEFAULT 0,
  `model_year` INT NOT NULL DEFAULT 0,
  `last_inspection` VARCHAR(10) NULL,
  `car_damaged_in_accident` TINYINT NOT NULL DEFAULT 0,
  `imported` TINYINT NOT NULL DEFAULT 0,
  PRIMARY KEY (`vin`));

CREATE TABLE `hackathon`.`vehicle_image` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `vehicle_vin` VARCHAR(17) NOT NULL COMMENT '',
  `name` VARCHAR(45) NOT NULL COMMENT '',
  `image_data` MEDIUMBLOB NOT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '');
