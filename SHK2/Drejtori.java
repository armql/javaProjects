package SHK2;

public class Drejtori extends StafiAdministrativ implements Individi {
    private String kualifikimi;
    
    public Drejtori(String emri, int mosha, String departamenti, String kualifikimi) throws PunetoriException {
        super(emri, mosha, departamenti);
        if (kualifikimi == null || kualifikimi.trim().isEmpty()) {
            throw new PunetoriException("Emri nuk eshte inicializuar ose eshte e zbrazet");
        }
        this.kualifikimi=kualifikimi;
    }

    public String getKualifikimi() {
        return kualifikimi;
    }
    public void setKualifkimi(String kualifikimi) throws PunetoriException {
        if (kualifikimi == null || kualifikimi.trim().isEmpty()) {
            throw new PunetoriException("Emri nuk eshte inicializuar ose eshte e zbrazet");
        }
        this.kualifikimi=kualifikimi;
    }

    @Override
    public boolean angazhimiFullTime() {
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + kualifikimi;
    }
}
