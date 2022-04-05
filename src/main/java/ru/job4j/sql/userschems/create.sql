create table user_one (
id serial primary key,
username text,
user_role text references role(rolename)
);

create table role (
id serial primary key,
role_name text,
role_rules text references rules(rule_name)
);

create table rules (
id serial primary key,
rule_name text
);

create table items (
id serial primary key,
creator text references user_one(username),
items_comment text,
items_attaches text,
items_category text references categories(category),
items_state text references status(status)
);

create table comments (
id serial primary key,
comment text references items(items_comment)
);

create table attaches (
id serial primary key,
attach text references items(items_attaches)
);

create table categories (
id serial primary key,
category text
);

create table status (
id serial primary key,
status text
);