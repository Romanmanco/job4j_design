 create table visitor(
     id serial primary key,
     name varchar(255)
 );

 create table menu_cafe(
     id serial primary key,
     name varchar(255)
 );

 create table visitors_orders(
     id serial primary key,
     visitor_id int references visitor(id),
     menu_cafe_id int references menu_cafe(id)
 );

insert into visitor(name) values ('Mickal');
insert into visitor(name) values ('Maxim');
insert into visitor(name) values ('Roman');

insert into menu_cafe(name) values ('Pasta');
insert into menu_cafe(name) values ('Pizza');
insert into menu_cafe(name) values ('Coca-cola');

insert into visitors_orders(visitor_id, menu_cafe_id) values (1, 1);
insert into visitors_orders(visitor_id, menu_cafe_id) values (1, 2);
insert into visitors_orders(visitor_id, menu_cafe_id) values (1, 3);
insert into visitors_orders(visitor_id, menu_cafe_id) values (2, 1);
insert into visitors_orders(visitor_id, menu_cafe_id) values (2, 2);
insert into visitors_orders(visitor_id, menu_cafe_id) values (3, 3);

select * from visitor;
select * from menu_cafe;
select * from visitors_orders;