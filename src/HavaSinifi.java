public abstract class HavaSinifi extends SavasAraclari{

    String sinif;
    public HavaSinifi(int seviyePuani, String sinif) {
        super(seviyePuani);
        this.sinif = sinif;
    }

    public abstract String altsinif();
    public abstract int karaVurusAvantaji();

    @Override
    public String sinif() {
        return "";
    }

    @Override
    public int vurus() {
        return 0;
    }

    @Override
    public int dayaniklilik() {
        return 0;
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
