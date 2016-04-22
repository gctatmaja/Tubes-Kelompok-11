/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Model.Application;
import View.AddMahasiswa;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author useR
 */
public class ControllerAddMahasiswa implements ActionListener {
    Application model;
    AddMahasiswa view;
    
    ControllerAddMahasiswa(Application model) {
       this.model = model;
       view = new AddMahasiswa();
       view.setVisible(true);
       view.addListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object o = ae.getSource();
        if (o.equals(view.getOKAddMahasiswa())){
            model.createMhsAction(view.getNim(), view.getNama(), view.getKelas());
            JOptionPane.showMessageDialog(null, "Create Mahasiswa Berhasil");
            new ControllerMainMenu(model);
            view.dispose();
        }
    }
    
}
