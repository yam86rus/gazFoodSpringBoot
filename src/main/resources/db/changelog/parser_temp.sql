DELETE FROM test_db.employees WHERE id = 1;

insert into `test_db`.employees (`name`,`city_id`,`surname`,`patronymic`,`position`,`department`,`phoneGaz`,`phoneMobile`)
select `name`,1,`surname`,`patronymic`,`position`,`department`,`phoneGaz`,`phoneMobile`
from `my_db`.`employees`;

