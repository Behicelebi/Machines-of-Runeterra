import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ucak extends HavaSinifi {

    public Image texture;
    private static final Logger logger = Logger.getLogger(Ucak.class.getName());

    public Ucak(int seviyePuani, int vurus, int dayaniklilik) {
        super(seviyePuani, vurus, dayaniklilik);
        try {
            texture = ImageIO.read(new File("Files/Ucak.png"));
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error loading texture: Files/Ucak.png", e);
        }
        verilenHasar = vurus;
    }

    public String sinif() {
        return super.sinif();
    }

    @Override
    public String altsinif() {
        return "Uçak";
    }

    @Override
    public int karaVurusAvantaji() {
        return 10;
    }

    @Override
    public void DurumGuncelle(Oyuncu hasarAlan, Oyuncu hasarVeren, int i, int seviye_puani){
        hasarVeren.kartListesi.get(hasarVeren.placed_cards.get(i)).verilenHasar = Oyun.SaldiriHesapla(hasarVeren.kartListesi.get(hasarVeren.placed_cards.get(i)),hasarAlan.kartListesi.get(hasarAlan.placed_cards.get(i)));
        if(hasarVeren.kartListesi.get(hasarVeren.placed_cards.get(i)).verilenHasar >= hasarAlan.kartListesi.get(hasarAlan.placed_cards.get(i)).dayaniklilik){
            Oyun.dosyaYaz("--->> " + (i+1) + ". kutuda olan " + hasarAlan.oyuncuAdi + "'in Ucak karti " + hasarVeren.kartListesi.get(hasarVeren.placed_cards.get(i)).verilenHasar + " kadar hasar yiyerek yok edildi !\n");
        }else{
            Oyun.dosyaYaz("--->> " + (i+1) + ". kutuda olan " + hasarAlan.oyuncuAdi + "'in Ucak kartinin dayanikliligi " + hasarAlan.kartListesi.get(hasarAlan.placed_cards.get(i)).dayaniklilik + " den " + hasarVeren.kartListesi.get(hasarVeren.placed_cards.get(i)).verilenHasar + " kadar hasar yiyerek " + (hasarAlan.kartListesi.get(hasarAlan.placed_cards.get(i)).dayaniklilik - hasarVeren.kartListesi.get(hasarVeren.placed_cards.get(i)).verilenHasar) + " oldu.\n");
        }
        hasarAlan.kartListesi.get(hasarAlan.placed_cards.get(i)).dayaniklilik -= hasarVeren.kartListesi.get(hasarVeren.placed_cards.get(i)).verilenHasar;
        if(hasarAlan.kartListesi.get(hasarAlan.placed_cards.get(i)).dayaniklilik <= 0){
            if(seviye_puani <= 10){
                hasarVeren.kartListesi.get(hasarVeren.placed_cards.get(i)).seviyePuani += 10;
                hasarVeren.skor += 10;
            }else{
                hasarVeren.kartListesi.get(hasarVeren.placed_cards.get(i)).seviyePuani += seviye_puani;
                hasarVeren.skor += seviye_puani;
            }
        }
    }

    @Override
    public void KartPuaniGoster() {
        Oyun.dosyaYaz("Bu Ucak kartinin seviye puani: " + seviyePuani + "\n");
    }
}
