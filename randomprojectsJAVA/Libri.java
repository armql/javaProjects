public class Libri {
    private String isbn; // readonly
    private String titulliFaqeve;
    private int numriFaqeve;
    private int dataBotimit;

    public Libri(String isbn, String titulliFaqeve, int numriFaqeve,int dataBotimit) {
        this.isbn = isbn;
        this.titulliFaqeve = titulliFaqeve;
        this.numriFaqeve = numriFaqeve;
        this.dataBotimit = dataBotimit;
    }

    public String getIsbn(){
        return isbn;
    }

    public String getTitulliFaqeve(){
        return titulliFaqeve;
    }public void setTitulliFaqeve(String titulliFaqeve){
        this.titulliFaqeve=titulliFaqeve;
    }

    public int getNumriFaqeve(){
        return numriFaqeve;
    }public void setNumriFaqeve(int numriFaqeve){
        this.numriFaqeve=numriFaqeve;
    }
    
    public int getDataBotimit() {
        return dataBotimit;
    }public void setDataBotimit(int dataBotimit) {
        this.dataBotimit=dataBotimit;
    }

    public String toString() {
        return "ISBN: " + isbn + " Titulli: " + titulliFaqeve + " - " + numriFaqeve + " faqe dhe Data Botimit: " + dataBotimit;  
    }

    public boolean equals(Object o) {

        if (o instanceof Libri) {
            Libri l = (Libri)o;
            return l.getTitulliFaqeve().equals(titulliFaqeve); 
        }
        else {
            return false;
        }

    }

    
    

    
}