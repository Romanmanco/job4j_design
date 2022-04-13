insert into devices(name_device, price)
values ('apple', 6000), ('samsung', 4000), ('huawei', 3000), ('nokia', 2000);
select * from devices;

insert into people(name_customer) values ('Вася'), ('Петя'), ('Игорь');
select * from people;

insert into devices_people(people_id, device_id) values (1, 1), (1, 2), (1, 3);
insert into devices_people(people_id, device_id) values (2, 2), (2, 1), (2, 2);
insert into devices_people(people_id, device_id) values (3, 1), (3, 1), (3, 1);
select * from devices_people;
