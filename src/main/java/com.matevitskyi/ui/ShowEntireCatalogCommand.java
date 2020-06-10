package com.matevitskyi.ui;

import com.matevitskyi.model.EcoBike;
import com.matevitskyi.model.FoldingBike;
import com.matevitskyi.service.EcoBikeService;
import com.matevitskyi.service.FoldingBikeService;
import com.matevitskyi.service.PrintService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ShowEntireCatalogCommand implements Command {

    private FoldingBikeService foldingBikeService;
    private EcoBikeService ecoBikeService;
    private PrintService printService;

    public ShowEntireCatalogCommand(FoldingBikeService foldingBikeService, EcoBikeService ecoBikeService, PrintService printService) {
        this.foldingBikeService = foldingBikeService;
        this.ecoBikeService = ecoBikeService;
        this.printService = printService;
    }

    @Override
    public void execute() {
        List<FoldingBike> foldingBikeList = foldingBikeService.getAll();
        List<EcoBike> ecoBikeList = ecoBikeService.getAll();
        List entireBikeCatalog = new ArrayList<>();
        entireBikeCatalog.addAll(foldingBikeList);
        entireBikeCatalog.addAll(ecoBikeList);
        printService.printBikeCatalog(entireBikeCatalog);
    }
}
