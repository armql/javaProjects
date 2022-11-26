package Pajisjaa;

public abstract class PajisjaElektrike extends Pajisja { 
    private int voltazhi;
    private char kategoriaShpenzuese;

    public PajisjaElektrike(String numriSerik, String prodhuesi, int voltazhi, char kategoriaShpenzuese) {
        super(numriSerik, prodhuesi);
        this.voltazhi = voltazhi;
        this.kategoriaShpenzuese = kategoriaShpenzuese;
    }

    public abstract boolean kaBateri();

    
    public int getVoltazhi() {
        return voltazhi;
    }public void setVoltazhi(int voltazhi) {
        this.voltazhi = voltazhi;
    }
    
    public char getKategoriaShpenzuese() {
        return kategoriaShpenzuese;
    }public void setKategoriaShpenzuese(char kategoriaShpenzuese) {
        this.kategoriaShpenzuese = kategoriaShpenzuese;
    }

    public String toString() {
        return super.toString() + voltazhi + " - " + kategoriaShpenzuese;
    }

}
