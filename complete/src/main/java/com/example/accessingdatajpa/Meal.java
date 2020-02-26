package com.example.accessingdatajpa;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Meal {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String description;
	private Integer priceInCents;

	@ManyToMany(mappedBy = "meals",fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
	private List<Menu> menus;

	protected Meal() {}


	public Meal(String description, Integer priceInCents) {
		this.description=description;
		this.priceInCents=priceInCents;
	}

	@Override
	public String toString() {
		return "Meal{" +
				"id=" + id +
				", description='" + description + '\'' +
				", priceInCents=" + priceInCents +
				'}';
	}
}
