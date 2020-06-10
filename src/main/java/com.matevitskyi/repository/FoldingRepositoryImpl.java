package com.matevitskyi.repository;

import com.matevitskyi.model.FoldingBike;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;

@Repository
public class FoldingRepositoryImpl implements FoldingBikeRepository {

    private final List<FoldingBike> foldingBikeList = new ArrayList<>();

    @Override
    public List<FoldingBike> findAll() {
        return new ArrayList<>(foldingBikeList);
    }

    @Override
    public boolean save(FoldingBike foldingBike) {
        return foldingBikeList.add(foldingBike);
    }

    @Override
    public FoldingBike findFirst(FoldingBike foldingBike) {

        Comparator<FoldingBike> foldingBikeAllFieldsComparator = comparing(FoldingBike::getBrand)
                .thenComparing(FoldingBike::getWeight)
                .thenComparing(FoldingBike::getHasLight)
                .thenComparing(FoldingBike::getColor)
                .thenComparing(FoldingBike::getPrice)
                .thenComparing(FoldingBike::getWheelSize)
                .thenComparing(FoldingBike::getNumberOfGears);
        Comparator<FoldingBike> foldingBikeBrandNameComparator = comparing(FoldingBike::getBrand);

        Comparator<FoldingBike> foldingBikeComparator = hasNullFields(foldingBike) ? foldingBikeBrandNameComparator : foldingBikeAllFieldsComparator;

        foldingBikeList.sort(foldingBikeComparator);
        int index = Collections.binarySearch(foldingBikeList, foldingBike, foldingBikeComparator);
        if (index < 0) {
            return null;
        }
        return foldingBikeList.get(index);
    }

    private boolean hasNullFields(FoldingBike foldingBike) {
        return foldingBike.getWeight() == null
                || foldingBike.getHasLight() == null
                || foldingBike.getColor() == null
                || foldingBike.getPrice() == null
                || foldingBike.getNumberOfGears() == null
                || foldingBike.getWheelSize() == null;
    }
}
