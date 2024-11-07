public class Ucak extends HavaSinifi{

    public Ucak(int seviyePuani, int vurus, int dayaniklilik) {
        super(seviyePuani, vurus, dayaniklilik);
    }

    public String sinif() {
        return super.sinif();
    }

    @Override
    public String altsinif() {
        return "Uçak";
    }

    @Override
    public int karaVurusAvantaji() {
        return 10;
    }

    @Override
    void DurumGuncelle(Oyuncu insan, Oyuncu bilgisayar, int i){
        int bilgisayar_vurus = Oyun.SaldiriHesapla(bilgisayar.kartListesi.get(bilgisayar.placed_cards.get(i)),insan.kartListesi.get(insan.placed_cards.get(i)));
        System.out.println((i+1) + ". kutuda olan " + insan.oyuncuAdi + "'nun Ucak kartinin dayanikliligi " + insan.kartListesi.get(insan.placed_cards.get(i)).dayaniklilik + " den " + bilgisayar_vurus + " kadar hasar yiyerek " + (insan.kartListesi.get(insan.placed_cards.get(i)).dayaniklilik - bilgisayar_vurus) + " oldu.");
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
        System.out.println("Ucak Guncellendi");
    }

    @Override
    void KartPuaniGoster(){}
}
