insert into devices(name_device, price)
values ('apple', 150), ('samsung', 125), ('huawei', 105);
insert into devices(name_device, price)
values ('nokia', 5001);
select * from devices;

insert into people(name_customer) values ('Вася'), ('Петя'), ('Игорь');
select * from people;

insert into devices_people(device_id, people_id) values (1, 1), (1, 2), (1, 3);
insert into devices_people(device_id, people_id) values (2, 1), (2, 2), (2, 3);
insert into devices_people(device_id, people_id) values (3, 1), (3, 2), (3, 3);

select * from devices_people;
