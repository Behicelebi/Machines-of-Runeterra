public abstract class DenizSinifi extends SavasAraclari{

    public DenizSinifi(int seviyePuani) {
        super(seviyePuani);
    }

    public abstract String altsinif();
    public abstract int havaVurusAvantaji();
    public abstract int dayaniklilik();
    public abstract int vurus();
    public String sinif(){
        return "Deniz";
    }

    @Override
    void KartPuaniGoster() {
        System.out.println(seviyePuani);
    }

    @Override
    void DurumGuncelle() {
        System.out.println("Guncellendi");
    }
}
