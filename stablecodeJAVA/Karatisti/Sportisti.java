package Karatisti;
public class Sportisti {
    protected int id; // readonly
    protected String emri;
    protected int mosha;
    protected char gjinia;

    public Sportisti(int id,String emri,char gjinia,int mosha) {
        this.id=id;
        this.emri=emri;
        this.mosha=mosha;
        this.gjinia=gjinia;
    }

    public int getID() {
        return id;
    }

    public String getEmri() {
        return emri;
    }public void setEmri(String emri) {
        this.emri=emri;
    }

    public int getMosha() {
        return mosha;
    }public void setMosha(int mosha) {
        this.mosha=mosha;
    }

    public char getGjinia() {
        return gjinia;
    }public void setGjinia(char gjinia) {
        this.gjinia=gjinia;
    }

    @Override
    public boolean equals(Object o) {
        
        if(super.equals(o)) {
            return true;
        }else{
            if(o instanceof Sportisti) {
                Sportisti s = (Sportisti)o;
                return s.getEmri().equals(emri) && s.getID() == id;
            }else{
                return false;
            }
        }
    }

    public String toString(){
        String g = "";
        if (gjinia == 'M' || gjinia == 'm' ) {
            g = "Mashkull ";
        }else if (gjinia == 'F' || gjinia == 'f') {
            g = "Femer ";
        }
        else {
            g = "nuk gjindet ne sistem. ";
        }

        return "ID:" + id + " Emri:" + emri + " me Gjini " + g + mosha + " vjec."; 
    }

}
