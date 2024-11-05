import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

public class GamePanel extends JPanel {
    int WIDTH,HEIGHT;
    Oyuncu insan,bilgisayar;
    ArrayList<Rectangle> insan_kartlar = new ArrayList<>();
    ArrayList<Rectangle> bilgisayar_kartlar = new ArrayList<>();
    int selectedRect = -1;
    Point dragOffset;

    GamePanel(int WIDTH, int HEIGHT, Oyuncu insan, Oyuncu bilgisayar){
        this.insan = insan;
        this.bilgisayar = bilgisayar;
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
        this.setPreferredSize(new Dimension(this.WIDTH,this.HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.setLayout(null);

        int bosluk, kartbosluk=150;
        bosluk = (WIDTH - (insan.kartListesi.size()*150 - 70))/2;
        if(bosluk<25){
            bosluk=25;
            while(25 + insan.kartListesi.size()*kartbosluk - (kartbosluk-80) >= WIDTH - 25){kartbosluk--;}
        }
        for (int i = 0; i < insan.kartListesi.size(); i++) {
            Rectangle button = new Rectangle((i*kartbosluk)+bosluk,HEIGHT-150,80,120);
            insan_kartlar.add(button);
        }

        kartbosluk = 150;
        bosluk = (WIDTH - (bilgisayar.kartListesi.size()*150 - 70))/2;
        if(bosluk<25){
            bosluk=25;
            while(25 + bilgisayar.kartListesi.size()*kartbosluk - (kartbosluk-80) >= WIDTH - 25){kartbosluk--;}
        }
        for (int i = 0; i < bilgisayar.kartListesi.size(); i++) {
            Rectangle button = new Rectangle((i*kartbosluk)+bosluk,30,80,120);
            bilgisayar_kartlar.add(button);
        }

        JLabel bilgisayar_label = new JLabel(bilgisayar.oyuncuAdi);
        bilgisayar_label.setHorizontalAlignment(JLabel.CENTER);
        bilgisayar_label.setVerticalAlignment(JLabel.TOP);
        bilgisayar_label.setForeground(Color.white);
        bilgisayar_label.setFont(new Font("Arial",Font.PLAIN,15));
        bilgisayar_label.setBounds(0,0,WIDTH,20);
        this.add(bilgisayar_label);

        JLabel oyuncu_label = new JLabel(insan.oyuncuAdi);
        oyuncu_label.setHorizontalAlignment(JLabel.CENTER);
        oyuncu_label.setVerticalAlignment(JLabel.TOP);
        oyuncu_label.setForeground(Color.white);
        oyuncu_label.setFont(new Font("Arial",Font.PLAIN,15));
        oyuncu_label.setBounds(0,HEIGHT-20,WIDTH,20);
        this.add(oyuncu_label);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                for (int i=0; i<insan_kartlar.size(); i++) {
                    if (insan_kartlar.get(i).contains(e.getPoint())) {
                        selectedRect = i;
                        dragOffset = new Point(e.getX() - insan_kartlar.get(i).x, e.getY() - insan_kartlar.get(i).y);
                    }
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                selectedRect = -1;
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                for (int i=0; i<insan_kartlar.size(); i++) {
                    if (i==selectedRect) {
                        insan_kartlar.get(i).setLocation(e.getX() - dragOffset.x, e.getY() - dragOffset.y);
                        repaint();
                    }
                }
            }
        });
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }
    public void draw(Graphics g){
        g.setColor(Color.white);
        g.setFont(new Font("Arial",Font.PLAIN,15));
        int bosluk, kartbosluk=150;
        for (int i = 0; i < insan.kartListesi.size(); i++) {
            bosluk = (WIDTH - (insan.kartListesi.size()*150 - 70))/2;
            if(bosluk<25){
                bosluk=25;
                while(25 + insan.kartListesi.size()*kartbosluk - (kartbosluk-80) >= WIDTH - 25){kartbosluk--;}
            }
            g.setColor(Color.red);
            g.fillRect(insan_kartlar.get(i).x,insan_kartlar.get(i).y,insan_kartlar.get(i).width,insan_kartlar.get(i).height);
            g.setColor(Color.white);
            if(insan.kartListesi.get(i) instanceof HavaSinifi temp){
                g.drawString(temp.altsinif(),(i*kartbosluk)+bosluk,HEIGHT-150);
            } else if (insan.kartListesi.get(i) instanceof KaraSinifi temp) {
                g.drawString(temp.altsinif(),(i*kartbosluk)+bosluk,HEIGHT-150);
            } else if (insan.kartListesi.get(i) instanceof DenizSinifi temp) {
                g.drawString(temp.altsinif(),(i*kartbosluk)+bosluk,HEIGHT-150);
            }
        }
        for (int i = 0; i < bilgisayar.kartListesi.size(); i++) {
            bosluk = (WIDTH - (bilgisayar.kartListesi.size()*150 - 70))/2;
            if(bosluk<25){
                bosluk=25;
                while(25 + bilgisayar.kartListesi.size()*kartbosluk - (kartbosluk-80) >= WIDTH - 25){kartbosluk--;}
            }
            g.setColor(Color.red);
            g.fillRect(bilgisayar_kartlar.get(i).x,bilgisayar_kartlar.get(i).y,bilgisayar_kartlar.get(i).width,bilgisayar_kartlar.get(i).height);
            g.setColor(Color.white);
            if(bilgisayar.kartListesi.get(i) instanceof HavaSinifi temp){
                g.drawString(temp.altsinif(), (i*kartbosluk)+bosluk,30);
            } else if (bilgisayar.kartListesi.get(i) instanceof KaraSinifi temp) {
                g.drawString(temp.altsinif(),(i*kartbosluk)+bosluk,30);
            } else if (bilgisayar.kartListesi.get(i) instanceof DenizSinifi temp) {
                g.drawString(temp.altsinif(),(i*kartbosluk)+bosluk,30);
            }
        }
    }
}
