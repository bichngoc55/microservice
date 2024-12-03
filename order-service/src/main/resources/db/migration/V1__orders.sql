USE order_service;

CREATE TABLE  `orders`  (
                            `id` BIGINT AUTO_INCREMENT  ,
                            `customer_name` VARCHAR(100)  ,
                            `customer_phone` VARCHAR(20),
                            `customer_address` VARCHAR(255),
                            `customer_email` VARCHAR(100),
                            `order_status` VARCHAR(50),
                            `order_date` DATETIME,
                            `quantity` INT,
                            `price` DECIMAL(10, 2),
                            PRIMARY KEY (`id`)
);