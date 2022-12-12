package finalizingEXCEINTE;

public class Profesori extends Mesimdhenesi implements Angazhim{ 
    private String thirrjaAkademike;

    public Profesori(String emri, int vitiLindjes, String fushaStudimit, String thirrjaAkademike) throws MesimdhenesiException{
        super(emri,vitiLindjes,fushaStudimit);
        if(thirrjaAkademike == null || thirrjaAkademike.equals("")) {
            throw new MesimdhenesiException("Thirrja Akademike eshte e zbrazet ose NULL");
        }
        this.thirrjaAkademike=thirrjaAkademike;
    }

    public String getThirrjaAkademike() {
        return thirrjaAkademike;
    }public void setThirrjaAkademike(String thirrjaAkademike) throws MesimdhenesiException {
        if(thirrjaAkademike == null || thirrjaAkademike.equals("")) {
            throw new MesimdhenesiException("Thirrja Akademike eshte e zbrazet ose NULL");
        }
        this.thirrjaAkademike=thirrjaAkademike;
    }

    @Override
    public boolean mentoron() {
        return true;
    }

    @Override
    public String getAngazhimi() {
        return "Ligjerata";
    }

    @Override
    public String toString() {
        return "Profesori " + super.toString() + " mban " + getAngazhimi() + " ka thirrje " + thirrjaAkademike;
    }
    
}
