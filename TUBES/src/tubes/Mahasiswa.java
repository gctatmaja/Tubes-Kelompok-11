package tubes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Budhi
 */
public class Mahasiswa {
    private String nama;
    private long nim;
    private String kelas;
    
    public Mahasiswa (String nama, long nim, String kelas){
        this.nama = nama;
        this.nim = nim;
        this.kelas = kelas;
    }
    
    public void setName(String nama){
        this.nama = nama;
    }
    
    public String getName(){
        return nama;
    }
    
    public void setNim(long nim){
        this.nim = nim;
    }
    
    public long getNim(){
        return nim;
    }
    
    public void setKelas(String kelas){
        this.kelas = kelas;
    }
    
    public String getKelas(){
        return kelas;
    }
}
