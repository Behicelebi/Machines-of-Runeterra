public class KFS extends KaraSinifi{

    public KFS(int seviyePuani) {
        super(seviyePuani);
    }

    @Override
    public int dayaniklilik() {
        return 10;
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
        return "KFS";
    }

    @Override
    public int denizVurusAvantaji() {
        return 10;
    }

    public int havaVurusAvantaji() {
        return 20;
    }
}
