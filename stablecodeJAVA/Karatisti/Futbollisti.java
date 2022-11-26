package Karatisti;
public class Futbollisti extends Sportisti {
    public int numri;

    public Futbollisti (int numri,int id,String emri,char gjinia,int mosha) {
        super(id,emri,gjinia,mosha);
        this.numri=numri;
    }
    
    public int getNumri() {
        return numri;
    }public void setNumri(int numri) {
        this.numri = numri;
    }

    @Override
    public String toString() {
        return super.toString() + " " + numri; 
    }


}

