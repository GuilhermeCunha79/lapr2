package app.domain.shared;

import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DateTimeTest {

    @Test
    public void testCompareTo() {
        DateTime d1 = new DateTime("15/06/2020","08:00");
        DateTime d2 = new DateTime("15/06/2020","09:00");
        int result = d1.compareTo(d2);
        assertEquals(-1 ,result);
    }
}