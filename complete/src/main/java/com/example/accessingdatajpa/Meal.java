package com.example.accessingdatajpa;

import lombok.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

	protected Meal() {}


	public Meal(String description, Integer priceInCents) {
		this.description=description;
		this.priceInCents=priceInCents;
	}

}
