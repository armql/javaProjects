package StafAkademik;

public abstract class Mesimdhenesi extends StafiAkademik {
    private String angazhimi;

    public Mesimdhenesi(String emri, int vitiLindjes, String angazhimi) {
        super(emri, vitiLindjes, false);
        this.angazhimi = angazhimi;
    }

    public String getAngazhimi() {
        return angazhimi;
    }public void setAngazhimi(String angazhimi) {
        this.angazhimi=angazhimi;
    }

    public abstract boolean mentoron();
    
    @Override
    public String toString() {
        return super.toString() + angazhimi; 
    }

}
