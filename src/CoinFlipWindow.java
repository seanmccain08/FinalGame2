import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CoinFlipWindow extends JPanel {

    public static int value = 0;
    static Font mainFont = new Font("SansSerif", Font.PLAIN, 30);
    static Font boldFont = new Font("SansSerif", Font.BOLD, 30);
    static Font bodyFont = new Font("SansSerif", Font.PLAIN, 15);

    ImageIcon coin = new ImageIcon();

    public CoinFlipWindow() {

        setBackground(Color.black);

    }

    @Override
    public void paintComponent(Graphics g){

        Menu.changeColor(this);

        g.setColor(Color.black);
        g.fillRect(300, 0, 300, 400);
        g.setColor(Color.white);
        if(Main.coinFlipSelected == 0){

            g.setColor(Color.yellow);
            g.setFont(boldFont);
            g.drawString("Heads", 50, 155);
            g.setColor(Color.white);
            g.setFont(mainFont);
            g.drawString("Tails", 50, 205);
            coin = new ImageIcon("Images/heads.png");

        }
        else{

            g.setColor(Color.white);
            g.setFont(mainFont);
            g.drawString("Heads", 50, 155);
            g.setColor(Color.yellow);
            g.setFont(boldFont);
            g.drawString("Tails", 50, 205);
            coin = new ImageIcon("Images/tails.png");

        }
        g.drawImage(coin.getImage(), 280, 0, 340, 272, null);
        g.setColor(Color.white);
        g.setFont(bodyFont);
        g.drawString("To attack Jack, you must choose", 330, 270);
        g.drawString("heads or tails. A coin flip will", 330, 290);
        g.drawString("determine if you hit or miss.", 330, 310);
        g.drawString("If you miss, Jack will hit you,", 330, 330);
        g.drawString("but if you hit, you're safe.", 330, 350);

        try {
            Thread.sleep(25);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        repaint();

    }

}
