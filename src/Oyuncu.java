import java.util.List;

public class Oyuncu {

    public String oyuncuAdi;
    int oyuncuID, skor;
    protected List<SavasAraclari> kartListesi;

    Oyuncu(int oyuncuID, String oyuncuAdi, int skor){
        this.oyuncuAdi = oyuncuAdi;
        this.oyuncuID = oyuncuID;
        this.skor = skor;
    }

    public void SkorGoster(){}
    public void kartSec(){}
}
