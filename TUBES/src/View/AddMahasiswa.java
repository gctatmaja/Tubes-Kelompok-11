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
        BtnBack = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Tambah Mahasiswa");

        FormNimMahasiswa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FormNimMahasiswaActionPerformed(evt);
            }
        });

        BtnOKAddMahasiswa.setText("OK");

        BtnBack.setText("Back");

        jLabel2.setText("Masukkan NIM");

        jLabel3.setText("Masukkan Nama");

        jLabel4.setText("Masukkan Kelas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BtnBack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnOKAddMahasiswa))
                    .addComponent(FormNimMahasiswa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                    .addComponent(FormNamaMahasiswa, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(FormKelasMahasiswa, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(0, 78, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(118, 118, 118))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel1)
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FormNimMahasiswa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FormNamaMahasiswa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FormKelasMahasiswa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnBack)
                    .addComponent(BtnOKAddMahasiswa))
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FormNimMahasiswaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FormNimMahasiswaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FormNimMahasiswaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnBack;
    private javax.swing.JButton BtnOKAddMahasiswa;
    private javax.swing.JTextField FormKelasMahasiswa;
    private javax.swing.JTextField FormNamaMahasiswa;
    private javax.swing.JTextField FormNimMahasiswa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
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

    public JButton getBtnBack() {
        return BtnBack;
    }
    
    public void addListener(ActionListener e){
        BtnOKAddMahasiswa.addActionListener(e);
        FormNimMahasiswa.addActionListener(e);
        FormNamaMahasiswa.addActionListener(e);
        FormKelasMahasiswa.addActionListener(e);
        BtnBack.addActionListener(e);
    }

}
