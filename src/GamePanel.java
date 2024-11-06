import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GamePanel extends JPanel implements ActionListener {
    int WIDTH,HEIGHT;
    Oyuncu insan,bilgisayar;
    ArrayList<Rectangle> insan_kartlar = new ArrayList<>();
    ArrayList<Rectangle> bilgisayar_kartlar = new ArrayList<>();
    ArrayList<Rectangle> play_boxes = new ArrayList<>();
    ArrayList<Integer> box_placed = new ArrayList<>();
    ArrayList<Point> temp_location = new ArrayList<>();
    JButton ready;
    int selectedRect = -1;
    boolean placed_error = false;
    boolean tur = false;
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

        for (int i = 0; i < 3; i++) {box_placed.add(-1);}

        setCardPositions();

        ready = new JButton("READY");
        ready.setBounds(1100,320,80,30);
        ready.setFocusable(false);
        ready.addActionListener(this);
        this.add(ready);

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
                    if (insan_kartlar.get(i).contains(e.getPoint()) && !tur) {
                        selectedRect = i;
                        dragOffset = new Point(e.getX() - insan_kartlar.get(i).x, e.getY() - insan_kartlar.get(i).y);
                    }
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                for (int j=0; j<insan_kartlar.size(); j++) {
                    for (int i=3; i<6; i++) {
                        if (play_boxes.get(i).contains(e.getPoint()) && j==selectedRect && box_placed.get(i-3) == -1) {
                            insan_kartlar.get(j).x = play_boxes.get(i).x;
                            insan_kartlar.get(j).y = play_boxes.get(i).y;
                            placed_error = false;
                            box_placed.set(i-3,j);
                            break;
                        }else if(j==selectedRect){
                            insan_kartlar.get(j).x = temp_location.get(j).x;
                            insan_kartlar.get(j).y = temp_location.get(j).y;
                            for (int k = 0; k < 3; k++) {
                                if(box_placed.get(k) == j){box_placed.set(k,-1);}
                            }
                        }
                    }
                }
                repaint();
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
        for (int i = 0; i < 6; i++) {
            g.setColor(Color.white);
            g.drawRect(play_boxes.get(i).x,play_boxes.get(i).y,play_boxes.get(i).width,play_boxes.get(i).height);
        }
        for (int i = 0; i < insan.kartListesi.size(); i++) {
            bosluk = (WIDTH - (insan.kartListesi.size()*150 - 70))/2;
            if(bosluk<25){
                bosluk=25;
                while(25 + insan.kartListesi.size()*kartbosluk - (kartbosluk-80) >= WIDTH - 25){kartbosluk--;}
            }
            g.setColor(Color.red);
            g.fillRect(insan_kartlar.get(i).x,insan_kartlar.get(i).y,insan_kartlar.get(i).width,insan_kartlar.get(i).height);
            g.setColor(Color.green);
            g.drawRect(insan_kartlar.get(i).x,insan_kartlar.get(i).y,insan_kartlar.get(i).width,insan_kartlar.get(i).height);
            g.setColor(Color.white);
            if(insan.kartListesi.get(i) instanceof HavaSinifi temp){
                g.drawString(temp.altsinif(),insan_kartlar.get(i).x,insan_kartlar.get(i).y);
            } else if (insan.kartListesi.get(i) instanceof KaraSinifi temp) {
                g.drawString(temp.altsinif(),insan_kartlar.get(i).x,insan_kartlar.get(i).y);
            } else if (insan.kartListesi.get(i) instanceof DenizSinifi temp) {
                g.drawString(temp.altsinif(),insan_kartlar.get(i).x,insan_kartlar.get(i).y);
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
            g.setColor(Color.green);
            g.drawRect(bilgisayar_kartlar.get(i).x,bilgisayar_kartlar.get(i).y,bilgisayar_kartlar.get(i).width,bilgisayar_kartlar.get(i).height);
            g.setColor(Color.white);
            if(bilgisayar.kartListesi.get(i) instanceof HavaSinifi temp){
                g.drawString(temp.altsinif(), bilgisayar_kartlar.get(i).x,bilgisayar_kartlar.get(i).y);
            } else if (bilgisayar.kartListesi.get(i) instanceof KaraSinifi temp) {
                g.drawString(temp.altsinif(),bilgisayar_kartlar.get(i).x,bilgisayar_kartlar.get(i).y);
            } else if (bilgisayar.kartListesi.get(i) instanceof DenizSinifi temp) {
                g.drawString(temp.altsinif(),bilgisayar_kartlar.get(i).x,bilgisayar_kartlar.get(i).y);
            }
        }
        if(placed_error){
            g.setColor(Color.red);
            g.drawString("You need to place 3 cards",900,340);
        }
    }

    public void setCardPositions(){
        int bosluk, kartbosluk=150;
        bosluk = (WIDTH - (insan.kartListesi.size()*150 - 70))/2;
        if(bosluk<25){
            bosluk=25;
            while(25 + insan.kartListesi.size()*kartbosluk - (kartbosluk-80) >= WIDTH - 25){kartbosluk--;}
        }
        for (int i = 0; i < insan.kartListesi.size(); i++) {
            Rectangle button = new Rectangle((i*kartbosluk)+bosluk,HEIGHT-150,80,120);
            insan_kartlar.add(button);
            temp_location.add(new Point(button.x,button.y));
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

        kartbosluk = 150;
        bosluk = (WIDTH - (3*150 - 70))/2;
        if(bosluk<25){
            bosluk=25;
            while(25 + bilgisayar.kartListesi.size()*kartbosluk - (kartbosluk-80) >= WIDTH - 25){kartbosluk--;}
        }
        for (int i = 0; i < 6; i++) {
            Rectangle button = new Rectangle(((i%3)*kartbosluk)+bosluk,(HEIGHT/2)-(150-(i/3*150)),80,120);
            play_boxes.add(button);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ArrayList<SavasAraclari> toRemove = new ArrayList<>();
        if(e.getSource()==ready){
            for (int i = 0; i < 3; i++) {
                if(box_placed.get(i) == -1){
                    placed_error=true;
                    repaint();
                }
            }
            if(!placed_error){
                /*
                for (int i = 0; i < 3; i++) {
                    if(box_placed.get(i) != -1){
                        insan_kartlar.remove(box_placed.get(i));
                        insan.kartListesi.remove(box_placed.get(i));
                    }
                }*/
                setCardPositions();
                tur = true;
            }
        }
    }
}
