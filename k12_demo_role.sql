CREATE TABLE k12_demo.role
(
    ID int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    NAME varchar(100) NOT NULL,
    REMARK varchar(100),
    STATUS tinyint(4) DEFAULT '1'
);
INSERT INTO k12_demo.role (NAME, REMARK, STATUS) VALUES ('技术支持', '最权限', 1);
INSERT INTO k12_demo.role (NAME, REMARK, STATUS) VALUES ('招生老师', '查看数据', 1);
INSERT INTO k12_demo.role (NAME, REMARK, STATUS) VALUES ('教学总监', '校管中心权限', 1);