package StafAkademik;

public class Asistenti extends Mesimdhenesi {
    public String llojiUshtrimeve;

    public Asistenti(String emri, int vitiLindjes, String llojiUshtrimeve) {
        super(emri, vitiLindjes, "Ushtrime");
        this.llojiUshtrimeve = llojiUshtrimeve;
    }

    @Override
    public boolean mentoron() {
        return false;
    } 
    
    public String getLlojiUshtrimeve() {
        return llojiUshtrimeve;
    }public void setLlojiUshtrimeve(String llojiUshtrimeve) {
        this.llojiUshtrimeve=llojiUshtrimeve;
    }

    @Override
    public String toString() {
        return "Profesori " + super.toString()  + " " + llojiUshtrimeve; 
    }
}
