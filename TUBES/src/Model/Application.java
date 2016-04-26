/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import Model.Asisten;
import Model.Dokumentasi;
import Model.Mahasiswa;
import Model.Orang;
import Model.Tubes;


/**
 *
 * @author useR
 */


public class Application {
    private Collection<Mahasiswa> listMhs;
    private Collection<Asisten> listAsisten;
    private List<Tubes> listTubes;
    private Orang currentUser;

    public Application() {
        this.listMhs = new ArrayList<>();
        this.listAsisten = new ArrayList<>();
        this.listTubes = new ArrayList<>();
        this.currentUser = null;
    }
    
    public Collection<Tubes> getListTubes() {
        return this.listTubes;
    }
   
    
    public Orang getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(Orang currentUser) {
        this.currentUser = currentUser;
    }
    
    public void setCurrentUserNull() {
        this.currentUser = null;
    }
    public void loginMenu() {
        System.out.println("Pilih menu anda");
        System.out.println("1. login via nim");
        System.out.println("2. add asisten");
        System.out.println("3. add mahasiswa");
    }
    
    public boolean loginGuiAction(String nim) {
       return Stream.concat(this.listAsisten.stream(), this.listMhs.stream())
               .filter(o -> o.getNim().equalsIgnoreCase(nim)).findFirst().isPresent();
    }
    
    public boolean loginNimAction(String nim) {
         if (this.currentUser==null) {
            currentUser = findAsistenByNim(nim);
            return true;
        } else {
            return false;
        }
//        if (this.currentUser == null) {
//            Orang nextUser = Stream.concat(this.listAsisten.stream(), this.listMhs.stream())
//                    .filter(o -> o.getNim().equalsIgnoreCase(nim)).findFirst().get();
//            
//            this.currentUser = nextUser;
//        }
      
    }
    
    public void createAsistenAction(String nim, String nama) {
        Asisten newAsisten = new Asisten(nim, nama);
        this.listAsisten.add(newAsisten);
    }
    
    public void createMhsAction(String nim, String nama, String kelas) {
        Mahasiswa newMahasiswa = new Mahasiswa(nim, nama, kelas);
       
        this.listMhs.add(newMahasiswa);
    }
    
    public void addDocAction(UUID tubesUuid, String text) {
        this.listTubes = this.listTubes
                .stream()
                .map((Tubes t) -> {
                    if (t.getUuid().equals(tubesUuid)){
                        t.addDokumentasi(new Dokumentasi(text));
                    }
                    
                    return t;
                })
                .collect(Collectors.toList());
    }
    
    public void addTubesMhsAction(UUID tubesUuid, String nim) {
        this.listMhs = this.listMhs
                .parallelStream()
                .map((Mahasiswa m) -> {
                    if (m.getNim().equalsIgnoreCase(nim)) {
                        m.setTubes(tubesUuid);
                    }
                    
                    return m;
                }).collect(Collectors.toList());
        
        this.listTubes = this.listTubes
                .parallelStream()
                .map((Tubes t) -> {
                    if (t.getUuid().equals(tubesUuid)) {
                        t.addMember(nim);
                    }
                    
                    return t;
                }).collect(Collectors.toList());
                
    }
    
    public void removeTubesMhsAction(UUID tubesUuid, String nim) {
        this.listMhs = this.listMhs
                .parallelStream()
                .map((Mahasiswa m) -> {
                    if (m.getNim().equalsIgnoreCase(nim)) {
                        m.setTubes(null);
                    }
                    
                    return m;
                }).collect(Collectors.toList());
        
        this.listTubes = this.listTubes
                .parallelStream()
                .map((Tubes t) -> {
                    if (t.getUuid().equals(tubesUuid)) {
                        t.removeMember(nim);
                    }
                    
                    return t;
                }).collect(Collectors.toList());
                
    }
    
    public void addTubesAction(String judul) {
        this.listTubes.add(new Tubes(judul));
    }
    
    public Mahasiswa findMhsByNim(String nim) {
        return this.listMhs.stream()
                       .filter(m -> m.getNim().equalsIgnoreCase(nim))
                       .findFirst().get();
    }
    public Tubes findTubesByJudul(String judul) {
        Tubes x = null;
        for (Tubes temp : listTubes){
            if (temp.getJudul().equals(judul)){
                x= temp;
            }
        }
        return x;
    }
    
    public Asisten findAsistenByNim(String nim) {
        return this.listAsisten.stream()
                       .filter(m -> m.getNim().equalsIgnoreCase(nim))
                       .findFirst().get();
    }
    
    public void DisplayMemberTubes(Tubes tubes) {
        Collection<String> mahasiswa = tubes.getMember();
        
        if (mahasiswa.size() < 1) {
            System.out.println("tidak ada mahasiswa dalam tubes ini");
        } else {
            mahasiswa.forEach(m -> System.out.println("nim: "+m));
        }
    }
    
    public void kurangTambahMemberTubes(int action, UUID tubesUuid, String nim) {
        switch(action) {
            case 1:
                System.out.println("masukkan nim mhs yang ingin anda keluarkan: ");
                Mahasiswa mahasiswa = this.findMhsByNim(nim);
                if (mahasiswa == null) {
                    System.out.println("mahasiswa tidak ditemukan");
                } else {
                    this.removeTubesMhsAction(tubesUuid, mahasiswa.getNim());
                }
                break;
                
            case 2:
                System.out.println("masukkan nim mhs yang ingin anda tambahkan: ");
                Mahasiswa mahasiswatambah = this.findMhsByNim(nim);
                if (mahasiswatambah == null) {
                    System.out.println("mahasiswa tidak ditemukan");
                } else {
                    this.addTubesMhsAction(tubesUuid, mahasiswatambah.getNim());
                }
                break;
                
            default:
                break;
        }
    }
    
    public void logout() {
        this.currentUser = null;
    }
    
    public void mainMenu() {
        int inputInt;
        String inputStr;
        while (true) {
            inputInt = 0;
            inputStr = "";
            Scanner reader = new Scanner(System.in);
            if (this.currentUser == null) {
                this.loginMenu();
                try {
                switch (reader.nextInt()) {
                    case 1:
                        System.out.println("masukkan nim anda:");
                        inputStr = reader.next();
                        this.loginNimAction(inputStr);
                        break;
                    case 2:
                        System.out.println("masukkan nim asisten");
                        inputStr = reader.next();
                        String nimAsisten = inputStr;
                        System.out.println("masukkan nama asisten");
                        inputStr = reader.next();
                        String namaAsisten = inputStr;
                        this.createAsistenAction(nimAsisten, namaAsisten);
                        break;
                    case 3:
                        System.out.println("masukkan nim mahasiswa");
                        inputStr = reader.next();
                        String nimMhs = inputStr;
                        System.out.println("masukkan nama mahasiswa");
                        inputStr = reader.next();
                        String namaMhs = inputStr;
                        System.out.println("masukkan kelas mahasiswa");
                        inputStr = reader.next();
                        String kelasMhs = inputStr;
                        this.createMhsAction(nimMhs, namaMhs, kelasMhs);
                        break;
                    default:
                        System.out.println("tolong pilih nomor 1 2 3");
                        break;
                }
                } catch (Exception e) {
                    continue;
                }
            } else if (this.currentUser.getRole().equalsIgnoreCase("mahasiswa")) {
               Mahasiswa mhs = this.findMhsByNim(this.currentUser.getNim());
               System.out.println("1. masukkan dokumetasi");
               System.out.println("2. pilih tubes");
               System.out.println("3. logout");
               try {
                   inputInt = reader.nextInt();
                   switch(inputInt) {
                       case 1:
                           if (mhs.getTubes() == null) {
                               System.out.println("oooops anda tidak punya tubes");
                           } else {
                               System.out.println("silahkan masukkan dokumentasi:");
                               inputStr = reader.next();
                               this.addDocAction(mhs.getTubes(), inputStr);   
                           }
                           break;
                       case 2:
                           if (mhs.getTubes() != null) {
                               System.out.println("anda sudah punya tubes silahkan kontak asisten untuk ganti tubes");
                           } else {
                               System.out.println("silahkan pilih tubes");
                                if (this.listTubes.size() < 1) {
                                    System.out.println("tidak ada tubes sekarang silahkan coba lagi kapan kapan");
                                } else {
                                 for (int i = 0;i<this.listTubes.size();i++) {
                                     System.out.println(i+". "+this.listTubes.get(i).getJudul());
                                 }
                                  
                                 try {
                                     System.out.println("masukkan nomor tubes");
                                     inputInt = reader.nextInt();
                                     this.addTubesMhsAction(this.listTubes.get(inputInt).getUuid(), mhs.getNim());
                                 } catch (Exception e){
                                     System.out.println("wowww inputan ente keknya bikin error");
                                     break;
                                 }
                                }
                           }System.out.println("masukkan nomor tubes");
                                 inputInt = reader.nextInt();
                           break;
                       case 3:
                           this.logout();
                           break;
                   }
               } catch (Exception e) {
                   System.out.println("inputan terakhir anda tidak dimengerti");
                   continue;
               }
            } else if (this.currentUser.getRole().equalsIgnoreCase("asisten")) {
                Asisten ass = this.findAsistenByNim(this.currentUser.getNim());
                System.out.println("1. tambah tubes");
                System.out.println("2. lihat daftar tubes");
                System.out.println("3. Logout");
                try {
                    inputInt = reader.nextInt();
                    switch (inputInt) {
                        case 1 :
                            System.out.println("masukkan judul tubes: ");
                            inputStr = reader.next();
                            this.addTubesAction(inputStr);
                            break;
                        case 2 :
                            if (this.listTubes.size() <1){
                                System.out.println("tidak ada tubes untuk dilihat");
                            } else {
                                for (int i = 0;i<this.listTubes.size();i++) {
                                    System.out.println(i +". "+this.listTubes.get(i).getJudul());
                                }
                                try {
                                   System.out.println("pilih nomor judul untuk lihat member");
                                   inputInt = reader.nextInt();
                                   Tubes tubes = this.listTubes.get(inputInt);
                                   this.DisplayMemberTubes(tubes);
                                   System.out.println("pilih aksi: ");
                                   System.out.println("1. kurangi member");
                                   System.out.println("2. tambah member");
                                   inputInt = reader.nextInt();
                                   this.kurangTambahMemberTubes(inputInt, tubes.getUuid(), inputStr);  
                                } catch (Exception e) {
                                    System.out.println("Inputan ada bikin eror "+e.getMessage());
                                    continue;
                                }
                            }
                            break;
                        case 3:
                            this.logout();
                            break;
                    }
                } catch (Exception e) {
                    System.out.println("inputan terakhir anda tidak dimengerti");
                    continue;
                }
            }
        }
    }
   
}