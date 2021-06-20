package app.domain.model;

import junit.framework.TestCase;

public class CodeAdapterTest extends TestCase {

    public void testGetCode() {
        String string = "Olfgdh12345a";

        CodeAdapter codeAdapter = new CodeAdapter();

        assertNotNull(codeAdapter.getCode(string,2));

    }
}