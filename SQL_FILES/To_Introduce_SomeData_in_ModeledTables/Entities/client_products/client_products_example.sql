use eduit_labdb_bankmodel;

-- describe cities table
describe client_products ;

-- describe cities table values
select * from client_products e;

-- select based on an id
select id, bank_products_id, clients_id from client_products where  id <=> "10C";
select id, bank_products_id from client_products where  clients_id <=> "CC1094";

-- update rows
update client_products set bank_products_id = "2" where id <=> "10C";
-- update client_products set bank_products_id = "3", clients_id = "CC1094", id = "10C" where id <=> "10A";

-- delete rows
delete from client_products where id <=> "10C";


INSERT into client_products (id, bank_products_id, clients_id) values ("10C", 1,"CC1094");
  
INSERT into client_products (id, bank_products_id, clients_id)
VALUES
  ("1A", 1,"CC1085"),
  ("2A", 2,"CC1086"),
  ("2B", 3,"CC1087"),
  ("3A", 1,"CC1088"),
  ("4A", 3,"CC1089"),
  ("5A", 1,"CC1090"),
  ("6A", 2,"CC1091"),
  ("7A", 2,"CC1092"),
  ("8A", 1,"CC1093"),
  ("9A", 3,"CC1094"),
  ("10A", 2,"CC1095"),
  ("11A", 3,"CC1096"),
  ("12A", 1,"CC1097"),
  ("13A", 2,"CC1098"),
  ("14A", 1,"CC1099");
  
  
-- select all columns from client_products cp 
select id, bank_products_id, clients_id from client_products order by clients_id;