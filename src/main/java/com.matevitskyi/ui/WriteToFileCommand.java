package com.matevitskyi.ui;

import com.matevitskyi.service.EcoBikeService;
import com.matevitskyi.service.FileService;
import com.matevitskyi.service.FoldingBikeService;
import com.matevitskyi.service.PrintService;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class WriteToFileCommand implements Command {

    public static final String SAVING_TO_FILE_STARTED = "Saving to file started...\n";
    private static final String PLEASE_ENTER_PATH_TO_THE_FILE = "Please enter path to the file";
    private static final String FAILED_TO_SAVE_DATA_TO_FILE = "Failed to save data to file ";
    private static final String PLEASE_TRY_AGAIN = ", please try again";
    private PrintService printService;
    private FoldingBikeService foldingBikeService;
    private EcoBikeService ecoBikeService;
    private FileService fileService;

    public WriteToFileCommand(PrintService printService, FoldingBikeService foldingBikeService, EcoBikeService ecoBikeService, FileService fileService) {
        this.printService = printService;
        this.foldingBikeService = foldingBikeService;
        this.ecoBikeService = ecoBikeService;
        this.fileService = fileService;
    }

    @Override
    public void execute() {
        printService.print(PLEASE_ENTER_PATH_TO_THE_FILE);
        Scanner scanner = new Scanner(System.in);
        String pathForFileSaving = scanner.nextLine();
        List<String> bikes = new ArrayList<>();

        bikes.addAll(foldingBikeService.getAllAsString());
        bikes.addAll(ecoBikeService.getAllAsString());

        try {
            printService.print(SAVING_TO_FILE_STARTED);
            fileService.writeToFile(bikes, pathForFileSaving);
        } catch (IOException e) {
            printService.print(FAILED_TO_SAVE_DATA_TO_FILE + pathForFileSaving + PLEASE_TRY_AGAIN);
        }
    }
}
