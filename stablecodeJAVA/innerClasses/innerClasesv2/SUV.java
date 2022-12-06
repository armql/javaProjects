package innerClasses.innerClasesv2;

public class SUV extends Automjeti {
    private boolean eshte4x4;

    public SUV(String nrShasise, String prodhuesi, int vitiProdhimit, boolean eshte4x4) {
        super(nrShasise, prodhuesi, vitiProdhimit);
        this.eshte4x4 = eshte4x4;
    }

    @Override
    public boolean eshteAutomatik() {
        return false;
    }

    @Override
    public String toString() {
        return "SUV " + super.toString() + " : " + (eshte4x4? "Eshte 4x4" : "Nuk eshte 4x4");
    }
    
}
