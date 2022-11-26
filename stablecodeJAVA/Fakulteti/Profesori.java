public class Profesori extends Mesimdhenesi {
    
    protected String thirrjaAkademike;

    public Profesori(String emri, int vitiLindjes, String angazhimi, String thirrjaAkademike) {
        super(emri, vitiLindjes, angazhimi);
        this.thirrjaAkademike = thirrjaAkademike;
    }

    @Override
    public String mentoron() {
    return " Mentoron punime diplome ";
    }
    public String getThirrjaAkademike() {
        return thirrjaAkademike;
    }    public void setThirrjaAkademike(String thirrjaAkademike) {
        this.thirrjaAkademike = thirrjaAkademike;
    }

    @Override
    public void setAngazhimi(String angazhimi) {
        super.setAngazhimi("Ligjerata");
    }

    @Override
    public String getAngazhimi() {
        // TODO Auto-generated method stub
        return super.getAngazhimi();
    }

    @Override
    public String toString() {
        return "Profesori " + getEmri() + " mban " + getAngazhimi() + " ka thirrje " + thirrjaAkademike +  mentoron();
    }

}
