package com.matevitskyi.ui;

import org.springframework.stereotype.Component;

@Component
public class CommandFactory {

    private ShowEntireCatalogCommand showEntireCatalogCommand;
    private AddNewFoldingBikeCommand addNewFoldingBikeCommand;
    private AddNewEcoBikeCommand addNewEcoBikeCommand;
    private SearchBikeCommand searchBikeCommand;
    private WriteToFileCommand writeToFileCommand;
    private ExitCommand exitCommand;
    private CommandNotExist commandNotExist;

    public CommandFactory(ShowEntireCatalogCommand showEntireCatalogCommand, AddNewFoldingBikeCommand addNewFoldingBikeCommand, AddNewEcoBikeCommand addNewEcoBikeCommand, SearchBikeCommand searchBikeCommand, WriteToFileCommand writeToFileCommand, ExitCommand exitCommand, CommandNotExist commandNotExist) {
        this.showEntireCatalogCommand = showEntireCatalogCommand;
        this.addNewFoldingBikeCommand = addNewFoldingBikeCommand;
        this.addNewEcoBikeCommand = addNewEcoBikeCommand;
        this.searchBikeCommand = searchBikeCommand;
        this.writeToFileCommand = writeToFileCommand;
        this.exitCommand = exitCommand;
        this.commandNotExist = commandNotExist;
    }

    Command defineCommand(String input) {
        switch (input) {
            case "1":
                return showEntireCatalogCommand;
            case "2":
                return addNewFoldingBikeCommand;
            case "3":
                return addNewEcoBikeCommand;
            case "4":
                return addNewEcoBikeCommand;
            case "5":
                return searchBikeCommand;
            case "6":
                return writeToFileCommand;
            case "7":
                return exitCommand;
            default:
                return commandNotExist;
        }
    }
}
