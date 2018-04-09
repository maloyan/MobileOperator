-- -----------------------------------------------------
-- Table `Customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Customer` (
  `Customer_ID` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `company` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `address` VARCHAR(45) NOT NULL,
  `commersial_or_personal` VARCHAR(45) NOT NULL,
  `passport` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Customer_ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Tariff`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Tariff` (
  `Tariff_ID` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `int_mb` INT NULL,
  `int_day` INT NULL,
  `call_day_per_minute` INT NULL,
  `call_night_per_minute` INT NULL,
  `call_per_day` INT NULL,
  `sms` INT NULL,
  PRIMARY KEY (`Tariff_ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Contract`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Contract` (
  `Contract_ID` INT NOT NULL AUTO_INCREMENT,
  `Customer_ID` INT NOT NULL,
  `Tariff_ID` INT NOT NULL,
  `phone_number` VARCHAR(45) NULL,
  `balance` INT NOT NULL,
  `register_date` DATETIME NULL,
  PRIMARY KEY (`Contract_ID`),
  CONSTRAINT `fk_Contract_Customer`
    FOREIGN KEY (`Customer_ID`)
    REFERENCES `Customer` (`Customer_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Contract_Tariff`
    FOREIGN KEY (`Tariff_ID`)
    REFERENCES `Tariff` (`Tariff_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Services`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Services` (
  `Service_ID` INT NOT NULL AUTO_INCREMENT,
  `service_name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(45) NULL,
  PRIMARY KEY (`Service_ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Event`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Event` (
  `Event_ID` INT NOT NULL AUTO_INCREMENT,
  `Contract_ID` INT NOT NULL,
  `Service_ID` INT NOT NULL,
  `start_date` DATETIME NOT NULL,
  `end_date` DATETIME NULL,
  `amount` INT NOT NULL,
  PRIMARY KEY (`Event_ID`),
  CONSTRAINT `fk_Event_Contract`
    FOREIGN KEY (`Contract_ID`)
    REFERENCES `Contract` (`Contract_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Event_Services`
    FOREIGN KEY (`Service_ID`)
    REFERENCES `Services` (`Service_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
