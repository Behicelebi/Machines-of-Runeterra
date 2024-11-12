import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Oyun {

    public static int toplamHamleSayisi = 5;
    public static int roundNum = 1;
    public static Oyuncu insan;
    public static Oyuncu bilgisayar;
    static Random random = new Random();

    public static void main(String[] args) {
        insan = new Oyuncu(1,"Player",0);
        bilgisayar = new Oyuncu(0,"Computer",0);
        try{
            FileWriter writer = new FileWriter("sonuc.txt");
            writer.write("-----------\nOYUN LOGU\n-----------\n");
            writer.close();
        }catch (IOException e){e.printStackTrace();}
        kartDagit(insan, 6);
        kartDagit(bilgisayar, 6);
        new Frame(Oyun.insan,Oyun.bilgisayar);
    }

    public static int SaldiriHesapla(SavasAraclari A, SavasAraclari B){
        if (A instanceof Siha temp && B instanceof DenizSinifi){
            return temp.vurus + temp.denizVurusAvantaji();
        } else if (A instanceof KFS temp && B instanceof HavaSinifi) {
            return temp.vurus + temp.havaVurusAvantaji();
        } else if (A instanceof Sida temp && B instanceof KaraSinifi) {
            return temp.vurus + temp.karaVurusAvantaji();
        }

        if(A instanceof HavaSinifi temp && B instanceof KaraSinifi){
            return temp.vurus + temp.karaVurusAvantaji();
        } else if (A instanceof KaraSinifi temp && B instanceof DenizSinifi) {
            return temp.vurus + temp.denizVurusAvantaji();
        } else if (A instanceof DenizSinifi temp && B instanceof HavaSinifi) {
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
                    if(roundNum != 1)
                        dosyaYaz("\n" + oyuncu.oyuncuAdi + "'a verilen kart: Ucak\n");
                    break;
                case 1:
                    Select = new Obus(0, 10, 20);
                    if(roundNum != 1)
                        dosyaYaz("\n" + oyuncu.oyuncuAdi + "'a verilen kart: Obüs\n");
                    break;
                case 2:
                    Select = new Firkateyn(0, 10, 25);
                    if(roundNum != 1)
                        dosyaYaz("\n" + oyuncu.oyuncuAdi + "'a verilen kart: Fırkateyn\n");
                    break;
                case 3:
                    Select = new Siha(0, 10, 15);
                    if(roundNum != 1)
                        dosyaYaz("\n" + oyuncu.oyuncuAdi + "'a verilen kart: Siha\n");
                    break;
                case 4:
                    Select = new KFS(0, 10, 10);
                    if(roundNum != 1)
                        dosyaYaz("\n" + oyuncu.oyuncuAdi + "'a verilen kart: KFS\n");
                    break;
                case 5:
                    Select = new Sida(0, 10, 15);
                    if(roundNum != 1)
                        dosyaYaz("\n" + oyuncu.oyuncuAdi + "'a verilen kart: Sida\n");
                    break;
                default:
                    break;
            }
            oyuncu.kartListesi.add(Select);
            oyuncu.disabled_cards.add(true);
            oyuncu.temp_disabled_cards.add(true);
        }
    }

    public static void dosyaYaz(String content){
        try (FileWriter fileWriter = new FileWriter("sonuc.txt", true)) {
            fileWriter.write(content);
        } catch (IOException e) {
            System.out.println("Dosyaya yazarken hata olustu");
            e.printStackTrace();
        }
    }
}