package Fakulteti;
public class Mesimdhenesi {
    
    //3 PARAMETRAT 
    private String emri;//readonly
    private int vitiLindjes;            
    private String angazhimi;
    
    public Mesimdhenesi() {}

    // KONSTRUKTORI
    public Mesimdhenesi(String emri, int vitiLindjes, String angazhimi) {
        this.emri = emri;
        this.vitiLindjes = vitiLindjes;             
        this.angazhimi = angazhimi;
    } 

    //Implementimi Get/set()
    public String getEmri() {
        return emri;
    }

    public int getVitiLindjes() {
        return vitiLindjes;
    }public void setVitiLindjes(int vitiLindjes) {
        this.vitiLindjes=vitiLindjes;
    }

    public String getAngazhimi() {
        return angazhimi;
    }public void setAngazhimi(String angazhimi) { 
        this.angazhimi=angazhimi;
    }
    
    //implementimi toString()
    public String toString() {
        return emri + ":" + vitiLindjes + "-" + angazhimi; 
    }

    //implementimi i metodes se krahasimit equals() 
    public boolean equals(Object o) {
        if(o instanceof Mesimdhenesi) {
                Mesimdhenesi m=(Mesimdhenesi)o;
              return m.getEmri().equals(emri) && m.getVitiLindjes()==vitiLindjes;
                }else {
            return false;
        }
        
    }

}
