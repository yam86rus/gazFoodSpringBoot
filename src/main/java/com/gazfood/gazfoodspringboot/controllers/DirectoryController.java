package com.gazfood.gazfoodspringboot.controllers;

import com.gazfood.gazfoodspringboot.entity.User;
import com.gazfood.gazfoodspringboot.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class DirectoryController {
    @Autowired
    private CityService cityService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private VacancyService vacancyService;

    @Autowired
    private CassaService cassaService;

    @Autowired
    private PartnerService partnerService;

    @Autowired
    private StatusService statusService;

    @Autowired
    private ContractService contractService;

    @Autowired
    private CafeteriaService cafeteriaService;

    @Autowired
    private DishService dishService;

    @Autowired
    private DishCategoryService dishCategoryService;

    @Autowired
    private PriceCategoryService priceCategoryService;

    @Autowired
    private MenuListService menuListService;

    @Autowired
    private MenuService menuService;

    @Autowired
    private CafeteriaAndMenuService cafeteriaAndMenuService;

    @Autowired
    private OrderStatusService orderStatusService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private UserService userService;



    @GetMapping("/directories")
    public String getAllDirectories(Model model, Principal principal) {
        model.addAttribute("cityCount", cityService.getCountCities());
        model.addAttribute("employeeCount", employeeService.getCountEmployees());
        model.addAttribute("vacancyCount", vacancyService.getCountVacancies());
        model.addAttribute("cassaCount", cassaService.getCountCasses());
        model.addAttribute("partnerCount", partnerService.getCountPartners());
        model.addAttribute("statusCount", statusService.getCountStatuses());
        model.addAttribute("contractCount", contractService.getCountContracts());
        model.addAttribute("cafeteriaCount", cafeteriaService.getCountCafeterias());
        model.addAttribute("dishCount",dishService.getCountDishes());
        model.addAttribute("dishCategoriesCount",dishCategoryService.getCountDishCategories());
        model.addAttribute("priceCategoryCount",priceCategoryService.getCountPriceCategories());
        model.addAttribute("menuListCount",menuListService.getCountMenuList());
        model.addAttribute("menuCount",menuService.getCountMenus());
        model.addAttribute("cafeteriaAndMenuCount", cafeteriaAndMenuService.getCountCafeteriaAndMenu());
        model.addAttribute("orderStatusCount", orderStatusService.getCountOrderStatus());
        model.addAttribute("emailsCount", emailService.getEmailCount());
        model.addAttribute("usersCount", userService.getCountUsers());
        model.addAttribute("user", userService.findByUsername(principal.getName()));


        return "all-directories";
    }
}
