package Pajisja;

public class Dyqani {
    private String emri;
    private Pajisja [] pajisjet;
    int index=0;

    public Dyqani(String emri,int nrP) {
        this.emri=emri;
        pajisjet = new Pajisja[nrP];
    }

    public boolean egziston(Pajisja p){
        for (int i = 0; i < index; i++) {
            if(pajisjet[i].equals(p)){
                return true;
            }
        }
        return false;
    }

    public void shtoPajisjet(Pajisja p) {
        if (p == null) {
            System.out.println("Vargu eshte NULL");
        }
        if (index == pajisjet.length) {
            System.out.println("Vargu eshte i mbushur");
        }
        if(egziston(p)) {
            System.out.println("Pajisja egziston");
        }
        pajisjet[index++]=p;
    }

    public void shtypPajisjetMeGarancion(int Garancia) {
        for (int i = 0; i < index; i++) {
            if(pajisjet[i] instanceof PajisjaElektrike) {
                PajisjaElektrike p =(PajisjaElektrike)pajisjet[i];
                if (p.getGarancioni() > Garancia) {
                    System.out.println(pajisjet[i]);
                }
            }
        }
    }

    public void ktheEnelaresjaProdhuesi5(String prodhuesi) {
        for (int i = 0; i < index; i++) {
            if (pajisjet[i] instanceof Enelaresja) {
                Enelaresja enlr =(Enelaresja)pajisjet[i];
                if(enlr.getProdhuesi().equals(prodhuesi)) {
                    if(enlr.getNrProgrameve() > 5) {
                      System.out.println(pajisjet[i]);
                    }
                }
            }
        }
    }

    public void ktheMullirineKafesMateriali(String materiali) {
        for (int i = 0; i < index; i++) {
            if (pajisjet[i] instanceof MulliriKafes) {
                MulliriKafes mlr =(MulliriKafes)pajisjet[i];
                if(mlr.getMateriali().equals(materiali)) {
                    System.out.println(pajisjet[i]);
                }
            }
        }
    }

    public void printAll() {
        for (int i = 0; i < pajisjet.length; i++) {
            System.out.println(i + "." + pajisjet[i]);
        }
    }

    public static void main(String[] args) {
        Dyqani d = new Dyqani("ABC Shop", 20);

        Enelaresja e1 = new Enelaresja("1D633", "Bosch", 500, 'A', 8);
        Enelaresja e2 = new Enelaresja("1D123", "Cedo", 500, 'C', 3);
        Enelaresja e3 = new Enelaresja("1D313", "Bosch", 500, 'A', 10);
        Enelaresja e4 = new Enelaresja("1D612", "Lenovo", 250, 'B', 6);
        Enelaresja e5 = new Enelaresja("1D125", "Beko", 450, 'B', 6);
        MP3Player m1 = new MP3Player("3A345", "Apple", 12, 'A', 2);
        MP3Player m2 = new MP3Player("3A412", "Rosch", 12, 'C', 2);
        MP3Player m3 = new MP3Player("3A123", "Beats", 12, 'A', 2);
        MulliriKafes mu1 = new MulliriKafes("D313", "2Lien", "Metal");
        MulliriKafes mu2 = new MulliriKafes("D200", "L3ien", "Wood");
        MulliriKafes mu3 = new MulliriKafes("D202", "L3ien v2", "Wood");
        MulliriKafes mu4 = new MulliriKafes("D206", "L3ien v3", "Wood");


        d.shtoPajisjet(e1);
        d.shtoPajisjet(e2);
        d.shtoPajisjet(e3);
        d.shtoPajisjet(e4);
        d.shtoPajisjet(e5);
        d.shtoPajisjet(m1);
        d.shtoPajisjet(m2);
        d.shtoPajisjet(m3);
        d.shtoPajisjet(mu1);
        d.shtoPajisjet(mu2);
        d.shtoPajisjet(mu3);
        d.shtoPajisjet(mu4);
        System.out.println("test");
        d.printAll();
        System.out.println("");
        System.out.println("metoda shtypPajisjetMeGarancion");
        d.shtypPajisjetMeGarancion(4);
        System.out.println("");
        System.out.println("metoda ktheEnelaresetProdhuesi5");
        d.ktheEnelaresjaProdhuesi5("Bosch");
        System.out.println("");
        System.out.println("metoda ktheMullirinEKafesMateriali");
        d.ktheMullirineKafesMateriali("Wood");


    }







}
