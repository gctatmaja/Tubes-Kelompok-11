/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controler;

import Model.Application;
import Model.Orang;
import View.Login;
import View.MenuAsisten;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author ASUS
 */
class ControllerMenuAsisten implements ActionListener{
    Application model;
    MenuAsisten view;
    Orang p;
    public ControllerMenuAsisten(Application model) {
         this.model = model;
        view = new MenuAsisten();
        view.setVisible(true);
        view.addListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        if(o.equals(view.getBtnLihatDaftarTubes())){
            new ControllerListTubes(model);
            view.dispose();
        }else if(o.equals(view.getBtnLogout())){
            new ControllerLogin(model);
            model.setCurrentUserNull();
            view.dispose();
        }else if (o.equals(view.getBtnTambahTubes())){
            new ControllerAddTubes(model);
            view.dispose();    
        }
    }
    
}
