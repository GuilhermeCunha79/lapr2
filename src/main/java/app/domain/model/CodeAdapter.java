package app.domain.model;

public class CodeAdapter {
    public String getCode(String data, int x) {
        return x+data.substring(2, 12);
    }
}
