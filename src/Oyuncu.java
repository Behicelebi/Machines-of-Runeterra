import java.util.ArrayList;
import java.util.List;

public class Oyuncu {

    public String oyuncuAdi;
    int oyuncuID, skor;
    protected List<SavasAraclari> kartListesi = new ArrayList<>();

    Oyuncu(int oyuncuID, String oyuncuAdi, int skor){
        this.oyuncuAdi = oyuncuAdi;
        this.oyuncuID = oyuncuID;
        this.skor = skor;
    }

    Oyuncu(){
        this.oyuncuAdi = "NULL";
        this.oyuncuID = -1;
        this.skor = 0;
    }

    public void SkorGoster(){}
    public void kartSec(){}
}
