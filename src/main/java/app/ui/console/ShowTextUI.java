package app.ui.console;

import app.ui.console.utils.Utils;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class ShowTextUI implements Runnable{


    private String text;
    public ShowTextUI(String text)
    {
        if (StringUtils.isBlank(text))
            throw new IllegalArgumentException("ShowTextUI does not support null or empty text");

        this.text = text;
    }
    public void run()
    {
        Utils.printToConsole("\n");
        Utils.printToConsole(this.text);
        Utils.printToConsole("\n");
    }
}
