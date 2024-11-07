public class Obus extends KaraSinifi{

    public Obus(int seviyePuani, int vurus, int dayaniklilik) {
        super(seviyePuani, vurus, dayaniklilik);
    }

    public String sinif() {
        return super.sinif();
    }

    @Override
    public String altsinif() {
        return "Obüs";
    }

    @Override
    public int denizVurusAvantaji() {
        return 5;
    }
}
