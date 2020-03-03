package com.example.accessingdatajpa.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
//@ToString
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date menuDate=Calendar.getInstance().getTime();
    @Column(columnDefinition = "integer default '0'")
    private Integer totalVotes=0;
    private boolean enabled;
    private String description;

    @ManyToMany(mappedBy = "menus",fetch = FetchType.EAGER)
    private List<Meal> meals = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    private Restaurant restaurant;

    protected Menu(){}

    public Menu(String description){
        if(description!=null){
            this.description=description;
        }
    }
    @Override
    public String toString() {
        return "Menu{" +
                "id= " + id +
                ", menuDate= " + menuDate +
                ", totalVotes= " + totalVotes +
                ", enabled= " + enabled +
                ", description= " + description + '\'' +
                "meals: "+mealsAsString()+
                "restaurant = "+restaurant+
                '}';
    }

    String mealsAsString(){
        if(meals.isEmpty()){
            return "{No Meals}";
        }
        StringBuilder mealsAsString = new StringBuilder();
        for(Meal meal:meals){
            mealsAsString.append("{");
            mealsAsString.append("ID = "+meal.getId().toString());
            mealsAsString.append("description ="+meal.getDescription());
            mealsAsString.append("\tprice in cents = "+meal.getPriceInCents());
            mealsAsString.append("}");
        }

        return mealsAsString.toString();
    }
}
