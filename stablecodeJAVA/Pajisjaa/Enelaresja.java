package Pajisjaa;

public class Enelaresja extends PajisjaElektrike {
    private int nrProgrameve;

    public Enelaresja(String numriSerik, String prodhuesi, int voltazhi, char kategoriaShpenzuese, int nrProgrameve) {
        super(numriSerik, prodhuesi, voltazhi, kategoriaShpenzuese);
        this.nrProgrameve = nrProgrameve;
    }
    
    public boolean kaBateri() {
        return false;
    }
    
    public int getNrProgrameve() {
        return nrProgrameve;
    }public void setNrProgrameve(int nrProgrameve) {
        this.nrProgrameve = nrProgrameve;
    }

    public String toString() {
        return "Enelaresja me " + nrProgrameve + " programe " + super.toString();
    }

}
