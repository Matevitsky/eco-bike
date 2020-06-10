package com.matevitskyi.ui;

import com.matevitskyi.model.EcoBike;
import com.matevitskyi.model.FoldingBike;
import com.matevitskyi.service.EcoBikeService;
import com.matevitskyi.service.FoldingBikeService;
import com.matevitskyi.service.PrintService;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class SearchBikeCommand implements Command {

    private static final String FOLDING_BIKE = "FOLDING BIKE";
    private static final String SPEEDELEC = "SPEEDELEC";
    private static final String E_BIKE = "E-BIKE";
    private static final String SEARCHING_STARTED = "Searching started...\n";
    private static final String PLEASE_ENTER_A_BRAND = "Please enter a brand";
    private UiHelper uiHelper;
    private PrintService printService;
    private FoldingBikeService foldingBikeService;
    private EcoBikeService ecoBikeService;


    public SearchBikeCommand(UiHelper uiHelper, PrintService printService, FoldingBikeService foldingBikeService, EcoBikeService ecoBikeService) {
        this.uiHelper = uiHelper;
        this.printService = printService;
        this.foldingBikeService = foldingBikeService;
        this.ecoBikeService = ecoBikeService;
    }

    @Override
    public void execute() {

        String brand = uiHelper.enterString(PLEASE_ENTER_A_BRAND);

        if (brand.contains(FOLDING_BIKE)) {
            FoldingBike foldingBike = uiHelper.getFromUserFoldingBikeDatForSearching(brand);

            CompletableFuture
                .supplyAsync(() -> foldingBikeService.searchBike(foldingBike))
                .thenAccept(o -> uiHelper.checkIfFound(o));

        } else if (brand.contains(E_BIKE) || brand.contains(SPEEDELEC)) {
            EcoBike ecoBike = uiHelper.getFromUserEcoBikeDatForSearching(brand);
            printService.print(SEARCHING_STARTED);
            CompletableFuture
                .supplyAsync(() -> ecoBikeService.searchBike(ecoBike))
                .thenAccept(ecoBike1 -> uiHelper.checkIfFound(ecoBike1));
        }
    }
}

