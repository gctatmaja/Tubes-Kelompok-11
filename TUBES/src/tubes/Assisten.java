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
public final class Assisten 
{
    private String nama;
    private long nim;
    private TugasBesar[] tugasBesar ;
    private int nTugasBesar ;

    Assisten(String ahmad, String lakilaki, int i, int i0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void createTugasBesar(String judul)
    {
 	TugasBesar tubes = new TugasBesar(judul);
 	if(nTugasBesar<tugasBesar.length)
        {
            tugasBesar[nTugasBesar] = tubes;
            nTugasBesar++;
            System.out.println("Accepted"); 
 	}
 		
        else
        {
            System.out.println();
            System.out.println("full array");
 	}
    }
    
    public Assisten(String nama, long nim)
    {
        this.setNama(nama);
        this.setNim(nim);
    }


    public String getNama() {
        return nama;
    }


    public void setNama(String nama) {
        this.nama = nama;
    }


    public long getNim() {
        return nim;
    }

    public void setNim(long nim) {
        this.nim = nim;
    } 

    String getId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Object getTugasBesar(int p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    int getmaxTugasBesar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void tambahMahasiswa(String string, String nama, String jeniskel, int nim) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void setId(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void createTugasBesar(String aplikasi_inventaris, int i, int i0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void setPass(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}


















