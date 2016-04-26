/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Administrator
 */
public class AppSingleton {
    private static final Application instance = null;
    
    private AppSingleton() {
        
    }
    
    public static Application getSingleton() {
        if (instance == null) {
            return new Application();
        }
        
        return instance;
    }
}
