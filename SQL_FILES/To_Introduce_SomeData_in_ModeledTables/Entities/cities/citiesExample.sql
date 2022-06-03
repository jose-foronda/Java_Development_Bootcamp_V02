use eduit_labdb_bankmodel;

-- describe cities table
describe cities;

-- describe cities table values
select * from cities c ;

-- select based on an id
select name from cities where  id <=> 2;

-- update rows
update cities set name = "Calarca" where id <=> 13;

-- delete rows
delete from cities where id <=> 15;

INSERT INTO eduIT_labDB_BanKModel.cities (name) values ("Soacha");
-- INSERT INTO eduIT_labDB_BanKModel.cities (id, name) values (15, "Soacha");


-- select all columns from cities
select id, name from cities;