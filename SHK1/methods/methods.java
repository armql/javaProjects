package SHK1.methods;
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

    //Metoda shtypIEmri() por qe i kthen me counter ndryshe me count/int
    public int shtypIEmri(String emri) {
        int count = 0;

        for(int i=0; i<index; i++) {
            if (personat[i].getEmri().equals(emri)) {
                count++;
            }
        }
        return count;
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

    //Metoda ktheSipasEmrit() emrin e te cileve e merr edhe si parameter!
    public Personi[] ktheSipasEmrit(String emri) {
        if (index == 0) {
            System.out.println("Nuk ka asnje person ne listen tuaj.");
        }

        Personi[] tempEmri = null;
        int count = 0;

        for (int i = 0; i < index; i++) {
            if (personat[i].getEmri().equals(emri)) {
                count++;
            }
        }

        if (count == 0) {
            System.out.println("Nuk ka asnje person me emrin " + emri);
        }

        tempEmri = new Personi[count];
        int pozita = 0;
        
        for (int i = 0; i < index; i++) {
            if (personat[i].getEmri().equals(emri)) {
                tempEmri[pozita++] = personat[i];
            }
        }

        return tempEmri;
    }

    //metoda fshijPersonin() qe fshine VETEM NJE PERSON
    public boolean fshijPersonin(Personi p) {
        if (index == 0) {
            System.out.println("Nuk ka asnje person ne listen tuaj.");
        }

        for (int i = 0; i < index; i++) {
            if (personat[i] == p) {
                for (int j = i; j < index; j++) {
                    personat[j] = personat[j + 1];
                }

                personat[--index] = null;
                i--;
                return true;
            }
        }
        return false;
    }

    //metoda fshijPersoni() qe fshine me shum se nje person me parameter emri
    public int fshijEPersoni(String emri) {
        if (index == 0) {
            System.out.println("Nuk ka asnje person ne listen tuaj.");
        }
        int count = 0;
        for (int i = 0; i < index; i++) {
            if(personat[i].equals(emri)) {
                count++;
                for(int j = i; j<index; j++) {
                    personat[j] = personat[j + 1];
                }

                personat[--index] = null;
                i--;
            }
        }
        return count;
    }

    //metoda printAll() qe printon te gjithe listen e personav
    public void printAll(){
        if (index == 0) {
            System.out.println("Nuk ka asnje person ne listen tuaj.");
            return;
        }

        for (int i = 0; i < index; i++) {
            System.out.println(i + "." + personat[i]);
        }
    }

    public static void main(String[] args) {
        methods m = new methods("uebete", 25);

        Personi p1 = new Personi("Dan", "Houser", 42, 'M', 6900);
        Personi p2 = new Personi("Denzel", "Washington", 50, 'M', 120);
        Personi p3 = new Personi("Bill", "Gejti", 60, 'M', 6900);
        Personi p4 = new Personi("Sam", "Houser", 37, 'M', 622);
        Personi p5 = new Personi("Sam", "Cook", 90, 'M', 342);
        Personi p6 = new Personi("Leroy", "Cook", 60, 'M', 742);
        Personi p7 = new Personi("Asd", "Wasder", 60, 'M', 123456789);

        m.shtoPersonin(p1);
        m.shtoPersonin(p2);
        m.shtoPersonin(p3);
        m.shtoPersonin(p4);
        m.shtoPersonin(p5);
        m.shtoPersonin(p6);
        m.shtoPersonin(p7);

        System.out.println("-----=Lista e momentit:");
        m.printAll();

        System.out.println("");
        System.out.println("-----=Metoda shtypEmri: ");
        m.shtypEmri("Sam");

        System.out.println("");
        System.out.println("-----=Metoda shtypIEmri sa jane me kete emer ne counter?: ");
        //VEREJTJE per shkaqe qe menyra sesi metoda perdoret psh int duhet qe te hyj brenda nje println qe te shfaqet ne TERMINAL,kjo vlen edhe per rregulla te tjera!
        System.out.println(m.shtypIEmri("Sam"));

        System.out.println("");
        System.out.println("-----=Metoda personiMeIRi");
        System.out.println(m.personiMeIRi());

        System.out.println("");
        System.out.println("-----=Metoda personiMeIVjeter");
        System.out.println(m.personiMeIVjeter());

        System.out.println("");
        System.out.println("-----=Metoda ktheSipasEmrit");
        //VEREJTJE metoda KTHE() kerkohet qe GJITHMON te inicializohet nje [temp] array kthehet ne for-each dhe printohet qe te funksionoj ne TERMINAL
        Personi[] temp = m.ktheSipasEmrit("Sam");
        for (Personi p : temp) {
            System.out.println(p);
        }

        //metoda fshijPersonin() qe fshin nje person!
        System.out.println("");
        System.out.println("-----=Metoda fshijPersonin");
        m.fshijPersonin(p2);

        System.out.println("");
        System.out.println("-----=LISTA PAS FSHIRJES SE NJE PERSONI");
        System.out.println(m.personiMeIVjeter());

        //metoda fshijEPersoni() qe fshin me shume se nje person me parameter EMRI
        System.out.println("");
        System.out.println("-----=Metoda fshijPersonin");
        m.fshijEPersoni("Denzel");

        System.out.println("");
        System.out.println("-----=LISTA PAS FSHIRJES SE nje apo me shume personav me parameter EMRI");
        m.printAll();

    }

}