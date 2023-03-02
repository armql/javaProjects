package SHK2.Fakulteti;

public class Profesori extends Mesimdhenesi {
    private String thirrjaAkademike;

    public Profesori(String emri, int vitiLindjes, boolean iRregullt, String thirrjaAkademike) throws MesimdhenesiException {
        super(emri, vitiLindjes, iRregullt, "Ligjerata");
        if (thirrjaAkademike == null || thirrjaAkademike.trim().isEmpty()) {
            throw new MesimdhenesiException("Thirrja akademike eshte null ose e zbrazet.");
        }
        this.thirrjaAkademike=thirrjaAkademike;
    }

    public boolean mentoron() {
        return true;
    }
    public String getThirrjaAkademike() {
        return thirrjaAkademike;
    }public void setThirrjaAkademike(String thirrjaAkademike) throws MesimdhenesiException {
        if (thirrjaAkademike == null || thirrjaAkademike.trim().isEmpty()) {
        throw new MesimdhenesiException("Thirrja akademike eshte null ose e zbrazet.");
    }
    this.thirrjaAkademike=thirrjaAkademike;
    }

    @Override
    public String toString() {
        return "Profesori " + super.toString() + " ka thirrje " + thirrjaAkademike;
    }
}
