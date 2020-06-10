package com.matevitskyi.model;

import lombok.Data;

@Data
public abstract class Bike {

    private String brand;
    private Integer weight; //grams
    private Boolean hasLight;
    private String color;
    private Integer price;


}
