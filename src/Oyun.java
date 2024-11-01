import java.util.Random;

public class Oyun {

    public int toplamHamleSayisi = 5;
    public static Oyuncu insan;
    public static Oyuncu bilgisayar;
    static Random random = new Random();

    public static void main(String[] args) {
        insan = new Oyuncu(1,"Oyuncu",0);
        bilgisayar = new Oyuncu(0,"Bilgisayar",0);
        kartDagit(insan);
        kartDagit(bilgisayar);
        new Frame(Oyun.insan,Oyun.bilgisayar);
    }

    public static void kartDagit(Oyuncu oyuncu) {
        for (int i = 1; i <= 6; i++) {
            int select;
            if (oyuncu.skor >= 20){ select = random.nextInt(6); }
            else { select = random.nextInt(3); }
            SavasAraclari Select = null;
            //Printler debug için eklendi.
            switch(select){
                case 0:
                    Select = new Ucak(0,"Hava");
                    System.out.println("Ucak Hava");
                    break;
                case 1:
                    Select = new Obus(0,"Kara");
                    System.out.println("Obus Kara");
                    break;
                case 2:
                    Select = new Firkateyn(0,"Deniz");
                    System.out.println("Firkateyn Deniz");
                    break;
                case 3:
                    Select = new Siha(0,"Hava");
                    System.out.println("Siha Hava");
                    break;
                case 4:
                    Select = new KFS(0,"Kara");
                    System.out.println("KFS Kara");
                    break;
                case 5:
                    Select = new Sida(0,"Deniz");
                    System.out.println("Sida Deniz");
                    break;
                default:
                    break;
            }
            oyuncu.kartListesi.add(Select);
        }
    }
}