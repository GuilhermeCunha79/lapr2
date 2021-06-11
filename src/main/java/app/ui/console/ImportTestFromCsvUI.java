package app.ui.console;


import app.controller.ImportTestFromCsvController;
import app.ui.console.utils.Utils;

public class ImportTestFromCsvUI implements Runnable {

    private ImportTestFromCsvController ctrl = new ImportTestFromCsvController();

    @Override
    public void run() {
        String path = Utils.readLineFromConsole("Introduce path:");
        if(ctrl.searchCsvFile(path)){
            ctrl.createTestFromCsvFile();
        }else {
            Utils.printToConsole("File not found!");
        }
    }
}
