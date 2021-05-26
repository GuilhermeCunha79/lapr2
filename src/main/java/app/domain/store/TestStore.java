package app.domain.store;

import app.domain.model.Client;
import app.domain.model.Test;
import app.domain.shared.DateTime;
import app.domain.shared.SendingEmailSMS;

import java.util.ArrayList;
import java.util.List;

public class TestStore {

    private List<Test> testList = new ArrayList<>();
    private Client client;
    private DateTime validatedAt;

    public List<Test> getTestsWithoutResults(){
        System.out.println(testList.size());
        List<Test> lTestNoResult = new ArrayList<>();
        for (Test recordTest : testList){
            if(!recordTest.getResultStatus())
                lTestNoResult.add(recordTest);
        }
        if(lTestNoResult.isEmpty())
            return null;
        else
            return lTestNoResult;
    }

    public List<Test> getTestWithoutReport(){
        List<Test> lTestNoReport = new ArrayList<>();
        if(!testList.isEmpty()) {
            for (Test test : testList) {
                if (!test.getReportStatus())
                    lTestNoReport.add(test);
            }
            if (lTestNoReport.isEmpty())
                return null;
            else
                return lTestNoReport;
        }else{
            return null;
        }
    }

    public Test getTestByCode(String testCode){
        for(Test test : testList){
            if(test.getInternalCode().equals(testCode))
                return test;
        }
        return null;
    }

    //LOOP

/*
    public Test getTest(){
    }

    public Client getClient(){
    }*/

    public void validatedAt(){
        this.validatedAt = new DateTime();
    }

    public void sendEmailSms(String name){
        name=this.client.getName();
        SendingEmailSMS.sendEmailWithNotification(name);
    }
}