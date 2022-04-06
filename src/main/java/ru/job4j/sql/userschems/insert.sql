insert into rules(rule_name) values ('правило1');
insert into rules(rule_name) values ('правило2');
insert into rules(rule_name) values ('правило3');
select * from rules;

insert into role(role_name) values ('роль1');
insert into role(role_name) values ('роль2');
insert into role(role_name) values ('роль3');
select * from role;

insert into categories(category) values ('категория1');
insert into categories(category) values ('категория2');
insert into categories(category) values ('категория3');
select * from categories;

insert into status(status) values ('статус1');
insert into status(status) values ('статус2');
insert into status(status) values ('статус3');
select * from status;

insert into user_one(username, user_role) values ('пользователь1', 1);
insert into user_one(username, user_role) values ('пользователь2', 2);
insert into user_one(username, user_role) values ('пользователь3', 3);
select * from user_one;

insert into role1(role_name, role_rules) values (1, 1);
insert into role1(role_name, role_rules) values (2, 2);
insert into role1(role_name, role_rules) values (2, 3);
select * from role1;

insert into items(creator, items_comment, items_attaches, items_category, items_state)
values (3, 'комментарий1', 'вложение1', 1, 1);
insert into items(creator, items_comment, items_attaches, items_category, items_state)
values (4, 'комментарий2', 'вложение2', 2, 2);
insert into items(creator, items_comment, items_attaches, items_category, items_state)
values (5, 'комментарий3', 'вложение3', 3, 3);
select * from items;

insert into comments(comment) values (2);
insert into comments(comment) values (3);
insert into comments(comment) values (4);
select * from comments;

insert into attaches(attach) values (2);
insert into attaches(attach) values (3);
insert into attaches(attach) values (4);
select * from attaches;