use eduit_labdb_bankmodel;

-- describe cities table
describe offices ;

-- describe cities table values
select * from offices;

-- select based on an id
select name from offices where  city_id <=> 2;

-- update rows
update offices  set name = "New Castle" where city_id <=> 4;

-- delete rows
delete from offices  where city_id <=> 23;

-- Insert values
INSERT INTO eduIT_labDB_BanKModel.offices (city_id, name) values
  (1, "New Castle"),
  (2, "Oslo"),
  (3, "Great Falls"),
  (4, "Ogbomosho"),
  (5, "Anamur"),
  (6, "Juárez"),
  (7, "Igboho"),
  (8, "Owerri"),
  (9, "Cawdor"),
  (10, "Seogwipo"),
  (11, "Bima"),
  (13, "Nicoya"),
  (14, "Cork"),
  (15, "Kyiv");
 
 INSERT INTO eduIT_labDB_BanKModel.offices (city_id, name) values (1, "New Castle");

 INSERT INTO eduIT_labDB_BanKModel.offices (city_id, name) values (23, "new office");

-- select all columns from cities
select city_id, name from offices;


