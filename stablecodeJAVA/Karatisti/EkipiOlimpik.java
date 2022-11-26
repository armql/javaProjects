package Karatisti;
public class EkipiOlimpik {
    protected String emri;
    Sportisti [] sportistat;
    int index = 0;    


    public EkipiOlimpik(String emri2,int nrS) {
        emri = emri2;
        sportistat = new Sportisti[nrS];
    }


    public boolean egzistonSportisti(Sportisti s) {
        for (int i = 0; i < index; i++) {
            if (sportistat[i].equals(s)){
                return true;
            }
        }
        return false;
    }

    public void shtoSportisti(Sportisti s){
        if (s == null) {
            System.out.println("Sportisti nuk pranon kto parametra.");
        }

        if (index >= sportistat.length) {
            System.out.println("Sportisti nuk mund te shtohet lista eshte mbushur.");
        }
        if(egzistonSportisti(s)) {
            System.out.println("Sportisti tashme egziston.");
        }
        sportistat[index++] = s;
    }

    public void getFutbollistetgjinia(char gjinia) {
        if (index == 0) {
            System.out.println("Nuk egziston");
            return;
        }

        for (int i=0; i<index; i++) {
            if (sportistat[i] instanceof Futbollisti) {
            Futbollisti krtl =(Futbollisti)sportistat[i]; 
            
                if(sportistat[i].getGjinia() == gjinia )  {
                    System.out.println(sportistat[i]);
                }
            }
        }
    
    }
    
    public Sportisti shtypKaratistetMeTeRi() {
        Sportisti meIRi = sportistat[0];
        int moshaCaktuar = 34;

        for (int i = 0; i<index; i++) {
            if (sportistat[i] instanceof Karatisti) {
            Karatisti krtl =(Karatisti)sportistat[i]; 
                if(krtl.getMosha() < moshaCaktuar){
                    meIRi=sportistat[i];
                }
            }
        }
        return meIRi;
    }

    public boolean largoSportistin(Sportisti s){
        if(s==null){
            System.out.println("Sportisti eshte null");
            return false;
        }
        
        for(int i=0;i<index;i++){
            if(sportistat[i]!=null&&sportistat[i].equals(s)){
                for(int j=i;j<index;j++){
                    sportistat[j]=sportistat[j+1];
                }
            
                sportistat[index--]=null;
                return true;
            }
        }
        return false;
    }

    public boolean fshijSipasStilit(String stili){
       
        for(int i = 0; i < index; i++){
            if (sportistat[i] instanceof Karatisti) {
                Karatisti krtl =(Karatisti)sportistat[i]; 
                if(krtl.getStili().equals(stili)){
                    
                    for(int j = i; j < index-1; j++){
                        sportistat[j] = sportistat[j+1];
                    }
                    sportistat[--index] = null;
                    i--;
                    return true;
                }
            }
        }

        return false;
    }

   
    public void printAll(){
        for(int i=0;i<sportistat.length;i++){
            System.out.println(i+"."+sportistat[i]);
        }
    }

    public static void main(String[] args) {
        EkipiOlimpik e1 = new EkipiOlimpik("Kosova Team", 25);

        Sportisti s1 = new Sportisti(212210, "David",'M',30);
        Sportisti s2 = new Sportisti(212211, "Blaine",'M',28);
        Sportisti s3 = new Sportisti(212212, "Robert",'M',31);
        Sportisti s4 = new Sportisti(212213, "Lorraine",'F',31);
        Sportisti s5 = new Sportisti(212214, "John",'M',32);
        Sportisti s6 = new Sportisti(212215, "Albert",'M',27);
        Sportisti s7 = new Sportisti(212216, "Rio",'M',30);
        Sportisti s8 = new Sportisti(212217, "Vin",'M',30);
        Sportisti s9 = new Sportisti(212218, "Lianne",'F',28);
        Futbollisti f1 = new Futbollisti(3, 212210, "Robin", 'F', 32);
        Futbollisti f2 = new Futbollisti(4, 212211, "Leon", 'M', 30);
        Karatisti k1 = new Karatisti(212210, "Majlinda", 31, 'F', "Judo");
        Karatisti k2 = new Karatisti(212211, "Luan", 27, 'M', "Judo");
        Karatisti k3 = new Karatisti(212212, "Kelmend", 29, 'M', "Boks");
        

        e1.shtoSportisti(s1);
        e1.shtoSportisti(s2);
        e1.shtoSportisti(s3);
        e1.shtoSportisti(s4);
        e1.shtoSportisti(s5);
        e1.shtoSportisti(s6);
        e1.shtoSportisti(s7);
        e1.shtoSportisti(s8);
        e1.shtoSportisti(s9);
        e1.shtoSportisti(f1);
        e1.shtoSportisti(f2);
        e1.shtoSportisti(k1);
        e1.shtoSportisti(k2);
        e1.shtoSportisti(k3);
        System.out.println("");
        System.out.println("Sportisti me i ri ne ekipen e sportit te Kosoves:");
        System.out.println(e1.shtypKaratistetMeTeRi());
        System.out.println("");
        System.out.println("Lista e Femrave ne ekipen e sportit te Kosoves:");
        e1.getFutbollistetgjinia('F');
        System.out.println("");
        System.out.println("Lista e Meshkujve ne ekipen e sportit te Kosoves:");
        e1.getFutbollistetgjinia('M');

        System.out.println("");
        System.out.println("metoda fshijSipasStilit");
        e1.fshijSipasStilit("Boks");
        System.out.println("");
        System.out.println("");
        e1.printAll();
        
        


        
        


    }



}
