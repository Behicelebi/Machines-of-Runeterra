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
        g.setColor(Color.red);
        for (int i = 0; i < 6; i++) {
            g.fillRect((i*170)+25,30,100,150);
            g.fillRect((i*170)+25,HEIGHT-180,100,150);
        }
    }
}
