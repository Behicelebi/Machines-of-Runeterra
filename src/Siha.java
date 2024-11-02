public class Siha extends HavaSinifi{

    public Siha(int seviyePuani) {
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
        return "Siha";
    }

    @Override
    public int karaVurusAvantaji() {
        return 10;
    }

    public int denizVurusAvantaji() {
        return 10;
    }
}
