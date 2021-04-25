DELETE FROM test_db.employees WHERE id = 1;

insert into `test_db`.employees (`name`,`city_id`,`surname`,`patronymic`,`position`,`department`,`phoneGaz`,`phoneMobile`)
select `name`,1,`surname`,`patronymic`,`position`,`department`,`phoneGaz`,`phoneMobile`
from `my_db`.`employees`;

insert into `test_db`.casses (`cassa_name`,`prefix`,`ammy_admin`,`any_desk`,`computer_name`,`cassa_address`,`data_update`,`temp`,`fn_deadline_data`,`kpp`,`rnkkt`,`fn_number`)
select `cassaName`,`prefix`,`ammy`,`anyDesk`,`computerName`,`cassaAdres`,`simNumber`,`planUpdate`,`fnDeadLineData`,`kpp`,`rnkkt`,`fnNumber`
from `my_db`.`cassa`;
