create table ticket(
    id serial primary key,
    price int,
    number int
);

create table visitor(
    id serial primary key,
    name varchar(255),
    ticket_id int references ticket(id) unique
);

select * from ticket;
select * from visitor;