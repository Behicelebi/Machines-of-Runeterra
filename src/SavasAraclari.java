public abstract class SavasAraclari {

    int seviyePuani;

    public SavasAraclari(int seviyePuani){
        this.seviyePuani = seviyePuani;
    }

    //Abstract Property
    public abstract String sinif();
    public abstract int vurus();
    public abstract int dayaniklilik();


    abstract void KartPuaniGoster();
    abstract void DurumGuncelle();
}
