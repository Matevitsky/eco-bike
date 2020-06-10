package com.matevitskyi.service;


import com.matevitskyi.model.EcoBike;

import java.util.List;

public interface EcoBikeService {

    boolean create(String[] record);

    boolean save(EcoBike ecoBike);

    List<EcoBike> getAll();

    EcoBike searchBike(EcoBike ecoBike);

    List<String> getAllAsString();
}

