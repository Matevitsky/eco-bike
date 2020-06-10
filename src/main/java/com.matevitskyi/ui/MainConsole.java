package com.matevitskyi.ui;

import com.matevitskyi.service.InitService;
import com.matevitskyi.service.PrintService;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Scanner;

@Component
public class MainConsole {

    private static final String PLEASE_ENTER_PATH_TO_THE_FILE = "Please enter path to the file";
    private static final String READING_FROM_FILE = "Reading from file ";
    private static final String FILED_PLEASE_TRY_AGAIN = " filed, please try again\n";
    private static final String MENU = "Please make your choice:\n" +
            "1 - Show the entire EcoBike catalog\n" +
            "2 – Add a new folding bike\n" +
            "3 – Add a new speedelec\n" +
            "4 – Add a new e-bike\n" +
            "5 – Find the first item of a particular brand\n" +
            "6 – Write to file\n" +
            "7 – Stop the program\n";
    private InitService initService;
    private PrintService printService;
    private CommandFactory commandFactory;

    public MainConsole(InitService initService, PrintService printService, CommandFactory commandFactory) {
        this.initService = initService;
        this.printService = printService;
        this.commandFactory = commandFactory;
    }

    public void startApp() {
        printService.print(PLEASE_ENTER_PATH_TO_THE_FILE);
        Scanner scanner = new Scanner((System.in));
        String filePath = scanner.nextLine();
        try {
            initService.initDB(filePath);
        } catch (IOException e) {
            printService.print(READING_FROM_FILE + filePath + FILED_PLEASE_TRY_AGAIN);
            startApp();
        }

        runConsoleMenu();
    }

    private void runConsoleMenu() {
        Scanner scanner = new Scanner(System.in);

        String input;
        while (true) {

            System.out.print(MENU);

            input = scanner.nextLine();

            Command command = commandFactory.defineCommand(input);
            command.execute();
        }
    }
}
