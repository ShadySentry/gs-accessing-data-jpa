package com.example.accessingdatajpa.model;

import lombok.*;
import org.springframework.util.Assert;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class Meal {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String description;
	private Integer priceInCents;

	@ManyToMany(/*mappedBy = "meals",*/
			fetch = FetchType.EAGER,
			cascade = CascadeType.PERSIST)
	@JoinTable(name = "meal_menu",
	joinColumns = @JoinColumn(name = "meal_id"),
	inverseJoinColumns = @JoinColumn(name = "menu_id"))
	private List<Menu> menus = new ArrayList<>();

	protected Meal() {}


	public Meal(String description, Integer priceInCents) {
		this.description=description;
		this.priceInCents=priceInCents;
	}

	public void	addMenu(Menu menu){
		Assert.notNull(menu,"menu can't be null");
		if(!menus.contains(menu)){
			menus.add(menu);
		}
	}


}
