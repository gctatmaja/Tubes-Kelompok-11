/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author useR
 */
public class AddAsisten extends javax.swing.JFrame {

    /**
     * Creates new form AddAsisten
     */
    public AddAsisten() {
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

        BtnOKAddAsisten = new javax.swing.JButton();
        FormNimAsisten = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        FormNamaAsisten = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BtnOKAddAsisten.setText("OK");
        BtnOKAddAsisten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnOKAddAsistenActionPerformed(evt);
            }
        });

        FormNimAsisten.setText("Masukkan NIM");

        jLabel2.setText("AddAsisten");

        FormNamaAsisten.setText("Masukkan Nama");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(BtnOKAddAsisten))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(FormNimAsisten)
                            .addComponent(FormNamaAsisten, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(jLabel2)))
                .addContainerGap(154, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel2)
                .addGap(53, 53, 53)
                .addComponent(FormNimAsisten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(FormNamaAsisten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(BtnOKAddAsisten)
                .addContainerGap(66, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnOKAddAsistenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnOKAddAsistenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnOKAddAsistenActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnOKAddAsisten;
    private javax.swing.JTextField FormNamaAsisten;
    private javax.swing.JTextField FormNimAsisten;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables

    public JTextField getFormNamaAsisten() {
        return FormNamaAsisten;
    }

    public JTextField getFormNimAisten() {
        return FormNimAsisten;
    }

    public JButton getOkAddAsisten() {
        return BtnOKAddAsisten;
    }
    
    public String getNim(){
        return FormNimAsisten.getText();
    }
    
    public void setNim(String nim){
        FormNimAsisten.setText(nim);
    }
    
    public String getNama(){
        return FormNamaAsisten.getText();
    }
    
    public void setNama(String nim){
        FormNamaAsisten.setText(nim);
    }
    
    public void addListener(ActionListener e){
        BtnOKAddAsisten.addActionListener(e);
//        FormNimAsisten.addActionListener(e);
//        FormNamaAsisten.addActionListener(e);
    }

}