insert into type_prod(name_type) values ('СЫР'), ('МОЛОКО'), ('МЯСО');
select * from type_prod;

insert into product(name_product, type_id, expired_date, value, price)
values ('Сыр копченый', 1, '2022.07.01', 15, 250),
('Сыр сулугуни', 1, '2022.11.03', 12, 175),
('Мясо копченое', 3, '2022.12.09', 5, 450),
('Молоко пастеризованное', 2, '2022.04.05', 6, 65),
('Молоко цельное', 2, '2022.09.06', 8, 75),
('Мясо мороженое', 3, '2022.01.05', 8, 450);
select * from product;


