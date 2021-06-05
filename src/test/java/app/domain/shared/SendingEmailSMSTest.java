package app.domain.shared;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SendingEmailSMSTest {

    @Test(expected = InvocationTargetException.class)
    public void testConstructor() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<SendingEmailSMS> z = SendingEmailSMS.class.getDeclaredConstructor();
        z.setAccessible(true);
        z.newInstance();
    }

}