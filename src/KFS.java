public class KFS extends KaraSinifi{

    public KFS(int seviyePuani, String sinif) {
        super(seviyePuani,sinif);
        sinif = "Kara";
    }

    @Override
    public int dayaniklilik() {
        return 10;
    }

    public String sinif() {
        return "Kara";
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
