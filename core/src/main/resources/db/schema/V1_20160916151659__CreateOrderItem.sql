CREATE TABLE IF NOT EXISTS `pizza_saloon`.`order_item` (
  `id` BIGINT NOT NULL,
  `order_id` BIGINT NOT NULL,
  `pizza_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `order_item_to_order_idx` (`order_id` ASC),
  INDEX `order_item_to_pizza_idx` (`pizza_id` ASC),
  CONSTRAINT `order_item_to_order`
    FOREIGN KEY (`order_id`)
    REFERENCES `pizza_saloon`.`order` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `order_item_to_pizza`
    FOREIGN KEY (`pizza_id`)
    REFERENCES `pizza_saloon`.`pizza` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;