package com.matevitskyi.ui;

import com.matevitskyi.model.EcoBike;
import com.matevitskyi.service.EcoBikeService;
import com.matevitskyi.service.PrintService;
import org.springframework.stereotype.Component;

@Component
public class AddNewEcoBikeCommand implements Command {

    private static final String PLEASE_ENTER_A_BRAND_AND_PRESS_ENTER = "Please enter a brand and press ENTER Example: 'SPEEDELEC Peugeot' or 'E-BIKE Koga'";
    private EcoBikeService ecoBikeService;
    private PrintService printService;
    private UiHelper uiHelper;

    public AddNewEcoBikeCommand(EcoBikeService ecoBikeService, PrintService printService, UiHelper uiHelper) {
        this.ecoBikeService = ecoBikeService;
        this.printService = printService;
        this.uiHelper = uiHelper;
    }

    @Override
    public void execute() {
        printService.print(PLEASE_ENTER_A_BRAND_AND_PRESS_ENTER);
        EcoBike ecoBike = uiHelper.getEcoBikeWithParametersFromUser();
        ecoBikeService.save(ecoBike);
    }
}
