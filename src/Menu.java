import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JPanel implements ActionListener {
    int WIDTH,HEIGHT;
    JButton submit = new JButton("SUBMIT");

    Menu(int WIDTH, int HEIGHT){
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
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
        submit.setBounds(150,300,80,30);
        this.add(submit);
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }
    public void draw(Graphics g){
        g.setColor(Color.white);
        g.setFont(new Font("Arial",Font.PLAIN,30));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==submit){}
    }
}