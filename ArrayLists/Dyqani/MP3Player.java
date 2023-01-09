package ArrayLists.Dyqani;

public class MP3Player extends PajisjaElektrike implements Perdoret{
    private int memory;

    public MP3Player(String numriSerik, String prodhuesi, int voltazhi, char kategoriaShpenzuese, int memory)
            throws PajisjaException {
        super(numriSerik, prodhuesi, voltazhi, kategoriaShpenzuese);
        if (memory < 0 || memory >= 4096) {
            throw new PajisjaException("MP3Player mund te kete max 4GB");
        }
        this.memory = memory;
    }

    public int getMemory() {
        return memory;
    }public void setMemory(int memory) throws PajisjaException{
        if (memory < 0 || memory >= 4096) {
            throw new PajisjaException("MP3Player mund te kete max 4GB");
        }
        this.memory = memory;
    }

    public boolean kaBateri() {
        return true;
    }

    public String getRekuizita() {
        return "Argetues";
    }

    public String toString() {
        int ram;
        ram = memory;
        if (ram != 256) {
            System.out.println("RAM:256MB");
        }
        else if (ram == 512) {
            System.out.println("RAM: 512MB");
        }
        else if (ram == 1024) {
            System.out.println("RAM: 1GB");
        }
        else if (ram == 2048) {
            System.out.println("RAM: 2GB");
        }
        else if (ram == 3072) {
            System.out.println("RAM: 3GB");
        }
        else if (ram == 4096) {
            System.out.println("RAM: 4GB");
        }else {
            System.out.println("Memory stick out of bounds");
        }
        
        return "MP3Player " + super.toString() + " : " + ram;
    
    }

}
