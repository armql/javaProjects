package SHK2.Fakulteti;

public abstract class Mesimdhenesi extends StafiAkademik {
    private String angazhimi;
    public abstract boolean mentoron();
    
    public Mesimdhenesi(String emri, int vitiLindjes, boolean iRregullt, String angazhimi) throws MesimdhenesiException {
        super(emri, vitiLindjes, iRregullt);
        if (angazhimi == null || angazhimi.trim().isEmpty()) {
            throw new MesimdhenesiException("Angazhimi eshte i zbrazet ose nuk eshte inicializuar.");
        }
        this.angazhimi=angazhimi;
    }
    
    public String getAngazhimi() {
        return angazhimi;
    }public void setAngazhimi(String angazhimi) throws MesimdhenesiException {
        if (angazhimi == null || angazhimi.trim().isEmpty()) {
            throw new MesimdhenesiException("Angazhimi eshte i zbrazet ose nuk eshte inicializuar.");
        }
        this.angazhimi=angazhimi;
    }

    @Override
    public String toString() {
        return "Dekani " + super.toString() + " mban " + angazhimi; 
    }
}
