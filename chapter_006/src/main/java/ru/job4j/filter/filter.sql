select * from product as p
inner join type as t on t.name = "СЫР";

select * from product
where name like '%мороженное';

select * from product
where expired_date < '2018-30-06 12:00:00';

select max(price) from product;

select count(*) from product as p
inner join type as t on t.name = "СЫР";

select * from product as p
inner join type as t on t.name = "СЫР" or t.name = "МОЛОКО";

select t.name from type as t
inner join product as p
where count(p.id) < 10;

select p.name, t.type from product as p
inner join type as t;
