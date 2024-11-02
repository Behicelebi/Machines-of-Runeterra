public class Firkateyn extends DenizSinifi{

    public Firkateyn(int seviyePuani) {
        super(seviyePuani);
    }

    @Override
    public int dayaniklilik() {
        return 25;
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
        return "Firkateyn";
    }

    @Override
    public int havaVurusAvantaji() {
        return 5;
    }
}

