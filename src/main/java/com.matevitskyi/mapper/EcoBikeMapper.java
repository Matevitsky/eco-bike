package com.matevitskyi.mapper;

import com.matevitskyi.model.EcoBike;

public interface EcoBikeMapper {
    EcoBike mapStringArrayToEcoBike(String[] array);

    String convertEcoBikeToString(EcoBike ecoBike);
}
