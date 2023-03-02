package SHK2.Fakulteti;

public class Asistenti extends Mesimdhenesi {
    public String llojiUshtrimeve;

    public Asistenti(String emri, int vitiLindjes, boolean iRregullt, String llojiUshtrimeve)
            throws MesimdhenesiException {
        super(emri, vitiLindjes, iRregullt, "Ushtrime");
        if (llojiUshtrimeve == null || llojiUshtrimeve.trim().isEmpty()) {
            throw new MesimdhenesiException("Lloji i ushtrimeve eshte null ose e zbrazet.");
        }
        this.llojiUshtrimeve = llojiUshtrimeve;
    }

    public String getLlojiUshtrimeve() {
        return llojiUshtrimeve;
    }public void setLlojiUshtrimeve(String llojiUshtrimeve) throws MesimdhenesiException {
        if (llojiUshtrimeve == null || llojiUshtrimeve.trim().isEmpty()) {
            throw new MesimdhenesiException("Lloji i ushtrimeve eshte null ose e zbrazet.");
        }
        this.llojiUshtrimeve = llojiUshtrimeve;
    }

    public boolean mentoron() {
        return false;
    }

    @Override
    public String toString() {
        return "Asistenti " + super.toString() + " mban Ushtrime ne " + llojiUshtrimeve;
    }
}
