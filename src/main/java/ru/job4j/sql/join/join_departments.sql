create table emploers (
    id serial primary key,
    name_emploer varchar(255)
);

create table departments (
    id serial primary key,
    name_department varchar(255),
    emploers_id int references emploers(id)
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

select * from emploers e
left join departments d on e.id = d.emploers_id;

select * from departments d
right join emploers e on d.emploers_id = e.id;

select * from departments d
full join emploers e on d.emploers_id = e.id;

select e1.name_emploer as Работник, e2.name_emploer as Работник
from emploers e1
cross join emploers e2;