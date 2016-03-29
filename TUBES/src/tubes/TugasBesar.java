package tubes;

/**
 *
 * @author ASUS
 */
class TugasBesar {
    private Dokumentasi[] dokumentasi;
	private Mahasiswa[] member;
	private String judul;
	private String dateAssist;

    TugasBesar(String judul) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	
	public void addDokumentasi(){
		
	}
	private static int jmlMhs = 0;
	public void addMember(Mahasiswa m){
		Mahasiswa[] member = new Mahasiswa[5];
		this.member[jmlMhs]= m;
		this.jmlMhs++;
		
	}
	public void setJudul(String judul) {
        this.judul = judul;
    }
	public String getJudul() {
        return judul;
    }
	public void setDateAssist(String dateAssist) {
        this.dateAssist = dateAssist;
    }
	public String getDateAssist() {
        return dateAssist;
    }
	
}
