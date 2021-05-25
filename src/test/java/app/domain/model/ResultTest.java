package app.domain.model;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ResultTest {
    Result result = new Result("Positivo");

    @Test
    public void testGetResultText() {
        String expected = "Positivo";
        assertEquals(expected, result.getResultText());
    }

    @Test
    public void testSetResultText() {
        String expected = "Negativo";
        result.setResultText("Negativo");
        assertEquals(expected, result.getResultText());
    }

    @Test
    public void testRegisterResultDateTime() {
        result.registerResultDateTime();
        Assert.assertNotNull(result.getResultDateTime());
    }

    @Test
    public void testTestToString() {
        Assert.assertNotNull(result.toString());
    }
}