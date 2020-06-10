package com.matevitskyi.mapper;


import com.matevitskyi.model.FoldingBike;

public interface FoldingBikeMapper {
    FoldingBike mapStringArrayToFoldingBike(String[] array);

    String convertFoldingBikeToString(FoldingBike foldingBike);
}
