package com.matevitskyi.service;

import com.matevitskyi.model.FoldingBike;

import java.util.List;

public interface FoldingBikeService {

    List<FoldingBike> getAll();

    boolean create(String[] record);

    boolean save(FoldingBike foldingBike);

    FoldingBike searchBike(FoldingBike foldingBike);

    List<String> getAllAsString();
}
