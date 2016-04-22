/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controler;

import Model.Application;
import Model.Orang;
import View.AddTubes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
class ControllerAddTubes implements ActionListener{
    Application model;
    AddTubes view;
    Orang p;
    public ControllerAddTubes(Application model) {
        this.model = model;
        view = new AddTubes();
        view.setVisible(true);
        view.addListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        if(o.equals(view.getOkAddTubes())){
            model.addTubesAction(view.getFormJudulTubes().getText());
            JOptionPane.showMessageDialog(null, "Add Judul Tubes berhasil");
            new ControllerMenuAsisten(model);
            view.dispose();  
        }
    }
    
}
