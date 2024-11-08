public abstract class SavasAraclari {

    int seviyePuani;
    int vurus;
    int dayaniklilik;

    public SavasAraclari(int seviyePuani, int vurus, int dayaniklilik){
        this.seviyePuani = seviyePuani;
        this.vurus = vurus;
        this.dayaniklilik = dayaniklilik;
    }

    //Abstract Property
    public abstract String sinif();

    //Abstract Method
    public abstract void KartPuaniGoster();
    public abstract void DurumGuncelle(Oyuncu insan, Oyuncu bilgisayar, int i);
}
