package com.gazfood.gazfoodspringboot.dao;

import com.gazfood.gazfoodspringboot.entity.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContractRepository extends JpaRepository<Contract, Integer> {
    long count();
    public List<Contract> findTop10ByOrderById();

}
