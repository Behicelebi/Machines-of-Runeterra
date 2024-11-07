import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class GamePanel extends JPanel implements ActionListener {
    int WIDTH,HEIGHT;
    Oyuncu insan,bilgisayar;
    ArrayList<Rectangle> insan_kartlar = new ArrayList<>();
    ArrayList<Rectangle> bilgisayar_kartlar = new ArrayList<>();
    ArrayList<Rectangle> play_boxes = new ArrayList<>();
    ArrayList<Point> temp_location = new ArrayList<>();
    ArrayList<Point> temp_location_pc = new ArrayList<>();
    JButton ready;
    int selectedRect = -1;
    int roundNum = 1;
    boolean placed_error = false;
    boolean tur = false;
    boolean isAdded_insan = false,isAdded_pc = false, gameOver=false;
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
                    if (insan_kartlar.get(i).contains(e.getPoint()) && !tur && insan.disabled_cards.get(i) && !gameOver) {
                        selectedRect = i;
                        dragOffset = new Point(e.getX() - insan_kartlar.get(i).x, e.getY() - insan_kartlar.get(i).y);
                    }
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                for (int j=0; j<insan_kartlar.size(); j++) {
                    for (int i=3; i<6; i++) {
                        if (play_boxes.get(i).contains(e.getPoint()) && j==selectedRect && insan.placed_cards.get(i-3) == -1) {
                            insan_kartlar.get(j).x = play_boxes.get(i).x;
                            insan_kartlar.get(j).y = play_boxes.get(i).y;
                            placed_error = false;
                            insan.kartSec(i-3,j);
                            break;
                        }else if(j==selectedRect){
                            insan_kartlar.get(j).x = temp_location.get(j).x;
                            insan_kartlar.get(j).y = temp_location.get(j).y;
                            for (int k = 0; k < 3; k++) {
                                if(insan.placed_cards.get(k) == j){insan.kartSec(k,-1);}
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
        g.drawString("ROUND " + roundNum,20,HEIGHT/2-10);
        for (int i = 0; i < 6; i++) {
            g.setColor(Color.white);
            g.drawRect(play_boxes.get(i).x,play_boxes.get(i).y,play_boxes.get(i).width,play_boxes.get(i).height);
        }
        for (int i = 0; i < insan.kartListesi.size(); i++) {
            if(insan.disabled_cards.get(i)){g.setColor(Color.red);}
            else{g.setColor(Color.gray);}
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
            if(bilgisayar.disabled_cards.get(i)){g.setColor(Color.red);}
            else{g.setColor(Color.gray);}
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
        if(gameOver){
            g.setColor(Color.red);
            g.setFont(new Font("Arial",Font.PLAIN,45));
            g.drawString("GAME OVER",WIDTH-300,(HEIGHT/2)-50);
        }
    }

    public void setCardPositions(){
        insan_kartlar.clear();
        bilgisayar_kartlar.clear();
        temp_location.clear();
        temp_location_pc.clear();
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
            temp_location_pc.add(new Point(button.x,button.y));
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

    public void turn(){
        bilgisayar.kartSec(0,0);
        java.util.Timer timer = new Timer();
        TimerTask task = new TimerTask(){
            int finalI = -1;
            @Override
            public void run() {
                if(finalI>=0 && finalI != 3){
                    bilgisayar_kartlar.get(bilgisayar.placed_cards.get(finalI)).x = play_boxes.get(finalI).x;
                    bilgisayar_kartlar.get(bilgisayar.placed_cards.get(finalI)).y = play_boxes.get(finalI).y;
                }
                if(finalI>=2 && finalI != 3){
                    tur=false;
                    System.out.println("ROUND " + roundNum + " Starting ------------------------------------------------------------");
                    for (int i = 0; i < 3; i++) {
                        if(insan.kartListesi.get(insan.placed_cards.get(i)) instanceof Ucak temp){
                            temp.DurumGuncelle(insan,bilgisayar,i);
                        } else if(insan.kartListesi.get(insan.placed_cards.get(i)) instanceof Siha temp){
                            temp.DurumGuncelle(insan,bilgisayar,i);
                        } else if (insan.kartListesi.get(insan.placed_cards.get(i)) instanceof Obus temp) {
                            temp.DurumGuncelle(insan,bilgisayar,i);
                        } else if (insan.kartListesi.get(insan.placed_cards.get(i)) instanceof KFS temp) {
                            temp.DurumGuncelle(insan,bilgisayar,i);
                        } else if (insan.kartListesi.get(insan.placed_cards.get(i)) instanceof Firkateyn temp) {
                            temp.DurumGuncelle(insan,bilgisayar,i);
                        } else if (insan.kartListesi.get(insan.placed_cards.get(i)) instanceof Sida temp) {
                            temp.DurumGuncelle(insan,bilgisayar,i);
                        }
                    }
                    for (int i = 0; i < 3; i++) {
                        if(bilgisayar.kartListesi.get(bilgisayar.placed_cards.get(i)) instanceof Ucak temp){
                            temp.DurumGuncelle(bilgisayar,insan,i);
                        } else if(bilgisayar.kartListesi.get(bilgisayar.placed_cards.get(i)) instanceof Siha temp){
                            temp.DurumGuncelle(bilgisayar,insan,i);
                        } else if (bilgisayar.kartListesi.get(bilgisayar.placed_cards.get(i)) instanceof Obus temp) {
                            temp.DurumGuncelle(bilgisayar,insan,i);
                        } else if (bilgisayar.kartListesi.get(bilgisayar.placed_cards.get(i)) instanceof KFS temp) {
                            temp.DurumGuncelle(bilgisayar,insan,i);
                        } else if (bilgisayar.kartListesi.get(bilgisayar.placed_cards.get(i)) instanceof Firkateyn temp) {
                            temp.DurumGuncelle(bilgisayar,insan,i);
                        } else if (bilgisayar.kartListesi.get(bilgisayar.placed_cards.get(i)) instanceof Sida temp) {
                            temp.DurumGuncelle(bilgisayar,insan,i);
                        }
                    }
                    System.out.println();
                }
                if(finalI >= 3) {
                    for (int i = 0; i < 3; i++) {
                        //I LITERALLY F*CKED THIS FUNCTION DON'T TOUCH IT
                        if(insan.kartListesi.get(insan.placed_cards.get(i)).dayaniklilik <= 0){
                            insan.kartListesi.remove(insan.placed_cards.get(i).intValue());
                            insan_kartlar.remove(insan.placed_cards.get(i).intValue());
                            for(int j = 0; j < 3; j++){
                                if(insan.placed_cards.get(j) > insan.placed_cards.get(i)){
                                    insan.kartSec(j, insan.placed_cards.get(j)-1);
                                }
                            }
                        }
                        if(bilgisayar.kartListesi.get(bilgisayar.placed_cards.get(i)).dayaniklilik <= 0) {
                            bilgisayar.kartListesi.remove(bilgisayar.placed_cards.get(i).intValue());
                            bilgisayar_kartlar.remove(bilgisayar.placed_cards.get(i).intValue());
                            for(int j = 0; j < 3; j++){
                                if(bilgisayar.placed_cards.get(j) > bilgisayar.placed_cards.get(i)){
                                    bilgisayar.placed_cards.set(j, bilgisayar.placed_cards.get(j)-1);
                                }
                            }
                        }
                    }
                    if(roundNum == Oyun.toplamHamleSayisi){gameOver=true;}
                    roundNum++;
                    for (int i = 0; i < 3; i++) {
                        insan.disabled_cards.set(insan.placed_cards.get(i),false);
                        bilgisayar.disabled_cards.set(bilgisayar.placed_cards.get(i),false);
                        insan.kartSec(i,-1);
                        bilgisayar.placed_cards.set(i, -1);
                    }
                    boolean test1=true;
                    int number1 = 0;
                    for (int i = 0; i < insan.kartListesi.size(); i++) {
                        if (insan.disabled_cards.get(i)) {
                            test1 = false;
                            number1++;
                        }
                    }
                    if(test1 || number1<3){
                        for (int i = 0; i < insan.disabled_cards.size(); i++) {
                            insan.disabled_cards.set(i,true);
                        }
                    }
                    Oyun.kartDagit(insan, 1);
                    if(insan.kartListesi.size()<3){
                        if(!isAdded_insan){
                            if(insan.kartListesi.size()==2){Oyun.kartDagit(insan, 1);}
                            isAdded_insan = true;
                        }
                    }
                    boolean test2=true;
                    int number2 = 0;
                    for (int i = 0; i < bilgisayar.kartListesi.size(); i++) {
                        if (bilgisayar.disabled_cards.get(i)) {
                            test2 = false;
                            number2++;
                        }
                    }
                    if(test2 || number2<3){
                        for (int i = 0; i < bilgisayar.disabled_cards.size(); i++) {
                            bilgisayar.disabled_cards.set(i,true);
                        }
                    }
                    Oyun.kartDagit(bilgisayar, 1);
                    if(bilgisayar.kartListesi.size()<3){
                        if(!isAdded_pc){
                            if(bilgisayar.kartListesi.size()==2){Oyun.kartDagit(bilgisayar, 1);}
                            isAdded_pc = true;
                        }
                    }
                    setCardPositions();
                    if(!gameOver){ready.setEnabled(true);}
                    timer.cancel();
                }
                finalI++;
                repaint();
            }
        };
        timer.scheduleAtFixedRate(task, 0, 1000);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==ready){
            for (int i = 0; i < 3; i++) {
                if(insan.placed_cards.get(i) == -1){
                    placed_error=true;
                    repaint();
                }
            }
            if(!placed_error){
                ready.setEnabled(false);
                tur = true;
                turn();
            }
        }
    }
}
