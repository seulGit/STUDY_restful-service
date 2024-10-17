insert into users(id, join_date, name, password, ssn) values (90001, now(), 'User1', 'test111', '701010-1111111');
insert into users(id, join_date, name, password, ssn) values (90002, now(), 'User2', 'test222', '801212-1111111');
insert into users(id, join_date, name, password, ssn) values (90003, now(), 'User3', 'test333', '901110-1111111');

insert into post(description, user_id) values('My First Post', 90001);
insert into post(description, user_id) values('My Second Post', 90001);