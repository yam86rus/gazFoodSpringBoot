# Подгружаем города
insert into `test_db`.cities(`cityName`)
select `cityName`
from `prod_db`.`cities`;

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

# Подгружаем статусы договоров
insert into `test_db`.statuses (`status_name`)
select `status_name`
from `prod_db`.`statuses`;

# Подгружаем контрагентов
insert into `test_db`.partners (`partner_name`,`partner_inn`,`partner_kpp`,`partner_adress`,`personal_manager`,`manager_mobile_phone`,`manager_city_phone`,`manager_email`)
select `partner_name`,`partner_inn`,`partner_kpp`,`partner_adress`,`personal_manager`,`manager_mobile_phone`,`manager_city_phone`,`manager_email`
from `prod_db`.`partners`;

# Подгружаем договора
insert into `test_db`.contracts(`contract_name`,`contract_number`,`contract_data`,`contract_partner_id`,`contract_status_id`)
select `contract_name`,`contract_number`,`contract_data`,`contract_partner_id`,`contract_status_id`
from `prod_db`.`contracts`;

# Подгружаем столовые
insert into `test_db`.cafeterias (`name`,`address`,`phone`)
select `name`,`address`,`phone`
from `prod_db`.`cafeterias`;

# Подгружаем категории блюд
insert into `test_db`.dishes_categories(`name`)
select `name`
from `prod_db`.dishes_categories;

# Подгружаем блюда
insert into `test_db`.dishes (`name`,`structure`,`weight`,`price`,`dishCategory_id`)
select `name`,`structure`,`weight`,`price`,`dishCategory_id`
from `prod_db`.dishes;


