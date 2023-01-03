package ArrayLists.Dyqani;

public class Enelaresja extends PajisjaElektrike implements Perdoret{
    private int nrProgrameve;

    public Enelaresja(String numriSerik, String prodhuesi, int voltazhi, char kategoriaShpenzuese, int nrProgrameve)
            throws PajisjaException {
        super(numriSerik, prodhuesi, voltazhi, kategoriaShpenzuese);
        if (nrProgrameve < 0 && nrProgrameve >= 12) {
            throw new PajisjaException("Numri i programeve te nje Enelarese mund te jete prej 1-12");
        }
        this.nrProgrameve = nrProgrameve;
    }

    public int getNrProgrameve() {
        return nrProgrameve;
    }public void setNrProgrameve(int nrProgrameve) throws PajisjaException{
        if (nrProgrameve < 0 && nrProgrameve >= 12) {
            throw new PajisjaException("Numri i programeve te nje Enelarese mund te jete prej 1-12");
        }
        this.nrProgrameve = nrProgrameve;
    }

    @Override
    public boolean kaBateri() {
        return false;
    }

    @Override
    public String getPerdorimi() {
        return " Shtepiak ";
    }

    @Override
    public String toString() {
        return "Enelaresja me " + nrProgrameve + " programe " + super.toString();
    }

}
