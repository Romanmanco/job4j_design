create table devices (
    id serial primary key,
    name_device varchar(255),
    price float
);

create table people (
    id serial primary key,
    name_customer varchar(255)
);

create table devices_people (
    id serial primary key,
    device_id int references devices(id),
    people_id int references people(id)
);

select avg(price) from devices;

select s.name_device as Название_устройства, avg(s.price) as Цена
from devices_people as ss
join devices s
on ss.people_id = s.id
group by s.name_device;

select s.name_device, avg(s.price)
from devices_people as ss
join devices s
on ss.device_id = s.id
group by s.name_device
having avg(s.price) > 5000;