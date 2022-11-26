
public abstract class Mesimdhenesi {

    private String emri;
    private int vitiLindjes;
    private String angazhimi;
    protected abstract String mentoron();
        
    public Mesimdhenesi(String emri, int vitiLindjes, String angazhimi) {
        this.emri = emri;
        this.vitiLindjes = vitiLindjes;
        this.angazhimi = angazhimi;
    }

    public String getEmri() {
        return emri;
    }
    
    public int getVitiLindjes() {
        return vitiLindjes;
    }public void setVitiLindjes(int vitiLindjes) {
        this.vitiLindjes = vitiLindjes;
    }

    public String getAngazhimi() {
        return angazhimi;
    }public void setAngazhimi(String angazhimi) {
        this.angazhimi = angazhimi;
    }

    public String toString() {
        return emri + " + " + vitiLindjes + " mban " + angazhimi;
    }
 


    public boolean equals(Object o) {
        Mesimdhenesi m =(Mesimdhenesi)o;
        if (o instanceof Mesimdhenesi)  {
            return m.getEmri().equals(emri) && m.getVitiLindjes() == vitiLindjes;
        }else {
            return false;
        }
    }

}
