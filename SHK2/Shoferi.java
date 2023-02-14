package SHK2;

public class Shoferi extends Punetori {
    private String regjioni = "null";

    public Shoferi(String emri, int mosha, String regjioni) throws PunetoriException {
        super(emri,mosha);
        if (regjioni == null || regjioni.trim().isEmpty()) {
            throw new PunetoriException("Regjioni nuk eshte inicializuar ose eshte i zbrazet");
        }
        this.regjioni=regjioni;
    }

    public String getRegjioni() {
        return regjioni;
    }

    @Override
    public boolean angazhimiFullTime() {
        return false;
    }

    @Override
    public String toString() {
        return super.toString() + " dhe regjioni:" + regjioni;
    }
}
