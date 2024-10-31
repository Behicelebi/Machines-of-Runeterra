import java.util.Random;

public class Oyun {

    public int toplamHamleSayisi = 5;
    public static Oyuncu insan;
    public static Oyuncu bilgisayar;
    static Random random = new Random();

    public static void main(String[] args) {
        insan = new Oyuncu(1,"Oyuncu",0);
        bilgisayar = new Oyuncu(0,"Bilgisayar",0);
        for (int i = 1; i <= 12; i++) {
            int select = random.nextInt(6);
            SavasAraclari Select = null;
            switch(select){
                case 0:
                    Select = new Ucak(0,"Hava");
                    break;
                case 1:
                    Select = new Siha(0,"Hava");
                    break;
                case 2:
                    Select = new Obus(0,"Kara");
                    break;
                case 3:
                    Select = new KFS(0,"Kara");
                    break;
                case 4:
                    Select = new Firkateyn(0,"Deniz");
                    break;
                case 5:
                    Select = new Sida(0,"Deniz");
                    break;
                default:
                    break;
            }
            if(i>6){insan.kartListesi.add(Select);}
            else{bilgisayar.kartListesi.add(Select);}
        }
        new Frame(Oyun.insan,Oyun.bilgisayar);
    }

    public void SaldiriHesapla(){}
}