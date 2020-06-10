package com.matevitskyi.model;

import lombok.Data;

@Data
public class EcoBike extends Bike {

    private Integer maxSpeed; //km/h
    private Integer batteryCapacity; //mAh

    @Override
    public String toString() {
        String hasLight = "null";
        if (getHasLight() != null) {
            hasLight = getHasLight() ? "head/tail light." : "no head/tail light.";
        }
        return String.format("\n%s with %d mAh battery and %s\n" +
                        "Price: %d euros\n",
                getBrand(), batteryCapacity, hasLight, getPrice());
    }

}
