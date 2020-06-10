package com.matevitskyi.model;

import lombok.Data;


@Data
public class FoldingBike extends Bike implements Comparable {

    private Integer wheelSize; //inch
    private Integer numberOfGears;

    @Override
    public String toString() {
        String hasLight = "null";
        if (getHasLight() != null) {
            hasLight = getHasLight() ? "head/tail light." : "no head/tail light.";
        }
        return String.format("\n%s with %d gear(s) and %s\n" +
                        "Price: %d euros\n",
                getBrand(), numberOfGears, hasLight, getPrice());
    }

    @Override
    public int compareTo(Object o) {

        FoldingBike foldingBike = (FoldingBike) o;
        int result = this.getBrand().compareTo(foldingBike.getBrand());

        if (result == 0 && this.getWeight() != null && foldingBike.getWeight() != null) {
            result = this.getWeight().compareTo(foldingBike.getWeight());
        }

        if (result == 0 && this.getHasLight() != null && foldingBike.getHasLight() != null) {
            result = this.getHasLight().compareTo(foldingBike.getHasLight());
        }

        if (result == 0 && this.getColor() != null && foldingBike.getColor() != null) {
            result = this.getColor().compareTo(foldingBike.getColor());
        }


        if (result == 0 && this.getPrice() != null && foldingBike.getPrice() != null) {
            result = this.getPrice().compareTo(foldingBike.getPrice());
        }


        if (result == 0 && this.getNumberOfGears() != null && foldingBike.getNumberOfGears() != null) {
            result = this.getNumberOfGears().compareTo(foldingBike.getNumberOfGears());
        }


        if (result == 0 && this.getWheelSize() != null && foldingBike.getWheelSize() != null) {
            result = this.getWheelSize().compareTo(foldingBike.getWheelSize());
        }

        return result;
    }
}
