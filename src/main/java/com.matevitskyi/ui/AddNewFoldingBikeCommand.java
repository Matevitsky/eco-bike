package com.matevitskyi.ui;

import com.matevitskyi.model.FoldingBike;
import com.matevitskyi.service.FoldingBikeService;
import org.springframework.stereotype.Component;

@Component
public class AddNewFoldingBikeCommand implements Command {

    private FoldingBikeService foldingBikeService;
    private UiHelper uiHelper;

    public AddNewFoldingBikeCommand(FoldingBikeService foldingBikeService, UiHelper uiHelper) {
        this.foldingBikeService = foldingBikeService;
        this.uiHelper = uiHelper;
    }

    @Override
    public void execute() {
        FoldingBike foldingBikeFromUser = uiHelper.getFoldingBikeWithParametersFromUser();
        foldingBikeService.save(foldingBikeFromUser);
    }
}
