package SHK2;

import java.io.IOException;

public class Ndermarrja {
    private String emri;
    private Punetori [] punetoret;
    private int index;

    public Ndermarrja(String emri, int nrP) {
        this.emri=emri;
        punetoret = new Punetori[nrP];
    }

    public boolean ekziston(Punetori p) {
        for(int i = 0; i<index; i++) {
            if (punetoret[i].equals(p)) {
                return true;
            }
        }
        return false;
    }

    public void shtoPunetor(Punetori p) throws PunetoriException {
        if (p == null) {
            throw new PunetoriException("Punetori nuk eshte inicializuar");
        }
        if (index >= punetoret.length) {
            throw new PunetoriException("Lista eshte e mbushur");
        }
        if (ekziston(p)) {
            throw new PunetoriException("Punetori tashme ekziston ne varg");
        }
        punetoret[index++] = p;
    }

    public void getKualifikimet() {
        for (int i = 0; i < index; i++) {
            if (punetoret[i] instanceof Individi) {
                System.out.println(punetoret[i]);
            }
        }
    }

    public boolean kaTeGjithaLlojet() {
        int countSh = 0;
        int countK = 0;
        int countM = 0;
        int countD = 0;


        for (int i = 0; i < index; i++) {
            if (punetoret[i] instanceof Shoferi) {
                countSh++;
            }
            if (punetoret[i] instanceof Koordinatori) {
                countK++;
            }
            if (punetoret[i] instanceof Menaxheri) {
                countM++;
            }
            if (punetoret[i] instanceof Drejtori) {
                countD++;
            }
        }
            if(countSh != 0 && countK !=0 && countM != 0 && countD != 0){
                return true;
            }
            else{
                return false;
            }
    }

    public void shfaq() {
        for (int i = 0; i < index; i++) {
            System.out.println(punetoret[i].getEmri() + " " + punetoret[i].getMosha());
        }
    }


    public static void main(String[] args) {
        try {
            
            Ndermarrja n = new Ndermarrja("BLERIMI", 10);

            Drejtori d = new Drejtori("Trim", 31, "COMPUTER SCIENCE", "DR.SC.HONOR KAUZA");
            Shoferi sh1 = new Shoferi("Valdrin", 21, "Komoran");
            Shoferi sh2 = new Shoferi("Raqip", 48, "Vushtrre");

            Menaxheri m1 = new Menaxheri("Redi", 21, "1CA", "EKONOMIST");
            Menaxheri m2 = new Menaxheri("Atdhe", 21, "1CA", "SHEF I VETEVETES");

            Koordinatori k1 = new Koordinatori("Leo", 23, 2);
            Koordinatori k2 = new Koordinatori("Rea", 24, 4);

            n.shtoPunetor(d);
            n.shtoPunetor(sh1);
            n.shtoPunetor(sh2);
            n.shtoPunetor(m1);
            n.shtoPunetor(m2);
            n.shtoPunetor(k1);
            n.shtoPunetor(k2);

            System.out.println("Kualifkimi");
            n.getKualifikimet();
            System.out.println("Ndermarrja i ka te gjitha llojet e punetoreve: " + 
            n.kaTeGjithaLlojet());
            System.out.println("");
            n.shfaq();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
