import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Menu extends JPanel implements ActionListener {
    int WIDTH,HEIGHT;
    JTextField textField = new JTextField();
    Oyuncu insan, bilgisayar;
    JButton up_button = new JButton(">"), down_button = new JButton("<"), default_button = new JButton("Set Default");
    public Image background;
    private static final Logger logger = Logger.getLogger(GamePanel.class.getName());

    Menu(int WIDTH, int HEIGHT, Oyuncu insan, Oyuncu bilgisayar){
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
        this.insan = insan;
        this.bilgisayar = bilgisayar;
        this.setPreferredSize(new Dimension(this.WIDTH,this.HEIGHT));
        this.setFocusable(true);
        this.setLayout(null);

        try {
            background = ImageIO.read(new File("Files/MenuBG.png"));
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error loading texture: Files/MenuBG.png", e);
        }

        JLabel bilgisayar_label = new JLabel("Machines of Runeterra");
        bilgisayar_label.setHorizontalAlignment(JLabel.CENTER);
        bilgisayar_label.setVerticalAlignment(JLabel.TOP);
        bilgisayar_label.setForeground(Color.white);
        bilgisayar_label.setFont(new Font("Copperplate Gothic Bold",Font.ITALIC,70));
        bilgisayar_label.setBounds(0,50,WIDTH,100);
        this.add(bilgisayar_label);

        textField.setPreferredSize(new Dimension(10,300));
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setBounds(WIDTH/2-115,300,250,30);
        textField.setFont(new Font("Copperplate Gothic Bold",Font.PLAIN,15));
        textField.setText(insan.oyuncuAdi);
        this.add(textField);

        Timer up_holdTimer = new Timer(100, e -> {
            Oyun.toplamHamleSayisi++;
            repaint();
        });
        up_holdTimer.setInitialDelay(500);
        up_button.setBounds(WIDTH/2 + 95,420,40,25);
        up_button.setFont(new Font("Copperplate Gothic Bold",Font.BOLD,10));
        up_button.setHorizontalAlignment(SwingConstants.CENTER);
        up_button.setFocusable(false);
        up_button.addActionListener(this);
        up_button.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (!up_holdTimer.isRunning()) {up_holdTimer.start();}
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                up_holdTimer.stop();
            }
        });
        this.add(up_button);

        Timer down_holdTimer = new Timer(100, e -> {
            if(Oyun.toplamHamleSayisi>1){
                Oyun.toplamHamleSayisi--;
                repaint();
            }
        });
        down_holdTimer.setInitialDelay(500);
        down_button.setBounds(WIDTH/2 - 115,420,40,25);
        down_button.setFont(new Font("Copperplate Gothic Bold",Font.BOLD,10));
        down_button.setHorizontalAlignment(SwingConstants.CENTER);
        down_button.setFocusable(false);
        down_button.addActionListener(this);
        down_button.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (!down_holdTimer.isRunning()) {down_holdTimer.start();}
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                down_holdTimer.stop();
            }
        });
        this.add(down_button);

        default_button.setBounds(WIDTH/2-50,420,120,25);
        default_button.setFont(new Font("Copperplate Gothic Bold",Font.BOLD,12));
        default_button.setFocusable(false);
        default_button.addActionListener(this);
        this.add(default_button);
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }
    public void draw(Graphics g){
        g.drawImage(background,0,0,this);
        g.setColor(Color.white);
        g.setFont(new Font("Copperplate Gothic Bold",Font.PLAIN,15));
        g.drawString("Enter a player name !", WIDTH/2 - 80,280);
        g.drawString("Total round amount",WIDTH/2 - 75,360);
        g.setFont(new Font("Copperplate Gothic Bold",Font.PLAIN,20));
        String ortalanmis = String.format("%02d", Oyun.toplamHamleSayisi);
        g.drawString(ortalanmis,WIDTH/2-5 ,400);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == up_button){
            Oyun.toplamHamleSayisi++;
            repaint();
        } else if (e.getSource() == down_button) {
            if(Oyun.toplamHamleSayisi>1){
                Oyun.toplamHamleSayisi--;
                repaint();
            }
        } else if (e.getSource() == default_button) {
            Oyun.toplamHamleSayisi = 5;
            repaint();
        }
    }
}