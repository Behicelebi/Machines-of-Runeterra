public class Obus extends KaraSinifi{

    public Obus(int seviyePuani) {
        super(seviyePuani);
    }

    @Override
    public int dayaniklilik() {
        return 20;
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
        return "Obüs";
    }

    @Override
    public int denizVurusAvantaji() {
        return 5;
    }
}
