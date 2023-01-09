package Threads.Hipodromi;

public class KafshaGaruese extends Thread {
    private int mosha;
    private String emri;
    private int pozitaStartuese;
    public KafshaGaruese (int mosha, String emri, int pozitaStartuese) throws GaraException{
        if (pozitaStartuese <= 0) {
            throw new GaraException("Pozita Startuese eshte gabim");
        }

        this.emri=emri;
        this.mosha=mosha;
        this.pozitaStartuese=pozitaStartuese;
    }
    public int getMosha() {
        return mosha;
    }
    
    public String getEmri() {
        return emri;
    }public void setEmri(String emri) {
        this.emri = emri;
    }
    
    public int getPozitaStartuese() {
        return pozitaStartuese;
    }public void setPozitaStartuese(int pozitaStartuese) {
        this.pozitaStartuese = pozitaStartuese;
    }

    public boolean equals(Object o) {
        if (o instanceof KafshaGaruese) {
            KafshaGaruese kg = (KafshaGaruese)o;
            return kg.getEmri().equals(emri);
        }else {
            return false;
        }
    }

    

}
