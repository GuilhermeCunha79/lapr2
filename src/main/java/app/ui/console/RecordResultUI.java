package app.ui.console;

import app.controller.RecordResultController;
import app.domain.model.Test;
import app.ui.console.utils.Utils;

public class RecordResultUI implements Runnable{

    private RecordResultController ctrl;
    private Test test;

    @Override
    public void run() {
        this.ctrl = new RecordResultController();
        if(recordResult())
            System.out.println("Employee was succesfully registered!");
    }

    public boolean recordResult(){
        boolean state = false;
        do {
            String result = Utils.readLineFromConsole("Introduce the result of the given test: ");

            try {
                if(ctrl.getTestResults(test.getInternalCode())!=null){
                    ctrl.newResult(result);
                    state = true;
                }

                if (state) {
                    String answer = Utils.readLineFromConsole(String.format("%nConfirm the result of the test: %nResult: %s%n(Y/N)", result));
                    while (!answer.equalsIgnoreCase("Y") && !answer.equalsIgnoreCase("N")){
                        answer = Utils.readLineFromConsole("Answer not valid! Use (Y/N)");
                    }
                    if (answer.equalsIgnoreCase("Y")) {
                       // ctrl.saveResult(test);
                        return true;
                    }
                } else {
                    System.out.println("Result is invalid!");
                    return false;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }while(!state);
        return false;
    }
}
