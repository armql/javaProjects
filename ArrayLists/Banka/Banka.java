package ArrayLists.Banka;

import java.util.ArrayList;

public class Banka {
    private String emri;
    private ArrayList<LlogariaRrjedhese> llogariRrjedhese;
    private ArrayList<LlogariaKursyese> llogariKursimi;
    private String fileIn;
    private String fileOut;

    public Banka(String emri,String fileIn, String fileOut) throws LlogariaException {
        this.emri=emri;
        llogariRrjedhese = new ArrayList<LlogariaRrjedhese>();
        llogariKursimi = new ArrayList<LlogariaKursyese>();
    }

    
}
