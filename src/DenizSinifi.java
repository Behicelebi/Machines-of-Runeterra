public abstract class DenizSinifi extends SavasAraclari{

    public DenizSinifi(int seviyePuani, int vurus, int dayaniklilik) {
        super(seviyePuani, vurus, dayaniklilik);
    }

    public abstract String altsinif();
    public abstract int havaVurusAvantaji();
    public String sinif(){
        return "Deniz";
    }

    @Override
    public void KartPuaniGoster() {
        System.out.println(seviyePuani);
    }

    @Override
    public void DurumGuncelle(Oyuncu insan, Oyuncu bilgisayar, int i) {}
}
