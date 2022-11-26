public class Fakulteti {
    //Atributi kerkuar
    public String drejtimi;
    public Mesimdhenesi [] nrMesimdhenesit;
    int num=0;
    //Konstruktori ;ketu inicializohen atributet
    public Fakulteti (String drejtimi,int nrM) {
        this.drejtimi=drejtimi;
        nrMesimdhenesit = new Mesimdhenesi[nrM];
    }

    
    
    

    public static void main(String[] args) {
        
        Fakulteti UBT = new Fakulteti("Shkenca Kompjuterike dhe Inxhinieri - SHKI",15);

        Mesimdhenesi m1 = new Mesimdhenesi("Blerim Blerimi",1990,"Profesor");
        Mesimdhenesi m2 = new Mesimdhenesi("Blerim Gilani",1991,"Dr.Profesor");
        Mesimdhenesi m3 = new Mesimdhenesi("Lavdim valoranti",1990,"Profesor gjthsht/ Immortal ne Valorant");
        Mesimdhenesi m4 = new Mesimdhenesi("Elton Aliu",1991,"Profesor");
        Mesimdhenesi m5 = new Mesimdhenesi("Zhilbert Tafa",1990,"Profesor");
        Mesimdhenesi m6 = new Mesimdhenesi("Valdrin Haxhiu", 2003, "Profesor");
                
        UBT.shtoMesimdhenes(m1);
        UBT.shtoMesimdhenes(m2);
        UBT.shtoMesimdhenes(m3);
        UBT.shtoMesimdhenes(m4);
        UBT.shtoMesimdhenes(m5);
        UBT.shtoMesimdhenes(m6);
        System.out.println("Mesimdhenesi test:");
        System.out.println(m1);
        System.out.println("");
        System.out.println("Mesimdhenesi egziston test:");
        System.out.println(UBT.egziston(m2));
        System.out.println("");
        System.out.println("Mesimdhenesi me i ri");
        System.out.println(UBT.mesimdhenesiMeIRI());
        System.out.println("");
        System.out.println("Angazhimet si profesor");    	
		Mesimdhenesi[] temp = UBT.ktheAngazhimet("Profesor");
		for(Mesimdhenesi m : temp){
			System.out.println(m.toString());
		}
	
    
    }
    


    public Mesimdhenesi[] ktheAngazhimet(String a){
			
        int count = 0;
        for(int i = 0; i < num; i++){
            if(nrMesimdhenesit[i].getAngazhimi().equals(a)){
                count++;
            }
        }
        if(count == 0){
            return null;
        }
        Mesimdhenesi[] v = new Mesimdhenesi[count];
        int temp = 0;
        for(int i = 0; i < num; i++){
            if(nrMesimdhenesit[i].getAngazhimi().equals(a)){
                v[temp++] = nrMesimdhenesit[i];
            }
        }
        return v;
    }



    //Metoda ;ekziston 
	public boolean egziston(Mesimdhenesi m){
		for(int i=0; i<num; i++){
			if(nrMesimdhenesit[i].equals(m)){
                return true;
			}
		}
		return false;
	}

    
    //Metoda shtoMesimdhenesin per shtimin e nje mesimdhenesi ne rast se nuk egziston
    public void shtoMesimdhenes(Mesimdhenesi m) {
        if (m==null) {
            System.out.println("Mesimdhenesi nuk shtohet");
        }if (num==nrMesimdhenesit.length) {
            System.out.println("Nuk ka vend per " +m);
        }if (egziston(m)) {
            System.out.println("Egziston " +m);
        }
            nrMesimdhenesit[num++]=m;
        
    }

    //Metoda per te gjetur mesimdhenesin me te ri
    public Mesimdhenesi mesimdhenesiMeIRI() {
        Mesimdhenesi meIRI = null;

        for(int i=0; i<num; i++) {
            if(meIRI==null || nrMesimdhenesit[i].getVitiLindjes() > meIRI.getVitiLindjes()) {
                meIRI=nrMesimdhenesit[i];
            }
        }
        return meIRI;
    }

    
    //Metoda per te gjetur mesimdhenesin me te vjeter
    public Mesimdhenesi mesimdhenesiMeIVjeter() {
        Mesimdhenesi meIVjeter=nrMesimdhenesit[0];

        for (int i=0; i<num; i++){
            if(meIVjeter.getVitiLindjes()>nrMesimdhenesit[i].getVitiLindjes()) {
                meIVjeter=nrMesimdhenesit[i];
            }
        }
        return meIVjeter;
    }
    
}