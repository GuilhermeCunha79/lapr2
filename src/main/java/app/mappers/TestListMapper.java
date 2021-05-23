package app.mappers;

import org.apache.commons.lang3.NotImplementedException;

import java.util.List;

public class TestListMapper {

    private TestListMapper(){
        throw new IllegalStateException("Utility class");
    }

    public List<String> toDto(){
        throw new NotImplementedException("Method not implemented yet");
    }
}
