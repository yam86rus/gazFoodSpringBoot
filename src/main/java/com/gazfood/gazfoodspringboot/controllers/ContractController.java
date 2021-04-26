package com.gazfood.gazfoodspringboot.controllers;

import com.gazfood.gazfoodspringboot.entity.Contract;
import com.gazfood.gazfoodspringboot.entity.Employee;
import com.gazfood.gazfoodspringboot.entity.Partner;
import com.gazfood.gazfoodspringboot.entity.Status;
import com.gazfood.gazfoodspringboot.service.ContractService;
import com.gazfood.gazfoodspringboot.service.PartnerService;
import com.gazfood.gazfoodspringboot.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ContractController {
    @Autowired
    private ContractService contractService;

    @Autowired
    private PartnerService partnerService;

    @Autowired
    private StatusService statusService;


    @RequestMapping("/contracts")
    public String showAllContracts(Model model) {
        List<Contract> allContracts = contractService.getAllContracts();
        model.addAttribute("allContracts", allContracts);
        return "all-contracts";
    }

    @RequestMapping("/addNewContract")
    public String addNewContract(Model model) {
        Contract contract = new Contract();
        model.addAttribute("contract", contract);

        List<Partner> listPartners = partnerService.getAllPartners();
        model.addAttribute("listPartners", listPartners);

        List<Status> listStatuses = statusService.getAllStatuses();
        model.addAttribute("listStatuses", statusService.getAllStatuses());
        return "contract-form";
    }

    @RequestMapping("/saveContract")
    public String saveContract(@ModelAttribute("contract") Contract contract) {
        contractService.saveContract(contract);
        return "redirect:contracts";
    }

    @RequestMapping("/deleteContract")
    public String deleteContract(@RequestParam("contractId") int id) {
        contractService.deleteContract(id);
        return "redirect:contracts";
    }

    @RequestMapping("/updateContract")
    public String updateContract(@RequestParam("contractId") int id, Model model) {
        Contract contract = contractService.getContract(id);
        model.addAttribute("contract",contract);

        List<Partner> listPartners = partnerService.getAllPartners();
        model.addAttribute("listPartners", listPartners);

        List<Status> listStatuses = statusService.getAllStatuses();
        model.addAttribute("listStatuses", statusService.getAllStatuses());

        return "contract-form";
    }

}
