package tubes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

/**
 *
 * @author ASUS
 */
 
public class Tubes {
    private UUID uuid;
    private String judul;
    private Collection<String> member;
    private Collection<Dokumentasi> dokumentasi;

    public Tubes(String judul) {
        this.judul = judul;
        member = new ArrayList<>();
        dokumentasi = new ArrayList<>();
        this.uuid = UUID.randomUUID();
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getJudul() {
        return judul;
    }

    public Collection<String> getMember() {
        return member;
    }

    public Collection<Dokumentasi> getDokumentasi() {
        return dokumentasi;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }
    
    public void addMember(String m) {
        this.member.add(m);
    }
    
    public void addDokumentasi(Dokumentasi d) {
        this.dokumentasi.add(d);
    }
    
    public void removeDokumentasi(Dokumentasi d) {
        this.dokumentasi.remove(d);
    }
    
    public void removeMember(String m) {
        this.member.remove(m);
    }
}
