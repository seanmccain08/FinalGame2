import javax.swing.*;
import java.awt.*;

public class BurgerWindow extends JPanel {

    public BurgerWindow(){}

    static Font mainFont = new Font("SansSerif", Font.PLAIN, 30);
    static Font boldFont = new Font("SansSerif", Font.BOLD, 30);
    static Font bodyFont = new Font("SansSerif", Font.PLAIN, 15);
    public static int burgerEaten = 15;
    int frame = 50;
    ImageIcon fullBurger = new ImageIcon("Images/burger/full.png");
    ImageIcon quarter3Burger = new ImageIcon("Images/burger/threeQuarter.png");
    ImageIcon halfBurger = new ImageIcon("Images/burger/half.png");
    ImageIcon quarterBurger = new ImageIcon("Images/burger/quarter.png");

    @Override
    public void paintComponent(Graphics g){

        if(Settings.getBgColor() != 1){

            Menu.changeColor(this);

        }
        else{

            setBackground(Color.gray);

        }
        if(burgerEaten == 15){

            g.drawImage(fullBurger.getImage(), 200, 75, 200, 200, null);

        }
        else if(burgerEaten >= 10){

            g.drawImage(quarter3Burger.getImage(), 200, 75, 200, 200, null);

        }
        else if(burgerEaten >= 5){

            g.drawImage(halfBurger.getImage(), 200, 75, 200, 200, null);

        }
        else if(burgerEaten >= 0){

            g.drawImage(quarterBurger.getImage(), 200, 75, 200, 200, null);

        }

        g.setColor(Color.red);
        g.fillRect(0, 0, 600, 50);
        g.setColor(Color.green);
        int timerBarSizeX = frame*20;
        g.fillRect(0, 0, timerBarSizeX, 50);


        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        repaint();
        frame--;

    }

}
