package com.gazfood.gazfoodspringboot.dao;

import com.gazfood.gazfoodspringboot.entity.MenuList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuListRepository extends JpaRepository<MenuList, Integer> {
}
