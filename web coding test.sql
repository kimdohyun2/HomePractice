create schema webCodingTest;
use webCodingTest;

create table student(
	stu_num int auto_increment primary key,
    stu_id varchar(50) not null,
    stu_pw varchar(50) not null 
);

create table course(
	cs_num int auto_increment primary key,
    cs_name varchar(50) not null,
    credit int not null,
    max_regi int not null,
    cur_regi int default 0,
    cs_day varchar(20) not null,
    cs_time varchar(20) not null
);

create table course_regist(
	cr_num int auto_increment primary key,
    stu_num int,
    cs_num int,
    foreign key (stu_num) REFERENCES student(stu_num),
    foreign key (cs_num) REFERENCES course(cs_num)
);

insert into course(cs_name, credit, max_regi, cs_day, cs_time) 
values("컴퓨터이론", 3, 20, "금요일", "1-3");
insert into course(cs_name, credit, max_regi, cs_day, cs_time) 
values("UI/UX", 2, 20, "금요일", "5-6");
insert into course(cs_name, credit, max_regi, cs_day, cs_time) 
values("자료구조", 3, 20, "월요일", "1-3");
insert into course(cs_name, credit, max_regi, cs_day, cs_time) 
values("JAVA프로그래밍", 3, 20, "화요일", "1-3");
insert into course(cs_name, credit, max_regi, cs_day, cs_time) 
values("머신러닝", 3, 20, "화요일", "5-7");
insert into course(cs_name, credit, max_regi, cs_day, cs_time) 
values("소프트웨어공학", 3, 20, "수요일", "1-3");
insert into course(cs_name, credit, max_regi, cs_day, cs_time) 
values("클라우드 컴퓨팅", 2, 20, "수요일", "5-6");
insert into course(cs_name, credit, max_regi, cur_regi, cs_day, cs_time) 
values("임베디드시스템", 2, 25, 25, "목요일", "1-2");
insert into course(cs_name, credit, max_regi, cur_regi, cs_day, cs_time) 
values("안드로이드 프로그래밍", 3, 20, 20, "월요일", "1-3");

insert into student(stu_id, stu_pw) values("aaaa", "aaaa");
insert into student(stu_id, stu_pw) values("bbbb", "bbbb");
insert into student(stu_id, stu_pw) values("cccc", "cccc");
insert into student(stu_id, stu_pw) values("dddd", "dddd");
insert into student(stu_id, stu_pw) values("eeee", "eeee");

desc student;
desc course;
desc course_regist;

select * from student;
select * from course;
select * from course_regist;


