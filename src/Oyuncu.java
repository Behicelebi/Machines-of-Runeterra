import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Oyuncu {

    public String oyuncuAdi;
    int oyuncuID, skor;
    public List<SavasAraclari> kartListesi = new ArrayList<>();
    public ArrayList<Integer> placed_cards = new ArrayList<>();
    public ArrayList<Boolean> disabled_cards = new ArrayList<>();
    public ArrayList<Boolean> temp_disabled_cards = new ArrayList<>();
    static Random random = new Random();
    boolean disable_reset = false;

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

    public void SkorGoster(Graphics g){
        if(oyuncuID==0){g.drawString(oyuncuAdi + " : " + skor,20,700/2-140);}
        else if (oyuncuID==1){g.drawString(oyuncuAdi + " : " + skor,20,700/2+150);}
    }
    public void kartSec(int a, int b){
        if(oyuncuID==0){
            int store1=-1, store2=-1;
            for (int i = 0; i < 3; i++) {
                int rand = -1;
                while(true){
                    ArrayList<Integer> enabled_cards = new ArrayList<>();
                    for (int j = 0; j < disabled_cards.size(); j++) {if(disabled_cards.get(j)){enabled_cards.add(j);}}

                    if(enabled_cards.size()>=3){rand = random.nextInt(kartListesi.size());}
                    else if(enabled_cards.size()==2){
                        if(store1==-1){
                            rand = random.nextInt(2);
                            rand = enabled_cards.get(rand);
                        }else{
                            for (int j = 0; j < enabled_cards.size(); j++) {
                                if(enabled_cards.get(j)!=store1){
                                    rand = enabled_cards.get(j);
                                    for (int k = 0; k < disabled_cards.size(); k++) {disabled_cards.set(k,true);}
                                    break;
                                }
                            }
                        }
                        break;
                    } else {
                        rand = enabled_cards.get(0);
                        for (int j = 0; j < disabled_cards.size(); j++) {disabled_cards.set(j,true);}
                    }

                    if(rand==store1 || rand==store2 || !disabled_cards.get(rand)){continue;}
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
