package provim;

public class Apartamenti {
    
    private short numri;
    private byte kati;
    private double siperfaqja;
    private String emriPronarit;
    private boolean kaDepo;

    
    public Apartamenti(short numri,byte kati,double siperfaqja,String emriPronarit,boolean kaDepo) {
        this.numri=numri;
        this.kati=kati;
        this.siperfaqja=siperfaqja;
        this.emriPronarit=emriPronarit;
        this.kaDepo=kaDepo;
    }
    
    public short getNumri() {
        return numri;
    }
    
    public byte getKati() {
        return kati;
    }public void setKati(byte kati) {
        this.kati = kati;
    }
    
    public double getSiperfaqja() {
        return siperfaqja;
    }public void setSiperfaqja(double siperfaqja) {
        this.siperfaqja = siperfaqja;
    }
    
    public String getEmriPronarit() {
        return emriPronarit;
    }public void setEmriPronarit(String emriPronarit) {
        this.emriPronarit = emriPronarit;
    }
    
    public boolean isKaDepo() {
        return kaDepo;
    }public void setKaDepo(boolean kaDepo) {
        this.kaDepo = kaDepo;
    }
    
    public double getCmimi() {
        double cmimi=0;
        if(kati >= 1 && kati <= 5) {
            cmimi = siperfaqja * 800;
        }else {
            cmimi = siperfaqja * 700;
        }

        if(!kaDepo) {
            cmimi = cmimi - (cmimi * 0.01);
        }
        return cmimi;
    }

    public String toString() {
        return "Apartamenti " + numri + " me Pronar " + emriPronarit + " ne katin "
                + kati + " ka siperfaqe:" + siperfaqja + " m2 dhe " + (kaDepo? "Ka Depo" : "Nuk ka Depo"); 
    }
}
