package finalizingEXCEINTE;

public class Mesimdhenesi {
    private String emri;
    private int vitiLindjes;
    private String fushaStudimit;

    public Mesimdhenesi(String emri, int vitiLindjes, String fushaStudimit) throws MesimdhenesiException{
        if(emri == null || emri.equals("")) {
            throw new MesimdhenesiException("Emri eshte NULL ose i Zbrazet");
        }
        if(vitiLindjes >= 2004) {
            throw new MesimdhenesiException("Viti i lindjes duhet te jete 18 +");
        }
        if(fushaStudimit == null || fushaStudimit.equals("")) {
            throw new MesimdhenesiException("Fusha e Studimit eshte NULL ose e zbrazet");
        }

        this.emri=emri;
        this.vitiLindjes=vitiLindjes;
        this.fushaStudimit=fushaStudimit;
    }

    public String getEmri() {
        return emri;
    }

    public int getVitiLindjes() {
        return vitiLindjes;
    }public void setVitiLindjes(int vitiLindjes)  throws MesimdhenesiException {
        if(vitiLindjes > 1950 && vitiLindjes < 2004) {
            throw new MesimdhenesiException("Viti i lindjes duhet te jete 18 +");
        }
        this.vitiLindjes=vitiLindjes;
    }

    public String getFushaEStudimit() {
        return fushaStudimit;
    }public void setFushaEStudimit() throws MesimdhenesiException {
        if(fushaStudimit == null || fushaStudimit.equals("")) {
            throw new MesimdhenesiException("Fusha e Studimit eshte NULL ose e zbrazet");
        }
        this.fushaStudimit=fushaStudimit;
    }

    public boolean equals(Object o) {
        if(o instanceof Mesimdhenesi) {
            Mesimdhenesi m = (Mesimdhenesi)o;
            return m.getEmri().equals(emri) && m.getVitiLindjes() == vitiLindjes;
        }else {
            return false;
        }
    }

    public String toString() {
        return emri + " : " + vitiLindjes + " me fushe studimi " + fushaStudimit;
    }

}
