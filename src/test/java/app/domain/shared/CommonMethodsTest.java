package app.domain.shared;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;


public class CommonMethodsTest {

    @Test
    public void testConstructor() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<CommonMethods> c = CommonMethods.class.getDeclaredConstructor();
        c.setAccessible(true);
        c.newInstance();
    }

}