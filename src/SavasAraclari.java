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
    abstract void KartPuaniGoster();
    abstract void DurumGuncelle();
}
