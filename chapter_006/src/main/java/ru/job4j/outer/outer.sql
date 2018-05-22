create table cars (
	id serial primary key,
	name character varying (2000),
	id_transmission integer references transmission (id),
	id_engine integer references engine (id),
	id_gearbox integer references gearbox (id)
);

create table transmission (
	id serial primary key,
	name character varying (2000)
);

create table engine (
	id serial primary key,
	name character varying (2000)
);

create table gearbox (
	id serial primary key,
	name character varying (2000)
);

select * from cars;

select e.name from engine as e right outer join cars as c on c.id_engine <> e.id;
select t.name from transmission as t right outer join cars as c on c.id_transmission <> t.id;
select g.name from gearbox as g right outer join cars as c on c.id_gearbox <> g.id;
