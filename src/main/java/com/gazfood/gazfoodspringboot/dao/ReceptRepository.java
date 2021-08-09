package com.gazfood.gazfoodspringboot.dao;

import com.gazfood.gazfoodspringboot.entity.Employee;
import com.gazfood.gazfoodspringboot.entity.Recept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReceptRepository extends JpaRepository<Recept, Integer> {
    List<Recept> findAllByCode(String recept_code);

//    @Query(value = "SELECT * FROM test_db.recept WHERE recept_code= :m limit 1", nativeQuery = true)
//    Recept findReceptByCode(@Param("m") String recept_code);

    Recept findFirstByCode(String recept_code);
}
