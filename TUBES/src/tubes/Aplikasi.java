/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author useR
 */
public class Aplikasi {
     private ArrayList<Mahasiswa> listMahasiswa;
     private ArrayList<Assisten> listAssisten;
     
     public Aplikasi(){
        listMahasiswa = new ArrayList();
        listAssisten = new ArrayList();
    }
    
    public void addAssisten(String namaAssisten, long nimAsisten){
        listDosen.add(new Dosen(namaAssisten,nimAssisten));
    }
    
    public void addMahasiswa(String namaMhs,long nimMhs,String kelas ){
        listMahasiswa.add(new Mahasiswa(namaMhs,nimMhs,kelas));
    }
    
    public Mahasiswa getMahasiswa(long nimMhs){
        return listMahasiswa.get(nimMhs);
    }
    
    public void delMahasiswa(String namaMhs){
        listMahasiswa.remove(namaMhs);
    }
    
    public void saveFileAsisten(){
        try(FileOutputStream fouts = new FileOutputStream("Asisten.txt")){
            ObjectOutputStream oouts = new ObjectOutputStream(fouts);
            oouts.writeObject(listAssisten);
            outs.flush();
        }catch(Exception e){
            
        }
    }
    
    public void readFileAssisten(){
        try(ObjectInputStream oist = new ObjectInputStream(new FileInputStream("Assisten.txt"))){
            listAssisten = (ArrayList<Assisten>) oist.readObject();
            oist.close();
        }catch(Exception e){
            
        }
    }
    
    public void saveFileMahasiswa(){
        try(FileOutputStream fouts = new FileOutputStream("Mahasiswa.txt")){
            ObjectOutputStream oouts = new ObjectOutputStream(fouts);
            oouts.writeObject(listMahasiswa);
            oouts.flush();
        }catch(Exception e){
            
        }
    }
    
    public void readFileMahasiswa(){
        try(ObjectInputStream oist = new ObjectInputStream(new FileInputStream("Mahasiswa.txt"))){
            listMahasiswa = (ArrayList<Mahasiswa>) oist.readObject();
            oist.close();
        }catch(Exception e){
            
        }
    }
    
    public ArrayList getListAsisten(){
        return listAssisten;
    }
    
    public ArrayList getListMahasiswa(){
        return listMahasiswa;
    }
    
   
}