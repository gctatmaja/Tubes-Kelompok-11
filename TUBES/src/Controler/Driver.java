
package Controler;

import Model.Application;


/**
 *
 * @author useR
 */
public class Driver {
    public static void main(String[] args) {
        Application app = new Application();
        new ControllerMainMenu(app);
        
        app.mainMenu();
    }
}

