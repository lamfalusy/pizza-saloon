CREATE TABLE IF NOT EXISTS `pizza_saloon`.`pizza` (
  `id` BIGINT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `desciption` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;
