/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author useR
 */
public class MainMenu extends javax.swing.JFrame {

    public MainMenu() {
        initComponents();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAddMahasiswa = new javax.swing.JButton();
        btnAddAsisten = new javax.swing.JButton();
        btnLoginMhs = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnLoginAsisten = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnAddMahasiswa.setText("AddMahasiswa");

        btnAddAsisten.setText("AddAsisten ");

        btnLoginMhs.setText("Log In Mhs");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Main Menu");

        btnLoginAsisten.setText("Log In Asisten");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(161, 161, 161)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnAddMahasiswa, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                        .addComponent(btnLoginMhs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAddAsisten, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLoginAsisten, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(111, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addGap(46, 46, 46)
                .addComponent(btnAddAsisten)
                .addGap(18, 18, 18)
                .addComponent(btnAddMahasiswa)
                .addGap(18, 18, 18)
                .addComponent(btnLoginMhs)
                .addGap(18, 18, 18)
                .addComponent(btnLoginAsisten)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddAsisten;
    private javax.swing.JButton btnAddMahasiswa;
    private javax.swing.JButton btnLoginAsisten;
    private javax.swing.JButton btnLoginMhs;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

    public JButton getBtnAddAsisten() {
        return btnAddAsisten;
    }

    public JButton getBtnAddMahasiswa() {
        return btnAddMahasiswa;
    }

    public JButton getBtnLoginMhs() {
        return btnLoginMhs;
    }  
    public JButton getBtnLoginAsisten() {
        return btnLoginAsisten;
    }
    
    public void addListener(ActionListener e) {
        btnAddAsisten.addActionListener(e);
        btnAddMahasiswa.addActionListener(e);
        btnLoginMhs.addActionListener(e);
        btnLoginAsisten.addActionListener(e);
    }
}


