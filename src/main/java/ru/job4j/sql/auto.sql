CREATE TABLE auto (
    id serial primary key,
    name text,
    speed varchar,
    price int
);
insert into auto(name, speed, price) values ('ford','mini','ferrari');
update auto set speed = '150 m/h';
update auto set price = '200000$';
update auto set price = '150000 $' where id = 2;
delete from auto where price = '150000 $';

select * from auto;