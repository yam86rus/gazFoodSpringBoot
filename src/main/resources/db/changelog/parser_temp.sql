DELETE FROM test_db.employees WHERE id = 1;
DELETE FROM test_db.casses WHERE id=1;

# Подгружаем сотрудников
insert into `test_db`.employees (`name`,`city_id`,`surname`,`patronymic`,`position`,`department`,`phoneGaz`,`phoneMobile`)
select `name`,1,`surname`,`patronymic`,`position`,`department`,`phoneGaz`,`phoneMobile`
from `my_db`.`employees`;

# Подгружаем кассовые узлы
insert into `test_db`.casses (`cassa_name`,`prefix`,`ammy_admin`,`any_desk`,`computer_name`,`cassa_address`,`data_update`,`temp`,`fn_deadline_data`,`kpp`,`rnkkt`,`fn_number`,`mob_number`,`icc_number`,`phone_number`)
select `cassaName`,`prefix`,`ammy`,`anyDesk`,`computerName`,`cassaAdres`,`simNumber`,`planUpdate`,`fnDeadLineData`,`kpp`,`rnkkt`,`fnNumber`,`mob_number`,`icc_number`,`phone_number`
from `my_db`.`cassa`;


