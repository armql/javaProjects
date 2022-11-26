package Pajisjaa;

public class Dyqani {
    private String emri;
    private Pajisja [] pajisjet;
    
    private int index;

    private static int numriP;


    public Dyqani(String emri) {
        this.emri=emri;
    }
    
    static {
        numriP=25;
    }
       
    {
        Dyqani.TV tv = new Dyqani.TV("351", "Sony", 120, 'A', true);
        pajisjet = new Pajisja[numriP];   

        shtoPajisje(tv);
    }

    public class Turiela extends Pajisja {
        private int gjatesia;

        public Turiela(String numriSerik, String prodhuesi, int gjatesia) {
            super(numriSerik, prodhuesi);
            this.gjatesia = gjatesia;
        }

        public int getGjatesia() {
            return gjatesia;
        }public void setGjatesia(int gjatesia) {
            this.gjatesia=gjatesia;
        }

        public String toString () {
            return "Turiela " + super.toString() + gjatesia + "cm";
        } 
    }

    public static class TV extends PajisjaElektrike {
        private boolean eshteHD;
        
        public TV(String numriSerik, String prodhuesi, int voltazhi, char kategoriaShpenzuese,boolean eshteHD) {
            super(numriSerik, prodhuesi, voltazhi, kategoriaShpenzuese);
            this.eshteHD=eshteHD;
        }
        
        public boolean kaBateri() {
            return false;
        }
        
         public boolean getEshteHD() {
             return eshteHD;
         }public void setEshteHD(boolean eshteHD) {
             this.eshteHD = eshteHD;
         }

        public String toString() {
            return "TV " + (eshteHD? " eshte HD " : " nuk eshte HD ") + super.toString();
        }
    }
    public boolean egziston(Pajisja p) {
        for (int i = 0; i < index; i++) {
            if(pajisjet[i].equals(p)) {
                return true;
            }
        }
        return false;
    }

    public void shtoPajisje(Pajisja p) {
        if(p == null) {
            System.out.println("Pajisja eshte NULL");
            return;
        }
        if(index == pajisjet.length) {
            System.out.println("Pajisja nuk mund te shtohet pasi vargu eshte mbushur.");
            return;
        }
        if(egziston(p)) {
            System.out.println("Pajisja nuk egziston");
            return;
        }
        pajisjet[index++] = p;
    }

    public void shtypHD(boolean eshteHD) {
        for (int i = 0; i < index; i++) {
            if(pajisjet[i] instanceof TV) {
                TV tv =(TV)pajisjet[i];
                if(tv.getEshteHD() == eshteHD) {    
                    System.out.println(pajisjet[i]);
                }
            }
        }
    }



    public Turiela[] turietatGjatesia(int gjatesia) {
        
        int count = 0 ;
        for (int i = 0; i < index; i++) {
            if(pajisjet[i] instanceof Turiela) {
                Turiela tr =(Turiela)pajisjet[i];
                if(tr.getGjatesia() == gjatesia) {
                    count++;
                }
            }
        }

        Turiela [] turietat = new Turiela[count];
        int pozita=0;
        for (int i = 0; i < index; i++) {
            if(pajisjet[i] instanceof Turiela) {
                Turiela tr =(Turiela)pajisjet[i];
                if(tr.getGjatesia() == gjatesia) {
                    turietat[pozita++]=tr;
                }
            }
        }

        return turietat;
    }

    public void printALL() {
        for (int i = 0; i < pajisjet.length; i++) {
            System.out.println(i + "." + pajisjet[i]);
        }
    }


    public static void main(String[] args) {
        Dyqani d = new Dyqani("ABC Shop");

        Enelaresja e1 = new Enelaresja("244", "Bosch", 300, 'A', 12);
        Enelaresja e2 = new Enelaresja("242", "Allen", 250, 'B', 8);
        Enelaresja e3 = new Enelaresja("246", "Sony", 350, 'A', 6);
    
        MP3Player mp1 = new MP3Player("344", "Apple", 12, 'A', 2);
        MP3Player mp2 = new MP3Player("342", "Samsung", 8, 'B', 4);
        MP3Player mp3 = new MP3Player("346", "Huawei", 6, 'B', 4);
    
        MulliriKafes m1 = new MulliriKafes("144", "Tenda", "Wood");
        MulliriKafes m2 = new MulliriKafes("142", "Ritech", "Wood");
        MulliriKafes m3 = new MulliriKafes("146", "Quantix", "Metal");
        
        Pajisja t1 = new D.Turiela("642", "Ruszn", 50);
        Pajisja t2 = new D.Turiela("622", "Ruszn", 50);
        Pajisja t3 = new Dyqani.Turiela("646", "Api", 20);

        
        
        Dyqani.TV tv1 = new Dyqani.TV("744", "Sony", 240, 'A', false);
        Dyqani.TV tv2 = new Dyqani.TV("742", "LG", 350, 'A', true);
        Dyqani.TV tv3 = new Dyqani.TV("746", "Samsung", 300, 'B', true);
       
        d.shtoPajisje(e1);
        d.shtoPajisje(e2);
        d.shtoPajisje(e3);
        d.shtoPajisje(mp1);
        d.shtoPajisje(mp2);
        d.shtoPajisje(mp3);
        d.shtoPajisje(m1);
        d.shtoPajisje(m2);
        d.shtoPajisje(m3);

        d.shtoPajisje(t1);
        d.shtoPajisje(t2);
        d.shtoPajisje(t3);
        d.shtoPajisje(tv1);
        d.shtoPajisje(tv2);
        d.shtoPajisje(tv3);

        System.out.println("");
        System.out.println("metoda shtypHD:");
        d.shtypHD(false);

        System.out.println("");
        System.out.println("metoda turietatGjatesia:");
        d.turietatGjatesia(50);
        
        
        
    }
   

}

