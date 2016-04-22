/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Model.Application;
import View.MainMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author useR
 */
public class ControllerMainMenu implements ActionListener {
    Application model;
    MainMenu view;
    
    public ControllerMainMenu (Application model){
        this.model = model;
        view = new MainMenu();
        view.setVisible(true);
        view.addListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
    Object source = ae.getSource();
        if (source.equals(view.getBtnAddAsisten())){
            new ControllerAddAsisten(model);
            view.dispose();
        } else if (source.equals(view.getBtnAddMahasiswa())){
            new ControllerAddMahasiswa(model);
            view.dispose();
        } else if (source.equals(view.getBtnLogin())){
            new ControllerLogin(model);
            view.dispose();
        } else if (source.equals(view.getBtnLoginMhs())){
            new ControllerLoginMhs(model);
            view.dispose();
        }
    }
}
