/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
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
    private Collection<Tubes> listTubes;
    private Orang currentUser;

    public Application() {
        this.listMhs = new ArrayList<>();
        this.listAsisten = new ArrayList<>();
        this.currentUser = null;
    }
    
    private Scanner reader = new Scanner(System.in);
    
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
                .stream()
                .map((Mahasiswa m) -> {
                    if (m.getNim().equalsIgnoreCase(nim)) {
                        m.setTubes(tubesUuid);
                    }
                    
                    return m;
                }).collect(Collectors.toList());
        
        this.listTubes = this.listTubes
                .stream()
                .map((Tubes t) -> {
                    if (t.getUuid().equals(tubesUuid)) {
                        t.addMember(nim);
                    }
                    
                    return t;
                }).collect(Collectors.toList());
                
    }
    
    private void removeTubesMhsAction(UUID tubesUuid, String nim) {
        this.listMhs = this.listMhs
                .stream()
                .map((Mahasiswa m) -> {
                    if (m.getNim().equalsIgnoreCase(nim)) {
                        m.setTubes(null);
                    }
                    
                    return m;
                }).collect(Collectors.toList());
        
        this.listTubes = this.listTubes
                .stream()
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
        
        mahasiswa.forEach(m -> System.out.println("nim: "+m));
    }
    
    private void kurangTambahMemberTubes(int action, UUID tubesUuid) {
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
    
    public void mainMenu() {
        while (true) {
            if (this.currentUser == null) {
                this.loginMenu();
                switch (reader.nextInt()) {
                    case 1:
                        System.out.println("masukkan nim anda:");
                        this.loginNimAction(reader.next());
                        break;
                    case 2:
                        System.out.println("masukkan nim asisten");
                        String nimAsisten = reader.next();
                        System.out.println("masukkan nama asisten");
                        String namaAsisten = reader.next();
                        this.createAsistenAction(nimAsisten, namaAsisten);
                        break;
                    case 3:
                        System.out.println("masukkan nim mahasiswa");
                        String nimMhs = reader.next();
                        System.out.println("masukkan nama mahasiswa");
                        String namaMhs = reader.next();
                        System.out.println("masukkan kelas mahasiswa");
                        String kelasMhs = reader.next();
                        this.createMhsAction(nimMhs, namaMhs, kelasMhs);
                        break;
                    default:
                        System.out.println("tolong pilih nomor 1 2 3");
                        break;
                }
            } else if (this.currentUser.getRole().equalsIgnoreCase("mahasiswa")) {
               Mahasiswa mhs = this.findMhsByNim(this.currentUser.getNim());
               if (mhs.getTubes() != null) {
                   System.out.println("silahkan masukkan dokumentasi:");
                   this.addDocAction(mhs.getTubes(), reader.next());
               } else {
                   System.out.println("silahkan pilih tubes");
                   Tubes[] arrTubes = (Tubes[]) this.listTubes.toArray();
                   if (arrTubes.length == 0) {
                       System.out.println("tidak ada tubes sekarang silahkan coba lagi kapan kapan");
                   } else {
                    for (int i = 0;i<arrTubes.length;i++) {
                        System.out.println(i+". "+arrTubes[i].getJudul());
                    }

                    System.out.println("masukkan nomor tubes");

                    try {
                        this.addTubesMhsAction(arrTubes[reader.nextInt()].getUuid(), mhs.getNim());
                    } catch (Exception e){
                        System.out.println("wowww inputan ente keknya bikin error");
                        continue;
                    }
                   }
               }
            } else if (this.currentUser.getRole().equalsIgnoreCase("asisten")) {
                Asisten ass = this.findAsistenByNim(this.currentUser.getNim());
                System.out.println("1. tambah tubes");
                System.out.println("2. lihat daftar tubes");
                if (reader.nextInt() == 1) {
                    System.out.println("masukkan judul tubes: ");
                    this.addTubesAction(reader.next());
                } else if (reader.nextInt() == 2) {
                    Tubes[] arrTubes = (Tubes[]) this.listTubes.toArray();
                    
                    if (arrTubes.length == 0) {
                        System.out.println("tidak ada tubes untuk dilihat");
                    } else {
                        for (int i = 0;i<arrTubes.length;i++) {
                            System.out.println(i+". "+arrTubes[i].getJudul());
                        }
                        System.out.println("pilih nomor judul untuk detail member:");
                        try {
                            Tubes tubes = arrTubes[reader.nextInt()];
                            this.DisplayMemberTubes(tubes);
                            System.out.println("pilih aksi: ");
                            System.out.println("1. kurangi member");
                            System.out.println("2. tambah member");
                            this.kurangTambahMemberTubes(reader.nextInt(), tubes.getUuid());
                        } catch (Exception e) {
                            System.out.println("wow inputan anda hampir bikin error");
                        }
                    }
                }
            }
        }
    }
   
}
