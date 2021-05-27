package app.domain.store;

import app.domain.model.Client;
import app.domain.model.Test;
import app.domain.shared.SendingEmailSMS;

import java.util.ArrayList;
import java.util.List;

public class TestStore {

    private List<Test> testList = new ArrayList<>();

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

    public List<Test> getTestWithoutValidation() {
        List<Test> testWithoutValidation = new ArrayList<>();
        if (!testList.isEmpty()) {
            for (Test test : testList) {
                if (!test.getValidationStatus())
                    testWithoutValidation.add(test);
            }
            if (testWithoutValidation.isEmpty())
                return null;
            else
                return testWithoutValidation;
        } else {
            return null;
        }
    }


    public boolean doValidation(List<Test> testWithoutValidation) {

        if (testWithoutValidation.isEmpty()) {
            for (Test test:testList) {
                Test test1= getTestByCode(test.getInternalCode());
                Client client = test1.getClient();
                String name = client.getName();
                Test.changeStateValidationToDone();
                SendingEmailSMS.sendEmailWithNotification(name);
                return true;
            }

        }
        return false;
    }


    public List<Test> getTestList() {
        return new ArrayList<>(testList);
    }
}

