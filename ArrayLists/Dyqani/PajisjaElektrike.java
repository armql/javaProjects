package ArrayLists.Dyqani;

public abstract class PajisjaElektrike extends Pajisja{
    private int voltazhi;
    private char kategoriaShpenzuese;

    public abstract boolean kaBateri();

    public PajisjaElektrike(String numriSerik, String prodhuesi, int voltazhi, char kategoriaShpenzuese) throws PajisjaException {
        super(numriSerik, prodhuesi);
        if(voltazhi < 80 && voltazhi > 1200) {
            throw new PajisjaException("Pajisja Elektrike duhet te jete 80 min - 1200 max volt.");
        }
        this.voltazhi = voltazhi;
        this.kategoriaShpenzuese=kategoriaShpenzuese;
    }

    public int getVoltazhi() {
        return voltazhi;
    }public void setVoltazhi(int voltazhi) {
        this.voltazhi = voltazhi;
    }

    @Override
    public String toString() {
        char kategoria;
        kategoria = kategoriaShpenzuese;
        if (kategoria == 'A' || kategoria == 'B' || kategoria == 'C') {
            System.out.println("(Kategori eficiente dhe e pranueshme.)");
        }
        if (kategoria == 'D') {
            System.out.println("(Mesatarisht e mire mirepo jo mjaftueshem.)");
        }
        if (kategoria == 'E' || kategoria == 'F' || kategoria == 'G') {
            System.out.println("(Kategori jo eficiente dhe e pa pranueshme.)");
        }
        return super.toString() + " " + voltazhi + "V - " + kategoriaShpenzuese + kategoria;
    }

}
