package com.example.accessingdatajpa;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.util.Assert;

import javax.persistence.*;
import java.util.ArrayList;
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
    private Date menuDate;
    private Integer totalVotes;
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
                "id=" + id +
                ", menuDate=" + menuDate +
                ", totalVotes=" + totalVotes +
                ", enabled=" + enabled +
                ", description='" + description + '\'' +
                "meals:"+mealsAsString()+
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
