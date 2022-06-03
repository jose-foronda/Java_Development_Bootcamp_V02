use eduit_labdb_bankmodel;

-- describe cities table
describe eduit_labdb_bankmodel.employees_hierarchy ;

-- describe cities table values
select * from employees_hierarchy;
select * from employees; 

-- all
select employeehierarchy.*, e.name, e.phone_number, e.start_date from (select e1.id, e1.name, e1.phone_number, e1.start_date, eh.Employee_boss_id  from employees e1 
inner join
employees_hierarchy eh on e1.id <=> eh.Employee_subaltern_id) as employeehierarchy 
inner join employees e on employeehierarchy.Employee_boss_id <=> e.id ;

-- select for one employee used in search with key
select he.*, e.name as boss_name, e.phone_number as boss_phone_number, e.start_date as boss_start_date  
from (select subaltern.*, boss.Employee_boss_id from (select e1.id, e1.name, e1.phone_number, e1.start_date  from employees e1 where e1.id <=> 31) as subaltern
  inner join
(select eh.* from employees_hierarchy as eh where eh.Employee_subaltern_id <=> 31) as boss) as he 
inner join 
(select employees.* from employees) as e on he.Employee_boss_id <=> e.id ;


 
/* select employeehierarchy.*, e.id, e.name, e.phone_number, e.start_date from (select e1.id, e1.name, e1.phone_number, e1.start_date, eh.Employee_subaltern_id, eh.Employee_boss_id  from employees e1 
inner join
employees_hierarchy eh on e1.id <=> eh.Employee_subaltern_id) as employeehierarchy 
inner join employees e on employeehierarchy.Employee_boss_id <=> e.id ;*/



-- for update process
update employees_hierarchy set Employee_boss_id = 35 where Employee_subaltern_id <=> 31 and Employee_boss_id <=> 33;


-- for delete process
delete from employees_hierarchy where Employee_subaltern_id <=> 31 and Employee_boss_id <=> 35;


-- list elements 
select * from employees; 
select * from employees_hierarchy;
-- list elements (used in java)
select emp.*, boss_emp.name as boss_name, boss_emp.phone_number as boss_phone_number, boss_emp.start_date as boss_start_date from (select emp.*, eh.Employee_boss_id  from (select * from employees) as emp 
inner join
(select employees_hierarchy.* from employees_hierarchy) as eh on emp.id <=> eh.Employee_subaltern_id) as emp
inner join
(select * from employees) as boss_emp on emp.Employee_boss_id <=> boss_emp.id;
  
INSERT into employees_hierarchy (Employee_subaltern_id, Employee_boss_id)
VALUES
  (41, 31),
  (40, 32),
  (39, 33),
  (40, 31),
  (31, 33),
  (34, 31),
  (38, 47),
  (37, 32),
  (32, 31),
  (32, 33),
  (38, 42),
  (35, 33),
  (31, 41),
  (41,42),
  (42, 31);
  
 INSERT into employees_hierarchy (Employee_subaltern_id, Employee_boss_id) VALUES (31, 35);
  