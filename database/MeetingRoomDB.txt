

create table MEETINGROOMS (ROOM_ID INT(10) AUTO_INCREMENT NOT NULL,ROOM_NAME VARCHAR(30) NOT NULL , BUILDING VARCHAR(30) NOT NULL, ACTIVE VARCHAR(1) NOT NULL, PRIMARY KEY(ROOM_ID));


create table USERS (USER_ID INT(10) AUTO_INCREMENT NOT NULL,USER_NAME VARCHAR(30) NOT NULL , USER_LOGINNAME VARCHAR(30) NOT NULL, USER_PASSWORD VARCHAR(20) NOT NULL, ACTIVE VARCHAR(1) NOT NULL, PRIMARY KEY(USER_ID));


create table PUBLICHOLIDAYS (HOLIDAY_ID INT(10) AUTO_INCREMENT NOT NULL, HOLIDAY_NAME VARCHAR(20) NOT NULL, HOLIDAY_DATE DATE NOT NULL, PRIMARY KEY(HOLIDAY_ID));


create table RESERVATIONS (RESERVATION_ID INT(10) AUTO_INCREMENT NOT NULL, ROOM_ID INT(10) NOT NULL, RESERVATION_DATE DATE NOT NULL, RESERVATION_STARTTIME TIME NOT NULL, RESERVATION_ENDTIME TIME NOT NULL, USER_ID INT(10) NOT NULL, RESERVATION_DESCRIPTION VARCHAR(200) NOT NULL, ACTIVE VARCHAR(1) NOT NULL,PRIMARY KEY(RESERVATION_ID));


insert  into publicholidays (holiday_name , holiday_date ) values ('New Year', '2014-01-01');
insert  into publicholidays (holiday_name , holiday_date ) values ('Easter Day', '2014-04-20');
insert  into publicholidays (holiday_name , holiday_date ) values ('Easter Monday', '2014-04-21');
insert  into publicholidays (holiday_name , holiday_date ) values ('Labor Day', '2014-05-01');
insert  into publicholidays (holiday_name , holiday_date ) values ('Ascension Day', '2014-05-29');
insert  into publicholidays (holiday_name , holiday_date ) values ('Whit Sunday', '2014-06-08');
insert  into publicholidays (holiday_name , holiday_date ) values ('Whit Monday', '2014-06-09');
insert  into publicholidays (holiday_name , holiday_date ) values ('Belgian National Day', '2014-07-21');
insert  into publicholidays (holiday_name , holiday_date ) values ('Assumption of Mary', '2014-08-15');
insert  into publicholidays (holiday_name , holiday_date ) values ('All Saints Day', '2014-11-01');
insert  into publicholidays (holiday_name , holiday_date ) values ('Armistice Day', '2014-11-11');
insert  into publicholidays (holiday_name , holiday_date ) values ('Christmas Day', '2014-12-25');


