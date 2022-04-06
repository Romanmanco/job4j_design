create table fauna (
    id serial primary key,
    name text,
    avg_age int,
    discovery_date date
);

insert into fauna(name, avg_age, discovery_date)
values ('Tiger', 50000, '2018-09-02');
insert into fauna(name, avg_age, discovery_date)
values ('Beer', 17777, '2022-01-11');
insert into fauna(name, avg_age, discovery_date)
values ('Bee', 12000, '2021-12-07');
insert into fauna(name, avg_age, discovery_date)
values ('Fish', 20000, '2022-03-09');
insert into fauna(name, avg_age, discovery_date)
values ('Dog', 20000, null );
insert into fauna(name, avg_age, discovery_date)
values ('Someone', null, '1950-06-03');
insert into fauna(name, avg_age, discovery_date)
values ('Someone', null, '1949-07-02');

select * from fauna;
select * from fauna where name like 'Fish%';
select * from fauna where avg_age > 10000 and avg_age < 21000;
select * from fauna where discovery_date is null;
select * from fauna where discovery_date < '01.01.1950';