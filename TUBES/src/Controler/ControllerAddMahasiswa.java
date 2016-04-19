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
    
    }
    
}
