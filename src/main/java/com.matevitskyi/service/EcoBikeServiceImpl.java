package com.matevitskyi.service;

import com.matevitskyi.mapper.EcoBikeMapper;
import com.matevitskyi.model.EcoBike;
import com.matevitskyi.repository.EcoBikeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EcoBikeServiceImpl implements EcoBikeService {

    private EcoBikeMapper ecoBikeMapper;
    private EcoBikeRepository ecoBikeRepository;

    public EcoBikeServiceImpl(EcoBikeMapper ecoBikeMapper, EcoBikeRepository ecoBikeRepository) {
        this.ecoBikeMapper = ecoBikeMapper;
        this.ecoBikeRepository = ecoBikeRepository;
    }

    @Override
    public boolean save(EcoBike ecoBike) {
        return ecoBikeRepository.save(ecoBike);

    }

    @Override
    public List<EcoBike> getAll() {
        return ecoBikeRepository.findAll();
    }

    @Override
    public EcoBike searchBike(EcoBike ecoBike) {
        return ecoBikeRepository.findFirst(ecoBike);
    }

    @Override
    public List<String> getAllAsString() {
        List<EcoBike> allBikes = ecoBikeRepository.findAll();
        return allBikes.stream()
                .map(ecoBike -> ecoBikeMapper.convertEcoBikeToString(ecoBike))
                .collect(Collectors.toList());

    }

    @Override
    public boolean create(String[] record) {
        EcoBike ecoBike = ecoBikeMapper.mapStringArrayToEcoBike(record);
        return ecoBikeRepository.save(ecoBike);
    }
}
