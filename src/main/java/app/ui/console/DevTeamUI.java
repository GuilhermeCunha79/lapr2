package app.ui.console;

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
        System.out.println("\n");
        System.out.printf("Development Team:\n");
        System.out.printf("\t André Santos - 120534@isep.ipp.pt \n");
        System.out.printf("\t Francisco Malheiro - 1201485@isep.ipp.pt \n");
        System.out.printf("\t Guilherme Cunha - 1201506@isep.ipp.pt \n");
        System.out.printf("\t João Martins - 1201539@isep.ipp.pt \n");
        System.out.printf("\t Pedro Moreira - 1191526@isep.ipp.pt \n");
        System.out.println("\n");
    }
}
