USE `mydb_jsp_practice` ;



insert into mydb_jsp_practice.systemusers (email, password)
values
("jose09621@hotmail.com", AES_ENCRYPT("HOLA1234",'ProtalentoEducacionITAlliance'));



-- update statement
update systemusers set password = AES_ENCRYPT("key","UHJvdGFsZW50b0VkdWNhY2lvbklUQWxsaWFuY2U=") where email = "jose09621@hotmail.com";

select email, AES_DECRYPT(password,"UHJvdGFsZW50b0VkdWNhY2lvbklUQWxsaWFuY2U=") as passwordDecrypt from mydb_jsp_practice.systemusers;


-- To list all the elements
select email, AES_DECRYPT(password, "ProtalentoEducacionITAlliance") as password  from systemusers;

select * from systemusers s ;



-- Employee database
select * from employees e ;
select documentType, documentNumber, name, lastName, age, birthDate from employees;

-- insert into
insert into employees (documentType, documentNumber, name, lastName, age, birthDate)
values
();

-- Modify employee
update employees set  name = , lastName = , age = , birthDate = where documentType = and  documentNumber = ;

-- delete employee
delete from employees where documentType = ? and documentNumber = ?;
 