CREATE TABLE IF NOT EXISTS `pizza_saloon`.`pizza` (
  `id` BIGINT AUTO_INCREMENT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;
