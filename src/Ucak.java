public class Ucak extends HavaSinifi{

    public Ucak(int seviyePuani, int vurus, int dayaniklilik) {
        super(seviyePuani, vurus, dayaniklilik);
    }

    public String sinif() {
        return super.sinif();
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
