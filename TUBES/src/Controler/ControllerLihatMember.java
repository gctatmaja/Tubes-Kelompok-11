/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controler;

import Model.Application;
import Model.Orang;
import View.LihatMember;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author ASUS
 */
class ControllerLihatMember implements ActionListener{
    
    Application model;
    LihatMember view;
    Orang p;

     public void setP(Orang p) {
        this.p = p;
    }
     
    public ControllerLihatMember(Application model) {
         this.model = model;
        view = new LihatMember();
        view.setVisible(true);
        view.addListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        if(o.equals(view.getTambahMember())){
            new ControllerTambahMember(model);
            view.dispose();
        }else if(o.equals(view.getKurangiMember())){
            new ControllerKurangMember(model);
            view.dispose();
        }else if (o.equals(view.getBtnBack())){
            new ControllerMenuMhs(model);
            view.dispose();
        }
    }
}
