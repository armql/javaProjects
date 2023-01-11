package Sportisti;

public class EkipiOlimpik {
    private String emri;
    private Sportisti [] sportistat;
    private int index;
    
    public EkipiOlimpik(String emri, int nrS) {
        this.emri=emri;
        sportistat = new Sportisti[nrS];
    }

    public boolean ekziston(Sportisti s) {
        for (int i = 0; i < index; i++) {
            if (sportistat[i].equals(s)) {
                return true;
            }
        }
        return false;
    }

    public void shtoSportisti(Sportisti s) throws SportistiException {
        if(s == null) {
            throw new SportistiException("Sportisti eshte NULL");
        }
        if(index == sportistat.length) {
            throw new SportistiException("Vargu eshte i mbushur");
        }
        if(ekziston(s)) {
            throw new SportistiException("Sportisti ekziston ne varg");
        }
        sportistat[index++] = s;
    }

    public void shtypDistancen(int distanca) {
        for (int i = 0; i < index; i++) {
            if (sportistat[i] instanceof Vrapuesi) {
                Vrapuesi v = (Vrapuesi)sportistat[i];
                if(v.getDistanca() == distanca) {
                    System.out.println(sportistat[i]);
                }
            }
        }
    }

    public Atleti[] atletetMosha(int mosha) {

        Atleti [] at = null;
        int count = 0;

        for (int i = 0; i < index; i++) {
            if (sportistat[i] instanceof Atleti) {
                Atleti a = (Atleti)sportistat[i];
                if (a.getMosha() == mosha) {
                    count++;
                }
            }
        }

        if(count == 0) {
            System.out.println("Nuk kemi ndonje atlet me moshen " + mosha);
        }

        at = new Atleti[count];
        int pozita = 0;

        for (int i = 0; i < index; i++) {
            if (sportistat[i] instanceof Atleti) {
                Atleti a = (Atleti)sportistat[i];
                if (a.getMosha() == mosha) {
                    at[pozita++] = a;
                }
            }
        }
        return at;
    }

    public Sportisti[] gjiniaMeERe(char gjinia) {
        
        Sportisti [] sportist = null;
        int count = 0;
        int mosha = 0;

        for (int i = 0; i < index; i++) {
            if (sportistat[i].getGjinia() == gjinia) {
                if(sportistat[i].getMosha() < mosha ) {
                    count++;
                }
            }
        }

        if (count == 0) {
            System.out.println("Nuk kemi asnje Sportist me kete gjini" + gjinia);
        }

        sportist = new Sportisti[count];
        int pozita = 0;
        
        for (int i = 0; i < index; i++) {
            if (sportistat[i].getGjinia() == gjinia) {
                if(sportistat[i].getMosha() < mosha ) {
                    sportist[pozita++] = sportistat[i];
                }
            }
        }
        
        return sportist;

    }

    public static void main(String[] args) {
        try {
            EkipiOlimpik e = new EkipiOlimpik("Kosova Team", 25);

            Futbollisti f1 = new Futbollisti(001, "testjb", 23, 'M', 12);
            Futbollisti f2 = new Futbollisti(002, "testax", 21, 'M', 6);
            Futbollisti f3 = new Futbollisti(003, "testlg", 26, 'M', 2);
        
            Karateisti k1 = new Karateisti(111, "leasbs", 25, 'M', 10);
            Karateisti k2 = new Karateisti(112, "leatea", 32, 'M', 10);
            Karateisti k3 = new Karateisti(113, "eadeaf", 27, 'F', 10);

            Vrapuesi v1 = new Vrapuesi(221, "oegake", 31, 'F', 1200);
            Vrapuesi v2 = new Vrapuesi(222, "egeage", 22, 'F', 600);
            Vrapuesi v3 = new Vrapuesi(223, "egdhrs", 19, 'F', 400);
            Vrapuesi v4 = new Vrapuesi(224, "hrsgfd", 20, 'F', 400);

            e.shtoSportisti(f1);
            e.shtoSportisti(f2);
            e.shtoSportisti(f3);
            
            e.shtoSportisti(k1);
            e.shtoSportisti(k2);
            e.shtoSportisti(k3);
            
            e.shtoSportisti(v1);
            e.shtoSportisti(v2);
            e.shtoSportisti(v3);

            System.out.println("Metoda shtypDistancen: ");
            e.shtypDistancen(400);
            
            System.out.println("");
            System.out.println("Metoda atletetMosha: ");
            e.atletetMosha(22);
            
            System.out.println("");
            System.out.println("Metoda atletetMosha: ");
            e.gjiniaMeERe('F');
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
