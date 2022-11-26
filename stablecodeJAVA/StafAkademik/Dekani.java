package StafAkademik;

public class Dekani extends StafiAkademik {
    private String gradaAkademike;

    public Dekani(String emri, int vitiLindjes, String gradaAkademike) {
        super(emri, vitiLindjes, false);
        this.gradaAkademike = gradaAkademike;
    }

    public String getGradaAkademike() {
        return gradaAkademike;
    }public void setGradaAkademike(String gradaAkademike) {
        this.gradaAkademike=gradaAkademike;
    }

    @Override
    public String toString() {
        return "Dekani " + gradaAkademike + "." + super.toString();
    }

}
