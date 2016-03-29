/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes;

/**
 *
 * @author ALHAMDU SYUKRI
 */
public class Aplikasi {
     private ArrayList<Mahasiswa> listMahasiswa;
     private ArrayList<Asisten> listAsisten;
     
     public Aplication(){
        listMahasiswa = new ArrayList();
        listAsisten = new ArrayList();
    }
    
    public void addAsisten(String namaAsisten, long nimAsisten){
        listDosen.add(new Dosen(namaAsisten,nimAsisten));
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
            oouts.writeObject(listAsisten);
            oouts.flush();
        }catch(Exception e){
            
        }
    }
    
    public void readFileAsisten(){
        try(ObjectInputStream oist = new ObjectInputStream(new FileInputStream("Asisten.txt"))){
            listAsisten = (ArrayList<Asisten>) oist.readObject();
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
        return listAsisten;
    }
    
    public ArrayList getListMahasiswa(){
        return listMahasiswa;
    }
    
   
}
