public abstract class KaraSinifi extends SavasAraclari{

    public KaraSinifi(int seviyePuani, int vurus, int dayaniklilik) {
        super(seviyePuani, vurus, dayaniklilik);
    }

    public abstract String altsinif();
    public abstract int denizVurusAvantaji();
    public String sinif(){
        return "Kara";
    }

    @Override
    public void KartPuaniGoster() {
        System.out.println(seviyePuani);
    }

    @Override
    public void DurumGuncelle(Oyuncu insan, Oyuncu bilgisayar, int i, int seviye_puani) {}
}
