create table type_prod (
id serial primary key,
name_type text
);

create table product (
id serial primary key,
name_product text,
type_id int references type_prod(id),
expired_date text,
value int,
price int
);

select * from product where type_id = 1;

select * from product where name_product like '%мороженое%';

select * from product where expired_date < '2022.04.06';

select max(price) from product;

select s.name_type as Тип, ss.value as Остаток
from product as ss
join type_prod s
on ss.type_id = s.id
group by s.name_type, ss.value;

select * from product where type_id = 1 or type_id = 2;

select s.name_type as Тип, sum(value) as Остаток
from product as ss
join type_prod s
on ss.type_id = s.id
group by s.name_type, ss.value
having sum(ss.value) < 10;

select * from product;