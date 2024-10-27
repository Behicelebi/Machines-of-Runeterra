public class Ucak extends HavaSinifi{

    public Ucak(int seviyePuani, String sinif) {
        super(seviyePuani, sinif);
        sinif = "Hava";
    }

    @Override
    public int dayaniklilik() {
        return 20;
    }

    public String sinif() {
        return "Hava";
    }

    @Override
    public int vurus() {
        return 10;
    }

    @Override
    public String altsinif() {
        return "Uçak";
    }

    @Override
    public int karaVurusAvantaji() {
        return 10;
    }
}
