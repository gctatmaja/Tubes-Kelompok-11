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
	
	public void addDokumentasi(){
		
	}
	private static int jmlMhs = 0;
	public void addMember(Mahasiswa m){
		Mahasiswa member= new Mahasiswa[5];
		this.member[jmlMhs]= m;
		this.jmlMhs++;
		
	}
	public void setJudul(String judul) {
        this.judul = judul;
    }
	public long getJudul() {
        return judul;
    }
	public void setDateAssist(String dateAssist) {
        this.dateAssist = dateAssist;
    }
	public long getDateAssist() {
        return dateAssist;
    }
	
}
