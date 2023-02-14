package SHK2;

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

            if(countSh != 0 && countK !=0 && countM != 0 && countD != 0){
                return true;
            }
            else{
                return false;
            }
        }
    }

    public void shfaq() {
        for (int i = 0; i < index; i++) {
            System.out.println(punetoret[i].getEmri() + " " + punetoret[i].getMosha());
        }
    }


    public static void main(String[] args) {
        
    }
}
