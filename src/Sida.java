public class Sida extends DenizSinifi{

    public Sida(int seviyePuani) {
        super(seviyePuani);
    }

    @Override
    public int dayaniklilik() {
        return 15;
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
        return "Sida";
    }

    @Override
    public int havaVurusAvantaji() {
        return 10;
    }

    public int karaVurusAvantaji(){
        return 10;
    }
}

