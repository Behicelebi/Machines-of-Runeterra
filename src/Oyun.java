import java.util.Random;

public class Oyun {

    public static int toplamHamleSayisi = 5;
    public static Oyuncu insan;
    public static Oyuncu bilgisayar;
    static Random random = new Random();

    public static void main(String[] args) {
        insan = new Oyuncu(1,"Player",0);
        bilgisayar = new Oyuncu(0,"Computer",0);
        kartDagit(insan, 6);
        kartDagit(bilgisayar, 6);
        new Frame(Oyun.insan,Oyun.bilgisayar);
    }

    public static int SaldiriHesapla(SavasAraclari A, SavasAraclari B){
        if (A instanceof Siha temp && B instanceof DenizSinifi temp2){
            return temp.vurus + temp.denizVurusAvantaji();
        } else if (A instanceof KFS temp && B instanceof HavaSinifi temp2) {
            return temp.vurus + temp.havaVurusAvantaji();
        } else if (A instanceof Sida temp && B instanceof KaraSinifi temp2) {
            return temp.vurus + temp.karaVurusAvantaji();
        }

        if(A instanceof HavaSinifi temp && B instanceof KaraSinifi temp2){
            return temp.vurus + temp.karaVurusAvantaji();
        } else if (A instanceof KaraSinifi temp && B instanceof DenizSinifi temp2) {
            return temp.vurus + temp.denizVurusAvantaji();
        } else if (A instanceof DenizSinifi temp && B instanceof HavaSinifi temp2) {
            return temp.vurus + temp.havaVurusAvantaji();
        }

        return A.vurus;
    }

    public static void kartDagit(Oyuncu oyuncu, int dagitmaAdedi) {
        for (int i = 1; i <= dagitmaAdedi; i++) {
            int select;
            if (oyuncu.skor >= 20){ select = random.nextInt(6); }
            else { select = random.nextInt(3); }
            SavasAraclari Select = null;
            //Printler debug için eklendi.
            switch(select){
                case 0:
                    Select = new Ucak(0, 10, 20);
//                    System.out.println("Ucak Hava");
                    break;
                case 1:
                    Select = new Obus(0, 10, 20);
//                    System.out.println("Obus Kara");
                    break;
                case 2:
                    Select = new Firkateyn(0, 10, 25);
//                    System.out.println("Firkateyn Deniz");
                    break;
                case 3:
                    Select = new Siha(0, 10, 15);
//                    System.out.println("Siha Hava");
                    break;
                case 4:
                    Select = new KFS(0, 10, 10);
//                    System.out.println("KFS Kara");
                    break;
                case 5:
                    Select = new Sida(0, 10, 15);
//                    System.out.println("Sida Deniz");
                    break;
                default:
                    break;
            }
            oyuncu.kartListesi.add(Select);
            oyuncu.disabled_cards.add(true);
            oyuncu.temp_disabled_cards.add(true);
        }
    }
}