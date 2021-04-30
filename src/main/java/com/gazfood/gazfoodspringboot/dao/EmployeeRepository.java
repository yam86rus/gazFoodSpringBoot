package com.gazfood.gazfoodspringboot.dao;

import com.gazfood.gazfoodspringboot.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findAllByName(String name);

    long count();

    @Query(value = "SELECT * FROM employees WHERE MONTH(birthday)= :m ORDER BY DAY(birthday)", nativeQuery = true)
    List<Employee> findAllBirthday(@Param("m") int month);


}


