public class Obus extends KaraSinifi{

    public Obus(int seviyePuani, int vurus, int dayaniklilik) {
        super(seviyePuani, vurus, dayaniklilik);
    }

    public String sinif() {
        return super.sinif();
    }

    @Override
    public String altsinif() {
        return "Obüs";
    }

    @Override
    public int denizVurusAvantaji() {
        return 5;
    }

    @Override
    public void DurumGuncelle(Oyuncu insan, Oyuncu bilgisayar, int i){
        int bilgisayar_vurus = Oyun.SaldiriHesapla(bilgisayar.kartListesi.get(bilgisayar.placed_cards.get(i)),insan.kartListesi.get(insan.placed_cards.get(i)));
        System.out.println((i+1) + ". kutuda olan " + insan.oyuncuAdi + "'nun Obus kartinin dayanikliligi " + insan.kartListesi.get(insan.placed_cards.get(i)).dayaniklilik + " den " + bilgisayar_vurus + " kadar hasar yiyerek " + (insan.kartListesi.get(insan.placed_cards.get(i)).dayaniklilik - bilgisayar_vurus) + " oldu.");
        insan.kartListesi.get(insan.placed_cards.get(i)).dayaniklilik -= bilgisayar_vurus;
        if(insan.kartListesi.get(insan.placed_cards.get(i)).dayaniklilik <= 0){
            if(insan.kartListesi.get(insan.placed_cards.get(i)).seviyePuani <= 10){
                bilgisayar.kartListesi.get(bilgisayar.placed_cards.get(i)).seviyePuani += 10;
                bilgisayar.skor += 10;
            }else{
                bilgisayar.kartListesi.get(bilgisayar.placed_cards.get(i)).seviyePuani += insan.kartListesi.get(insan.placed_cards.get(i)).seviyePuani;
                bilgisayar.skor += insan.kartListesi.get(insan.placed_cards.get(i)).seviyePuani;
            }
        }
    }

    @Override
    public void KartPuaniGoster(){
        System.out.println("Bu Obus kartinin seviye puani: " + seviyePuani + "\n");
    }
}
