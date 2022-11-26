public class Biblioteka {
    
    private String emriBibliotekes;
    private Libri [] Librat;
    int index = 0;

    public Biblioteka (String e,int nrL) {
        e=emriBibliotekes;
        Librat = new Libri[nrL];
    }

    public boolean egziston(Libri l) {
        for(int i = 0; i<index; i++) {
            if(Librat[i].equals(l)) {
                return true;
            }            
        }
        return false;
    }

    public void shtoLibra (Libri l) {
        if (l == null) {
            System.out.println("Libri nuk shtohet");
            return;
        }
        if (index==Librat.length) {
            System.out.println("Libri egziston" + l);
        }
        if (egziston(l)) {
            System.out.println("Libri nuk egziston" + l);
        }

        Librat[index++]=l;
    }

    public void printAllBooks(){
        for (int i = 0; i<index; i++) {
            System.out.println(i + " . " + Librat[i]);
        }
    }

    public Libri libriMeIVjetri() {
        Libri meIVjetri = Librat[0];
        for(int i = 0; i<index; i++){
            
            if(meIVjetri.getDataBotimit()>Librat[i].getDataBotimit()) {
                meIVjetri=Librat[i];
            }
        
        }
        return meIVjetri;
    }

    public Libri libriMeIRi() {
        Libri meIRI = Librat[0];
        
        for(int i=0; i<index; i++) {
            if(meIRI.getDataBotimit()<Librat[i].getDataBotimit()) {
                meIRI=Librat[i];
            }
        }
        return meIRI;
    }

    public int fshijLibrin(int dataBotimit) {
        int count = 0;
        
        for (int i=0; i<index; i++) {
            if (Librat[i].getDataBotimit() < dataBotimit) {
                count++;
                for(int j = i; j<index; i++){
                    Librat[j] = Librat[j+1];
                }
                Librat[--index] = null;
                i--;
            }
        }
        return count;
    }    

    public int getTotali(){
        return Librat.length - index;
    }


    public static void main(String[] args) {
        Biblioteka b1 = new Biblioteka("ARVANITA", 20);

        Libri l1 = new Libri("N2U3403431", "Red River", 420, 2012);
        Libri l2 = new Libri("E3C8831424", "Scarface", 900, 2014);
        Libri l3 = new Libri("R3E3546423", "Lionel Messi", 450,2020);
        Libri l4 = new Libri("L3T4428974", "Geo-Now", 1030,2018);
        Libri l5 = new Libri("V6G3567835", "National Security Corrupted", 320, 2008);

        b1.shtoLibra(l1);
        b1.shtoLibra(l2);
        b1.shtoLibra(l3);
        b1.shtoLibra(l4);
        b1.shtoLibra(l5);
        
        System.out.println("");
        System.out.println("Te gjitha librat ne Bibliotek:");
        b1.printAllBooks();
        
        System.out.println("");
        System.out.println("Libri me i vjeter ne Bibliotek eshte:");
        System.out.println(b1.libriMeIVjetri());
        
        System.out.println("");
        System.out.println("Libri me i ri ne Bibliotek eshte:");
        System.out.println(b1.libriMeIRi());
       
        System.out.println("");
        System.out.println("Testim krahasimi:");
        System.out.println("Libri i pare krahasohet me librin e katert:  " + l1.equals(l4));
        
        System.out.println("");
        System.out.println("Merret totali i librav: " + b1.getTotali());
        
        
        System.out.println("");
        System.out.println("A egziston libri i pare: " + b1.egziston(l1));
        
    }



}