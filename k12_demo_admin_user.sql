CREATE TABLE k12_demo.admin_user
(
    ID int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    PASSWORD varchar(256) NOT NULL,
    EMAIL varchar(50) NOT NULL,
    REAL_NAME varchar(20) NOT NULL,
    STATUS smallint(6) DEFAULT '1' NOT NULL
);
INSERT INTO k12_demo.admin_user (PASSWORD, EMAIL, REAL_NAME, STATUS) VALUES ('111111', 'admin@k12.com', '超级管理员', 1);
INSERT INTO k12_demo.admin_user (PASSWORD, EMAIL, REAL_NAME, STATUS) VALUES ('111111', 'test@k12.com', '测试用户', 1);