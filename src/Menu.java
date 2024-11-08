import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JPanel implements ActionListener {
    int WIDTH,HEIGHT;
    JButton submit = new JButton("SUBMIT");
    JTextField textField = new JTextField();
    Oyuncu insan, bilgisayar;
    JLabel background;

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

        submit.addActionListener(this);
        submit.setBounds(WIDTH/2 - 45,400,110,30);
        submit.setFocusable(false);
        submit.setFont(new Font("Copperplate Gothic Bold",Font.PLAIN,14));
        this.add(submit);

        textField.setPreferredSize(new Dimension(10,300));
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setBounds(WIDTH/2-115,300,250,30);
        textField.setFont(new Font("Copperplate Gothic Bold",Font.PLAIN,15));
        textField.setText("Player");
        this.add(textField);
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }
    public void draw(Graphics g){
        g.setColor(Color.white);
        g.setFont(new Font("Copperplate Gothic Bold",Font.PLAIN,15));
        g.drawString("Enter a player name !", WIDTH/2 - 80,280);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==submit){
            insan.oyuncuAdi = textField.getText();
        }
    }
}