package SHK2;

public abstract class StafiAdministrativ extends Punetori {
    private String departamenti;

    public StafiAdministrativ(String emri, int mosha, String departamenti) throws PunetoriException {
        super(emri, mosha);
        if (departamenti == null || departamenti.trim().isEmpty()) {
            throw new PunetoriException("Departamenti nuk eshte inicializuar ose eshte i zbrazet.");
        }
        this.departamenti=departamenti;
    }

    public String getDepartamenti() {
        return departamenti;
    }

    public void setDepartamenti(String departamenti) throws PunetoriException {
        if (departamenti == null || departamenti.trim().isEmpty()) {
            throw new PunetoriException("Departamenti nuk eshte inicializuar ose eshte i zbrazet.");
        }
        this.departamenti=departamenti;
    }
}
