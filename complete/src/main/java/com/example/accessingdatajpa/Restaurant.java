package com.example.accessingdatajpa;

import lombok.Getter;
import lombok.Setter;
import org.springframework.util.Assert;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.util.Assert.notNull;

@Entity
@Getter
@Setter
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String description;
    private int votes;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST,mappedBy = "restaurant")
    private List<Menu> menus = new ArrayList<>();

    protected Restaurant(){}
    public Restaurant(String description){
        notNull(description,"description can't be null");
    }

    public void addMenu(Menu menu){
        notNull(menu, "menu can't be null");
        if(!menus.contains(menu)){
            menus.add(menu);
        }
    }
}
