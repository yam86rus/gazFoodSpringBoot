package com.gazfood.gazfoodspringboot.service;

import com.gazfood.gazfoodspringboot.dao.ContractRepository;
import com.gazfood.gazfoodspringboot.entity.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContractsServiceImpl implements ContractService {

    @Autowired
    private ContractRepository contractRepository;

    @Override
    public List<Contract> getAllContracts() {
        List<Contract> getAllContracts = contractRepository.findAll();
        return getAllContracts;
    }

    @Override
    public List<Contract> getFirstTenContracts() {
        List<Contract> firstTenContracts = contractRepository.findTop10ByOrderById();
        return firstTenContracts;
    }

    @Override
    public Contract getContract(int id) {
        Contract contract = null;
        Optional<Contract> optional = contractRepository.findById(id);
        if (optional.isPresent()) {
            contract = optional.get();
        }
        return contract;
    }

    @Override
    public void saveContract(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public void deleteContract(int id) {
        contractRepository.deleteById(id);
    }

    @Override
    public long getCountContracts() {
        return contractRepository.count();
    }


}
