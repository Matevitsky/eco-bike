package com.matevitskyi.repository;

import com.matevitskyi.model.EcoBike;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;

@Repository
public class EcoBikeRepositoryImpl implements EcoBikeRepository {

    private final List<EcoBike> ecoBikeList = new ArrayList<>();

    @Override
    public boolean save(EcoBike ecoBike) {
        return ecoBikeList.add(ecoBike);

    }


    @Override
    public List<EcoBike> findAll() {
        return new ArrayList<>(ecoBikeList);
    }

    @Override
    public EcoBike findFirst(EcoBike ecoBike) {

        Comparator<EcoBike> ekoBikeAllFieldsComparator = comparing(EcoBike::getBrand)
                .thenComparing(EcoBike::getWeight)
                .thenComparing(EcoBike::getHasLight)
                .thenComparing(EcoBike::getColor)
                .thenComparing(EcoBike::getPrice)
                .thenComparing(EcoBike::getMaxSpeed)
                .thenComparing(EcoBike::getBatteryCapacity);


        Comparator<EcoBike> ecoBikeBrandNameComparator = comparing(EcoBike::getBrand);

        Comparator<EcoBike> ecoBikeComparator = hasNullFields(ecoBike) ? ecoBikeBrandNameComparator : ekoBikeAllFieldsComparator;

        ecoBikeList.sort(ecoBikeComparator);
        int index = Collections.binarySearch(ecoBikeList, ecoBike, ecoBikeComparator);

        if (index < 0) {
            return null;
        }
        return ecoBikeList.get(index);
    }

    private boolean hasNullFields(EcoBike ecoBike) {
        return ecoBike.getWeight() == null
                || ecoBike.getHasLight() == null
                || ecoBike.getColor() == null
                || ecoBike.getPrice() == null
                || ecoBike.getMaxSpeed() == null
                || ecoBike.getBatteryCapacity() == null;
    }


}
