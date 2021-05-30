package app.controller;


import org.junit.Assert;
import org.junit.Test;

public class WriteReportControllerTest {

    WriteReportController ctrl = new WriteReportController();

    @Test
    public void testGetTestWithoutReportMethodWhenThereAreNoTests() {
        Assert.assertNotNull(ctrl.getTestWithoutReport());
    }




}