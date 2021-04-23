package com.gazfood.gazfoodspringboot.dao;

import com.gazfood.gazfoodspringboot.entity.Cassa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CassaRepository extends JpaRepository<Cassa, Integer> {
    long count();
}
