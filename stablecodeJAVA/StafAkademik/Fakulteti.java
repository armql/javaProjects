package StafAkademik;

public class Fakulteti {
    private String drejtimi;
    private StafiAkademik [] stafi;
    int index;  
    public Fakulteti(String drejtimi,int nrS) {
        this.drejtimi=drejtimi;
        stafi = new StafiAkademik[nrS];
    }

    public boolean egziston(StafiAkademik s) {
        for (int i = 0; i < index; i++) {
            if(stafi[i].equals(s)) {
                return true;
            }
        }
        return false;
    }

    public void shtoStafin(StafiAkademik s) {
        if (s == null) {
            System.out.println("Kjo parameter nuk pranohet.");
        }
        if (index == stafi.length) {
            System.out.println("Stafi nuk mund te shtohet pasi vargu eshte mbushur.");
        }
        if (egziston(s)) {
            System.out.println("Stafi tashme egziston ne varg.");
        }
        stafi[index++] = s;
    }

    public StafiAkademik stafiIRregulltMeIRi(int vitiLindjes) {
        StafiAkademik meIRi = null;

        for (int i = 0; i < index; i++) {
            if(stafi[i] instanceof Mesimdhenesi) {
                Mesimdhenesi msm =(Mesimdhenesi)stafi[i]; 
                if(meIRi == null || msm.getIRregullt() == false && msm.getVitiLindjes() < vitiLindjes) {
                    meIRi=stafi[i];
                }
            }
        }
        return meIRi;
    }

    public StafiAkademik[] mentoretEVitit(int vitiLindjes){
        if(index == 0){
            System.out.println("Ky dyqan nuk ka asnje Pajisje/e!");
            return null;
        }

        StafiAkademik[] spEmri = null;
        int count = 0;
        for(int i = 0; i < index; i++){
            if (stafi[i] instanceof Mesimdhenesi) {
                Mesimdhenesi msm =(Mesimdhenesi)stafi[i];
                if(msm.mentoron() == false && msm.getVitiLindjes() == vitiLindjes){
                    count++;
                }
            }
        }

        if(count == 0){
            System.out.println("Nuk ka staf me kete ditelindje " + vitiLindjes);
            return null;
        }

        spEmri = new StafiAkademik[count];
        int pozita = 0;
        for(int i = 0; i < index; i++){
            if (stafi[i] instanceof Mesimdhenesi) {
            Mesimdhenesi msm =(Mesimdhenesi)stafi[i];    
                if(msm.mentoron() == false && msm.getVitiLindjes() == vitiLindjes){
                    spEmri[pozita++] = stafi[i];
                }
            }
        }

        return spEmri;
    }

    public void printALL() {
        for (int i = 0; i < stafi.length; i++) {
            System.out.println(i + " . " + stafi[i]);
        }
    }
    
    public static void main(String[] args) {
        Fakulteti f1 = new Fakulteti("Shkenca Kompjuterike", 15);

        Profesori p1 = new Profesori("Blerim Blerimi", 1992, "Profesor");
        Profesori p2 = new Profesori("Lavdim Valoranti", 1993, "Profesor");
        Profesori p3 = new Profesori("Lavdim Menxhiqi", 1993, "Profesor");
        Profesori p4 = new Profesori("Ramizi vogel", 1993, "Profesor");
        Profesori p5 = new Profesori("Shkelqim Berisha", 1986, "Profesor");
        Asistenti a1 = new Asistenti("Elton Aliu", 1996, "SHKI/Java");
        Asistenti a2 = new Asistenti("Rion Rioni", 1995, "DATABAZA/SQL");
        Asistenti a3 = new Asistenti("Dion Kuka", 1996, "Rrjeta dhe Kompjuterik");

        f1.shtoStafin(p1);
        f1.shtoStafin(p2);
        f1.shtoStafin(p3);
        f1.shtoStafin(p4);
        f1.shtoStafin(p5);
        f1.shtoStafin(a1);
        f1.shtoStafin(a2);
        f1.shtoStafin(a3);
        f1.egziston(a3);
        System.out.println("I gjithe stafi SHKI:");
        f1.printALL();
        System.out.println("Mentoret pa punime diplome te Vitit 1996:");
        StafiAkademik[] temp1 = f1.mentoretEVitit(1996);
		for(StafiAkademik a : temp1){
			System.out.println(a.toString());
		}
        System.out.println("Lista e stafit jo te rregullt me te ri");
        System.out.println(f1.stafiIRregulltMeIRi(1996));   
    }
}
