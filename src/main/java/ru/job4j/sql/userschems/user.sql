create table user1(
id serial primary key,
username text
);

create table user_role (
id serial primary key,
rolename text,
user_id int references user1(id)
);

create table role_rules (
id serial primary key,
user_name text references user1(username),
rule_name text references user_role(rolename)
);

create table items (
id serial primary key,
creator text references user1(username),
items_comment text references comments(comment),
items_attaches text references attaches(attach),
items_category text references categories(category),
items_state text references status(status)
);

create table comments (
id serial primary key,
comment text
);

create table attaches (
id serial primary key,
attach text
);

create table categories (
id serial primary key,
category text
);

create table status (
id serial primary key,
status text
);