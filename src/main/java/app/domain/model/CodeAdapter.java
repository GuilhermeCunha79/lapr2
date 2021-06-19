package app.domain.model;

public class CodeAdapter {
    public String getCode(String data, int x) {
        String retorno = x+data.substring(2, 12);
        return retorno;
    }
}
