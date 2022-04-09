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

create table price_devices_people (
    id serial primary key,
    name_customer int references people(id),
    device_id int references devices(id),
    people_id int references people(id)
);

--drop table devices;
--drop table people;
--drop table devices_people;

select avg(price) from devices;

select p.name_customer as Пользователь, avg(dp.device_id) as Средняя_цена_его_устройств
from people as p
join devices_people dp
on p.id = dp.device_id
group by p.name_customer;

--select p.name_customer as Пользователь, avg(d.price) as Средняя_цена
--from people as p
--join devices d
--on p.id = d.id
--group by p.name_customer;

select s.name_device, avg(s.price)
from devices_people as ss
join devices s
on ss.device_id = s.id
group by s.name_device
having avg(s.price) > 5000;