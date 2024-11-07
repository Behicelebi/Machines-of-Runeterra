import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JPanel implements ActionListener {
    int WIDTH,HEIGHT;
    JButton submit = new JButton("SUBMIT");
    JTextField textField = new JTextField();
    Oyuncu insan, bilgisayar;

    Menu(int WIDTH, int HEIGHT, Oyuncu insan, Oyuncu bilgisayar){
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
        this.insan = insan;
        this.bilgisayar = bilgisayar;
        this.setPreferredSize(new Dimension(this.WIDTH,this.HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.setLayout(null);

        JLabel bilgisayar_label = new JLabel("Savaş Araçları Kart Oyunu");
        bilgisayar_label.setHorizontalAlignment(JLabel.CENTER);
        bilgisayar_label.setVerticalAlignment(JLabel.TOP);
        bilgisayar_label.setForeground(Color.white);
        bilgisayar_label.setFont(new Font("Arial",Font.PLAIN,30));
        bilgisayar_label.setBounds(0,50,WIDTH,100);
        this.add(bilgisayar_label);

        submit.addActionListener(this);
        submit.setBounds(300,300,90,30);
        submit.setFocusable(false);
        this.add(submit);

        textField.setPreferredSize(new Dimension(10,300));
        textField.setBounds(10,300,250,30);
        textField.setFont(new Font("Arial",Font.PLAIN,15));
        textField.setText("Oyuncu");
        this.add(textField);
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }
    public void draw(Graphics g){
        g.setColor(Color.white);
        g.setFont(new Font("Arial",Font.PLAIN,15));
        g.drawString("Enter a username: ", 10,280);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==submit){
            insan.oyuncuAdi = textField.getText();
        }
    }
}