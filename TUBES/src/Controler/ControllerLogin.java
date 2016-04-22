/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Model.Application;
import Model.Orang;
import View.Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author useR
 */
public class ControllerLogin implements ActionListener {
    Application model;
    Login view;
    Orang p;
    
    public ControllerLogin(Application model) {
        this.model = model;
        view = new Login();
        view.setVisible(true);
        view.addListener(this);
        p = null;
    }
   
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source.equals(view.getBtnOKLogin())){
            if (model.loginNimAction(view.getNim())) {
                JOptionPane.showMessageDialog(null, "Login berhasil");
                new ControllerMenuAsisten(model);
                view.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Login gagal");
                new ControllerLogin(model);
            }
            
        }
//        view.getBtnOKLogin();
//        new ControllerLogin(model);
//        view.dispose();
//        view.setNim(p.getNim());
    }
}
