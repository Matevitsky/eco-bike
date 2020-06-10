package com.matevitskyi.ui;

import com.matevitskyi.service.PrintService;
import org.springframework.stereotype.Component;

@Component
public class CommandNotExist implements Command {

    private static final String PLEASE_CHOOSE_OPTION_BETWEEN_1_7 = "Please choose option between 1 - 7\n";

    private PrintService printService;

    public CommandNotExist(PrintService printService) {
        this.printService = printService;
    }

    @Override
    public void execute() {
        printService.print(PLEASE_CHOOSE_OPTION_BETWEEN_1_7);
    }
}
