public class EkipiBasketbollit {

	private String Ekipi;
	private Basketbollisti [] Basketbollistat;
	int index = 0;

	public EkipiBasketbollit(String Ekipi,int nrB) {
		this.Ekipi=Ekipi;
		Basketbollistat = new Basketbollisti[nrB];
	}

	public void shtoBasketbollistin(Basketbollisti b) {

		if (b == null) {
			System.out.print("Emri nuk eshte i pranueshem.");
			return;
		}
		if (index >= Basketbollistat.length) {
			System.out.print("Basketbollisti eshte ne ekip");
			return;
		}
		if (bskbtEgziston(b)) {
			System.out.print("Basketbollisti egziston ne ekip");
			return;
		}
		Basketbollistat[index++] = b;
	}

    public Basketbollisti[] kthePozicionineBSKBT(String b){

        int count = 0;
        for (int i = 0; i < index; i++) {
            if (Basketbollistat[i].getPozicioniBasketbollistit().equals(b)) {
                count++;
            }
        }

        Basketbollisti[] v = new Basketbollisti[count];
        int temp = 0;
        for (int i = 0; i < index; i++) {   
            if (Basketbollistat[i].getPozicioniBasketbollistit().equals(b)) {
                v[temp++] = Basketbollistat[i];
            }
        }
        return v;

    }
    
    public Basketbollisti ktheMeIRIBasketbollisti() {
        Basketbollisti meIRi = null;

        for (int i = 0; i < index; i++) {
            
            if(meIRi == null || Basketbollistat[i].getmoshaBasketbollistit() < meIRi.getmoshaBasketbollistit()) {
                meIRi=Basketbollistat[i];
            }
        }
        return meIRi;
    }

    public Basketbollisti ktheMeIVjeterbBasketbollisti() {
        Basketbollisti meIVjeter = null;

        for (int i = 0; i < index; i++) {
            if(meIVjeter == null || Basketbollistat[i].getmoshaBasketbollistit() > meIVjeter.getmoshaBasketbollistit()) {
                meIVjeter=Basketbollistat[i];
            }
        }
        return meIVjeter;
    }
    
    public Basketbollisti ktheKushmeShumPike() {
        Basketbollisti meShumP = null;
        
        for (int i = 0; i < index; i++) {
            if (meShumP==null || Basketbollistat[i].getPiketEKutive() > meShumP.getPiketEKutive()) {
                meShumP=Basketbollistat[i];   
            }
        }
        return meShumP;
    }

    public Basketbollisti ktheKushmePakPike() {
        Basketbollisti mePakP = null;

        for (int i = 0; i < index; i++) {

            if (mePakP==null || Basketbollistat[i].getPiketEKutive() < mePakP.getPiketEKutive()) {
                mePakP=Basketbollistat[i];
            }
            
        }
        return mePakP;

    }

	public boolean bskbtEgziston(Basketbollisti b) {
		for (int i=0; i<index; i++) {
			if (Basketbollistat[i].equals(b)) {
			return true;
			}
		}
        return false;
	}

	public void printAll() {
		for (int i=0; i<Basketbollistat.length; i++) {
			System.out.print(i + "." + Basketbollistat[i]);
		}
	}

	public static void main(String[] args) {
		
        EkipiBasketbollit Ekipi = new EkipiBasketbollit("Leets",12);

		Basketbollisti b1 = new Basketbollisti("M.Jordan",13,"centre",32,141,false);
		Basketbollisti b2 = new Basketbollisti("K.Duncan",21,"forward guard",36,120,true);
		Basketbollisti b3 = new Basketbollisti("Sh.O'Neal",3,"centre",42,122,true);
		Basketbollisti b4 = new Basketbollisti("Stephen Curry",6,"shooting guard",30,82,true);
		Basketbollisti b5 = new Basketbollisti("O.Robertson",9,"centre",28,141,false);
		Basketbollisti b6 = new Basketbollisti("W.Chamberlain",4,"point guard",30,50,true);
		Basketbollisti b7 = new Basketbollisti("L.James",3,"centre",25,48,true);
		Basketbollisti b8 = new Basketbollisti("M.Johnson",7,"power forward",44,72,true);
	
        Ekipi.shtoBasketbollistin(b1);
        Ekipi.shtoBasketbollistin(b2);
        Ekipi.shtoBasketbollistin(b3);
        Ekipi.shtoBasketbollistin(b4);
        Ekipi.shtoBasketbollistin(b5);
        Ekipi.shtoBasketbollistin(b6);
        Ekipi.shtoBasketbollistin(b7);
        Ekipi.shtoBasketbollistin(b8);
        
        System.out.println("Lista e te gjith Basketbollistav ne LEETS:");
        Ekipi.printAll();
        System.out.println("");
        System.out.println("");

        System.out.println("");
        System.out.println("Basketbollisti me,me se shumti pike eshte: " + Ekipi.ktheKushmeShumPike());
        System.out.println("Basketbollisti me,me pak pike eshte: " + Ekipi.ktheKushmePakPike());

        
        System.out.println("");
        System.out.println("Basketbollisti me i riu eshte: " + Ekipi.ktheMeIRIBasketbollisti());
        System.out.println("Basketbollisti me i vjetri eshte: " + Ekipi.ktheMeIVjeterbBasketbollisti());
        
        System.out.println("");
        System.out.println("Shtype gjinia e Basketbollistit");

        System.out.println("");
        System.out.println("Basketbollistat e pozicionuar ne centre:");
        Basketbollisti[] temp = Ekipi.kthePozicionineBSKBT("centre");
        for (Basketbollisti b : temp) {
            System.out.println(b.toStringFORCALLS());
        
        }
    }

}

