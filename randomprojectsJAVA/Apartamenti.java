/*
Klasa Apartamenti:						           	        


[2 pikë]

[1 pikë]

[2 pikë]


[5 pikë]
•	

•	Ofroni metodën që bënë krahasimin për barazi të dy objekteve të tipit Apartamenti Dy instanca të 
klasës Apartamenti janë të barabartë nëse i kanë të gjitha atributet e barabarta. 
[3 pikë]
*/

public class Apartamenti{
    /*
        •	Klasa Apartamenti ka pesë atribute: numri (numër i plote 16 bit) 
atribut readonly (p.sh. 2), kati (numer i plote 8 bit) ,
siperfaqja (numër me presje dhjetore 32 bit) atribut, emriPronarit (tekst) atribut 
dhe kaDepo atribut boolean.
    
    */
    public short numri; // readonly
    public byte kati;
    public float siperfaqja;
    public String emriPronarit;
    public boolean kaDepo;
    
    /*
        •	Ofroni një konstruktor të vetëm që pranon që të pesë parametrat, të cilat edhe 
i përdorë për t’i inicializuar variablat e instancës. 
    */

    public Apartamenti(short nr, byte k, float s, String e, boolean ka){
        numri = nr;
        kati = k;
        siperfaqja = s;
        emriPronarit = e;
        kaDepo = ka;	
    }

/*
•	Për variablat më lartë ofroni metodat get dhe set (ato të cilat ju i shihni të nevojshme). 
*/
    public short getNumri(){
        return numri;
    }
    public void setKati(byte k){
        kati = k;
    }
    public byte getKati(){
        return kati;
    }
    public void setSiperfaqja(float s){
        siperfaqja = s;
    }
    public float getSiperfaqja(){
        return siperfaqja;
    }
    public void setEmriPronarit(String e){
        emriPronarit = e;
    }
    public String getEmriPronarit(){
        return emriPronarit;
    }
    public void setKaDepo(boolean ka){
        kaDepo = ka;
    }
    public boolean getKaDepo(){
        return kaDepo;
    }
    
/*
    •	Ofroni metodën getCmimi e cila kthen si rezultat cmimin e apartamentit.
Cmimi të kalkulohet sipas kateve. Për katet 1 deri në 5, cmimi për metër katror është 800 euro, 
ndërsa për katet tjera, cmimi të kalkulohet me vlerën 700 euro.
Nëse apartamenti nuk ka depo të ofrohet zbritje 10% në vlerë totale. 

*/	
public double getCmimi(){
    double cmimi = 0;
    if(kati >= 1 && kati <= 5){
        cmimi = siperfaqja * 800;
    }
    else{
        cmimi = siperfaqja * 700;
    }
    if(!kaDepo){
        //cmimi = cmimi * 0.9;
        cmimi = cmimi - (cmimi*0.1);
        // 50000 - 5000 = 45000;
    }
    return cmimi;
    
}
/*
Ofroni metodën që përfaqëson objektin si String. Reprezentimi i një objekti të tipit Apartamenti në 
String duhet të jetë si vijon:  
Apartamenti <numri> me pronar <emriPronarit> ne katin <kati> ka siperfaqe: <siperfaqja> m2 dhe (nuk) ka Depo
[2 pikë]

*/
public String ktheAkaDepo(){
    if(kaDepo){
        return "ka depo";
    }
    else{
        return "nuk ka depo";
    }
}


public String toString(){
    return "Apartamenti " + numri + " me pronar " + emriPronarit + " ne katin " + kati + " ka siperfaqe: " + siperfaqja + " m2 "
    + " dhe " + (kaDepo? "ka depo" : "nuk ka depo");
    
}

/*
Ofroni metodën që bënë krahasimin për barazi të dy objekteve të tipit Apartamenti Dy instanca të 
klasës Apartamenti janë të barabartë nëse i kanë të gjitha atributet e barabarta. 
*/	
public boolean equals(Object obj){
    if(obj instanceof Apartamenti){
        Apartamenti mysafir = (Apartamenti) obj;
        if(numri == mysafir.getNumri() &&
           kati == mysafir.getKati() &&
           emriPronarit.equals(mysafir.getEmriPronarit()) &&
           siperfaqja == mysafir.getSiperfaqja() &&
           kaDepo == mysafir.getKaDepo()){
               return true;
           }	
    }
    return false;
    
}


}
