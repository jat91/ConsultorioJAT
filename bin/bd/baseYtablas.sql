-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema consultoriojat
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema consultoriojat
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `consultoriojat` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `consultoriojat` ;

-- -----------------------------------------------------
-- Table `consultoriojat`.`paciente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `consultoriojat`.`paciente` (
  `pacDni` INT NOT NULL,
  `pacNom` VARCHAR(30) NOT NULL,
  `pacApe` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`pacDni`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `consultoriojat`.`medico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `consultoriojat`.`medico` (
  `medMat` INT NOT NULL,
  `medNom` VARCHAR(30) NOT NULL,
  `medApe` VARCHAR(30) NOT NULL,
  `medEsp` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`medMat`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `consultoriojat`.`historiaclinica`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `consultoriojat`.`historiaclinica` (
  `hcNum` INT NOT NULL,
  `hcFecIng` DATE NOT NULL,
  `hcPacDNI` INT NOT NULL,
  `hcMedMat` INT NOT NULL,
  `hcDiag` VARCHAR(30) NOT NULL,
  `hcTrat` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`hcNum`),
  INDEX `hcPacDNI` (`hcPacDNI` ASC) VISIBLE,
  INDEX `hcMedMat` (`hcMedMat` ASC) VISIBLE,
  CONSTRAINT `historiaclinica_ibfk_1`
    FOREIGN KEY (`hcPacDNI`)
    REFERENCES `consultoriojat`.`paciente` (`pacDni`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `historiaclinica_ibfk_2`
    FOREIGN KEY (`hcMedMat`)
    REFERENCES `consultoriojat`.`medico` (`medMat`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
