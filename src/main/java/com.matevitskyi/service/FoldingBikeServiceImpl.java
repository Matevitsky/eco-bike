package com.matevitskyi.service;

import com.matevitskyi.mapper.FoldingBikeMapper;
import com.matevitskyi.model.FoldingBike;
import com.matevitskyi.repository.FoldingBikeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FoldingBikeServiceImpl implements FoldingBikeService {

    private FoldingBikeRepository foldingBikeRepository;
    private FoldingBikeMapper foldingBikeMapper;

    public FoldingBikeServiceImpl(FoldingBikeRepository foldingBikeRepository, FoldingBikeMapper foldingBikeMapper) {
        this.foldingBikeRepository = foldingBikeRepository;
        this.foldingBikeMapper = foldingBikeMapper;
    }

    @Override
    public List<FoldingBike> getAll() {
        return foldingBikeRepository.findAll();
    }

    @Override
    public boolean save(FoldingBike foldingBike) {

        return foldingBikeRepository.save(foldingBike);
    }

    @Override
    public FoldingBike searchBike(FoldingBike foldingBike) {
        return foldingBikeRepository.findFirst(foldingBike);
    }

    @Override
    public boolean create(String[] record) {
        FoldingBike foldingBike = foldingBikeMapper.mapStringArrayToFoldingBike(record);
        return foldingBikeRepository.save(foldingBike);

    }

    @Override
    public List<String> getAllAsString() {
        List<FoldingBike> allBikes = getAll();
        return allBikes.stream()
                .map(foldingBike -> foldingBikeMapper.convertFoldingBikeToString(foldingBike))
                .collect(Collectors.toList());
    }
}
