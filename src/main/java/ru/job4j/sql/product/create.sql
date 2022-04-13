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
where t.name_type = 'СЫР';

select * from product where name_product like '%мороженое%';

select * from product where expired_date < current_date;

select * from product p where p.price = (select max(price) from product);

select name_type as Имя_типа, count(*) as Количество_продуктов
from product p left join type_prod t
on p.type_id = t.id
group by name_type;

select * from product p
join type_prod t
on p.type_id = t.id
where t.name_type = 'СЫР' or t.name_type = 'МОЛОКО';

select name_type as Имя_типа, count(*) as Количество_продуктов
from product p left join type_prod t
on p.type_id = t.id
group by name_type
having count(*) < 10;

select * from product p
join type_prod t
on p.type_id = t.id;

