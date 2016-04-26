/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controler;

import Model.Application;
import Model.Orang;
import Model.OutUser;
import View.MenuMahasiswa;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author ASUS
 */
class ControllerMenuMhs implements ActionListener{
    Application model;
    MenuMahasiswa view;
    Orang p;
    
    public ControllerMenuMhs(Application model) {
         this.model = model;
         p = OutUser.getSingleton().getUser();
        view = new MenuMahasiswa();
        view.setVisible(true);
        view.addListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        if(o.equals(view.getBtnPilihTubes())){
            ControllerListTubes x = new ControllerListTubes(model);
            x.setP(p);
            view.dispose();
        }else if(o.equals(view.getBtnLogoutMhs())){
            new ControllerMainMenu(model);
            OutUser.getSingleton().setUser(null);
            view.dispose();
        }else if (o.equals(view.getBtnMasukDoc())){
            ControllerDokumentasi x =new ControllerDokumentasi(model);
            view.dispose();    
        }
    }
    
}
