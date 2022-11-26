package Pajisja;

public abstract class PajisjaElektrike extends Pajisja {
    private int voltazhi;
    private char kategoriaShpenzuese;
    
    public PajisjaElektrike(String numriSerik, String prodhuesi, int voltazhi, char kategoriaShpenzuese) {
        super(numriSerik, prodhuesi);
        this.voltazhi = voltazhi;
        this.kategoriaShpenzuese = kategoriaShpenzuese;
    }

    /**
     * @return the voltazhi
     */
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

    public abstract int getGarancioni();

    @Override
    public String toString() {
        return super.toString() + voltazhi + " - " + kategoriaShpenzuese + " ";
    }
}
