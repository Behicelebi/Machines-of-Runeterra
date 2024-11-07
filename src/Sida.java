public class Sida extends DenizSinifi{

    public Sida(int seviyePuani, int vurus, int dayaniklilik) {
        super(seviyePuani, vurus, dayaniklilik);
    }

    public String sinif() {
        return super.sinif();
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

