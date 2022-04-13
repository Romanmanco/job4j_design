create table body_car (
    id serial primary key,
    "name" text
);

create table engine (
    id serial primary key,
    "name" text
);

create table transmission (
    id serial primary key,
    "name" text
);

create table car (
    id serial primary key,
    "name" text,
    body_car_id int references body_car(id),
    engine_id int references engine(id),
    transmission_id int references transmission(id)
);

select c.name as Название_машины, b.name as Кузов, e.name as Двигатель, t.name as Коробка_передач
from car c
join body_car b
on c.body_car_id = b.id
join engine e
on c.engine_id = e.id
join transmission t
on c.transmission_id = t.id;

select c.name, b.name
from car c
join body_car b
on c.body_car_id = b.id
--group by c.name, b.name, b.id
--having b.id = null;
--where b.name = null;
