package com.example.accessingdatajpa;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.util.Assert;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.util.Assert.notNull;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String description;
    private int votes;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST, mappedBy = "restaurant")
    private List<Menu> menus = new ArrayList<>();

    protected Restaurant() {
    }

    public Restaurant(String description) {
        notNull(description, "description can't be null");
    }

    public void addMenu(Menu menu) {
        notNull(menu, "menu can't be null");
        if (!menus.contains(menu)) {
            menus.add(menu);
        }
    }

    public void removeMenu(Menu menu) {
        notNull(menu, "menu can't be null");
        if (menus.contains(menu)) {
            menus.remove(menu);
        }
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", votes=" + votes +
                '}';
    }

    String menusAsString() {
        if (menus.isEmpty()) {
            return "{No Meals}";
        }
        StringBuilder mealsAsString = new StringBuilder();
        for (Menu menu : menus) {
            mealsAsString.append("{");
            mealsAsString.append("ID = " + menu.getId().toString());
            mealsAsString.append("Date = " + menu.getMenuDate());
            mealsAsString.append("total votes = " + menu.getTotalVotes());
            mealsAsString.append("enabled = " + menu.isEnabled());
            mealsAsString.append("description =" + menu.getDescription());
            mealsAsString.append("}");
        }

        return mealsAsString.toString();
    }

}
