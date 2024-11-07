public abstract class HavaSinifi extends SavasAraclari{

    public HavaSinifi(int seviyePuani, int vurus, int dayaniklilik) {
        super(seviyePuani, vurus, dayaniklilik);
    }

    public abstract String altsinif();
    public abstract int karaVurusAvantaji();
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
