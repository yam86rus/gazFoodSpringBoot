DELETE FROM test_db.employees WHERE id = 1;
DELETE FROM test_db.casses WHERE id=1;
DELETE FROM test_db.vacancies where id=1;
DELETE FROM test_db.cafeterias where id=1;

# Подгружаем сотрудников
insert into `test_db`.employees (`name`,`city_id`,`surname`,`patronymic`,`position`,`department`,`phoneGaz`,`phoneMobile`)
select `name`,1,`surname`,`patronymic`,`position`,`department`,`phoneGaz`,`phoneMobile`
from `prod_db`.`employees`;

# Подгружаем кассовые узлы
insert into `test_db`.casses (`cassa_name`,`prefix`,`ammy_admin`,`any_desk`,`computer_name`,`cassa_address`,`data_update`,`temp`,`fn_deadline_data`,`kpp`,`rnkkt`,`fn_number`,`mob_number`,`icc_number`,`phone_number`)
select `cassaName`,`prefix`,`ammy`,`anyDesk`,`computerName`,`cassaAdres`,`simNumber`,`planUpdate`,`fnDeadLineData`,`kpp`,`rnkkt`,`fnNumber`,`mob_number`,`icc_number`,`phone_number`
from `prod_db`.`cassa`;

# Подгружаем вакансии
insert into `test_db`.vacancies (`vacancy_name`,`description`,`requirements`,`conditions`,`contacts`,`experience`,`vacancy_hours`,`contract_type`,`city_id`,`salary`)
select `vacancy`,`description`,`requirements`,`conditions`,`contacts`,"e1","e1","e1",1,10000
from `prod_db`.`vacancies`;

# Подгружаем столовые
insert into `test_db`.cafeterias (`name`,`address`,`phone`)
select `name`,`address`,`phone`
from `prod_db`.`cafeterias`


