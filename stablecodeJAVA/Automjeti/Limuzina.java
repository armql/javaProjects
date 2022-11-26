package Automjeti;

public class Limuzina extends Automjeti{ 

    public Limuzina(String nrShasise, String prodhuesi, int vitiProdhimit,String ngjyra) {
        super(nrShasise, prodhuesi, vitiProdhimit);
        this.ngjyra=ngjyra;
    }

    private String ngjyra;
    
    public String getNgjyra() {
        return ngjyra;
    }public void setNgjyra(String ngjyra) {
        this.ngjyra = ngjyra;
    }

    @Override
    public boolean eshteAutomatik() {
        return true;
    }

    @Override
    public String toString(){
        return "Limuzina " + super.toString() + " : " + ngjyra;
    }

}
