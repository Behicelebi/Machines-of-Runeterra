public class Obus extends KaraSinifi{

    public Obus(int seviyePuani, String sinif) {
        super(seviyePuani,sinif);
        sinif = "Kara";
    }

    @Override
    public int dayaniklilik() {
        return 20;
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
        return "Obüs";
    }

    @Override
    public int denizVurusAvantaji() {
        return 5;
    }
}
