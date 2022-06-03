use eduit_labdb_bankmodel;

-- describe cities table
describe bank_products;

-- describe cities table values
select * from bank_products;

-- select based on an id
select name from bank_products where  id <=> 2;

-- update rows
update bank_products set name = "CUENTA CORRIENTE" where id <=> 1;

-- delete rows
delete from bank_products where id <=> 3;

INSERT INTO eduIT_labDB_BanKModel.bank_products (name) values ("PRESTAMO");


-- select all columns from cities
select id, name from bank_products;