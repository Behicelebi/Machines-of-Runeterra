public class Siha extends HavaSinifi{

    public Siha(int seviyePuani, int vurus, int dayaniklilik) {
        super(seviyePuani, vurus, dayaniklilik);
    }

    public String sinif() {
        return super.sinif();
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
