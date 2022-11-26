package innerClasses;

public abstract class Mesimdhenesi {
    private String emri;
    private int vitiLindjes;
    private String angazhimi;
    
    public Mesimdhenesi(String emri, int vitiLindjes, String angazhimi) {
        this.emri = emri;
        this.vitiLindjes = vitiLindjes;
        this.angazhimi = angazhimi;
    }

    /**
     * @return the emri
     */
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

    public abstract boolean mentoron();
    
    public String toString() {
        return emri + " : " + vitiLindjes + " angazhohet ne " + angazhimi; 
    }

    public boolean equals(Object o) {
        if(o instanceof Mesimdhenesi) {
            Mesimdhenesi m =(Mesimdhenesi)o; 
            return m.getEmri().equals(emri) && m.getVitiLindjes() == vitiLindjes;
        }else {
            return false;
        }
    }

}
