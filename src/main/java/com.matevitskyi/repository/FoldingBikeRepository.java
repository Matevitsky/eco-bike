package com.matevitskyi.repository;

import com.matevitskyi.model.FoldingBike;

import java.util.List;

public interface FoldingBikeRepository {

    List<FoldingBike> findAll();

    boolean save(FoldingBike foldingBike);

    FoldingBike findFirst(FoldingBike foldingBike);
}
