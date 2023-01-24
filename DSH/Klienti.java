package DSH;

import java.util.ArrayList;
public class Klienti {
    private String emri;
    private int mosha;
    private char gjinia;
    private ArrayList<Hapesira> hapesiratERezervuara;


    public Klienti(String emri, char gjinia, int mosha) throws RezervimiException{
        if (emri == null || emri.trim().isEmpty()) {
            throw new RezervimiException("Emri nuk eshte inicializuar ose eshte i zbrazet.");
        }
        this.emri=emri;
        if (mosha < 0) {
            throw new RezervimiException("Mosha eshte gabim.");
        }
        this.mosha=mosha;
        this.gjinia=gjinia;
        hapesiratERezervuara = new ArrayList<Hapesira>();
    }

    public String getEmri() {
        return emri;
    }

    public char getGjinia() {
        return gjinia;
    }public void setGjinia(char gjinia) {
        this.gjinia = gjinia;
    }

    public int getMosha() {
        return mosha;
    }
    
    
    public boolean merreRradhen(Hoteli h) {
        h.radha.lock();
        try{
            ArrayList<Hapesira> temp = h.klienti.get(h);
            if (temp.isEmpty()) {
                return true;
            }
            return false;
        }
        finally{
        h.radha.unlock();
        }
    }
    
    public void rezervo(Hoteli h) throws RezervimiException{
        h.radha.lock();
        try{
            if (merreRradhen(h)) {
                // this = KLIENTI | inicializo nje hapesire te rezervuar e cila e rezervon ate hapesire per klientin
                Hapesira hapesiraRezervuar = h.rezervoHapsiren(this);
                // e shton ne listen e hapesiratERezervuara duke e fshire nga hapesirat e lira
                hapesiratERezervuara.add(hapesiraRezervuar);
                System.out.println(emri + " rezervoi me sukses hapesiren " + hapesiraRezervuar + " ne hotelin " +  h.getEmriHotelit());
            }else {
                System.out.println( h.radha + " . " + emri + " nuk e morri rradhen ne hotelin " + h );
            }
        }
        finally{
        h.radha.unlock();
        }
    }

    public boolean equals(Klienti k) {
        if (k.getEmri().equals(emri) && k.getGjinia() == gjinia && k.getMosha() == mosha) {
            return true;
        }

        return false;
    }

    public String toString() {
        return emri + " - " 
        + (gjinia == 'M' ? " Mashkull " : gjinia == 'F' ? " Femer " : " nuk gjindet ne sistem. ")
        + mosha + " vjec.";
    }

}
