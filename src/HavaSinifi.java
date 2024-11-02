public abstract class HavaSinifi extends SavasAraclari{

    public HavaSinifi(int seviyePuani) {
        super(seviyePuani);
    }

    public abstract String altsinif();
    public abstract int karaVurusAvantaji();
    public abstract int dayaniklilik();
    public abstract int vurus();
    public String sinif(){
        return "Hava";
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
