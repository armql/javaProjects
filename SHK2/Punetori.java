package SHK2;

public abstract class Punetori {
    private String emri;
    private int mosha;

    public abstract boolean angazhimiFullTime();

    public Punetori(String emri, int mosha) throws PunetoriException {
        if(emri == null || emri.trim().isEmpty()) {
            throw new PunetoriException("Emri nuk eshte inicializuar ose eshte NULL");
        }
        this.emri=emri;
        if (mosha < 0) {
            throw new PunetoriException("Mosha duhet te jete pozitive");
        }
        this.mosha=mosha;
    }
    

    public String getEmri() {
        return emri;
    }public void setEmri(String emri) throws PunetoriException {
        if(emri == null || emri.trim().isEmpty()) {
            throw new PunetoriException("Emri nuk eshte inicializuar ose eshte NULL");
        }
        this.emri=emri;
    }

    public int getMosha() {
        return mosha;
    }
    public void setMosha(int mosha) throws PunetoriException {
        if (mosha < 0) {
            throw new PunetoriException("Mosha duhet te jete pozitive");
        }
        this.mosha=mosha;
    }

    public String toString() {
        return emri + " : " + mosha + " vjec.";
    }
}
