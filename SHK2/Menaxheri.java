package SHK2;

public class Menaxheri extends Punetori implements Individi{
    private String sektori;

    public Menaxheri(String emri, int mosha, String sektori) throws PunetoriException {
        super(emri, mosha);
        if (sektori == null || sektori.trim().isEmpty()) {
            throw new PunetoriException("Sektori nuk eshte inicializuar ose eshte i zbrazet.");
        }
        this.sektori=sektori;
    }

    @Override
    public boolean angazhimiFullTime() {
        return false;
    }

    public String getKualifikimi() {
        return "null";
    }
}
