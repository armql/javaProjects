package provim;

public class Autosalloni {
    private String emri;
    private Vetura [] veturat;
    int index;

    public Autosalloni(String emri,int nrV) {
        this.emri=emri;
        veturat = new Vetura[nrV];
    }

    public boolean egzistonVetura(Vetura v) {
        for (int i = 0; i < index; i++) {
            if(veturat[i].equals(v)) {
                return true;
            }
        }
        return false;
    }

    public void shtoVetura(Vetura v) {
        if(v == null) {
            System.out.println("Vetura nuk mund te shtohet -NULL.");
        }
        if(index == veturat.length) {
            System.out.println("Vetura nuk mundet te shtohet sepse vargu eshte mbushur.");
        }
        if(egzistonVetura(v)) {
            System.out.println("Vetura nuk mund te shtohet sepse vargu eshte mbushur.");
        }
        veturat[index++] = v;
    }

    public void shtypModelet(String modeli) {
        for (int i = 0; i < index; i++) {
            if(veturat[i].getModeli().equals(modeli)) {
                System.out.println(veturat[i]);
            }
        }
    }

    public Vetura getOldTimer(int vitiProdhimit) {
        Vetura oldtimer = veturat[0];

        for (int i=0; i<index; i++) {
            if(oldtimer == null || veturat[i].getVitiProdhimit() < vitiProdhimit) {
                oldtimer=veturat[i];
            }
        }
        return oldtimer;
    }

    public boolean fshijVeturat(int vitiProdhimit) {
        for (int i = 0; i < index; i++) {
            if(veturat[i].getVitiProdhimit() == vitiProdhimit) {
                for (int j = i; j < index; j++) {
                    veturat[j] = veturat[j + 1]; 
                }
            }
            veturat[--index] = null;
            i--;
            return true;
        }
        return false;
    }


}
