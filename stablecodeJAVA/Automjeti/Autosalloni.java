package Automjeti;

public class Autosalloni {
    private String emri;
    private Automjeti [] automjetet;
    int index;

    public Autosalloni(String emri,int nrA) {
        this.emri=emri;
        automjetet = new Automjeti[nrA];
    }

    public boolean egziston(Automjeti a) {
        for (int i = 0; i < index; i++) {
            if (automjetet[i].equals(a)) {
                return true;
            }
        }
        return false;
    }

    public void shtoAutomjetin(Automjeti a) {
        if (a == null) {
            System.out.println("Automjeti nuk mund te shtohet me ate parameter.");
        }
        if(index == automjetet.length) {
            System.out.println("Automjeti nuk mund te shtohet vargu eshte mbushur.");
        }
        if (egziston(a)) {
            System.out.println("Automjeti nuk mund te shtohet,tashme egziston ne varg.");
        }
        automjetet[index++] = a;
    }

    public void utility4x4() {
        for (int i = 0; i < index; i++) {
            if (automjetet[i] instanceof UtilityVehicle) {
                UtilityVehicle UTV =(UtilityVehicle)automjetet[i];
                if (UTV.eshte4x4() == false) {
                    System.out.println(automjetet[i]);
                }
            }
        }
    } 

    public void shtypLimuzinaNgjyra(String ngjyra) {

        for (int i = 0; i < index; i++) {
            if(automjetet[i] instanceof Limuzina) {
                Limuzina lim = (Limuzina)automjetet[i];
                if (ngjyra == null || lim.getNgjyra().equals(ngjyra)) {
                    System.out.println(automjetet[i]);
                }
            }
        }
    }

    public Automjeti GPSMeIVjeter (int vitiProdhimit) {
        Automjeti meIVjeter = null;

        for (int i = 0; i < index; i++) {
            if (automjetet[i] instanceof MUV) {
                MUV muv =(MUV)automjetet[i];
                if (meIVjeter == null || muv.isKaGPS() == true && muv.getVitiProdhimit() < vitiProdhimit ) {
                    meIVjeter=automjetet[i];
                }
            }
        }
        return meIVjeter;
    }

    public void allTerrainProdhuesi(String prodhuesi) {
        for (int i = 0; i < index; i++) {
            if(automjetet[i] instanceof SUV) {
                SUV suv =(SUV)automjetet[i];
                if (suv.getEshteAllTerrain() == false && suv.getProdhuesi().equals(prodhuesi)) {
                    System.out.println(automjetet[i]);
                }
            }
        }
    }

    public void printALL() {
        for (int i = 0; i < automjetet.length; i++) {
            System.out.println(i + "." + automjetet[i]);
        }
    }
    public static void main(String[] args) {
        Autosalloni a = new Autosalloni("Salloni Gilangjia", 15);

        Limuzina l1 = new Limuzina("N103053", "Mercedes", 2010,"E Zeze");
        Limuzina l2 = new Limuzina("N404631", "M-Maybach", 2020,"E Bardhe");
        Limuzina l3 = new Limuzina("N706315", "Bentley", 2014,"E Kuqe");
        SUV s1 = new SUV("LN5312", "Brabus", 2021, true);
        SUV s2 = new SUV("LN7277", "Opel", 2017, true);
        SUV s3 = new SUV("LN6531", "Toyota", 2012, true);
        SUV s4 = new SUV("LN6311", "Toyota", 2008, false);
        SUV s5 = new SUV("LN6561", "Toyota", 2000, false);
        MUV m1 = new MUV("C31563", "Cairon", 2021, true);
        MUV m2 = new MUV("C26124", "Octane", 2002, true);
        MUV m3 = new MUV("C85361", "Redhorn", 2005, false);
        MUV m4 = new MUV("C91353", "Humvee", 2010, false);
        MUV m5 = new MUV("C24513", "Tesla", 2024, true);
     
        a.shtoAutomjetin(l1);
        a.shtoAutomjetin(l2);
        a.shtoAutomjetin(l3);
        a.shtoAutomjetin(s1);
        a.shtoAutomjetin(s2);
        a.shtoAutomjetin(s3);
        a.shtoAutomjetin(s4);
        a.shtoAutomjetin(s5);
        a.shtoAutomjetin(m1);
        a.shtoAutomjetin(m2);
        a.shtoAutomjetin(m3);
        a.shtoAutomjetin(m4);
        a.shtoAutomjetin(m5);
        System.out.println("e Gjithe lista e Automjetev:");
        a.printALL();
        System.out.println("");
        System.out.println("Ketu eshte metoda utility4x4:");
        a.utility4x4();
        System.out.println("");
        System.out.println("Ketu eshte metoda shtypLimuzinaNgjyra >E Zeze:");
        a.shtypLimuzinaNgjyra("E Zeze");
        System.out.println("");
        System.out.println("Ketu eshte GPSMeIVjeter se 2002:");
        System.out.println(a.GPSMeIVjeter(2030));
        System.out.println("");
        System.out.println("Ketu jane automjetet me kushtin allTerrainProdhuesi:");
        a.allTerrainProdhuesi("Toyota");
    }
}
