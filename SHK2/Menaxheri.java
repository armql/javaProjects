package SHK2;

public class Menaxheri extends Punetori implements Individi{
    private String sektori;
    private String kualifikimi;
    
    public Menaxheri(String emri, int mosha, String sektori, String kualifikimi) throws PunetoriException {
        super(emri, mosha);
        if (sektori == null || sektori.trim().isEmpty()) {
            throw new PunetoriException("Sektori nuk eshte inicializuar ose eshte i zbrazet.");
        }
        if(kualifikimi == null || kualifikimi.trim().isEmpty()){
            throw new PunetoriException("Plotesoni te dhenat");
        }
        this.kualifikimi=kualifikimi;
        this.sektori=sektori;
    }

    @Override
    public boolean angazhimiFullTime() {
        return false;
    }

    public String getKualifikimi() {
        return kualifikimi;
    }
}
