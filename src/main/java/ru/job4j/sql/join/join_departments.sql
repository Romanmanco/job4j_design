create table emploers (
    id serial primary key,
    name_emploer varchar(255)
);

create table departments (
    id serial primary key,
    name_department varchar(255),
    emploers_id int references emploers(id)
);

create table teens (
id serial primary key,
"name" text
);

create table teens1 (
id serial primary key,
gender text
);

insert into emploers(name_emploer) values ('Работник 1');
insert into emploers(name_emploer) values ('Работник 2');
insert into emploers(name_emploer) values ('Работник 3');

insert into departments(name_department, emploers_id) values ('Оодел 1', 1);
insert into departments(name_department, emploers_id) values ('Оодел 2', 2);
insert into departments(name_department, emploers_id) values ('Оодел 3', 3);
insert into departments(name_department, emploers_id) values ('Оодел 4', 1);
insert into departments(name_department, emploers_id) values ('Оодел 5', null);
insert into departments(name_department, emploers_id) values ('Оодел 6', null );

insert into teens1(gender) values ('Гендер1');
insert into teens1(gender) values ('Гендер2');
insert into teens1(gender) values ('Гендер3');

insert into teens(name) values ('Имя1');
insert into teens(name) values ('Имя2');
insert into teens(name) values ('Имя3');

select * from emploers e
left join departments d on e.id = d.emploers_id;

select * from departments d
right join emploers e on d.emploers_id = e.id;

select * from departments d
left join emploers e
on d.emploers_id = e.id where e.id is null;

select * from departments d
full join emploers e on d.emploers_id = e.id;

select e1.name_emploer as Работник, e2.name_emploer as Работник
from emploers e1
cross join emploers e2;

select * from emploers e left join departments d on e.id = d.emploers_id;
select * from departments d right join emploers e on e.id = d.emploers_id;

select * from departments d left join emploers e on d.emploers_id = e.id;
select * from emploers e right join departments d on d.emploers_id = e.id;

select e1.name as Имя, e2.gender as Гендер
from teens e1
cross join teens1 e2;