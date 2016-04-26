/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controler;

import Model.Application;
import Model.Mahasiswa;
import Model.Orang;
import Model.Tubes;
import View.LihatDaftarTubes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author ASUS
 */
class ControllerListTubes implements ActionListener{

    Application model;
    LihatDaftarTubes view;
    Orang p;

    public void setP(Orang p) {
        this.p = p;
    }
    
    public ControllerListTubes(Application model) {
        this.model = model;
        view = new LihatDaftarTubes();
        view.setListTubes(this.model.getListTubes());
        view.setVisible(true);
        view.addListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        if(o.equals(view.getOkLihatDaftarTubes())){
            Tubes t = model.findTubesByJudul((String) view.getListTubes().getSelectedValue());
            ControllerTambahMember c = new ControllerTambahMember(model);
            c.setT(t);
            view.dispose();
        }else if (o.equals(view.getBtnBack())){
            new ControllerMenuMhs(model);
            view.dispose();
        }
    }
    
}
