-- drop database if exists eduIT_labDB_BanKModel;
use eduIT_labDB_BanKModel;
INSERT 
	INTO eduIT_labDB_BanKModel.cities
	(name)
	VALUES
	  ("Puerto Carre�o"),
	  ("Saravena"),
	  ("Yopal"),
	  ("Medio Atrato"),
	  ("Pereira"),
	  ("Floridablanca"),
	  ("Agust�n Codazzi"),
	  ("Bogot�"),
	  ("Puerto Nari�o"),
	  ("Quibd�"),
	  ("Armenia"),
	  ("Puerto L�pez"),
	  ("Puerto As�s"),
	  ("Duitama"),
	  ("Soacha");
	  
describe cities;
show columns from eduIT_labDB_BanKModel.cities;

select * from cities bp ;

select * from bank_products bp 
LIMIT 0, 200;
