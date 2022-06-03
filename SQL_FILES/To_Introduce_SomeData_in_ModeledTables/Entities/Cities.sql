-- drop database if exists eduIT_labDB_BanKModel;
use eduIT_labDB_BanKModel;
INSERT 
	INTO eduIT_labDB_BanKModel.cities
	(name)
	VALUES
	  ("Puerto Carreño"),
	  ("Saravena"),
	  ("Yopal"),
	  ("Medio Atrato"),
	  ("Pereira"),
	  ("Floridablanca"),
	  ("Agustín Codazzi"),
	  ("Bogotá"),
	  ("Puerto Nariño"),
	  ("Quibdó"),
	  ("Armenia"),
	  ("Puerto López"),
	  ("Puerto Asís"),
	  ("Duitama"),
	  ("Soacha");
	  
describe cities;
show columns from eduIT_labDB_BanKModel.cities;

select * from cities bp ;

select * from bank_products bp 
LIMIT 0, 200;
