/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controler;

import Model.Application;
import Model.Orang;
import View.LoginAsisten;
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
    
    public Orang getP() {
        return p;
    }

    public void setP(Orang p) {
        this.p = p;
    }
    
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
           ControllerListTubes x = new ControllerListTubes(model);
           x.setP(p);
            view.dispose();
        }else if(o.equals(view.getBtnLogout())){
            new ControllerMainMenu(model);
            model.setCurrentUserNull();
            view.dispose();
        }else if (o.equals(view.getBtnTambahTubes())){
            ControllerAddTubes x = new ControllerAddTubes(model);
            x.setP(p);
            view.dispose();    
        }
    }
    
}
