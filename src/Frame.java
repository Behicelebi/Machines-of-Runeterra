import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame implements ActionListener {
    int WIDTH = 1200, HEIGHT = 700;

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int screenWidth = (int)screenSize.getWidth()/2-(WIDTH/2);
    int screenHeight = (int)screenSize.getHeight()/2-(HEIGHT/2);

    GamePanel gamePanel;
    Menu menu;

    JButton button = new JButton("PLAY");

    Frame(Oyuncu insan, Oyuncu bilgisayar){
        menu = new Menu(WIDTH,HEIGHT,insan,bilgisayar);
        gamePanel = new GamePanel(WIDTH,HEIGHT,insan,bilgisayar);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Machines of Runeterra");
        this.setResizable(false);
        this.setLocation(screenWidth,screenHeight);
        this.setSize(WIDTH,HEIGHT);
        this.add(menu);
        button.setFont(new Font("Copperplate Gothic Bold",Font.BOLD,14));
        button.setBounds((WIDTH/2)-30,600,80,30);
        button.setFocusable(false);
        button.addActionListener(this);
        menu.add(button);
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Frame frame = this;
        if(e.getSource()==button){
            gamePanel.insan.oyuncuAdi = menu.textField.getText();
            frame.getContentPane().remove(menu);
            frame.getContentPane().add(gamePanel);
            frame.getContentPane().revalidate();
            frame.getContentPane().repaint();
            gamePanel.requestFocus();
        }
    }
}