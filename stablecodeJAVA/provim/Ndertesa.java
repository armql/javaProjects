package provim;

public class Ndertesa {
    private String A11;
    private Apartamenti [] apartamentet;
    int index;

    public Ndertesa(String A11,int nrA) {
        this.A11=A11;
        apartamentet = new Apartamenti[nrA];
    }

    public boolean egzistonA(Apartamenti a) {
        for (int i = 0; i < index; i++) {
            if(apartamentet[i].equals(a)){
                return true;
            }
        }
        return false;
    }

    public void regjistroApartamentin(Apartamenti a){
        if(a == null) {
            System.out.println("Apartamenti eshte NULL.");
        }
        if(index == apartamentet.length) {
            System.out.println("Vargu eshte i mbushur me apartamente.");
        }
        if(egzistonA(a)){
            System.out.println("Apartamenti egziston ne varg");
        }
        apartamentet[index++] = a;
    }

    public boolean fshijApartamentin(double siperfaqja) {
        for (int i = 0; i<index; i++) {
            if(apartamentet[i].getSiperfaqja() == siperfaqja){
                for (int j = i; j<index; j++) {
                    apartamentet[j] = apartamentet[j + 1];
                }
                apartamentet[index--] = null;
                i--;
                return true;
            }
        }
        return false;
    }

    public void getNrSipasSiperfaqes(double siperfaqja) {
        for (int i = 0; i<index; i++) {
            if(apartamentet[i].getSiperfaqja() < siperfaqja){
                System.out.println(i + "." + apartamentet[i]);
            }
        }
    }

    public void getTotali() {
        for (int i = 0; i < apartamentet.length; i++) {
            if(index == apartamentet.length) {
                System.out.println(index);
            }
        }
    }

    public void cmimiMesatar(boolean kaDepo){
        if(!kaDepo) {
              
        }
    }

    
}
