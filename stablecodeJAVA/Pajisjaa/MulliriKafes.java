package Pajisjaa;

public class MulliriKafes extends Pajisja{
    private String materiali;


    public MulliriKafes(String numriSerik, String prodhuesi, String materiali) {
        super(numriSerik, prodhuesi);
        this.materiali = materiali;
    }


    public String getMateriali() {
        return materiali;
    }public void setMateriali(String materiali) {
        this.materiali = materiali;
    }

    public String toString() {
        return "MulliriiKafes prej " + materiali + " - " + super.toString();
    }
    
}
