use eduit_labdb_bankmodel;

-- describe cities table
describe eduit_labdb_bankmodel.employees_and_clientproducts ;

-- describe cities table values
select * from employees_and_clientproducts;
select * from employees;
select id, bank_products_id, clients_id from client_products order by clients_id;

-- select based on an id
select employees_id from employees_and_clientproducts where client_products_id <=> "10V";

select id, name, phone_number from employees where id in
(select employees_id from employees_and_clientproducts where client_products_id <=> "10V");


-- update row
update employees_and_clientproducts set employees_id = 44 where client_products_id <=> "10V" and employees_id <=> 42;


-- delete row
delete from employees_and_clientproducts where client_products_id <=> "10V" and employees_id <=> 32;


-- list elements
select p1.client_products_id, p1.employees_id, p2.name, p2.phone_number, p2.start_date  from (select client_products_id, employees_id from employees_and_clientproducts order by client_products_id) as p1 
inner join 
(select employees.* from employees) as p2 on p1.employees_id <=> p2.id ;
  
INSERT into employees_and_clientproducts (client_products_id, employees_id)
VALUES
  ("1A", 31),
  ("2A", 32),
  ("2B", 33),
  ("3A", 31),
  ("4A", 33),
  ("5A", 31),
  ("6A", 47),
  ("7A", 32),
  ("8A", 31),
  ("9A", 33),
  ("10V", 42),
  ("11A", 33),
  ("12A", 41),
  ("13A",42),
  ("14A", 31);
  
 INSERT into employees_and_clientproducts (client_products_id, employees_id) VALUES ("10V", 43);
  
  