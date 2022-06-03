-- MySQL Script generated by MySQL Workbench
-- Sat May 28 14:48:15 2022
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering
  
 
-- -----------------------------------------------------
-- Schema eduIT_labDB_BanKModel
-- -----------------------------------------------------
-- drop database if exists eduIT_labDB_BanKModel;
-- -----------------------------------------------------
-- Schema eduIT_labDB_BanKModel
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS eduIT_labDB_BanKModel DEFAULT CHARACTER SET utf8;
USE eduIT_labDB_BanKModel;

-- -----------------------------------------------------
-- Table `eduIT_labDB_BanKModel`.`cities`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS eduIT_labDB_BanKModel.cities (
  id INT(10) NOT NULL AUTO_INCREMENT,
  name VARCHAR(30) NOT NULL,
  PRIMARY KEY (id));


-- -----------------------------------------------------
-- Table `eduIT_labDB_BanKModel`.`offices`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS eduIT_labDB_BanKModel.offices (
  name VARCHAR(30) NOT NULL,
  city_id INT(10) NOT NULL,
  PRIMARY KEY (name),  
    FOREIGN KEY (city_id)
    REFERENCES eduIT_labDB_BanKModel.cities (id)
       ON DELETE CASCADE
   	   ON UPDATE CASCADE);


-- -----------------------------------------------------
-- Table `eduIT_labDB_BanKModel`.`clients`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS eduIT_labDB_BanKModel.clients (
  id VARCHAR(30) NOT NULL,
  client_name VARCHAR(45) NULL,
  city_id INT(10) NOT NULL,
  street VARCHAR(50) NOT NULL,
  PRIMARY KEY (id, city_id),  
    FOREIGN KEY (city_id)
    REFERENCES eduIT_labDB_BanKModel.cities (id)
    ON DELETE CASCADE
    ON UPDATE CASCADE);


-- -----------------------------------------------------
-- Table `eduIT_labDB_BanKModel`.`employees`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS eduIT_labDB_BanKModel.employees (
  id INT(15) NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  phone_number VARCHAR(20) NOT NULL,
  start_date DATE NOT NULL,
  PRIMARY KEY (id));


-- -----------------------------------------------------
-- Table `eduIT_labDB_BanKModel`.`employees_hierarchy`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS eduIT_labDB_BanKModel.employees_hierarchy (
  Employee_subaltern_id INT(15) NOT NULL,
  Employee_boss_id INT(15) NOT NULL,
  PRIMARY KEY (Employee_subaltern_id, Employee_boss_id),
    FOREIGN KEY (Employee_subaltern_id)
    REFERENCES eduIT_labDB_BanKModel.employees (id)
    	ON DELETE CASCADE
    	ON UPDATE CASCADE,
    FOREIGN KEY (Employee_boss_id)
    REFERENCES eduIT_labDB_BanKModel.employees (id)
    	ON DELETE NO ACTION
    	ON UPDATE CASCADE);


-- -----------------------------------------------------
-- Table `eduIT_labDB_BanKModel`.`bank_products`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS eduIT_labDB_BanKModel.bank_products (
  id INT(10) NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NULL,
  PRIMARY KEY (id));


-- -----------------------------------------------------
-- Table `eduIT_labDB_BanKModel`.`client_products`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS eduIT_labDB_BanKModel.client_products (
  id VARCHAR(45) NOT NULL,
  bank_products_id INT(10) NOT NULL,
  clients_id VARCHAR(30) NOT NULL,
  PRIMARY KEY (id, bank_products_id, clients_id),
    FOREIGN KEY (clients_id)
    REFERENCES eduIT_labDB_BanKModel.clients (id)    
    	ON DELETE CASCADE
    	ON UPDATE CASCADE,
    FOREIGN KEY (bank_products_id)
    REFERENCES eduIT_labDB_BanKModel.bank_products (id)    
    	ON DELETE CASCADE
    	ON UPDATE CASCADE);


-- -----------------------------------------------------
-- Table `eduIT_labDB_BanKModel`.`employees_and_clientproducts`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS eduIT_labDB_BanKModel.employees_and_clientproducts (
  client_products_id VARCHAR(45) NOT NULL,
  employees_id INT(15) NOT NULL,
  PRIMARY KEY (client_products_id, employees_id),
    FOREIGN KEY (employees_id)
    REFERENCES eduIT_labDB_BanKModel.employees (id)    
    	ON DELETE NO ACTION
    	ON UPDATE CASCADE,
    FOREIGN KEY (client_products_id)
    REFERENCES eduIT_labDB_BanKModel.client_products (id)    
    	ON DELETE CASCADE
    	ON UPDATE CASCADE);
 
