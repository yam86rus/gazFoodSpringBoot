package com.gazfood.gazfoodspringboot.service;

import com.gazfood.gazfoodspringboot.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getAllEmployees();
    public void saveEmployee(Employee employee);
    public Employee getEmployee(int id);
    public void deleteEmployee(int id);
    public List<Employee> findAllByName(String name);
    public long getCountEmployees();
    public List<Employee> findAllBirthday(int month);

}
