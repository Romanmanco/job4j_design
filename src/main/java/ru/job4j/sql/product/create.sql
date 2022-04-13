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

select * from product p
join type_prod t
on p.type_id = t.id
where t.name_type = 'СЫР'; 1

select * from product where name_product like '%мороженое%'; 2

select * from product where expired_date < current_date; 3

select * from product p where p.price = (select max(price) from product); 4

select name_type as Имя_типа, count(*) as Количество_продуктов
from product p left join type_prod t
on p.type_id = t.id
group by name_type; 5

select * from product where type_id = 1 or type_id = 2;

select name_type as Имя_типа, count(*) as Количество_продуктов
from product p left join type_prod t
on p.type_id = t.id
group by name_type
having count(*) < 10;
