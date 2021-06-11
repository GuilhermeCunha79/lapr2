package app.domain.model;

import app.domain.shared.DateTime;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReportTest {

    @Test(expected = IllegalArgumentException.class)
    public void ensureItsNotPossibleToAddBlankReportText(){
        new Report("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void ensureItsNotPossibleToAddReportTextWithMoreThan400words(){
        new Report("a b b d a a f d a d f a f d a d f d a d f a d f a d f a d f a d f a b b d a a f d a d f a f d a d f d a d f a d f a d f a d f a d f" +
                "a b b d a a f d a d f a f d a d f d a d f a d f a d f a d f a d f a b b d a a f d a d f a f d a d f d a d f a d f a d f a d f a d f" +
                "a b b d a a f d a d f a f d a d f d a d f a d f a d f a d f a d f a b b d a a f d a d f a f d a d f d a d f a d f a d f a d f a d f" +
                "a b b d a a f d a d f a f d a d f d a d f a d f a d f a d f a d f a b b d a a f d a d f a f d a d f d a d f a d f a d f a d f a d f" +
                "a b b d a a f d a d f a f d a d f d a d f a d f a d f a d f a d f a b b d a a f d a d f a f d a d f d a d f a d f a d f a d f a d f" +
                "a b b d a a f d a d f a f d a d f d a d f a d f a d f a d f a d f a b b d a a f d a d f a f d a d f d a d f a d f a d f a d f a d f" +
                "a b b d a a g g g g f");
    }

    @Test
    public void testGetReport(){
        Report rep = new Report("This is a report");
        String expected = "This is a report";
        assertEquals(expected, rep.getReportText());
    }

    @Test
    public void testToString(){
        Report rep = new Report("This is a report");
        String expected = String.format("Report created on: %s%nReport: This is a report", new DateTime());
        assertEquals(expected, rep.toString());
    }

}
