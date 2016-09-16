CREATE TABLE IF NOT EXISTS `pizza_saloon`.`order` (
  `id` BIGINT NOT NULL,
  `user_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `df_idx` (`user_id` ASC),
  CONSTRAINT `order_to_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `pizza_saloon`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;