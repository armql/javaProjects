package SHK2.Fakulteti;

public abstract class StafiAkademik {
    private String emri;
    private int vitiLindjes;
    public boolean iRregullt;
    
    public StafiAkademik(String emri, int vitiLindjes, boolean iRregullt) throws MesimdhenesiException {
        if (emri == null || emri.trim().isEmpty()) {
            throw new MesimdhenesiException("Emri nuk eshte inicializuar ose eshte i zbrazet.");
        }
        this.emri=emri;
        if (vitiLindjes < 0) {
            throw new MesimdhenesiException("Viti i lindjes eshte numer negativ ose eshte i zbrazet.");
        }
        this.vitiLindjes=vitiLindjes;
        this.iRregullt=iRregullt;
    }

    public String getEmri() {
        return emri;
    }

    public int getVitiLindjes() {
        return vitiLindjes;
    }public void setVitiLindjes(int vitiLindjes) throws MesimdhenesiException {
        if (vitiLindjes < 0) {
            throw new MesimdhenesiException("Viti i lindjes eshte numer negativ ose eshte i zbrazet.");
        }
        this.vitiLindjes=vitiLindjes;
    }
    public boolean getIRregullt() {
        return iRregullt;
    }public void setIRregullt(boolean iRregullt) {
        this.iRregullt=iRregullt;
    }

    public boolean equals(StafiAkademik sa) {
        if (sa.getEmri().equals(emri) && sa.getVitiLindjes() == vitiLindjes) {
            return true;
        }
        return false;
    }

    public String toString() {
        return emri + " : " + vitiLindjes + (iRregullt? " Staf i Rregullt" : " Staf jo i Rregullt");
    }
}
