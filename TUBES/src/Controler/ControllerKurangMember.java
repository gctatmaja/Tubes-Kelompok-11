/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controler;

import Model.Application;
import Model.Orang;
import Model.Tubes;
import View.KurangMember;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author ASUS
 */
class ControllerKurangMember implements ActionListener{
    Application model;
    KurangMember view;
    Orang p;
    Tubes t;

    public void setP(Orang p) {
        this.p = p;
    }
    
    public ControllerKurangMember (Application model) {
        this.model = model;
        view = new KurangMember();
        view.setVisible(true);
        view.addListener (this);
    }
    public void setT(Tubes t) {
        this.t = t;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         Object o = e.getSource();
        if(o.equals(view.getOkKurangiMember())){
            model.kurangTambahMemberTubes(1, t.getUuid(), view.getNIMKurangiMember().getText());
            ControllerMenuMhs x = new ControllerMenuMhs(model);
            view.dispose();
        }else if (o.equals(view.getBtnBack())){
            new ControllerLihatMember(model);
            view.dispose();
        }
    }
    
}
