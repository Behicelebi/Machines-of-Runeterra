import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Oyuncu {

    public String oyuncuAdi;
    int oyuncuID, skor;
    public List<SavasAraclari> kartListesi = new ArrayList<>();
    public ArrayList<Integer> placed_cards = new ArrayList<>();
    static Random random = new Random();

    Oyuncu(int oyuncuID, String oyuncuAdi, int skor){
        this.oyuncuAdi = oyuncuAdi;
        this.oyuncuID = oyuncuID;
        this.skor = skor;
        for (int i = 0; i < 3; i++) {placed_cards.add(-1);}
    }

    Oyuncu(){
        this.oyuncuAdi = "NULL";
        this.oyuncuID = -1;
        this.skor = 0;
    }

    public void SkorGoster(){}
    public void kartSec(int a, int b){
        if(oyuncuID==0){
            int store1=-1, store2=-1;
            for (int i = 0; i < 3; i++) {
                int rand;
                while(true){
                    rand = random.nextInt(kartListesi.size());
                    if(rand==store1 || rand==store2){continue;}
                    break;
                }
                store2 = store1;
                store1 = rand;
                placed_cards.set(i, rand);
            }
        }
        else if(oyuncuID==1){
            placed_cards.set(a,b);
        }
    }
}
