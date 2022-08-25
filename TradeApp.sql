
-- Schema TradeDB
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema TradeDB
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `TradeDB` DEFAULT CHARACTER SET utf8 ;
USE `TradeDB` ;

-- -----------------------------------------------------
-- Table `TradeDB`.`ticker`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TradeDB`.`ticker` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `companyName` VARCHAR(45) NOT NULL,
  `tickerSymbol` VARCHAR(45) NOT NULL,
  `price` DECIMAL(10,2) NOT NULL,
  `timezone` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `TradeDB`.`portfolio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TradeDB`.`portfolio` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `tickerId` INT NOT NULL,
  `numShare` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_portfolio_ticker_idx` (`tickerId` ASC) VISIBLE,
  CONSTRAINT `fk_portfolio_ticker`
    FOREIGN KEY (`tickerId`)
    REFERENCES `TradeDB`.`ticker` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `TradeDB`.`order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TradeDB`.`orders` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `createdDate` DATETIME NOT NULL,
  `completedDate` DATETIME NULL,
  `marketPrice` DECIMAL(10,2) NOT NULL,
  `goodTill` DATETIME NOT NULL,
  `numShare` INT NOT NULL,
  `priceType` VARCHAR(45) NOT NULL COMMENT '“Market order” “limit order” “Stop order” “trailing order”',
  `action` VARCHAR(45) NOT NULL COMMENT '“Buy” “Sell”',
  `status` VARCHAR(45) NOT NULL COMMENT '“Open” “Close” “Completed”',
  `tickerId` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_order_ticker_idx` (`tickerId` ASC) VISIBLE,
  CONSTRAINT `fk_order_ticker`
    FOREIGN KEY (`tickerId`)
    REFERENCES `TradeDB`.`ticker` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


INSERT INTO ticker (id, companyName, tickerSymbol, price, timezone)
VALUES (1, "APPLE", "APPL", 163.00, "EST");

INSERT INTO ticker (id, companyName, tickerSymbol, price, timezone)
VALUES (2, "GOOGLE", "GOOGL", 112.00, "EST");


INSERT INTO ticker (id, companyName, tickerSymbol, price, timezone)
VALUES (3, "Amazon", "AMZN", 142.90, "EST");


INSERT INTO ticker (id, companyName, tickerSymbol, price, timezone)
VALUES (4, "Citigroup Inc", "CITI", 54.32, "EST");


INSERT INTO ticker (id, companyName, tickerSymbol, price, timezone)
VALUES (5, "Meta Plaforms Inc", "META", 180.17, "EST");

INSERT INTO ticker (id, companyName, tickerSymbol, price, timezone)
VALUES (6, " Coinbase Global Inc", "COIN", 72.17, "EST");




use tradedb;

insert into orders (completedDate,createdDate, numShare, marketPrice, goodTill, priceType, action, status, tickerId) 
values (now(),now(), 5, 163.00, now(), "marketOrder", "buy", "open", 1);
insert into orders (completedDate,createdDate, numShare, marketPrice, goodTill, priceType, action, status, tickerId) 
values (now(),now(), 4, 163.00, now(), "marketOrder", "buy", "complete", 4);
insert into orders (completedDate,createdDate, numShare, marketPrice, goodTill, priceType, action, status, tickerId) 
values (now(),now(), 1, 163.00, now(), "marketOrder", "sell", "close", 5);

select * from ticker;

truncate table orders;

