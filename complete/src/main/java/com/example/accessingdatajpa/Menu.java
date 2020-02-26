package com.example.accessingdatajpa;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date menuDate;
    private Integer totalVotes;
    private boolean enabled;
    private String description;

    @ManyToMany(mappedBy = "menus",fetch = FetchType.EAGER)
    private List<Meal> meals;

    protected Menu(){}

    public Menu(String description){
        if(description!=null){
            this.description=description;
        }
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", menuDate=" + menuDate +
                ", totalVotes=" + totalVotes +
                ", enabled=" + enabled +
                ", description='" + description + '\'' +
                '}';
    }


}
