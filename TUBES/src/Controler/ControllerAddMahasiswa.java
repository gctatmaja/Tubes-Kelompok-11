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
            if (!view.getNim().isEmpty() && !view.getNama().isEmpty() && !view.getKelas().isEmpty()) {
                model.createMhsAction(view.getNim(), view.getNama(), view.getKelas());
                JOptionPane.showMessageDialog(null, "Create Mahasiswa Berhasil");
                new ControllerMainMenu(model);
                view.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Inputan harus terisi semua");
            }
        }else if (o.equals(view.getBtnBack())){
            new ControllerMainMenu(model);
            view.dispose();
        }else if(o.equals(view.getOKAddMahasiswa())){
            model.createMhsAction(null, null, null);
            JOptionPane.showMessageDialog(null, "Create Mahasiswa Gagal");
            view.dispose();
        }else if(o.equals(view.getOKAddMahasiswa())){
            model.createMhsAction(null, view.getNama(), view.getKelas());
            JOptionPane.showMessageDialog(null, "Nim belum terisi");
            view.dispose();
        }else if(o.equals(view.getOKAddMahasiswa())){
            model.createMhsAction(view.getNim(), null, view.getKelas());
            JOptionPane.showMessageDialog(null, "Nama belum terisi");
            view.dispose();
        }else if(o.equals(view.getOKAddMahasiswa())){
            model.createMhsAction(view.getNim(), view.getNama(), null);
            JOptionPane.showMessageDialog(null, "Kelas belum terisi");
            view.dispose();
        }

    }
    
}
