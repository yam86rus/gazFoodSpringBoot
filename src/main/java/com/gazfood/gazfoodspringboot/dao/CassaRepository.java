package com.gazfood.gazfoodspringboot.dao;

import com.gazfood.gazfoodspringboot.entity.Cassa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CassaRepository extends JpaRepository<Cassa, Integer> {
    long count();
    List<Cassa> findAllByOrderByCassaName();

//    Cassa getCassaByComputerName(String pcName);
    Cassa findCassaByComputerName(String pcName);
}
