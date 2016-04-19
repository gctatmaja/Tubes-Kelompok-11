/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import tubes.Asisten;
import tubes.Dokumentasi;
import tubes.Mahasiswa;
import tubes.Orang;
import tubes.Tubes;


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
    
    public void loginMenu() {
        System.out.println("Pilih menu anda");
        System.out.println("1. login via nim");
        System.out.println("2. add asisten");
        System.out.println("3. add mahasiswa");
    }
    
    private void loginNimAction(String nim) {
        if (this.currentUser == null) {
            Orang nextUser = Stream.concat(this.listAsisten.stream(), this.listMhs.stream())
                    .filter(o -> o.getNim().equalsIgnoreCase(nim)).findFirst().get();
            
            this.currentUser = nextUser;
        }
    }
    
    private void createAsistenAction(String nim, String nama) {
        Asisten newAsisten = new Asisten(nim, nama);
        this.listAsisten.add(newAsisten);
    }
    
    private void createMhsAction(String nim, String nama, String kelas) {
        Mahasiswa newMahasiswa = new Mahasiswa(nim, nama, kelas);
        this.listMhs.add(newMahasiswa);
    }
    
    private void addDocAction(UUID tubesUuid, String text) {
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
    
    private void addTubesMhsAction(UUID tubesUuid, String nim) {
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
    
    private void removeTubesMhsAction(UUID tubesUuid, String nim) {
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
    
    private void addTubesAction(String judul) {
        this.listTubes.add(new Tubes(judul));
    }
    
    private Mahasiswa findMhsByNim(String nim) {
        return this.listMhs.stream()
                       .filter(m -> m.getNim().equalsIgnoreCase(nim))
                       .findFirst().get();
    }
    
    private Asisten findAsistenByNim(String nim) {
        return this.listAsisten.stream()
                       .filter(m -> m.getNim().equalsIgnoreCase(nim))
                       .findFirst().get();
    }
    
    private void DisplayMemberTubes(Tubes tubes) {
        Collection<String> mahasiswa = tubes.getMember();
        
        if (mahasiswa.size() < 1) {
            System.out.println("tidak ada mahasiswa dalam tubes ini");
        } else {
            mahasiswa.forEach(m -> System.out.println("nim: "+m));
        }
    }
    
    private void kurangTambahMemberTubes(int action, UUID tubesUuid, Scanner reader) {
        switch(action) {
            case 1:
                System.out.println("masukkan nim mhs yang ingin anda keluarkan: ");
                Mahasiswa mahasiswa = this.findMhsByNim(reader.next());
                if (mahasiswa == null) {
                    System.out.println("mahasiswa tidak ditemukan");
                } else {
                    this.removeTubesMhsAction(tubesUuid, mahasiswa.getNim());
                }
                break;
                
            case 2:
                System.out.println("masukkan nim mhs yang ingin anda tambahkan: ");
                Mahasiswa mahasiswatambah = this.findMhsByNim(reader.next());
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
                                   this.kurangTambahMemberTubes(inputInt, tubes.getUuid(), reader);   
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