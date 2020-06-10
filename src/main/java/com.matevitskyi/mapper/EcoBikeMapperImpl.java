package com.matevitskyi.mapper;

import com.matevitskyi.model.EcoBike;
import org.springframework.stereotype.Component;

@Component
public class EcoBikeMapperImpl implements EcoBikeMapper {
    private static final String SEPARATOR = ";";

    @Override
    public EcoBike mapStringArrayToEcoBike(String[] array) {
        String brand = array[0].trim();
        int maxSpeed = Integer.parseInt(array[1].trim());
        int weight = Integer.parseInt(array[2].trim());
        boolean hasLight = Boolean.parseBoolean(array[3].trim());
        int batteryCapacity = Integer.parseInt(array[4].trim());
        String color = array[5].trim();
        int price = Integer.parseInt(array[6].trim());

        EcoBike ecoBike = new EcoBike();
        ecoBike.setBrand(brand);
        ecoBike.setMaxSpeed(maxSpeed);
        ecoBike.setBatteryCapacity(batteryCapacity);
        ecoBike.setWeight(weight);
        ecoBike.setHasLight(hasLight);
        ecoBike.setColor(color);
        ecoBike.setPrice(price);
        return ecoBike;
    }

    @Override
    public String convertEcoBikeToString(EcoBike ecoBike) {
        return ecoBike.getBrand() + SEPARATOR +
                ecoBike.getMaxSpeed() + SEPARATOR +
                ecoBike.getWeight() + SEPARATOR +
                ecoBike.getHasLight().toString().toUpperCase() + SEPARATOR +
                ecoBike.getBatteryCapacity() + SEPARATOR +
                ecoBike.getColor() + SEPARATOR +
                ecoBike.getPrice();
    }
}
