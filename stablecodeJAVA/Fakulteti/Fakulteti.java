public class Fakulteti {
    private String drejtimi;
    protected Mesimdhenesi [] mesimdhenesit;
    int index= 0;
    
    public Fakulteti (String drejtimi, int nrM) {
        this.drejtimi=drejtimi;
        mesimdhenesit =new Mesimdhenesi[nrM];
    }

    public boolean egziston(Mesimdhenesi m) {
        for (int i = 0; i < index; i++) {
            if (mesimdhenesit[i].equals(m)) {
                return true;
            }
        }
        return false;
    }

    public void shtoMesimdhenesi(Mesimdhenesi m) {
        if(m == null) {
            System.out.println("Mesimdhenesi nuk pranon keto parametra.");
        }
        if(index == mesimdhenesit.length) {
            System.out.println("Mesimdhenesi nuk mund te shtohet pasi vargu eshte mbushur.");
        }
        if(egziston(m)) {
            System.out.println("Mesimdhenesi egziston ne varg");
        }
        mesimdhenesit[index++] = m;
    }

    public Mesimdhenesi thirrjaMeEVjeter() {
        Mesimdhenesi meIVjeter = null;

        for (int i = 0; i < index; i++) {
            
            if(meIVjeter == null || mesimdhenesit[i].getVitiLindjes() < meIVjeter.getVitiLindjes()) {
                meIVjeter=mesimdhenesit[i];
            }
        }
        return meIVjeter;
    }

    
    // public void shtypMentoret(String mentoron) {
    //     for (int i = 0; i < index; i++) {
    //         if (mesimdhenesit[i] instanceof Profesori) {
    //             Mesimdhenesi en =mesimdhenesit[i];
    //             if (en.mentoron() == mentoron) {
    //                 System.out.println(en);
    //             }
    //         }
    //     }
    // }

    public void printALL() {
        for (int i = 0; i < mesimdhenesit.length; i++) {
            System.out.println(i + "." + mesimdhenesit[i]);
        }
    }

    public static void main(String[] args) {
        Fakulteti f1 = new Fakulteti("Shkenca Kompjuterike", 15);

        Profesori p1 = new Profesori("Zhilbert Tafa", 1982, "Rrjeta Kompjuterike", "Profesor");
        Profesori p2 = new Profesori("Blerim Blerimi", 1989, "Shkenca Kompjuterike 2", "Profesor");
        Profesori p3 = new Profesori("Lavda", 1990, "Shkenca Kompjuterike 2", "Profesor");
        Profesori p4 = new Profesori("Ramiz Sahiti", 1980, "Inxhinieri dhe Web", "Profesor");
        Profesori p5 = new Profesori("Azir Jusufi", 1985, "Struktura Diskrete", "Profesor");
        Asistenti a1 = new Asistenti("Dion", 1994, "Ushtrime", "Shkenca Kompjuterike");
        Asistenti a2 = new Asistenti("Elton", 1993, "Ushtrime", "Shkenca Kompjuterike");
        Asistenti a3 = new Asistenti("Rion", 1992, "Ushtrime", "Shkenca Kompjuterike");
        Asistenti a4 = new Asistenti("Albert", 1995, "Ushtrime", "Shkenca Kompjuterike");
        Asistenti a5 = new Asistenti("Leon", 1992, "Ushtrime", "Rrjeta Kompjuterike");

        f1.shtoMesimdhenesi(p1);
        f1.shtoMesimdhenesi(p2);
        f1.shtoMesimdhenesi(p3);
        f1.shtoMesimdhenesi(p4);
        f1.shtoMesimdhenesi(p5);
        f1.shtoMesimdhenesi(a1);
        f1.shtoMesimdhenesi(a2);
        f1.shtoMesimdhenesi(a3);
        f1.shtoMesimdhenesi(a4);
        f1.shtoMesimdhenesi(a5);

        System.out.println("if true atehere egziston Asistenti i pare 'a1' ; " + f1.egziston(a1));
        System.out.println("");
        System.out.println("Lista e te gjithe mesimdhenesve:");
        f1.printALL();

    }


}
