CREATE TABLE `setup-tecnorepo`.`categoria` (
  `id` INT NOT NULL,
  `nombre` VARCHAR(45) NULL,
  `categoria_padre` INT NULL,
  PRIMARY KEY (`id`));
  
  CREATE TABLE `setup-tecnorepo`.`miembro` (
  `id` INT NOT NULL,
  `nombre` VARCHAR(45) NULL,
  `descripcion` LONGTEXT NULL,
  `categoria_id` INT NOT NULL,
  PRIMARY KEY (`id`));

  ALTER TABLE `setup-tecnorepo`.`miembro` 
ADD CONSTRAINT `categoria_id`
  FOREIGN KEY (`categoria_id`)
  REFERENCES `setup-tecnorepo`.`categoria` (`id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;
  
  
    ALTER TABLE `setup-tecnorepo`.`categoria` 
ADD CONSTRAINT `categoria_padre`
  FOREIGN KEY (`categoria_padre`)
  REFERENCES `setup-tecnorepo`.`categoria` (`id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;
