/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controler;

import Model.Application;
import Model.Orang;
import Model.Tubes;
import View.TambahMember;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author ASUS
 */
class ControllerTambahMember implements ActionListener{

     Application model;
    TambahMember view;
    Orang p;
    Tubes t;

    
    public ControllerTambahMember(Application model) {
        this.model = model;
        view = new TambahMember();
        view.setVisible(true);
        view.addListener(this);
         
    }
    
    public void setT(Tubes t) {
        this.t = t;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        if(o.equals(view.getOkTambahMember())){
            model.kurangTambahMemberTubes(2, t.getUuid(), view.getNimTambahMember().getText());
            ControllerMenuMhs x = new ControllerMenuMhs(model);
            view.dispose();
        }else if(o.equals(view.getBtnBack())){
            new ControllerLihatMember(model);
        }
    }
    
}
