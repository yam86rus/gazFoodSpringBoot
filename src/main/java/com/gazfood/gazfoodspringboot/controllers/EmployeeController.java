package com.gazfood.gazfoodspringboot.controllers;

import com.gazfood.gazfoodspringboot.entity.City;
import com.gazfood.gazfoodspringboot.entity.Employee;
import com.gazfood.gazfoodspringboot.entity.User;
import com.gazfood.gazfoodspringboot.service.CityService;
import com.gazfood.gazfoodspringboot.service.EmployeeService;
import com.gazfood.gazfoodspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private CityService cityService;

    @Autowired
    private UserService userService;


    @GetMapping("/employees")
    public String showEmployeePage(Model model, Principal principal) {
        List<Employee> allEmployees = employeeService.getAllEmployees();
        model.addAttribute("allEmps", allEmployees);

        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);
        return "all-employees";
    }

    @RequestMapping("/addNewEmployee")
    public String addNewEmployee(Model model,Principal principal) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);

        List<City> listCities = cityService.getAllCities();
        model.addAttribute("listCities",listCities);

        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);

        return "employee-form";

    }
    @RequestMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:employees";
    }

    @RequestMapping(value = "/updateEmployee")
    public String updateEmployee(@RequestParam("empId") int id, Model model,Principal principal){
        Employee employee = employeeService.getEmployee(id);
        model.addAttribute("employee", employee);

        List<City> listCities = cityService.getAllCities();
        model.addAttribute("listCities",listCities);

        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);
        return "employee-form";
    }

    @RequestMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam("empId") int id){
        employeeService.deleteEmployee(id);
        return "redirect:employees";
    }

    @RequestMapping(value = "/detailsEmployee")
    public String detailsEmployee(@RequestParam("empId") int id, Model model,Principal principal){
        Employee employee = employeeService.getEmployee(id);
        model.addAttribute("employee", employee);

        List<City> listCities = cityService.getAllCities();
        model.addAttribute("listCities",listCities);

        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);

        return "employee-form";
    }

}
