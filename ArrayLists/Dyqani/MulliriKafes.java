package ArrayLists.Dyqani;

public class MulliriKafes extends Pajisja implements Perdoret{
    private String materiali;

    public MulliriKafes(String numriSerik, String prodhuesi, String materiali) throws PajisjaException {
        super(numriSerik, prodhuesi);
        if (materiali == null || materiali.trim().isEmpty()) {
            throw new PajisjaException("Emri i materialit eshte i zbrazet ose null");
        }
        this.materiali = materiali;
    }

    public String getMateriali() {
        return materiali;
    }public void setMateriali(String materiali) throws PajisjaException{
        if (materiali == null || materiali.trim().isEmpty()) {
            throw new PajisjaException("Emri i materialit eshte i zbrazet ose null");
        }
        this.materiali=materiali;
    }

    public String getPerdorimi() {
        return " Shtepiak ";
    }
    public String toString() {
        return "Mulliri i Kafes prej " + materiali + super.toString();
    }
}
