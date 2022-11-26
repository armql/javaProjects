package Dyqani;

public class Pajisja {
    protected int numriSerik; // readonly;
    protected String prodhuesi;
    protected int voltazhi;
    protected char kategoriaShpenzuese;
    
    public Pajisja(int numriSerik, String prodhuesi, int voltazhi, char kategoriaShpenzuese) {
        this.numriSerik = numriSerik;
        this.prodhuesi = prodhuesi;
        this.voltazhi = voltazhi;
        this.kategoriaShpenzuese = kategoriaShpenzuese;
    }
    
    public int getNumriSerik() {
        return numriSerik;
    }public void setNumriSerik(int numriSerik) {
        this.numriSerik = numriSerik;
    }

    public String getProdhuesi() {
        return prodhuesi;
    }public void setProdhuesi(String prodhuesi) {
        this.prodhuesi = prodhuesi;
    }
    
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
        return " SN:" + numriSerik + " Produced by " + prodhuesi + " Voltage:" + voltazhi + "V, ecoKategoria:" + kategoriaShpenzuese;
    }

    public boolean equals(Object o) {
        if (o instanceof Pajisja) {
            Pajisja p =(Pajisja)o;
            return p.getNumriSerik() == numriSerik;
        }else {
            return false;
        }

    }
    
}
