package app.domain.model;


import app.domain.shared.DateTime;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SampleTest  {

    @Test(expected = NullPointerException.class)
    public void ensureItsNotPossibleToAddNullCode(){ new Sample(null); }

    @Test(expected = IllegalArgumentException.class)
    public void ensureItsNotPossibleToAddBlankCode(){ new Sample(""); }

    @Test(expected = IllegalArgumentException.class) public void ensureItsNotPossibleToAddShorterCode(){ new Sample("123"); }

    @Test(expected = IllegalArgumentException.class) public void ensureItsNotPossibleToAddLongerCode(){ new Sample("123456789012"); }

    @Test
    public void testGetSampe(){
        Sample sample = new Sample("12345678901");
        String expected = "12345678901";
        assertEquals(expected, sample.getCode());
    }

    @Test
    public void testToString(){
        Sample rep = new Sample("12345678901");
        String expected = "Sample: 12345678901";
        assertEquals(expected, rep.toString());
    }

}