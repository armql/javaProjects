package innerClasses.innerClasesv2;

import StafAkademik.Mesimdhenesi;

public class Asistenti extends Mesimdhenesi {
    private String llojiUshtrimeve;

    public Asistenti (String emri,int vitiLindjes,String llojiUshtrimeve) {
        super(emri, vitiLindjes, "Ushtrime:");
        this.llojiUshtrimeve=llojiUshtrimeve;
    }

    public String getLlojiUshtrimeve() {
        return llojiUshtrimeve;
    }public void setLlojiUshtrimeve(String llojiUshtrimeve) {
        this.llojiUshtrimeve=llojiUshtrimeve;
    }

    public boolean mentoron() {
        return false;
    }

    @Override
    public String toString() {
        return "Asistenti " + super.toString() + llojiUshtrimeve;
    }
}
