package app.ui.console;

import app.ui.console.utils.Utils;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class DevTeamUI implements Runnable{


    public DevTeamUI()
    {

    }
    public void run()
    {
        Utils.printToConsole("\n");
        Utils.printToConsole("Development Team:");
        Utils.printToConsole("\t André Santos - 1201534@isep.ipp.pt");
        Utils.printToConsole("\t Francisco Malheiro - 1201485@isep.ipp.pt");
        Utils.printToConsole("\t Guilherme Cunha - 1201506@isep.ipp.pt");
        Utils.printToConsole("\t João Martins - 1201539@isep.ipp.pt");
        Utils.printToConsole("\t Pedro Moreira - 1191526@isep.ipp.pt");
        Utils.printToConsole("\n");
    }
}
