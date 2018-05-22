create database shalobasov;

create table role (
	id serial primary key,
	name_role character varying (2000)
);

create table state (
	id serial primary key,
	name_state character varying (2000)
);

create table rules (
	id serial primary key,
	rule text
);

create table category (
	id serial primary key,
	category character varying (2000)
);

create table item (
	id serial primary key unique,
	name_item character varying (2000),
	description text,
	id_category integer references category (id),
	id_state integer references state (id)
);

create table users (
	id serial primary key,
	login character varying (2000),
	pasword character varying (2000),
	create_date timestamp,
	id_role integer references role (id),
	id_item integer references item (id)
);

create table comments (
	id serial primary key,
	description text,
	item_id integer references item (id)
);

create table attach (
	id serial primary key,
	attach character (2000),
	item_id integer references item (id)
);

create table roles_rules (
	role_id integer references role (id),
	rules_id integer references rules (id)
);

insert into role (name_role) values ('администратор');
insert into role (name_role) values ('подаватель заявки');
insert into role (name_role) values ('редактор заявок');


insert into state (name_state) values ('редактор заявок');
insert into state (name_state) values ('подаватель заявки');
insert into state (name_state) values ('администратор');


insert into rules (rule) values ('редактирование');
insert into rules (rule) values ('удаление');
insert into rules (rule) values ('закрытие');
insert into rules (rule) values ('решение вопроса по заявки');


insert into category (category) values ('входящие');
insert into category (category) values ('архив');
insert into category (category) values ('исходящие');

insert into item (name_item, description, id_category, id_state) values ('первая заявка', 'первое описание', '1', '2');

insert into users (login, pasword, create_date, id_role, id_item) values ('первая пользователь', 'первыйпароль', '1999-01-02 04:05:06', '2', '1');

insert into attach (attach, item_id) values ('первый attach', '1');

insert into comments (description, item_id) values ('первое описание', '1');
