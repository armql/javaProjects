package Dyqani;

public class MP3Player extends Pajisja {
    
    protected int memoria;

    
    public MP3Player(int numriSerik, String prodhuesi, int voltazhi, char kategoriaShpenzuese, int memoria) {
        super(numriSerik, prodhuesi, voltazhi, kategoriaShpenzuese);
        this.memoria = memoria;
    }
    
    public int getMemoria() {
        return memoria;
    }public void setMemoria(int memoria) {
        this.memoria = memoria;
    }
    
    @Override
    public String toString() {
        return "MP3 Player" + super.toString() + " " + memoria + "GB";
    }

}
