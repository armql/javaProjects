package finalizingEXCEINTE;

public class Asistenti extends Mesimdhenesi implements Angazhim{
    private String llojiUshtrimeve;

    public Asistenti(String emri, int vitiLindjes, String fushaStudimit, String llojiUshtrimeve) throws MesimdhenesiException {
        super(emri, vitiLindjes, fushaStudimit);
        if(llojiUshtrimeve == null || llojiUshtrimeve.equals("")) {
            throw new MesimdhenesiException("Lloji I Ushtrimeve nuk eshte inicializuar ose eshte i zbrazet");
        }
        this.llojiUshtrimeve=llojiUshtrimeve;
    }

    public String getLlojiUshtrimeve() {
        return llojiUshtrimeve;
    }public void setLlojiUshtrimeve(String llojiUshtrimeve) throws MesimdhenesiException{
        this.llojiUshtrimeve=llojiUshtrimeve;
        if(llojiUshtrimeve == null || llojiUshtrimeve.equals("")) {
            throw new MesimdhenesiException("Lloji I Ushtrimeve nuk eshte inicializuar ose eshte i zbrazet");
        }
    }

    public boolean mentoron() {
        return false;
    }

    public String getAngazhimi() {
        return "Ushtrime";
    }

    public String toString() {
        return "Asistenti " + super.toString() + " mban " + getAngazhimi() + llojiUshtrimeve;
    }
}
