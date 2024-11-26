public abstract class SavasAraclari {

    int seviyePuani;
    int vurus;
    int dayaniklilik;
    public int verilenHasar;

    public SavasAraclari(int seviyePuani, int vurus, int dayaniklilik){
        this.seviyePuani = seviyePuani;
        this.vurus = vurus;
        this.dayaniklilik = dayaniklilik;
    }

    //Abstract Property
    public abstract String sinif();

    //Abstract Method
    public abstract void KartPuaniGoster();
    public abstract void DurumGuncelle(Oyuncu insan, Oyuncu bilgisayar, int i, int seviye_puani);
}
