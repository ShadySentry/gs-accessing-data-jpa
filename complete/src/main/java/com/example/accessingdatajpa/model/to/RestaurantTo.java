package com.example.accessingdatajpa.model.to;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;
import java.io.Serializable;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class RestaurantTo extends BaseTo implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull
    @NotBlank
    @Size(max = 255)
    private String description;

    @NotBlank
    @Range(min = 0,max = 100000)
    private int votes;




}
