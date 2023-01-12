public class methods{

    private String emri;
    private Personi [] personat;
    private int index = 0;

    public methods (String emri, int nrP){
        this.emri=emri;
        personat = new Personi[nrP];
    }

    public void shtoPersonin(Personi p) {
        if (p == null) {
            System.out.println("Personi eshte null");
            return;
        }
        if (index == personat.length) {
            System.out.println("Personi eshte ne listen e personav.");
            return;
        }
        
        /*
        Nqs eshte kerkuar si METOD NE VETI egziston() atehere vetem thirret metoda ne shtoPersoni
            
            if (ekziston(p)) {
                System.out.println("Personi tashme egziston ne list.");
                return;
            }
        
        VEREJTJE: NESE METODA NUK EGZISTON ATEHERE E KRIJOJME TE RE BRENDA METODES shtoPersonin()*/
        
        for (int i = 0; i < index; i++) {
            if (personat[i].equals(p)) {
                System.out.println("Personi egziston ne liste.");
                return;
            }
        }
        
        personat[index++] = p;
    }


    //Metoda e cila ne parameter kerkon qe te shtypet personi me emrin e njejt si emri i kerkuar NGA PARAMETRI
    public void shtypEmri(String emri) {

        for(int i=0; i<index; i++) {
            if (personat[i].getEmri().equals(emri)) {
                System.out.println(personat[i]);
            }
        }
    }

    //Metoda personiMeIRi()
    public Personi personiMeIRi() {
        if (index == 0) {
            System.out.println("Nuk ka asnje person ne listen tuaj.");
            return null;
        }

        Personi meIRi = null;
        for (int i = 0; i < index; i++) {
            
            if (meIRi == null || meIRi.getMosha() > personat[i].getMosha()) {
                meIRi = personat[i];
            }
        }
        return meIRi;
    }

    //Metoda personiMeIVjeter()
    public Personi personiMeIVjeter() {
        if (index == 0) {
            System.out.println("Nuk ka asnje person ne listen tuaj.");
            return null;
        }

        Personi meIVjeter = null;
        for (int i = 0; i < index; i++) {
            if (meIVjeter == null || meIVjeter.getMosha() < personat[i].getMosha()) {
                meIVjeter = personat[i];
            }
        }
        return meIVjeter;
    }


}