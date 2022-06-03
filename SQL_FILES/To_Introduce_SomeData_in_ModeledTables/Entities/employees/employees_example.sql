use eduit_labdb_bankmodel;

-- describe cities table
describe employees;

-- describe cities table values
select * from employees e;

-- select based on an id
select id, name, phone_number, start_date from employees where  id <=> 31;

-- update rows
update employees set name = "Jose Foronda", phone_number = "(+57) 311 788 56 10", start_date = date_add(curdate(), interval FLOOR(-186 + RAND() * (180)) MONTH)  where id <=> 31;

-- delete rows
delete from employees where id <=> 32;

INSERT into employees (name,phone_number, start_date)
VALUES
  ("Theodore Wise","(271) 741-9960", date_add(curdate(), interval FLOOR(-186 + RAND() * (180)) MONTH)),
  ("Giacomo Duffy","(334) 274-8007", date_add(curdate(), interval FLOOR(-186 + RAND() * (180)) MONTH)),
  ("Cade Bishop","1-725-532-7688", date_add(curdate(), interval FLOOR(-186 + RAND() * (180)) MONTH)),
  ("Mercedes Lott","1-734-714-5726", date_add(curdate(), interval FLOOR(-186 + RAND() * (180)) MONTH)),
  ("Summer Horn","(744) 518-4434", date_add(curdate(), interval FLOOR(-186 + RAND() * (180)) MONTH)),
  ("Nell Rivas","(520) 855-9512", date_add(curdate(), interval FLOOR(-186 + RAND() * (180)) MONTH)),
  ("Veronica Smith","(585) 819-1704", date_add(curdate(), interval FLOOR(-186 + RAND() * (180)) MONTH)),
  ("Aiko Woodard","1-394-721-4866", date_add(curdate(), interval FLOOR(-186 + RAND() * (180)) MONTH)),
  ("George Duffy","(442) 466-6718", date_add(curdate(), interval FLOOR(-186 + RAND() * (180)) MONTH)),
  ("Harrison Cunningham","(617) 189-7984", date_add(curdate(), interval FLOOR(-186 + RAND() * (180)) MONTH)),
  ("Karina Gross","1-257-507-1377", date_add(curdate(), interval FLOOR(-186 + RAND() * (180)) MONTH)),
  ("Britanney Melendez","(674) 297-5362", date_add(curdate(), interval FLOOR(-186 + RAND() * (180)) MONTH)),
  ("Yuli Mullen","(281) 559-2323", date_add(curdate(), interval FLOOR(-186 + RAND() * (180)) MONTH)),
  ("Michael Mann","(812) 768-8155", date_add(curdate(), interval FLOOR(-186 + RAND() * (180)) MONTH)),
  ("Venus Morales","1-266-571-8590", date_add(curdate(), interval FLOOR(-186 + RAND() * (180)) MONTH));
 
 INSERT into employees (id, name,phone_number, start_date) values (32, "Andres Felipe Foronda","(+57) 311 662 72 27", "2021-02-25");

-- select all columns from cities
select id, name, phone_number, start_date from employees;

select date_add(curdate(), interval FLOOR(-20 + RAND() * (15)) YEAR) ; 