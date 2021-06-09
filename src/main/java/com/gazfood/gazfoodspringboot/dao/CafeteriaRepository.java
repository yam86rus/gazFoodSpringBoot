package com.gazfood.gazfoodspringboot.dao;

import com.gazfood.gazfoodspringboot.entity.Cafeteria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CafeteriaRepository extends JpaRepository<Cafeteria, Integer> {
    long count();

    @Query(value = "select d.id, d.name, d.structure,  m.price, d.image_url from menu_list\n" +
            "join menu m on menu_list.id = m.menuList_id\n" +
            "join cafeteria_and_menu cam on menu_list.id = cam.menuList_id\n" +
            "join dishes d on d.id = m.dishes_id\n" +
            "where cafeteria_id=2", nativeQuery = true)
    List<Object[]> findAllDishesInMenuInCafeterias(int id);
}
