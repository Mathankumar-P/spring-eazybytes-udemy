create  table if not exists `contact_msg`(
    `contact_id` int auto_increment primary key,
    `name` varchar(100) not null,
    `mobile_num` varchar(10) not null,
    `email` varchar (100) not null,
    `subject` varchar (100) not null,
    `message` varchar (500) not null,
    `status` varchar (10) not null,
    `created_at` timestamp not null,
    `created_by` varchar(50) not null,
    `updated_at` timestamp default null,
    `updated_by` varchar(50) default null
);

CREATE TABLE IF NOT EXISTS `holidays` (
    `day` varchar(20) NOT NULL,
    `reason` varchar(100) NOT NULL,
    `type` varchar(20) NOT NULL,
    `created_at` TIMESTAMP NOT NULL,
    `created_by` varchar(50) NOT NULL,
    `updated_at` TIMESTAMP DEFAULT NULL,
    `updated_by` varchar(50) DEFAULT NULL
    );