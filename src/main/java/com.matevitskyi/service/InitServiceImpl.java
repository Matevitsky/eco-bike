package com.matevitskyi.service;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class InitServiceImpl implements InitService {

    private static final String SEPARATOR = ";";
    private static final String FOLDING_BIKE = "FOLDING BIKE ";
    private static final String SPEEDELEC = "SPEEDELEC ";
    private static final String E_BIKE = "E-BIKE ";
    private FileService fileService;
    private FoldingBikeService foldingBikeService;
    private EcoBikeService ecoBikeService;

    public InitServiceImpl(FileService fileService, FoldingBikeService foldingBikeService, EcoBikeService ecoBikeService) {
        this.fileService = fileService;
        this.foldingBikeService = foldingBikeService;
        this.ecoBikeService = ecoBikeService;
    }

    public void initDB(String path) throws IOException {
        List<String> strings = fileService.readFromFile(path);
        for (String line : strings) {
            save(line);
        }
    }

    private void save(String line) {
        String[] record = line.split(SEPARATOR);
        String brand = record[0];
        if (brand.contains(FOLDING_BIKE)) {
            foldingBikeService.create(record);
        } else if (brand.contains(SPEEDELEC) || brand.contains(E_BIKE)) {
            ecoBikeService.create(record);
        }
    }
}
