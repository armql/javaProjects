public class DyqaniElektronik{
	private String emri;
	private DVDPlayer [] DVDt;
	int index;

	public DyqaniElektronik(String emri,int nrDVD) {
		this.emri=emri;
		DVDt = new DVDPlayer[nrDVD];
	}

	public boolean egzistonDVD(DVDPlayer dvd) {
		for (int i=0; i<index; i++) {
			if(DVDt[i].equals(dvd)){
				return true;
			}
		}
		return false;
	}

	public void shtoDVD(DVDPlayer dvd) {
		if(dvd == null) {
			System.out.println("Kjo dvd eshte NULL.");
		}
		if(index == DVDt.length) {
			System.out.println("Vargu eshte i mbushur nuk pranon me shume DVD.");
		}
		if(egzistonDVD(dvd)) {
			System.out.println("Kjo dvd tashme egziston ne varg");
		}
		DVDt[index++] = dvd;
	}

	public void printDVDPlayer() {
		for (int i=0; i<DVDt.length; i++) {
			System.out.println(i + "." + DVDt[i]);
		}
	}

	public void getBySerialNo(String nrSerik) {
        if(nrSerik == null) {
            System.out.println("Ky nrSerik nuk gjindet ne varg.");
        }

		for (int i=0; i<index; i++) {
			if(DVDt[i].getNrSerik().equals(nrSerik)) {
				System.out.print(DVDt[i]);
			}
		}
	}

	public void shtypHD(boolean HD) {

		for (int i=0; i<index; i++) {
			if(DVDt[i].getEshteHD() == HD) {
				System.out.println(DVDt[i]);
			}
		}
	}

    public boolean fshijDVDPlayer(String marka) {
        for (int i = 0; i < index; i++) { 
            if(DVDt[i].getMarka().equals(marka)) {
                for (int j = i; j < index; j++) {
                    DVDt[j] = DVDt[j+1];
                }
                DVDt[--index] = null;
                i--;
                return true;
            }
        }
        return false;
    }


	public static void main(String[] args) {
		DyqaniElektronik d1 = new DyqaniElektronik("ElektroX",10);

		DVDPlayer dvd1 = new DVDPlayer("1001","Bosch",true);	
		DVDPlayer dvd2 = new DVDPlayer("1002","LG",true);	
		DVDPlayer dvd3 = new DVDPlayer("1003","HP",false);	
		DVDPlayer dvd4 = new DVDPlayer("1004","HP",true);	
		DVDPlayer dvd5 = new DVDPlayer("1005","Dell",false);
		DVDPlayer dvd6 = new DVDPlayer("1006","LG",false);

		d1.shtoDVD(dvd1);	
		d1.shtoDVD(dvd2);	
		d1.shtoDVD(dvd3);	
		d1.shtoDVD(dvd4);	
		d1.shtoDVD(dvd5);
        d1.shtoDVD(dvd6);
		d1.printDVDPlayer();
		System.out.print("");
		System.out.println("A egziston? " + d1.egzistonDVD(dvd3));
		System.out.print("");
        System.out.println("Inicializohet metoda per DVDPLAYER qe nuk jane HD:");
        d1.shtypHD(false);
        System.out.println("");
        System.out.println("Metoda shiko nrSerik inicializohet:");
        d1.getBySerialNo("12345678");
        System.out.println("");
        System.out.println("Inicializohet metoda e fshirjes marka");
        d1.fshijDVDPlayer("LG");
        System.out.println("");
        d1.printDVDPlayer();
	}

}