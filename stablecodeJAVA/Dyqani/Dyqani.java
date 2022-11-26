package Dyqani;

public class Dyqani{
    protected String emri;
    protected Pajisja [] pajisjet;
    int index=0;

    public Dyqani(String emri, int nrP) {
        this.emri = emri;
        pajisjet= new Pajisja[nrP] ;
    }

    public boolean egzistonPajisja(Pajisja p) {
       
        for (int i = 0; i < index; i++) {
            if (pajisjet[i].equals(p)){
                return true;
            }
        }   
        return false;
    }

    public void shtoPajisjen(Pajisja p) {
        
        if (p == null) {
            System.out.println("Nuk mundet te shtohet ne sistem.");
            return;
        }
        if (index >= pajisjet.length) {
            System.out.println("Nuk ka vend te shtohet ne sistem.");
            return;
        }
        if (egzistonPajisja(p)) {
            System.out.println("Pajisja egziston ne sistem.");
            return;
        }
        pajisjet[index++] = p;

    }

    public void shtypEnelarese(char kategoria) {
        for (int i = 0; i < index; i++) {
            if (pajisjet[i] instanceof Enelaresja) {
                Enelaresja en =(Enelaresja)pajisjet[i];
                if (en.getKategoriaShpenzuese() == kategoria) {
                    System.out.println(en);
                }
            }
        }
    }

    public void shtypMp3Voltazhi(int voltazhi) {
        for (int i = 0; i < index; i++) {
            if (pajisjet[i] instanceof MP3Player) {
                MP3Player mp3 =(MP3Player)pajisjet[i];
                if (mp3.getVoltazhi() == voltazhi) {
                    System.out.println(mp3);
                }
            }
        }
    }


    public boolean fshijPajisjen(Pajisja p){

        for(int i = 0; i < index; i++){
            if(p.equals(pajisjet[i])){
                for(int j = i; j < index-1; j++){
                    pajisjet[j] = pajisjet[j+1];
                }
                pajisjet[--index] = null;
                i--;
                return true;
            }
        }
        return false;
    }

    public void printoPajisjet() {
        for (int i = 0; i < pajisjet.length; i++) {
            System.out.println(i + "." + pajisjet[i]);
        }
    }

    public Pajisja[] ktheNumriProgrameve(int param){
        if(index == 0){
            System.out.println("Ky dyqan nuk ka asnje Pajisje/e!");
            return null;
        }

        Pajisja[] spEmri = null;
        int count = 0;
        for(int i = 0; i < index; i++){
            if (pajisjet[i] instanceof Enelaresja) {
                Enelaresja enlr =(Enelaresja)pajisjet[i];
                if(enlr.getNrProgrameve() == param){
                    count++;
                }
            }
        }

        if(count == 0){
            System.out.println("Ne kete Dyqan, asnje Pajisje nuk i fillon nrProgrameve me: " + param);
            return null;
        }

        spEmri = new Pajisja[count];
        int pozita = 0;
        for(int i = 0; i < index; i++){
            if (pajisjet[i] instanceof Enelaresja) {
            Enelaresja enlr =(Enelaresja)pajisjet[i];    
                if(enlr.getNrProgrameve() == param){
                    spEmri[pozita++] = pajisjet[i];
                }
            }
        }

        return spEmri;
    }

    public boolean fshijSipasMemories(int memoria){
       
        for(int i = 0; i < index; i++){
            if (pajisjet[i] instanceof MP3Player) {
                MP3Player mp3 =(MP3Player)pajisjet[i]; 
                if(mp3.getMemoria() == memoria){
                    
                    for(int j = i; j < index-1; j++){
                        pajisjet[j] = pajisjet[j+1];
                    }
                    pajisjet[--index] = null;
                    i--;
                    return true;
                }
            }
        }

        return false;
    }


    public static void main(String[] args) {
        Dyqani d1 = new Dyqani("ABC Shop", 25);

        Enelaresja e1  = new Enelaresja(1, "Acer", 350, 'A', 2);
        Enelaresja e2  = new Enelaresja(2, "Gorenje", 280, 'B', 2);
        Enelaresja e3  = new Enelaresja(3, "Beko", 250, 'B', 2);
        Enelaresja e4  = new Enelaresja(4, "Samsung", 285, 'D', 3);
        MP3Player player1 = new MP3Player(11, "Tooch", 8, 'C', 1);
        MP3Player player2 = new MP3Player(12, "Samsung", 12, 'A', 4); 
        MP3Player player3 = new MP3Player(13, "Apple", 8, 'A', 4); 
        MP3Player player4 = new MP3Player(14, "Ipod", 12, 'D', 1); 
        d1.shtoPajisjen(e1);
        d1.shtoPajisjen(e2);
        d1.shtoPajisjen(e3);
        d1.shtoPajisjen(e4);
        d1.shtoPajisjen(player1);
        d1.shtoPajisjen(player2);
        d1.shtoPajisjen(player3);
        d1.shtoPajisjen(player4);
        System.out.println("");
        System.out.println("Gjej pajisjet me ecoKategori A:");
        d1.shtypEnelarese('A'); 
		System.out.println("");
        System.out.println("Gjej pajisjet me tension 250V:");
        d1.shtypMp3Voltazhi(250);
	

        System.out.println("");
        System.out.println("Lista e pajisjeve tani:");
        d1.printoPajisjet();

        System.out.println("");
        System.out.println("Fshihet pajisja sipas memories 1:");
        d1.fshijSipasMemories(1);
        
        System.out.println("");
        System.out.println("Lista pas fshirjes:");
        d1.printoPajisjet();
        
        System.out.println("");
        System.out.println("KtheNrProgrameve:");
        Pajisja[] temp1 = d1.ktheNumriProgrameve(3);
		for(Pajisja a : temp1){
			System.out.println(a.toString());
		}

        

    }
    
}
