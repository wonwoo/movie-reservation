insert into CUSTOMER(NAME) values('wonwoo');

insert into movie (PRICE, RUNNING_TIME, TITLE) values(10000, 90, '아저씨');
insert into movie (PRICE, RUNNING_TIME, TITLE) values(9000, 100, '시간을 털자');
insert into movie (PRICE, RUNNING_TIME, TITLE) values(8000, 80, '날 보러 와요');

insert into SCREEN(MOVIE_ID, SCREEN_TIME, SEQ) values(1L,'2016-04-24 11:30:00',1);
insert into SCREEN(MOVIE_ID, SCREEN_TIME, SEQ) values(1L,'2016-04-24 12:30:00',2);
insert into SCREEN(MOVIE_ID, SCREEN_TIME, SEQ) values(1L,'2016-04-24 13:30:00',3);
insert into SCREEN(MOVIE_ID, SCREEN_TIME, SEQ) values(1L,'2016-04-24 14:30:00',4);
insert into SCREEN(MOVIE_ID, SCREEN_TIME, SEQ) values(1L,'2016-04-24 19:20:00',5);
insert into SCREEN(MOVIE_ID, SCREEN_TIME, SEQ) values(1L,'2016-04-24 21:00:00',6);
insert into SCREEN(MOVIE_ID, SCREEN_TIME, SEQ) values(1L,'2016-04-24 23:00:00',7);
insert into SCREEN(MOVIE_ID, SCREEN_TIME, SEQ) values(1L,'2016-04-24 23:55:00',8);
insert into SCREEN(MOVIE_ID, SCREEN_TIME, SEQ) values(1L,'2016-04-25 01:00:00',9);

insert into SCREEN(MOVIE_ID, SCREEN_TIME, SEQ) values(2L,'2016-04-24 12:00:00',1);
insert into SCREEN(MOVIE_ID, SCREEN_TIME, SEQ) values(2L,'2016-04-24 13:30:00',2);
insert into SCREEN(MOVIE_ID, SCREEN_TIME, SEQ) values(2L,'2016-04-24 16:30:00',3);
insert into SCREEN(MOVIE_ID, SCREEN_TIME, SEQ) values(2L,'2016-04-24 17:20:00',4);
insert into SCREEN(MOVIE_ID, SCREEN_TIME, SEQ) values(2L,'2016-04-24 22:10:00',5);


insert into DIS_COUNT(MOVIE_ID, DIS_COUNT_TYPE,PRICE) values(1, 'AMOUNT', 1000);
insert into DIS_COUNT(MOVIE_ID, DIS_COUNT_TYPE,PRICE) values(2, 'PERCENT', 10);

insert into DIS_COUNT_RULE(DISCOUNT_ID, SEQ) values(1, 1);
insert into DIS_COUNT_RULE(DISCOUNT_ID, SEQ) values(1, 9);
insert into DIS_COUNT_RULE(DISCOUNT_ID, SEQ) values(2, 2);
insert into DIS_COUNT_RULE(DISCOUNT_ID, SEQ) values(2, 5);



