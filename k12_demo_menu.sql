CREATE TABLE k12_demo.menu
(
    ID int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    NAME varchar(50) NOT NULL,
    PARENT_ID int(11),
    URL varchar(500)
);
INSERT INTO k12_demo.menu (NAME, PARENT_ID, URL) VALUES ('系统管理', null, null);
INSERT INTO k12_demo.menu (NAME, PARENT_ID, URL) VALUES ('菜单管理', 1, '/auth/menu.html');
INSERT INTO k12_demo.menu (NAME, PARENT_ID, URL) VALUES ('角色管理', 1, '/auth/role.html');
INSERT INTO k12_demo.menu (NAME, PARENT_ID, URL) VALUES ('用户管理', 1, '/auth/adminuser.html');
INSERT INTO k12_demo.menu (NAME, PARENT_ID, URL) VALUES ('校管中心', null, '');
INSERT INTO k12_demo.menu (NAME, PARENT_ID, URL) VALUES ('年级列表', 5, '/auth/grade.html');
INSERT INTO k12_demo.menu (NAME, PARENT_ID, URL) VALUES ('学科管理', 5, '/auth/subject.html');
INSERT INTO k12_demo.menu (NAME, PARENT_ID, URL) VALUES ('课程管理', 5, '/auth/course.html');
INSERT INTO k12_demo.menu (NAME, PARENT_ID, URL) VALUES ('教师资料', 5, '/auth/teacher.html');
INSERT INTO k12_demo.menu (NAME, PARENT_ID, URL) VALUES ('数据中心', null, '');
INSERT INTO k12_demo.menu (NAME, PARENT_ID, URL) VALUES ('学员咨询 ', 10, 'students.html');
INSERT INTO k12_demo.menu (NAME, PARENT_ID, URL) VALUES ('课程热度', 10, 'data.html?page=subject_sale');
INSERT INTO k12_demo.menu (NAME, PARENT_ID, URL) VALUES ('销售数据', 10, 'data.html?page=month_sale');
INSERT INTO k12_demo.menu (NAME, PARENT_ID, URL) VALUES ('活跃用户', 10, 'teacher.html');