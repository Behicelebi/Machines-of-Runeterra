public class Ucak extends HavaSinifi{

    public Ucak(int seviyePuani) {
        super(seviyePuani);
    }

    @Override
    public int dayaniklilik() {
        return 20;
    }

    public String sinif() {
        return super.sinif();
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
