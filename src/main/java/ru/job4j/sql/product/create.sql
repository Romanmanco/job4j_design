create table type_prod (
id serial primary key,
name_type text
);

create table product (
id serial primary key,
name_product text,
type_id int references type_prod(id),
expired_date date,
value int,
price int
);

select * from type_prod where name_type = 'СЫР';

select * from product where name_product like '%мороженое%';

select * from product where expired_date < current_date;

select max(price) as Максилмальная_цена
from product;

select s.name_type as Тип, ss.value as Остаток
from product as ss
join type_prod s
on ss.type_id = s.id
group by s.name_type, ss.value;

select s.name_type as Тип, ss.name_product as Наименование
from product as ss
join type_prod s
on ss.type_id = s.id
group by s.name_type, ss.name_product;


select s.name_type as Тип, sum(value) as Остаток
from product as ss
join type_prod s
on ss.type_id = s.id
group by s.name_type, ss.value
having sum(ss.value) < 10;