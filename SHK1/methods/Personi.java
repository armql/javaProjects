package SHK1.methods;

public class Personi {
    private String emri; // read-only
    private String mbiemri; 
    private int mosha; 
    private char gjinia;
    private int bilanci; // write only
    
    public Personi(String emri, String mbiemri, int mosha, char gjinia, int bilanci) {
        this.emri = emri;
        this.mbiemri = mbiemri;
        this.mosha = mosha;
        this.gjinia = gjinia;
        this.bilanci = bilanci;
    }

    public String getEmri() {
        return emri;
    }
    /*
    VEREJTJE: PASI QE rregulli thot qe eshte read-only atehere metoda setEmri() nuk mund te perdoret por vetem getEmri()

    MUND TE LEXOHET POR JO TE MBISHKRUHET
    
    public void setEmri(String emri) {
        this.emri = emri;
    }

    */
    public String getMbiemri() {
        return mbiemri;
    }public void setMbiemri(String mbiemri) {
        this.mbiemri = mbiemri;
    }

    public int getMosha() {
        return mosha;
    }public void setMosha(int mosha) {
        this.mosha = mosha;
    }

    public char getGjinia() {
        return gjinia;
    }public void setGjinia(char gjinia) {
        this.gjinia = gjinia;
    }

    /*
    VEREJTJE: PASI QE rregulli thot eshte write-only nuk mund te behet getBilanci() por vetem setBilanci()
    
    MUND TE MBISHKRUHET POR JO TE LEXOHET

    public int getBilanci() {
        return bilanci;
    }

    */
    public void setBilanci(int bilanci) {
        this.bilanci = bilanci;
    }

    // KETU KEMI KERKUAR NGA METODA EQUALS QE TE GJEJE NJE OBJEKT I CILI KA EMRIN DHE MOSHEN E NJEJT DUKE KRAHASUAR 2 OBJEKTE
    public boolean equals(Personi p) {
        if (p.getEmri()==emri && p.getMosha() == mosha) {
            return true;
        }
        return false;
        

        /*
         METODA E DETAJUAR PER equals()
        public boolean equals(Object o) {
            if (o instanceof Personi) {
                Personi p = (Personi)o;
                if (p.getEmri().equals(emri) && p.getMosha() == mosha) {
                    return true;
                }else {
                    return false;
                }
            }
        }    
         */
    }

    public String toString() {
        return "Emri: " + emri + " | Mbiemri: " + mbiemri + "\nMosha:" + mosha 
        + "\nGjinia:" + (gjinia == 'F' ? " Femer " : gjinia == 'M' ? " Mashkull " : " Nuk gjindet ne sistem!") 
        + "\nBilanci i vlefshem: " + bilanci + "EUR \n";

        /*
         MUND EDHE KESHTU TE PERDORET PER SHKAQE QE KERKOHET GJINIA DUHET TE DEFINOHET ME F-Femer dhe M-Mashkull ne toString();

         char gj;
         gj=gjinia;
         if (gj == 'F' || gj == 'f') {
            System.out.println(" Femer ");
         }
         if (gj == 'M' || gj == 'm') {
            System.out.println(" Mashkull ");
         }else{
            System.out.println(" Nuk gjindet ne sistem!");
         }
        
        return "Emri: " + emri + " Mbiemri: " + mbiemri + "\nMosha:" + mosha 
        + "\nGjinia:" + gj + "\n Bilanci i vlefshem:" + bilanci + "€";

         OSE BOOLEAN gjinia ateher shkruhet ne return (gjinia? "true" : "false")
         return "Emri: " + emri + " Mbiemri: " + mbiemri + "\nMosha:" + mosha 
        + "\nGjinia:" + (gjinia? "Mashkull" : "Femer") + "\n Bilanci i vlefshem:" + bilanci + "€";

         */
    }

}
