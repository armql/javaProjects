public class Basketbollisti {
	private String emriBasketbollistit; //readonly
	private int numriBasketbollistit; 
	private String pozicioniBasketbollistit; 
	private int piketeKutive;
	private boolean luanLojen; 
    private int moshaBasketbollistit;

	public Basketbollisti (String emriBasketbollistit,int numriBasketbollistit,String pozicioniBasketbollistit,int moshaBasketbollistit,int piketeKutive,boolean luan) {
		this.emriBasketbollistit=emriBasketbollistit;
		this.numriBasketbollistit=numriBasketbollistit;
		this.pozicioniBasketbollistit=pozicioniBasketbollistit;
        this.moshaBasketbollistit=moshaBasketbollistit;
		this.piketeKutive=piketeKutive;
		luanLojen=luan;

	}

	public String getEmriBasketbollistit() {
		return emriBasketbollistit;
	}

	public int getNumriBasketbollistit(){
		return numriBasketbollistit;
	}public void setNumriBasketbollistit(int numriBasketbollistit) {
		this.numriBasketbollistit=numriBasketbollistit;
	}

	public String getPozicioniBasketbollistit() {
		return pozicioniBasketbollistit;
	}public void setPozicioniBasketbollistit(String pozicioniBasketbollistit) {
		this.pozicioniBasketbollistit=pozicioniBasketbollistit;
	}

	public int getPiketEKutive() {
		return piketeKutive;
	}public void setPiketEKutive(int piketeKutive) {
		this.piketeKutive=piketeKutive;
	}

	public boolean getLuanLojen() {
		return luanLojen;
	}public void setLuanLojen(boolean luan) {
		luanLojen=luan;
	}
    
    public int getmoshaBasketbollistit() {
        return moshaBasketbollistit;
    }public void setMoshaBasketbollistit (int moshaBasketbollistit) {
        this.moshaBasketbollistit=moshaBasketbollistit;
    }


	
	public String toString() {
		return "Emri Basketbollistit eshte: " + emriBasketbollistit + " me numer:" 
        + numriBasketbollistit + " ka pozicionin si " + pozicioniBasketbollistit
        + ",Mosha " + moshaBasketbollistit + ". Lojtari: " + (luanLojen? "luan lojen.\n" : "nuk luan lojen.\n");    
    }


	public String toStringFORCALLS() {
		return "Emri Basketbollistit eshte: " + emriBasketbollistit + " me numer:" 
        + numriBasketbollistit + " ka pozicionin si " + pozicioniBasketbollistit
        + ",Mosha " + moshaBasketbollistit + ". Lojtari: "
        + (luanLojen? "luan lojen." : "nuk luan lojen.");    
    }



}


