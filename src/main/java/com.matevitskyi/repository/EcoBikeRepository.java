package com.matevitskyi.repository;

import com.matevitskyi.model.EcoBike;

import java.util.List;

public interface EcoBikeRepository {

    boolean save(EcoBike ecoBike);

    List<EcoBike> findAll();

    EcoBike findFirst(EcoBike ecoBike);
}
