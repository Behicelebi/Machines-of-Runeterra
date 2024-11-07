public class KFS extends KaraSinifi{

    public KFS(int seviyePuani, int vurus, int dayaniklilik) {
        super(seviyePuani, vurus, dayaniklilik);
    }

    public String sinif() {
        return super.sinif();
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
