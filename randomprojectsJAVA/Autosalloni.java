public class Autosalloni {
    
    // PARAMETRAT
    private String emri;
    private Automjeti [] nrAutomjeteve;
    
    int index = 0;
    // KONSTRUKTORI
    public Autosalloni(String e, int nrM) {
        emri = e;
        nrAutomjeteve = new Automjeti[nrM];
    }

    //METODA EXISTS
    public boolean egziston(Automjeti a){
		for(int i=0; i<index; i++){
			if(nrAutomjeteve[i].equals(a)){
                return true;
			}
		}
		return false;
	}

    //METODA shtoAutomjetin
    public void shtoAutomjetin(Automjeti a) {
        if (a==null) {
            System.out.println("Mesimdhenesi nuk shtohet");
        }
        if (index==nrAutomjeteve.length) {
            System.out.println("Nuk ka vend per " +a);
        }
        if (egziston(a)) {
            System.out.println("Egziston " +a);
        }
            nrAutomjeteve[index++]=a;
        
    }
    
    // METODA shtypSipasProdhuesit
    public Automjeti[] shtypSipasProdhuesit(String a){
			
        int count = 0;

        for(int i = 0; i < index; i++){
            if(nrAutomjeteve[i].getProdhuesi().equals(a)){
                count++;
            }
        }
        if(count == 0){
            return null;
        }
        Automjeti[] v = new Automjeti[count];
        int temp = 0;
        for(int i = 0; i < index; i++){
            if(nrAutomjeteve[i].getProdhuesi().equals(a)){
                v[temp++] = nrAutomjeteve[i];
            }
        }
        return v;
    }

    public Automjeti[] shtypSipasShasise(String a){
			
        int count = 0;

        for(int i = 0; i < index; i++){
            if(nrAutomjeteve[i].getNrShasise().equals(a)){
                count++;
            }
        }
        if(count == 0){
            return null;
        }
        Automjeti[] v = new Automjeti[count];
        int temp = 0;
        for(int i = 0; i < index; i++){
            if(nrAutomjeteve[i].getNrShasise().equals(a)){
                v[temp++] = nrAutomjeteve[i];
            }
        }
        return v;
    }


    public Automjeti automjetiMeIVjeter() {
        Automjeti meIVjeter=nrAutomjeteve[0];

        for (int i=0; i<index; i++){
            if(meIVjeter.getVitiProdhimit()>nrAutomjeteve[i].getVitiProdhimit()) {
                meIVjeter=nrAutomjeteve[i];
            }
        }
        return meIVjeter;
    }
    public static void main(String[] args) {
        
        Autosalloni Blerimi = new Autosalloni("AUTOSALLON-BLERIMI",50);

        Automjeti a1 = new Automjeti("SV30-0157366", "BMW x6", 2018);
        Automjeti a2 = new Automjeti("SV30-0169266", "Mercedes Benz", 2015);
        Automjeti a3 = new Automjeti("SV63-0131966", "BMW x3", 2012);
        Automjeti a4 = new Automjeti("XYZABC123409873CDE", "Mercedes Benz", 2015);
        Automjeti a5 = new Automjeti("SV30-0169265", "BMW M3", 2020);
        Automjeti a6 = new Automjeti("EA30-0169266", "Passat B8", 2018);
        Automjeti a7 = new Automjeti("GJ31-0169755", "Golf MKVII", 2009);
        Automjeti a8 = new Automjeti("EU53-3532336", "Tesla S", 2030);
        Automjeti a9= new Automjeti("DE31-6467433", "Opel", 2002);
        Automjeti a10= new Automjeti("CA37-4323251", "Opel", 2012);
        Automjeti a11= new Automjeti("AD21-5442424", "BMW M8 Coupe", 2018);
        Automjeti a12= new Automjeti("BC12-0542245", "BMW X6", 2018);

        Blerimi.shtoAutomjetin(a1);
        Blerimi.shtoAutomjetin(a2);
        Blerimi.shtoAutomjetin(a3);
        Blerimi.shtoAutomjetin(a4);
        Blerimi.shtoAutomjetin(a5);
        Blerimi.shtoAutomjetin(a6);
        Blerimi.shtoAutomjetin(a7);
        Blerimi.shtoAutomjetin(a8);
        Blerimi.shtoAutomjetin(a9);
        Blerimi.shtoAutomjetin(a10);
        Blerimi.shtoAutomjetin(a11);
        Blerimi.shtoAutomjetin(a12);

        System.out.println("Shtypet nese egziston Vetura kerkuar:");
        Automjeti[] temp = Blerimi.shtypSipasShasise("XYZABC123409873CDE");
		for(Automjeti a : temp){
			System.out.println(a.toString());
		}
        System.out.println("");
        System.out.println("Automjetet e prodhuesit OPEL:");
        Automjeti[] temp1 = Blerimi.shtypSipasProdhuesit("Opel");
		for(Automjeti a : temp1){
			System.out.println(a.toString());
		}
        System.out.println("");
        System.out.println("Automjeti me i vjeter");
        System.out.println(Blerimi.automjetiMeIVjeter());
	
    }
    
    
}
