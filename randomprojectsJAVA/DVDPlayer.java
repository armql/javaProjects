public class DVDPlayer {
	private String nrSerik;
	private String marka;
	private boolean eshteHD;

	public DVDPlayer(String nrSerik,String marka,boolean eshteHD) {
		this.nrSerik=nrSerik;
		this.marka=marka;
		this.eshteHD=eshteHD;
	}

	public String getNrSerik() {
		return nrSerik;
	}	

	public String getMarka() {
		return marka;
	}public void setMarka(String marka) {
		this.marka=marka;
	}

	public boolean getEshteHD() {
		return eshteHD;
	}public void setEshteHD(boolean eshteHD){
		this.eshteHD=eshteHD;
	}

	public String toString() {
	return nrSerik + " : " + marka +
	" - " + (eshteHD? "Eshte HD" : "Nuk eshte HD");
	}

	public boolean equals(Object o) {
		if(o instanceof DVDPlayer) {
			DVDPlayer dvd =(DVDPlayer)o;
			return dvd.getNrSerik().equals(nrSerik);
		}else{
			return false;
		}
	}

}