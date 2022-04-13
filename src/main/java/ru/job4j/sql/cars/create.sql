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
left join body_car b
on c.body_car_id = b.id
left join engine e
on c.engine_id = e.id
left join transmission t
on c.transmission_id = t.id;

select b.name, c.name
from body_car b
left join car c
on b.id = c.body_car_id
where c.name is null;

'Вывод деталей, которые не используются'

select e.name, c.name
from engine e
left join car c
on e.id = c.engine_id
where c.name is null;

select t.name, c.name
from transmission t
left join car c
on t.id = c.transmission_id
where c.name is null;

'Вывод машин без определенных деталей'

select c.name, b.name
from car c
left join body_car b
on c.body_car_id = b.id
where b.name is null;

select c.name, e.name
from car c
left join engine e
on c.engine_id = e.id
where e.name is null;

select c.name, t.name
from car c
left join transmission t
on c.transmission_id = t.id
where t.name is null;
