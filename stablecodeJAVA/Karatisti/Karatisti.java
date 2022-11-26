package Karatisti;
public class Karatisti extends Sportisti{
    protected String stili;
   
    public Karatisti(int id, String emri, int mosha, char gjinia, String stili) {
        super(id,emri,gjinia,mosha);
        this.stili = stili;
    }
    
    public String getStili() {
        return stili;
    }public void setStili(String stili) {
        this.stili = stili;
    }
    

    @Override
    public String toString() {
        return "Karatisti me Stil "+ stili + " " + super.toString();  
    }



}
