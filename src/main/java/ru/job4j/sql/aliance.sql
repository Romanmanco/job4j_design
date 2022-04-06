create table ticket_cinema (
id serial primary key,
name_film text,
cost int
);

create table visitors_cinema (
id serial primary key,
"name" varchar(255),
ticket_id int references ticket_cinema(id)
);

select * from ticket_cinema;
select * from visitors_cinema;

insert into ticket_cinema(name_film, cost) values ('Операция Ы', 1450);
insert into ticket_cinema(name_film, cost) values ('Бросок кобры', 1200);
insert into ticket_cinema(name_film, cost) values ('Грозовые ворота', 1150);

insert into visitors_cinema(name, ticket_id) values ('Ivan', 3);
insert into visitors_cinema(name, ticket_id) values ('Boris', 2);
insert into visitors_cinema(name, ticket_id) values ('Petr', 1);
insert into visitors_cinema(name) values ('Vasya');
insert into visitors_cinema(name) values ('Anya');

select pp.name, p.name_film, p.cost
from visitors_cinema as pp
join ticket_cinema as p
on pp.ticket_id = p.id;

select pp.name as Имя, p.name_film as Название,
p.cost as Номер from visitors_cinema as pp
join ticket_cinema as p
on pp.ticket_id = p.id;

select pp.name_film as Название, p.cost as Цена
from ticket_cinema as pp
join ticket_cinema as p
on pp.cost = p.cost;