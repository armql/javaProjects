public class Asistenti extends Mesimdhenesi{
    
    public String llojiUshtrimeve;


    public Asistenti(String emri, int vitiLindjes, String angazhimi, String llojiUshtrimeve) {
        super(emri, vitiLindjes, angazhimi);
        this.llojiUshtrimeve = llojiUshtrimeve;
    }

    @Override
    public boolean mentoron() {
       return false;
    }

    public String getLlojiUshtrimeve() {
        return llojiUshtrimeve;
    }public void setLlojiUshtrimeve(String llojiUshtrimeve) {
        this.llojiUshtrimeve = llojiUshtrimeve;
    }

    @Override
    public void setAngazhimi(String angazhimi) {
        super.setAngazhimi("Ushtrime");
    }

    @Override
    public String toString() {
        return "Asistenti " + getEmri() + " : " + getVitiLindjes() + " mban " + getAngazhimi() + " : " + llojiUshtrimeve  + mentoron();
    }
}
