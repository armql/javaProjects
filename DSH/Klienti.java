package DSH;

import java.util.ArrayList;

public class Klienti {
    private String emri;
    private int mosha;
    private char gjinia;
    private ArrayList<Hapesira> hapesiratERezervuara;

    public Klienti(String emri, int mosha, char gjinia) throws RezervimiException{
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
        if(h == null) {
            throw new RezervimiException("Hoteli nuk eshte inicializuar");
        }
        for (int i = 0; i < hapesiratERezervuara; i++) {
            if (hapesiratERezervuara[i] instanceof Hoteli) {
                Hoteli h = (Hoteli)hapesiratERezervuara[i];
                if (h.radh) {
                    
                }
            }
        }
    }

    
}
