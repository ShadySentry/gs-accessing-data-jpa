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

    @ManyToMany(mappedBy = "menus")
    private List<Meal> meals = new ArrayList<>();

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
