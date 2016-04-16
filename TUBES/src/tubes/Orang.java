/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes;

/**
 *
 * @author useR
 */

public abstract class Orang {
    private String nim;
    private String nama;
    private String role;

    public Orang(String nim, String nama, String role) {
        this.nim = nim;
        this.nama = nama;
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}
