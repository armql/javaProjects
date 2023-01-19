package DSH;

import java.util.ArrayList;
public class Klienti extends Hoteli{
    private String emri;
    private int mosha;
    private char gjinia;
    private ArrayList<Hapesira> hapesiratERezervuara;


    public Klienti(String emriHotelit,String emri, int mosha, char gjinia) throws RezervimiException{
        super(emriHotelit);
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

    public int getMosha() {
        return mosha;
    }
    
    public char getGjinia() {
        return gjinia;
    }public void setGjinia(char gjinia) {
        this.gjinia = gjinia;
    }

    public boolean merreRradhen(Hoteli h) throws RezervimiException{
        radha.lock();
        try{
            if (h == null) {
                throw new RezervimiException("Hoteli nuk ekziston");
            }
            ArrayList<Hapesira> temp = h.klienti.get(h);
            if (temp.isEmpty() == false) {
                return true;
            }
            return false;
        }
        finally{
            radha.unlock();
        }
    }
    
    public void rezervo(Hoteli h) throws RezervimiException{
        radha.lock();
        try{
            if (merreRradhen(h) == true) {
                hapesiratERezervuara.addAll(lista);
            }else {
                System.out.println( radha + " . " + emri + " nuk e morri rradhen ne hotelin " + h );
                return;
            }
        }
        finally{
            radha.unlock();
        }
    }

    public String toString() {
        return emri + " - " 
        + (gjinia == 'M' ? " Mashkull " : gjinia == 'F' ? " Femer " : " nuk gjindet ne sistem. ")
        + mosha + " vjec.";
    }

    public boolean equals(Klienti k) {
        if (k.getEmri().equals(emri) && k.getGjinia() == gjinia && k.getMosha() == mosha) {
            return true;
        }

        return false;
    }

}
