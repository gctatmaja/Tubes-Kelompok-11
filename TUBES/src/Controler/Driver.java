
package Controler;

import Model.AppSingleton;
import Model.Application;


/**
 *
 * @author useR
 */
public class Driver {
    public static void main(String[] args) {
        Application app = AppSingleton.getSingleton();
        new ControllerMainMenu(app);
        
        app.mainMenu();
    }
}

