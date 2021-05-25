package app.domain.model;

import app.domain.shared.DateTime;
import org.apache.commons.lang3.NotImplementedException;

import java.awt.image.BufferedImage;

public class Test {

    private DateTime createdAt;
    private String internalCode;
    private String nhsCode;
    private boolean reportDone;
    private boolean resultDone;
    private Report report;
 //   private Result result;
    private BufferedImage qrcode;

    public Test(String internalCode, String nhsCode) {
        //setQRCode(internalCode);
        setNHSCode(nhsCode);
        reportDone = false;
        resultDone = false;
    }

    /**
     * this method returns if this test already has a report or not using the reportDone boolean variable
     * @return true or false
     */
    public boolean getReportStatus(){
        return this.reportDone;
    }

    /**
     * this method returns if this test already has a result
     * @return true or false
     */
    public boolean getResultStatus(){
        return this.resultDone;
    }


    /**
     * This method returns the internal code of this test
     * @return a string with the internal code
     */
    public String getInternalCode() {
        return this.internalCode;
    }

    /*public BufferedImage setQRCode(String internalCode) throws OutputException {
        this.qrcode = generateEAN13BarcodeImage(internalCode);

        return this.qrcode;
    }*/

    public String setNHSCode(String nhsCode) {
        this.nhsCode = nhsCode;

        return this.nhsCode;
    }

    /*
    private static BufferedImage generateEAN13BarcodeImage(String barcodeText) throws OutputException {
        Barcode barcode = null;
        try {
            barcode = BarcodeFactory.createEAN13(barcodeText);
        } catch (BarcodeException e) {
            e.printStackTrace();
        }
        barcode.setPreferredBarHeight(40);
        barcode.setBarWidth(2);
        barcode.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,10));


        return BarcodeImageHandler.getImage(barcode);

    }*/

    /**
     * This method finds all the parameter test results done for this test and return them in a string
     * @return the results available
     */
    public String getTestResults() {
        throw new NotImplementedException("Method not implemented");
    }
/*
    public void addResult (Result result) {
        this.result = result;
        changeStateToResultDone();
    }*/

    /**
     * This method receives a Report and assigns it to the test it's related to
     * @param report the instance of a Report
     * @return if it was added or not
     */
    public boolean addReport(Report report) {
        this.report = report;
        changeStateToReportDone();
        return this.reportDone;
    }

    /**
     * The only purpose of this method is to change the state of the test to inform that the report is done
     */
    private void changeStateToReportDone() {
        reportDone = true;
    }

    private void changeStateToResultDone() {
        resultDone = true;
    }

    /**
     * This method returns a string with some important data about this test
     * @return string
     */
    @Override
    public String toString() {
        return String.format("Internal Code: %s | NHS Code: %s | Created on: %s |",
                this.internalCode, this.nhsCode, this.createdAt);
    }
}
