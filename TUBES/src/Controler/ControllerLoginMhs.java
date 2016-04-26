/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controler;

import Model.Application;
import Model.Orang;
import Model.OutUser;
import View.LoginMhs;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
class ControllerLoginMhs implements ActionListener{
    Application model;
    LoginMhs view;
    Orang p;
    public ControllerLoginMhs(Application model) {
       this.model = model;
        view = new LoginMhs();
        view.setVisible(true);
        view.addListener(this);
        p = null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         Object source = e.getSource();
        if (source.equals(view.getBtnOKLoginMhs())){
            if (model.loginGuiAction(view.getNim())) {
                JOptionPane.showMessageDialog(null, "Login berhasil");
                OutUser.getSingleton().setUser(model.findMhsByNim(view.getNim()));
                
                view.dispose(); 
            }else {
                JOptionPane.showMessageDialog(null, "Login gagal");
                new ControllerLoginMhs(model);
            }
            
        } else if (source.equals(view.getBtnBack())){
            new ControllerMainMenu(model);
            view.dispose();
            }
    }
}

