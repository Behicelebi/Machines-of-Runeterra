public class Oyun {

    public int toplamHamleSayisi = 5;
    public static Oyuncu insan;
    public static Oyuncu bilgisayar;

    public static void main(String[] args) {
        insan = new Oyuncu(0,"Oyuncu",0);
        bilgisayar = new Oyuncu(1,"Bilgisayar",0);
        new Frame(Oyun.insan,Oyun.bilgisayar);
        //Hello
        //Hello 41 merhaba
        //i am me
    }

    public void SaldiriHesapla(){}
}