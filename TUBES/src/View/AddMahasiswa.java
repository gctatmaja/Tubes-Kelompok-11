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
public class AddMahasiswa extends javax.swing.JFrame {

    /**
     * Creates new form AddMahasiswa
     */
    public AddMahasiswa() {
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

        jLabel1 = new javax.swing.JLabel();
        FormNimMahasiswa = new javax.swing.JTextField();
        FormNamaMahasiswa = new javax.swing.JTextField();
        FormKelasMahasiswa = new javax.swing.JTextField();
        BtnOKAddMahasiswa = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("AddMahasiswa");

        FormNimMahasiswa.setText("Masukkan NIM");
        FormNimMahasiswa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FormNimMahasiswaActionPerformed(evt);
            }
        });

        FormNamaMahasiswa.setText("Masukkan Nama");

        FormKelasMahasiswa.setText("Masukkan Kelas");

        BtnOKAddMahasiswa.setText("OK");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(160, 160, 160))
            .addGroup(layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(FormNimMahasiswa, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FormNamaMahasiswa, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FormKelasMahasiswa, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(BtnOKAddMahasiswa)))
                .addGap(0, 149, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addComponent(FormNimMahasiswa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(FormNamaMahasiswa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(FormKelasMahasiswa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BtnOKAddMahasiswa)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FormNimMahasiswaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FormNimMahasiswaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FormNimMahasiswaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnOKAddMahasiswa;
    private javax.swing.JTextField FormKelasMahasiswa;
    private javax.swing.JTextField FormNamaMahasiswa;
    private javax.swing.JTextField FormNimMahasiswa;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

    public JTextField getFormKelasMahasiswa() {
        return FormKelasMahasiswa;
    }

    public JTextField getFormNamaMahasiswa() {
        return FormNamaMahasiswa;
    }

    public JTextField getFormNimMahasiswa() {
        return FormNimMahasiswa;
    }

    public JButton getOKAddMahasiswa() {
        return BtnOKAddMahasiswa;
    }
    
    public String getNim(){
        return FormNimMahasiswa.getText();
    }
    
    public void setNim(String nim){
        FormNimMahasiswa.setText(nim);
    }
    
    public String getKelas(){
        return FormKelasMahasiswa.getText();
    }
    
    public void setKelas(String nim){
        FormKelasMahasiswa.setText(nim);
    }
    
    public String getNama(){
        return FormNamaMahasiswa.getText();
    }
    
    public void setNama(String nim){
        FormNamaMahasiswa.setText(nim);
    }
    
    public void addListener(ActionListener e){
        BtnOKAddMahasiswa.addActionListener(e);
        FormNimMahasiswa.addActionListener(e);
        FormNamaMahasiswa.addActionListener(e);
        FormKelasMahasiswa.addActionListener(e);
    }

}
