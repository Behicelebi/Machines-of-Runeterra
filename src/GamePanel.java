import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    int WIDTH,HEIGHT;
    Oyuncu insan,bilgisayar;

    GamePanel(int WIDTH, int HEIGHT){
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
        this.setPreferredSize(new Dimension(this.WIDTH,this.HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.setLayout(null);
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }
    public void draw(Graphics g){
        g.setColor(Color.white);
        g.setFont(new Font("Arial",Font.PLAIN,15));
        g.drawString(bilgisayar.oyuncuAdi, (WIDTH/2)-33,20);
        g.drawString(insan.oyuncuAdi,(WIDTH/2)-33,HEIGHT-10);
        for (int i = 0; i < insan.kartListesi.size(); i++) {
            g.setColor(Color.red);
            g.fillRect((i*170)+25,HEIGHT-180,100,150);
            g.setColor(Color.white);
            if(insan.kartListesi.get(i) instanceof HavaSinifi temp){
                g.drawString(temp.altsinif(),(i*170)+25,HEIGHT-180);
            } else if (insan.kartListesi.get(i) instanceof KaraSinifi temp) {
                g.drawString(temp.altsinif(),(i*170)+25,HEIGHT-180);
            } else if (insan.kartListesi.get(i) instanceof DenizSinifi temp) {
                g.drawString(temp.altsinif(),(i*170)+25,HEIGHT-180);
            }
        }
        for (int i = 0; i < bilgisayar.kartListesi.size(); i++) {
            g.setColor(Color.red);
            g.fillRect((i*170)+25,30,100,150);
            g.setColor(Color.white);
            if(bilgisayar.kartListesi.get(i) instanceof HavaSinifi temp){
                g.drawString(temp.altsinif(), (i*170)+25,30);
            } else if (bilgisayar.kartListesi.get(i) instanceof KaraSinifi temp) {
                g.drawString(temp.altsinif(),(i*170)+25,30);
            } else if (bilgisayar.kartListesi.get(i) instanceof DenizSinifi temp) {
                g.drawString(temp.altsinif(),(i*170)+25,30);
            }
        }
    }
}
