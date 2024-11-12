import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JPanel implements ActionListener {
    int WIDTH,HEIGHT;
    JTextField textField = new JTextField();
    Oyuncu insan, bilgisayar;
    JButton up_button = new JButton("▲"), down_button = new JButton("▼"), default_button = new JButton("Set Default");

    Menu(int WIDTH, int HEIGHT, Oyuncu insan, Oyuncu bilgisayar){
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
        this.insan = insan;
        this.bilgisayar = bilgisayar;
        this.setPreferredSize(new Dimension(this.WIDTH,this.HEIGHT));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.setLayout(null);

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

        up_button.setBounds(WIDTH/2 - 110,400,30,20);
        up_button.setFont(new Font("Calibri",Font.BOLD,5));
        up_button.setFocusable(false);
        up_button.addActionListener(this);
        this.add(up_button);

        down_button.setBounds(WIDTH/2 - 110,425,30,20);
        down_button.setFont(new Font("Calibri",Font.BOLD,5));
        down_button.setFocusable(false);
        down_button.addActionListener(this);
        this.add(down_button);

        default_button.setBounds(WIDTH/2 + 50,425,140,30);
        default_button.setFont(new Font("Copperplate Gothic Bold",Font.BOLD,14));
        default_button.setFocusable(false);
        default_button.addActionListener(this);
        this.add(default_button);
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }
    public void draw(Graphics g){
        g.setColor(Color.white);
        g.setFont(new Font("Copperplate Gothic Bold",Font.PLAIN,15));
        g.drawString("Enter a player name !", WIDTH/2 - 80,280);
        g.drawString("Total move amount: ",WIDTH/2 - 80,400);
        g.setFont(new Font("Copperplate Gothic Bold",Font.PLAIN,20));
        g.drawString("" + Oyun.toplamHamleSayisi,WIDTH/2 - 70,430);
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