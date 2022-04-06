create table rules (
id serial primary key,
rule_name text
);

create table role (
id serial primary key,
role_name text
);

create table categories (
id serial primary key,
category text
);

create table status (
id serial primary key,
status text
);

create table user_one (
id serial primary key,
username text,
user_role int references role(id)
);

create table role1 (
id serial primary key,
role_name int references role(id),
role_rules int references rules(id)
);

create table items (
id serial primary key,
creator int references user_one(id),
items_comment text,
items_attaches text,
items_category int references categories(id),
items_state int references status(id)
);

create table comments (
id serial references items(id),
comment int references items(id)
);

create table attaches (
id serial references items(id),
attach int references items(id)
);
