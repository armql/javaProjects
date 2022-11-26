package Publikimi;

import javax.crypto.interfaces.PBEKey;

public class Biblioteka {
    private String emri;
    private Publikimi [] publikimet;
    int index;

    public Biblioteka(String emri,int nrP) {
        this.emri=emri;
        publikimet = new Publikimi[nrP];
    }

    public boolean egzistonP(Publikimi p) {
        for (int i = 0; i < index; i++) {
            if (publikimet[i].equals(p)) {
                return true;
            }
        }
        return false;
    }

    public void shtoPublikimin(Publikimi p) {
        if(p == null) {
            System.out.println("Ky publikim eshte NULL");
        }
        if(index == publikimet.length) {
            System.out.println("Vargu eshte i mbushur ne publikime");
        }
        if(egzistonP(p)) {
            System.out.println("Publikimi egziston ne varg.");
        }
        publikimet[index++] = p;
    }

    public Publikimi digjitaliMeIVjeter(boolean b) {
        Publikimi meiVjeter = publikimet[0];
        
        for (int i=0; i<index; i++) {
            if(publikimet[i].eshteDigjitale() == b) {
                if(meiVjeter == null || publikimet[i].getVitiPublikimit() < meiVjeter.getVitiPublikimit()) {
                    meiVjeter=publikimet[i];
                }
            }
        }
        return meiVjeter;
    }

    public Libri[] libratDetyra(boolean b) {
        
        int count = 0 ;
        for (int i = 0; i < index; i++) {
            if(publikimet[i] instanceof Libri) {
                Libri l =(Libri)publikimet[i];
                if(l.kaDetyra() == b) {
                    count++;
                }
            }
        }

        Libri [] librat = new Libri[count];
        int pozita=0;
        for (int i = 0; i < index; i++) {
            if(publikimet[i] instanceof Libri) {
                Libri l =(Libri)publikimet[i];
                if(l.kaDetyra() == b) {
                    librat[pozita++]=l;
                }
            }
        }

        return librat;
    }


    public void shtypJournalVolum(int nrVolumit) {
        for (int i = 0; i <index; i++) {
            if(publikimet[i] instanceof Journal) {
                Journal jrn =(Journal)publikimet[i];
                if(jrn.getNrVolumit() == nrVolumit) {
                    System.out.println(publikimet[i]);
                }
            }
        }
    }

    public void printAll() {
        for (int i = 0; i < publikimet.length; i++) {
            System.out.println(i + "." + publikimet[i]);
        }
    }

    public static void main(String[] args) {
        Biblioteka b1 = new Biblioteka("UBT Library", 15);

        Enciklopedia e1 = new Enciklopedia("531521", "ead", 2002, 120, 2);
        Enciklopedia e2 = new Enciklopedia("241253", "e343d", 1975, 240, 3);
        Enciklopedia e3 = new Enciklopedia("241222", "e343d", 2000, 240, 3);
        Journal j1 = new Journal("135215", "et", 2012, 4);
        Journal j2 = new Journal("135215", "et", 2021, 2);
        Journal j3 = new Journal("135215", "et", 2004, 7);


        b1.shtoPublikimin(e1);
        b1.shtoPublikimin(e2);
        b1.shtoPublikimin(e3);
        b1.shtoPublikimin(j1);
        b1.shtoPublikimin(j2);
        b1.shtoPublikimin(j3);
        System.out.println("E gjithe lista");
        b1.printAll();
        System.out.println("");
        System.out.println("metoda shtypJournalVolum");
        b1.shtypJournalVolum(2);
        System.out.println("");
        System.out.println("metoda digjitaliMeIVjeter");
        System.out.println(b1.digjitaliMeIVjeter(false));
        System.out.println("");
        System.out.println("metoda libratDetyra");
        System.out.println("");
        System.out.println(b1.libratDetyra(false));
    }





}
