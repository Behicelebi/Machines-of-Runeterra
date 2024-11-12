import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Firkateyn extends DenizSinifi{

    public Image texture;
    private static final Logger logger = Logger.getLogger(Siha.class.getName());

    public Firkateyn(int seviyePuani, int vurus, int dayaniklilik) {
        super(seviyePuani, vurus, dayaniklilik);
        try {
            texture = ImageIO.read(new File("Files/KFS.png"));
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error loading texture: Files/KFS.png", e);
        }
    }

    public String sinif() {
        return super.sinif();
    }

    @Override
    public String altsinif() {
        return "Firkateyn";
    }

    @Override
    public int havaVurusAvantaji() {
        return 5;
    }

    @Override
    public void DurumGuncelle(Oyuncu insan, Oyuncu bilgisayar, int i, int seviye_puani){
        int bilgisayar_vurus = Oyun.SaldiriHesapla(bilgisayar.kartListesi.get(bilgisayar.placed_cards.get(i)),insan.kartListesi.get(insan.placed_cards.get(i)));
        System.out.println((i+1) + ". kutuda olan " + insan.oyuncuAdi + "'nun Firkateyn kartinin dayanikliligi " + insan.kartListesi.get(insan.placed_cards.get(i)).dayaniklilik + " den " + bilgisayar_vurus + " kadar hasar yiyerek " + (insan.kartListesi.get(insan.placed_cards.get(i)).dayaniklilik - bilgisayar_vurus) + " oldu.");
        insan.kartListesi.get(insan.placed_cards.get(i)).dayaniklilik -= bilgisayar_vurus;
        if(insan.kartListesi.get(insan.placed_cards.get(i)).dayaniklilik <= 0){
            if(seviye_puani <= 10){
                bilgisayar.kartListesi.get(bilgisayar.placed_cards.get(i)).seviyePuani += 10;
                bilgisayar.skor += 10;
            }else{
                bilgisayar.kartListesi.get(bilgisayar.placed_cards.get(i)).seviyePuani += seviye_puani;
                bilgisayar.skor += seviye_puani;
            }
        }
    }

    @Override
    public void KartPuaniGoster(){
        System.out.println("Bu Firkateyn kartinin seviye puani: " + seviyePuani + "\n");
    }
}

