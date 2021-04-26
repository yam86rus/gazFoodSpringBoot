package com.gazfood.gazfoodspringboot.service;

import com.gazfood.gazfoodspringboot.entity.City;
import com.gazfood.gazfoodspringboot.entity.Contract;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ContractService {

    List<Contract> getAllContracts();
    List<Contract> getFirstTenContracts();
    Contract getContract(int id);
    void saveContract(Contract contract);
    void deleteContract(int id);

    long getCountContracts();



}
