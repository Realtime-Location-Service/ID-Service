CREATE TABLE `company` (
                                  `id` INT NOT NULL AUTO_INCREMENT COMMENT 'Primary key.',
                                  `cid` varchar(255) NOT NULL COMMENT 'Unique id for this company. This is communicable among different services.',
                                  `domain` varchar(255) NOT NULL COMMENT 'Unique domain for the company',
                                  `name` varchar(255) NOT NULL COMMENT 'Name of the company',
                                  `created_at` timestamp DEFAULT NULL COMMENT 'Time of creation of the entry',
                                  `updated_at` timestamp DEFAULT NULL COMMENT 'Time of last update of any column',
                                  `deleted_at` timestamp DEFAULT NULL COMMENT 'Time of soft delete',
                                  PRIMARY KEY (`id`),
                                  UNIQUE KEY `uk_company_cid` (`cid`),
                                  UNIQUE KEY `uk_company_domain` (`domain`)
) ENGINE=InnoDB CHARSET=utf8;


CREATE TABLE `user` (
                               `id` INT NOT NULL AUTO_INCREMENT COMMENT 'Primary key.',
                               `company_id` INT NOT NULL COMMENT 'FK to the company',
                               `user_id` varchar(255) NOT NULL COMMENT 'Id of a user. Will be unique per company.',
                               `app_key` varchar(255) DEFAULT NULL,
                               `role` varchar(255) DEFAULT NULL,
                               `created_at` timestamp DEFAULT NULL COMMENT 'Time of creation of the entry',
                               `updated_at` timestamp DEFAULT NULL COMMENT 'Time of last update of any column',
                               `deleted_at` timestamp DEFAULT NULL COMMENT 'Time of soft delete',
                               PRIMARY KEY (`id`),
                               UNIQUE KEY `uk_user_company_id_user_id` (`company_id`, `user_id`),
                               KEY `idx_user_company_id` (`company_id`),
                               CONSTRAINT `fk_user_company_id` FOREIGN KEY (`company_id`) REFERENCES `company` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB CHARSET=utf8;