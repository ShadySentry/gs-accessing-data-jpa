package com.example.accessingdatajpa.model.to;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class MealTo extends BaseTo implements Serializable {
    private static final long serialVersionUID = 1L;
}
