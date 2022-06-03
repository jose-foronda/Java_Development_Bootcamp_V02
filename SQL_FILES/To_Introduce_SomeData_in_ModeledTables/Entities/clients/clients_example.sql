use eduit_labdb_bankmodel;

-- describe cities table
describe clients;

-- describe cities table values
select * from clients e;

-- select based on an id
select id, client_name, city_id, street from clients where  id <=> "CC1085";

-- update rows
update clients set client_name = "Jose Foronda", street = "Gaitan P#12"  where id <=> "CC1097" and city_id <=> 5;
update clients set id = "CC1098", client_name = "Jose Foronda", street = "Gaitan P#12"  where id <=> "CC1097";
-- delete rows
delete from clients where id <=> "CC1097" and city_id <=> 5;

INSERT into clients (id, client_name, city_id, street)
VALUES
  ("CC1085", "Ifeoma Peterson",4,"663-7149 Vehicula. St."),
  ("CC1086","Dane Gibson",8,"440-4655 Ornare, Ave"),
  ("CC1087","Armando Mccormick",8,"P.O. Box 827, 970 Nunc Av."),
  ("CC1088","Ila Roy",5,"Ap #437-5176 Vitae St."),
  ("CC1089","Fuller Shepard",1,"468-1878 Vehicula Road"),
  ("CC1090","Sebastian Greer",8,"335-6641 Volutpat. Av."),
  ("CC1091","Patience Lowery",3,"740-7974 Parturient Av."),
  ("CC1092","Maile Sharpe",1,"1302 Tristique Rd."),
  ("CC1093","Mia Ruiz",11,"Ap #607-9365 Tempor Avenue"),
  ("CC1094","Mason Guerrero",5,"851-3873 Sodales Road"),
  ("CC1095","Daniel Hughes",10,"219-3964 Turpis Av."),
  ("CC1096","Philip Avery",9,"Ap #612-5173 Gravida St."),
  ("CC1097","Conan Forbes",5,"818-6992 Est. Rd."),
  ("CC1098","Kevin Kline",1,"2411 Suscipit Avenue"),
  ("CC1099","Kane Mathis",9,"Ap #394-284 Aliquet Rd.");
 
INSERT into clients (id, client_name, city_id, street) values ("CC1097","Conan Forbes",5,"818-6992 Est. Rd.");
  
-- select all columns from cities
select id, client_name, city_id, street from clients;

