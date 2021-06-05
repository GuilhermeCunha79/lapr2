package app.domain.shared;

import junit.framework.TestCase;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SendingEmailSMSTest {

    @Test(expected = InvocationTargetException.class)
    public void testConstructor() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<SendingEmailSMS> c = SendingEmailSMS.class.getDeclaredConstructor();
        c.setAccessible(true);
        c.newInstance();
    }

}