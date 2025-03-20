create database board;
use board;
create table USER_INFO(
UI_NUM int not null auto_increment primary key,
UI_NAME VARCHAR(30) not null,
UI_ID VARCHAR(20) not null,
UI_PWD VARCHAR(60) not null,
UI_GRADE CHAR(1) default 1,
CREDAT CHAR(8) default (DATE_FORMAT(NOW(), '%Y%m%d')),
CRETIM CHAR(6) default (DATE_FORMAT(NOW(), '%H%i%s')),
LMODAT CHAR(8) default (DATE_FORMAT(NOW(), '%Y%m%d')),
LMOTIM CHAR(6) default (DATE_FORMAT(NOW(), '%H%i%s'))
);
desc user_info;

private int uiNum;
private String uiName;
private String uiId;
private String uiPwd;
private String uiGrade;
private credat;

select UI_NUM,UI_NAME,UI_ID,UI_PWD,UI_GRADE,CREDAT,CRETIM,LMODAT,LMOTIM from USER_INFO;

insert into USER_INFO(UI_NAME,UI_ID,UI_PWD,UI_GRADE)
values('홍길동','hong','1234','4');
update USER_INFO
set UI_NAME='k',
UI_ID ='j',
UI_PWD='1231',
UI_GRADE = 'r'
where UI_NUM=1;
where BI_NUM=1;
create table BOARD_INFO(
BI_NUM int not null auto_increment primary key,
BI_TITLE VARCHAR(200) not null,
BI_CONTENT TEXT not null,
UI_NUM INT not null,
CREDAT CHAR(8) default (DATE_FORMAT(NOW(), '%Y%m%d')),
CRETIM CHAR(6) default (DATE_FORMAT(NOW(), '%H%i%s')),
LMODAT CHAR(8) default (DATE_FORMAT(NOW(), '%Y%m%d')),
LMOTIM CHAR(6) default (DATE_FORMAT(NOW(), '%H%i%s')),
constraint
foreign key (UI_NUM) references USER_INFO(UI_NUM)
);

desc BOARD_INFO;
private int biNum;
private String biTitle;
private String biContent;
private int uiNum;
priavte String CREDAT;
select BI_NUM, BI_TITLE,BI_CONTENT,UI_NUM,CREDAT,CRETIM,LMODAT,LMOTIM from board_INFO;
insert into board_INFO(BI_TITLE,BI_CONTENT,UI_NUM)
VALUES('1','2',4);

