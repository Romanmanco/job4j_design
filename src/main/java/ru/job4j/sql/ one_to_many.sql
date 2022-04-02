create table cafe(
    id serial primary key,
    name varchar(255)
);

create table visitor(
    id serial primary key,
    name varchar(255),
    cafe_id int references cafe(id)
);

insert into cafe(name) values ('malibu');
insert into visitor(name, cafe_id) values ('Ivan', 1);

select * from cafe;
select * from visitor where id in (select id from cafe);