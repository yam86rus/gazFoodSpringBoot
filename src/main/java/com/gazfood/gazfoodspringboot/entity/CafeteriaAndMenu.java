package com.gazfood.gazfoodspringboot.entity;

import javax.persistence.*;

@Entity
@Table(name = "cafeteria_and_menu")
public class CafeteriaAndMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "cafeteria_id")
    private Cafeteria cafeteria;

    @ManyToOne
    @JoinColumn(name = "menuList_id")
    private MenuList menuList;

    public CafeteriaAndMenu() {
    }

    public CafeteriaAndMenu(Cafeteria cafeteria, MenuList menuList) {
        this.cafeteria = cafeteria;
        this.menuList = menuList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cafeteria getCafeteria() {
        return cafeteria;
    }

    public void setCafeteria(Cafeteria cafeteria) {
        this.cafeteria = cafeteria;
    }

    public MenuList getMenuList() {
        return menuList;
    }

    public void setMenuList(MenuList menuList) {
        this.menuList = menuList;
    }
}
