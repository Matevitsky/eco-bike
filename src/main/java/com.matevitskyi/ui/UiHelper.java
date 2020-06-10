package com.matevitskyi.ui;

import com.matevitskyi.model.Bike;
import com.matevitskyi.model.EcoBike;
import com.matevitskyi.model.FoldingBike;
import com.matevitskyi.service.PrintService;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Scanner;

@Component
public class UiHelper {

    private static final String PLEASE_ENTER_A_BRAND = "Please enter a brand";
    private static final String PLEASE_ENTER_THE_WEIGHT_OF_THE_BIKE_IN_GRAMS_OR_ENTER_FOR_SKIPPING = "Please enter the weight of the bike (in grams) or ENTER for skipping";
    private static final String PLEASE_ENTER_THE_AVAILABILITY_OF_LIGHTS_AT_FRONT_AND_BACK_TRUE_FALSE_OR_PRESS_ENTER_FOR_SKIPPING = "Please enter The availability of lights at front and back (TRUE/FALSE) or press ENTER for skipping";
    private static final String PLEASE_ENTER_A_COLOR_OR_PRESS_ENTER_FOR_SKIPPING = "Please enter a color or press ENTER for skipping";
    private static final String PLEASE_ENTER_A_PRICE_OR_PRESS_ENTER_FOR_SKIPPING = "Please enter a price or press ENTER for skipping";
    private static final String PLEASE_ENTER_A_WHEEL_SIZE_IN_INCH_OR_ENTER_FOR_SKIPPING = "Please enter a wheel size in inch or ENTER for skipping";
    private static final String PLEASE_ENTER_NUMBER_OF_GEARS_OR_ENTER_FOR_SKIPPING = "Please enter number of gears or ENTER for skipping";
    private static final String PLEASE_ENTER_MAX_SPEED_IN_KM_H_OR_PRESS_ENTER_FOR_SKIPPING = "Please enter max speed in km/h or press ENTER for skipping";
    private static final String PLEASE_ENTER_BATTERY_CAPACITY_IN_M_AH_OR_PRESS_ENTER_FOR_SKIPPING = "Please enter battery capacity in mAh or press ENTER for skipping";
    private static final String BIKE_NOT_FOUND = "\nBIKE NOT FOUND\n";
    private static final String PLEASE_ENTER_JUST_NUMBERS = "Please enter just numbers";
    private static final String VALUE_CANT_BE_EMPTY = "Value cant'be EMPTY";
    private static final String PLEASE_ENTER_THE_WEIGHT_OF_THE_BIKE_IN_GRAMS_AND_ENTER = "Please enter the weight of the bike (in grams) and ENTER";
    private static final String PLEASE_ENTER_THE_AVAILABILITY_OF_LIGHTS_AT_FRONT_AND_BACK_TRUE_FALSE_AND_PRESS_ENTER = "Please enter The availability of lights at front and back (TRUE/FALSE) and press ENTER";
    private static final String PLEASE_ENTER_A_COLOR_AND_PRESS_ENTER = "Please enter a color and press ENTER";
    private static final String PLEASE_ENTER_A_PRICE_AND_PRESS_ENTER = "Please enter a price and press ENTER";
    private static final String PLEASE_ENTER_A_WHEEL_SIZE_IN_INCH_AND_ENTER = "Please enter a wheel size in inch and ENTER";
    private static final String PLEASE_ENTER_NUMBER_OF_GEARS_AND_ENTER = "Please enter number of gears and ENTER";
    private static final String PLEASE_ENTER_MAX_SPEED_IN_KM_H_OR_PRESS_ENTER = "Please enter max speed in km/h or press ENTER";
    private static final String PLEASE_ENTER_BATTERY_CAPACITY_IN_M_AH_AND_PRESS_ENTER = "Please enter battery capacity in mAh and press ENTER";

    private static final String TRUE = "TRUE";
    private static final String FALSE = "FALSE";
    private static final String PLEASE_ENTER_TRUE_OR_FALSE = "Please enter TRUE or FALSE";
    private static final String BIKE_WAS_FOUND = "Bike was found ";


    private PrintService printService;


    public UiHelper(PrintService printService) {
        this.printService = printService;

    }


    public FoldingBike getFoldingBikeWithParametersFromUser() {
        String brand = enterString(PLEASE_ENTER_A_BRAND);
        Integer weight = enterInteger(PLEASE_ENTER_THE_WEIGHT_OF_THE_BIKE_IN_GRAMS_AND_ENTER);
        Boolean hasLight = enterBoolean(PLEASE_ENTER_THE_AVAILABILITY_OF_LIGHTS_AT_FRONT_AND_BACK_TRUE_FALSE_AND_PRESS_ENTER);
        String color = enterString(PLEASE_ENTER_A_COLOR_AND_PRESS_ENTER);
        Integer price = enterInteger(PLEASE_ENTER_A_PRICE_AND_PRESS_ENTER);
        Integer wheelSize = enterInteger(PLEASE_ENTER_A_WHEEL_SIZE_IN_INCH_AND_ENTER);
        Integer numberOfGears = enterInteger(PLEASE_ENTER_NUMBER_OF_GEARS_AND_ENTER);

        FoldingBike foldingBike = new FoldingBike();
        foldingBike.setBrand(brand);
        foldingBike.setWeight(weight);
        foldingBike.setHasLight(hasLight);
        foldingBike.setColor(color);
        foldingBike.setPrice(price);
        foldingBike.setWheelSize(wheelSize);
        foldingBike.setNumberOfGears(numberOfGears);

        return foldingBike;
    }


    public EcoBike getEcoBikeWithParametersFromUser() {
        String brand = enterString(PLEASE_ENTER_A_BRAND);
        Integer weight = enterInteger(PLEASE_ENTER_THE_WEIGHT_OF_THE_BIKE_IN_GRAMS_AND_ENTER);
        Boolean hasLight = enterBoolean(PLEASE_ENTER_THE_AVAILABILITY_OF_LIGHTS_AT_FRONT_AND_BACK_TRUE_FALSE_AND_PRESS_ENTER);
        String color = enterString(PLEASE_ENTER_A_COLOR_AND_PRESS_ENTER);
        Integer price = enterInteger(PLEASE_ENTER_A_PRICE_AND_PRESS_ENTER);

        Integer maxSpeed = enterInteger(PLEASE_ENTER_MAX_SPEED_IN_KM_H_OR_PRESS_ENTER);
        Integer batteryCapacity = enterInteger(PLEASE_ENTER_BATTERY_CAPACITY_IN_M_AH_AND_PRESS_ENTER);

        EcoBike ecoBike = new EcoBike();
        ecoBike.setBrand(brand);
        ecoBike.setWeight(weight);
        ecoBike.setHasLight(hasLight);
        ecoBike.setColor(color);
        ecoBike.setPrice(price);
        ecoBike.setMaxSpeed(maxSpeed);
        ecoBike.setBatteryCapacity(batteryCapacity);
        return ecoBike;
    }

    public Boolean enterBoolean(String message) {
        printService.print(message);
        boolean doLoop = true;
        Boolean hasLight = null;
        String status;

        Scanner scanner = new Scanner(System.in);

        while (doLoop) {
            status = scanner.nextLine();

            if (status.equals(TRUE) || status.equals(FALSE)) {
                hasLight = Boolean.parseBoolean(status);
                doLoop = false;
            } else {
                printService.print(PLEASE_ENTER_TRUE_OR_FALSE);
            }
        }
        return hasLight;
    }

    public Boolean enterNullableBoolean(String message) {
        printService.print(message);
        boolean doLoop = true;
        Boolean hasLight = null;
        String status;

        Scanner scanner = new Scanner(System.in);

        while (doLoop) {
            status = scanner.nextLine();
            if (status.isEmpty()) {
                return null;
            }

            if (status.equals(TRUE) || status.equals(FALSE)) {
                hasLight = Boolean.parseBoolean(status);
                doLoop = false;
            } else {
                printService.print(PLEASE_ENTER_TRUE_OR_FALSE);
            }
        }
        return hasLight;
    }

    public Integer enterInteger(String message) {
        printService.print(message);
        Integer number = 0;
        boolean isNumber;
        Scanner scanner = new Scanner(System.in);
        do {
            try {
                String line = scanner.nextLine();
                number = Integer.parseInt(line);
                isNumber = true;
            } catch (NumberFormatException e) {
                isNumber = false;
                printService.print(PLEASE_ENTER_JUST_NUMBERS);
            }

        } while (!isNumber);
        return number;
    }

    public Integer enterNullableInteger(String message) {
        printService.print(message);
        Integer number = 0;
        boolean isNumber;
        Scanner scanner = new Scanner(System.in);
        do {
            try {
                String line = scanner.nextLine();
                if (line.isEmpty()) {
                    return null;
                }
                number = Integer.parseInt(line);
                isNumber = true;
            } catch (NumberFormatException e) {
                isNumber = false;
                printService.print(PLEASE_ENTER_JUST_NUMBERS);
            }

        } while (!isNumber);
        return number;

    }

    public String enterString(String message) {

        Scanner scanner = new Scanner(System.in);
        printService.print(message);

        String line;
        do {
            line = scanner.nextLine();
            if (line.isEmpty()) {
                printService.print(VALUE_CANT_BE_EMPTY);
            }

        } while (line.isEmpty());

        return line;

    }

    public String enterNullableString(String message) {
        Scanner scanner = new Scanner(System.in);
        printService.print(message);
        String value = scanner.nextLine();
        return value.isEmpty() ? null : value;
    }


    public void checkIfFound(Bike bike) {
        if (Objects.isNull(bike)) {
            printService.print(BIKE_NOT_FOUND);
        } else {
            printService.print(BIKE_WAS_FOUND + bike.toString());
        }
    }

    public FoldingBike getFromUserFoldingBikeDatForSearching(String brand) {

        Integer wheelSize = enterNullableInteger(PLEASE_ENTER_A_WHEEL_SIZE_IN_INCH_OR_ENTER_FOR_SKIPPING);
        Integer numberOfGears = enterNullableInteger(PLEASE_ENTER_NUMBER_OF_GEARS_OR_ENTER_FOR_SKIPPING);
        Integer weight = enterNullableInteger(PLEASE_ENTER_THE_WEIGHT_OF_THE_BIKE_IN_GRAMS_OR_ENTER_FOR_SKIPPING);
        Boolean hasLight = enterNullableBoolean(PLEASE_ENTER_THE_AVAILABILITY_OF_LIGHTS_AT_FRONT_AND_BACK_TRUE_FALSE_OR_PRESS_ENTER_FOR_SKIPPING);
        String color = enterNullableString(PLEASE_ENTER_A_COLOR_OR_PRESS_ENTER_FOR_SKIPPING);
        Integer price = enterNullableInteger(PLEASE_ENTER_A_PRICE_OR_PRESS_ENTER_FOR_SKIPPING);


        FoldingBike foldingBike = new FoldingBike();
        foldingBike.setBrand(brand);
        foldingBike.setWeight(weight);
        foldingBike.setHasLight(hasLight);
        foldingBike.setColor(color);
        foldingBike.setPrice(price);
        foldingBike.setWheelSize(wheelSize);
        foldingBike.setNumberOfGears(numberOfGears);
        return foldingBike;
    }

    public EcoBike getFromUserEcoBikeDatForSearching(String brand) {

        Integer maxSpeed = enterNullableInteger(PLEASE_ENTER_MAX_SPEED_IN_KM_H_OR_PRESS_ENTER_FOR_SKIPPING);
        Integer weight = enterNullableInteger(PLEASE_ENTER_THE_WEIGHT_OF_THE_BIKE_IN_GRAMS_OR_ENTER_FOR_SKIPPING);
        Boolean hasLight = enterNullableBoolean(PLEASE_ENTER_THE_AVAILABILITY_OF_LIGHTS_AT_FRONT_AND_BACK_TRUE_FALSE_OR_PRESS_ENTER_FOR_SKIPPING);
        Integer batteryCapacity = enterNullableInteger(PLEASE_ENTER_BATTERY_CAPACITY_IN_M_AH_OR_PRESS_ENTER_FOR_SKIPPING);
        String color = enterNullableString(PLEASE_ENTER_A_COLOR_OR_PRESS_ENTER_FOR_SKIPPING);
        Integer price = enterNullableInteger(PLEASE_ENTER_A_PRICE_OR_PRESS_ENTER_FOR_SKIPPING);


        EcoBike ecoBike = new EcoBike();
        ecoBike.setBrand(brand);
        ecoBike.setWeight(weight);
        ecoBike.setHasLight(hasLight);
        ecoBike.setColor(color);
        ecoBike.setPrice(price);
        ecoBike.setMaxSpeed(maxSpeed);
        ecoBike.setBatteryCapacity(batteryCapacity);
        return ecoBike;
    }


}
