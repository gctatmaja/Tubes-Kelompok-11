/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Model.Application;
import View.AddAsisten;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
    
/**
 *
 * @author useR
 */
public class ControllerAddAsisten implements ActionListener {
    Application model;
    AddAsisten view;
    
    ControllerAddAsisten(Application model) {
       this.model = model;
       view = new AddAsisten();
       view.setVisible(true);
       view.addListener((ActionListener) this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
     
    }
    
}
