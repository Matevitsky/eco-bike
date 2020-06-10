package com.matevitskyi.mapper;

import com.matevitskyi.model.FoldingBike;
import org.springframework.stereotype.Component;

@Component
public class FoldingBileMapperImpl implements FoldingBikeMapper {
    private static final String SEPARATOR = ";";

    @Override
    public FoldingBike mapStringArrayToFoldingBike(String[] array) {

        String brand = array[0].trim();
        int sizeOfWheels = Integer.parseInt(array[1].trim());
        int numberOfGears = Integer.parseInt(array[2].trim());
        int weight = Integer.parseInt(array[3].trim());
        boolean hasLight = Boolean.parseBoolean(array[4].trim());
        String color = array[5].trim();
        int price = Integer.parseInt(array[6].trim());

        FoldingBike foldingBike = new FoldingBike();
        foldingBike.setBrand(brand);
        foldingBike.setWheelSize(sizeOfWheels);
        foldingBike.setNumberOfGears(numberOfGears);
        foldingBike.setWeight(weight);
        foldingBike.setHasLight(hasLight);
        foldingBike.setColor(color);
        foldingBike.setPrice(price);
        return foldingBike;
    }

    public String convertFoldingBikeToString(FoldingBike foldingBike) {

        return foldingBike.getBrand() + SEPARATOR +
                foldingBike.getWheelSize() + SEPARATOR +
                foldingBike.getNumberOfGears() + SEPARATOR +
                foldingBike.getWeight() + SEPARATOR +
                foldingBike.getHasLight().toString().toUpperCase() + SEPARATOR +
                foldingBike.getColor() + SEPARATOR +
                foldingBike.getPrice();
    }

}
