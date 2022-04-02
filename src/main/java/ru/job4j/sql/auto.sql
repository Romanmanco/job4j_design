create table auto (
id serial primary key,
name text,
speed varchar,
price int
)
insert into auto(name, speed, price) values ('ford', 150, 125000);
select * from auto;
insert into auto(name, speed, price) values ('audi', 175, 165000);
select * from auto;
insert into auto(name, speed, price) values ('volvo', 135, 111500);
select * from auto;
select speed from auto;
update auto set price = 150000 where name = 'volvo';
select * from auto;
delete from auto where price = 150000;
select * from auto;