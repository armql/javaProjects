package Libri;

public class Biblioteka {
    private String Libra;
    private Libri [] librat;
    int index= 0;

    public Biblioteka(String Libra,int nrL) {
        this.Libra=Libra;
        librat = new Libri[nrL];
    }

    public boolean egziston(Libri l) {
        for (int i = 0; i < index; i++) {
            if (librat[i].equals(l)){
                return true;
            }
        }
        return false;
    }

    public void shtoLibra(Libri l) {
        if (l == null) {
            System.out.println("Libri nuk mund te shtohet me keto parametra.");
        }
        if (index == librat.length) {
            System.out.println("Eshte mbushur vargu me libra");
        }
        if(egziston(l)){
            System.out.println("Libri egziston ne varg");
        }
        librat[index++] = l;
    }

    public Libri meIRiuMeDetyra() {
        Libri meIRi=null;

        for (int i = 0; i < index; i++) {
            if(librat[i].kaDetyra() == true) {
                if(meIRi == null || librat[i].getVitiPublikimit() > meIRi.getVitiPublikimit()){
                    meIRi=librat[i];
                }
            }
        }
        return meIRi;
    }    
    
    public void shtypLibratEVitit(int viti) {
        for (int i = 0; i < index; i++) {
            if (librat[i] instanceof LibriShkollor) {
                LibriShkollor ls = (LibriShkollor)librat[i];
            }
            if(librat[i].getVitiPublikimit() == viti) {
                System.out.println(librat[i]);
            }
        }
    }
    
    public void shtypEnciklopediaTitulli() {
        for (int i = 0; i < index; i++) {
            if (librat[i] instanceof Enciklopedia) {
                Enciklopedia enc =(Enciklopedia)librat[i];
                if (enc.getTitulli().equals("A")) {
                    System.out.println(enc);
                }
            }
        }
    }

    
    public boolean fshijLibrin(Libri l) {

        for (int i = 0; i < index; i++) {
            if(l.equals(librat[i])) {

                for (int j = i; j < index; j++) {
                    librat[j] = librat[j + 1];
                }
                librat[--index] = null;
                i--;
                return true;
            }
        }
        return false;
    }

    public int fshijLibrinSipTitullit(String titulli) {
        int count = 0;
        for (int i = 0; i < index; i++) {
            
            if(librat[i].getTitulli().equals(titulli)) {
                count++;
                for (int j = i; j < index; j++) {
                    librat[j] = librat[j + 1];
                }
                
                librat[--index] = null;
                i--;
            }
        }
        return count;

    }


    public void printALL() {
        for (int i = 0; i < librat.length; i++) {
            System.out.println(i + " . " + librat[i]);
        }
    }

    // public void printls() {
    //     for (int i = 0; i < index; i++) {
    //         librat[i] = librat[i] - index;
    //     }
    // }

    public static void main(String[] args) {
        Biblioteka b = new Biblioteka("UBT Library", 10);

        LibriShkollor l1 = new LibriShkollor("1351531531", "BIEE", 2017, "Basics of EE");
        LibriShkollor l2 = new LibriShkollor("343123521", "BIEE4", 2002, "Basics of EE");
        LibriShkollor l3 = new LibriShkollor("531631", "BIEE 6", 2002, "Basics of EE");
        Enciklopedia e1 = new Enciklopedia("1241241253", "WIKI I", 2022, 3);
        Enciklopedia e2 = new Enciklopedia("45232131", "WIKI", 1992, 3);
        Enciklopedia e3 = new Enciklopedia("646124125", "WIKI", 1992, 3);
        Enciklopedia e4 = new Enciklopedia("643235122", "WIKI III", 1992, 3);
    
        b.shtoLibra(l1);
        b.shtoLibra(l2);
        b.shtoLibra(l3);
        b.shtoLibra(e1);
        b.shtoLibra(e2);
        b.shtoLibra(e3);
        b.shtoLibra(e4);
        System.out.println("Printohet e gjith lista");
        System.out.println("");
        b.printALL();
        //METODA MEIRIU
        System.out.println("");
        System.out.println("Printohet me i riu me detyra");
        System.out.println(b.meIRiuMeDetyra());
        System.out.println("");
        System.out.println("Shtypet titulli Enciklopedia");
        b.shtypEnciklopediaTitulli();
        System.out.println("Fshij librin l2");
        b.fshijLibrin(l2);
        System.out.println("Fshij librin sipasTitullit");
        b.fshijLibrinSipTitullit("WIKI");
        System.out.println("");
        System.out.println("Printohet e gjith lista");
        b.printALL();
        


    
    }

}
