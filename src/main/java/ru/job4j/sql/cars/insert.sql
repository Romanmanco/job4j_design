insert into body_car("name")
values ('Кузов 1'), ('Кузов 2'), ('Кузов 3'), ('Кузов не используется');
select * from body_car;

insert into engine("name")
values ('Двигатель 1'), ('Двигатель не используется'), ('Двигатель 2'), ('Двигатель 3');
select * from engine;

insert into transmission("name")
values ('Коробка передач 1'), ('Коробка передач 2'), ('Коробка не используется'), ('Коробка передач 3');
select * from transmission;

insert into car("name", body_car_id, engine_id, transmission_id)
values ('Машина 1', 1, 1, 1), ('Машина 2', 1, 3, 4), ('Машина 3', 3, 1, null), ('Машина 4', null, 1, null), ('Машина 5', 2, null, null);
select * from car;

drop table body_car;
drop table engine;
drop table transmission;
drop table car;