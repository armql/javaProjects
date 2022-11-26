package StafAkademik;

public abstract class StafiAkademik {
    private String emri;
    private int vitiLindjes;
    private boolean iRregullt;
    
    public StafiAkademik(String emri, int vitiLindjes, boolean iRregullt) {
        this.emri = emri;
        this.vitiLindjes = vitiLindjes;
        this.iRregullt = iRregullt;
    }

    public String getEmri() {
        return emri;
    }

    public int getVitiLindjes() {
        return vitiLindjes;
    }public void setVitiLindjes(int vitiLindjes) {
        this.vitiLindjes=vitiLindjes;
    }
    
    public boolean getIRregullt() {
        return iRregullt;
    }public void setIRregullt(boolean iRregullt) {
        this.iRregullt=iRregullt;
    }

    public String toString() {
        return emri + " : " + vitiLindjes + (iRregullt?  " Staf i Rregullt " : " Staf jo i Rregullt ");
    }

    public boolean equals(Object o) {
        if (o instanceof StafiAkademik) {
            StafiAkademik s =(StafiAkademik)o;
            return s.getEmri().equals(emri) && s.getVitiLindjes() == vitiLindjes;
        }else {
            return false;
        }
    }
    
}