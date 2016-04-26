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
public class OutUser {
    private Orang user;
    private static OutUser instance = null;
    
    private OutUser() {
        this.user = null;
    }
    
    public static OutUser getSingleton() {
        if (instance == null) {
            return new OutUser();
        }
        
        return instance;
    }

    public Orang getUser() {
        return user;
    }

    public void setUser(Orang user) {
        this.user = user;
    }
}
