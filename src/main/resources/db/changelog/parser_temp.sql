DELETE FROM test_db.employees WHERE id = 1;
DELETE FROM test_db.casses WHERE id=1;
DELETE FROM test_db.vacancies where id=1;
DELETE FROM test_db.cafeterias where id=1;

# Подгружаем сотрудников
insert into `test_db`.employees (`name`,`surname`,`patronymic`,`birthday`,`position`,`department`,`city_id`,`phoneGaz`,`phoneMobile`,`email`)
select `name`,`surname`,`patronymic`,`birthday`,`position`,`department`,`city_id`,`phoneGaz`,`phoneMobile`,`email`
from `prod_db`.`employees`;

# Подгружаем кассовые узлы
insert into `test_db`.casses (`cassa_name`,`prefix`,`ammy_admin`,`any_desk`,`computer_name`,`cassa_address`,`data_update`,`temp`,`fn_deadline_data`,`kpp`,`rnkkt`,`fn_number`,`mob_number`,`icc_number`,`phone_number`)
select `cassa_name`,`prefix`,`ammy_admin`,`any_desk`,`computer_name`,`cassa_address`,`data_update`,`temp`,`fn_deadline_data`,`kpp`,`rnkkt`,`fn_number`,`mob_number`,`icc_number`,`phone_number`
from `prod_db`.`casses`;

# Подгружаем вакансии
insert into `test_db`.vacancies (`vacancy_name`,`description`,`requirements`,`conditions`,`contacts`,`contract_type`,`experience`,`vacancy_hours`,`city_id`,`salary`)
select `vacancy_name`,`description`,`requirements`,`conditions`,`contacts`,`contract_type`,`experience`,`vacancy_hours`,`city_id`,`salary`
from `prod_db`.`vacancies`;

# Подгружаем столовые
insert into `test_db`.cafeterias (`name`,`address`,`phone`)
select `name`,`address`,`phone`
from `prod_db`.`cafeterias`;

# Подгружаем блюда
insert into `test_db`.dishes (`name`,`structure`,`weight`,`price`,`category`)
select `name`,`structure`,`weight`,`price`,`category`
from `prod_db`.dishes;


