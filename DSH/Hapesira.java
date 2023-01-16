package DSH;

import java.util.HashMap;

public abstract class Hapesira {
    //TODO: ATTRIBUTE:nr needs to be UNIQUE HASHMAPS'
    private int nr;  
    private String pershkrimi;
    private double cmimi;
    
    public abstract boolean kaWifi();

    public Hapesira(int nr, String pershkrimi, double cmimi) throws RezervimiException{
        if (nr < 0) {
            throw new RezervimiException("Numer negativ");
        }
        this.nr = nr;
        if (pershkrimi == null || pershkrimi.trim().isEmpty()) {
            throw new RezervimiException("Pershkrimi eshte null ose i zbrazet");
        }
        this.pershkrimi = pershkrimi;
        if (cmimi < 0) {
            throw new RezervimiException("Numer negativ");
        }
        this.cmimi = cmimi;
    }

    public int getNr() {
        return nr;
    }

    public String getPershkrimi() {
        return pershkrimi;
    }

    public double getCmimi() {
        return cmimi;
    }public void setCmimi(double cmimi) throws RezervimiException{
        if (cmimi < 0) {
            throw new RezervimiException("Numer negativ");
        }
        this.cmimi = cmimi;
    }

    public boolean krahaso(Hapesira h) {
        if (h.getPershkrimi().equals(pershkrimi)) {
            return true;
        }
        return false;
    }

    public String toString() {
        return nr + " - " + pershkrimi + " : " + cmimi;
    }
}
