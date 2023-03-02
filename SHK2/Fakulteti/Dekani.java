package SHK2.Fakulteti;

public class Dekani extends StafiAkademik {
    private String gradaAkademike;
    
    public Dekani(String emri, int vitiLindjes, String gradaAkademike) throws MesimdhenesiException {
        super(emri, vitiLindjes, true);
        if (gradaAkademike == null || gradaAkademike.trim().isEmpty()) {
            throw new MesimdhenesiException("GradaAkademike eshte i zbrazet ose nuk eshte inicializuar.");
        }
        this.gradaAkademike=gradaAkademike;
    }
    
    public String getGradaAkademike() {
        return gradaAkademike;
    }public void setGradaAkademike(String gradaAkademike) throws MesimdhenesiException {
        if (gradaAkademike == null || gradaAkademike.trim().isEmpty()) {
            throw new MesimdhenesiException("Angazhimi eshte i zbrazet ose nuk eshte inicializuar.");
        }
        this.gradaAkademike=gradaAkademike;
    }

    @Override
    public String toString() {
        return "Dekani " + gradaAkademike + ". " + super.toString(); 
    }
}