package app.domain.shared;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;


public class ConstantsTest {

    @Test
    public void testConstructor() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<Constants> c = Constants.class.getDeclaredConstructor();
        c.setAccessible(true);
        Constants u = c.newInstance();
    }
}