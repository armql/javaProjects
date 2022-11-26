package Pajisja;

public class MP3Player extends PajisjaElektrike {
    private int memoria;

    public MP3Player(String numriSerik, String prodhuesi, int voltazhi, char kategoriaShpenzuese, int memoria) {
        super(numriSerik, prodhuesi, voltazhi, kategoriaShpenzuese);
        this.memoria = memoria;
    }

    public int getMemoria() {
        return memoria;
    }public void setMemoria(int memoria) {
        this.memoria = memoria;
    }

    public int getGarancioni(){
        int garancia = 1;
        return garancia;
    }
    
    public String toString() {
        return "Mp3Player " + super.toString() + " : " + memoria + "GB";
    }
    
}
