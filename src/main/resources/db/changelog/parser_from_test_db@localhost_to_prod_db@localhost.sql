# Подгружаем города
insert into `prod_db`.cities(`cityName`)
select `cityName`
from `test_db`.`cities`;

# Подгружаем сотрудников
insert into `prod_db`.employees (`name`,`surname`,`patronymic`,`birthday`,`position`,`department`,`city_id`,`phoneGaz`,`phoneMobile`,`email`)
select `name`,`surname`,`patronymic`,`birthday`,`position`,`department`,`city_id`,`phoneGaz`,`phoneMobile`,`email`
from `test_db`.`employees`;

# Подгружаем кассовые узлы
insert into `prod_db`.casses (`cassa_name`,`prefix`,`ammy_admin`,`any_desk`,`computer_name`,`cassa_address`,`data_update`,`temp`,`fn_deadline_data`,`kpp`,`rnkkt`,`fn_number`,`mob_number`,`icc_number`,`phone_number`)
select `cassa_name`,`prefix`,`ammy_admin`,`any_desk`,`computer_name`,`cassa_address`,`data_update`,`temp`,`fn_deadline_data`,`kpp`,`rnkkt`,`fn_number`,`mob_number`,`icc_number`,`phone_number`
from `test_db`.`casses`;

# Подгружаем вакансии
insert into `prod_db`.vacancies (`vacancy_name`,`description`,`requirements`,`conditions`,`contacts`,`contract_type`,`experience`,`vacancy_hours`,`city_id`,`salary`)
select `vacancy_name`,`description`,`requirements`,`conditions`,`contacts`,`contract_type`,`experience`,`vacancy_hours`,`city_id`,`salary`
from `test_db`.`vacancies`;

# Подгружаем статусы договоров
insert into `prod_db`.statuses (`status_name`)
select `status_name`
from `test_db`.`statuses`;

# Подгружаем контрагентов
insert into `prod_db`.partners (`partner_name`,`partner_inn`,`partner_kpp`,`partner_adress`,`personal_manager`,`manager_mobile_phone`,`manager_city_phone`,`manager_email`)
select `partner_name`,`partner_inn`,`partner_kpp`,`partner_adress`,`personal_manager`,`manager_mobile_phone`,`manager_city_phone`,`manager_email`
from `test_db`.`partners`;

# Подгружаем договора
insert into `prod_db`.contracts(`contract_name`,`contract_number`,`contract_data`,`contract_partner_id`,`contract_status_id`)
select `contract_name`,`contract_number`,`contract_data`,`contract_partner_id`,`contract_status_id`
from `test_db`.`contracts`;

# Подгружаем столовые
insert into `prod_db`.cafeterias (`name`,`address`,`phone`)
select `name`,`address`,`phone`
from `test_db`.`cafeterias`;

# Подгружаем категории блюд
insert into `prod_db`.dishes_categories(`name`)
select `name`
from `test_db`.dishes_categories;

# Подгружаем блюда
insert into `prod_db`.dishes (`name`,`structure`,`weight`,`price`,`dishCategory_id`)
select `name`,`structure`,`weight`,`price`,`dishCategory_id`
from `test_db`.dishes;


