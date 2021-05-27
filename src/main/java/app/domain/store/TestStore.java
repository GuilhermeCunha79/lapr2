package app.domain.store;

import app.controller.TestValidation;
import app.controller.ValidationController;
import app.domain.model.Client;
import app.domain.model.Test;
import app.domain.shared.DateTime;
import app.domain.shared.SendingEmailSMS;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TestStore {

    private List<Test> testList = new ArrayList<>();
    private Client client;
    private DateTime validatedAt;
    private Test test;

    public List<Test> getTestsWithoutResults() {
        System.out.println(testList.size());
        List<Test> lTestNoResult = new ArrayList<>();
        for (Test recordTest : testList) {
            if (!recordTest.getResultStatus())
                lTestNoResult.add(recordTest);
        }
        if (lTestNoResult.isEmpty())
            return null;
        else
            return lTestNoResult;
    }

    public List<Test> getTestWithoutReport() {
        List<Test> lTestNoReport = new ArrayList<>();
        if (!testList.isEmpty()) {
            for (Test test : testList) {
                if (!test.getReportStatus())
                    lTestNoReport.add(test);
            }
            if (lTestNoReport.isEmpty())
                return null;
            else
                return lTestNoReport;
        } else {
            return null;
        }
    }

    public Test getTestByCode(String internalCode) {
        for (Test test : testList) {
            if (test.getInternalCode().equals(internalCode))
                return test;
        }
        return null;
    }

    public Test createValidateTest(Test test) {
        if(test!=null) {
            return new TestValidation(test);
        }
        return null;
    }


    //LOOP

/*
    public Test getTest(){
    }

    public Client getClient(){
    }*/


    public void sendEmailSms(String name) {
        name = this.client.getName();
        SendingEmailSMS.sendEmailWithNotification(name);
    }

    public List<Test> getTestList() {
        return new ArrayList<>(testList);
    }
}

