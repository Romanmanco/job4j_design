create table devices (
    id serial primary key,
    name_device varchar(255),
    price int
);

create table people (
    id serial primary key,
    name_customer varchar(255)
);

create table devices_people (
    id serial primary key,
    people_id int references people(id),
    device_id int references devices(id)
);

drop table devices_people;
drop table people;
drop table devices;

select avg(price) from devices;

select p.name_customer as Пользователь, avg(d.price) as Средняя_цена_его_устройств
from devices_people as dp
join people p
on dp.people_id = p.id
join devices as d
on dp.device_id = d.id
group by p.name_customer;

select p.name_customer as Пользователь, avg(d.price) as Средняя_цена_его_устройств
from devices_people as dp
join people p
on dp.people_id = p.id
join devices as d
on dp.device_id = d.id
group by p.name_customer
having avg(d.price) > 5000;
