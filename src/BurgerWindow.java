import javax.swing.*;
import java.awt.*;

public class BurgerWindow extends JPanel {

    public BurgerWindow(){}

    public static boolean first = true;
    static Font mainFont = new Font("SansSerif", Font.PLAIN, 30);
    static Font boldFont = new Font("SansSerif", Font.BOLD, 30);
    static Font bodyFont = new Font("SansSerif", Font.PLAIN, 15);
    public static int lukeBurgerEaten = (int)(Math.random()*15+1);
    public static int burgerEaten = 15;
    int phase = 0;
    int frame = 50;
    int posX = 225;
    int posY = 100;
    int size = 150;
    boolean increase = true;
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
        if(frame == 0){

            if(phase == 0){

                phase++;
                frame = 45;

                //Do the damage

            }
            else{

                burgerEaten = 15;
                lukeBurgerEaten = (int)(Math.random()*15+1);
                Main.burgerWindow.setVisible(false);

            }

        }
        if(phase == 0){

            if(increase){

                size+=2;
                posX--;
                posY--;
                if(size == 200){

                    increase = false;

                }

            }
            else{

                size-=2;
                posX++;
                posY++;
                if(size == 150){

                    increase = true;

                }

            }
            if(burgerEaten == 15){

                g.drawImage(fullBurger.getImage(), posX, posY, size, size, null);

            }
            else if(burgerEaten >= 10){

                g.drawImage(quarter3Burger.getImage(), posX, posY, size, size, null);

            }
            else if(burgerEaten >= 5){

                g.drawImage(halfBurger.getImage(), posX, posY, size, size, null);

            }
            else if(burgerEaten >= 0){

                g.drawImage(quarterBurger.getImage(), posX, posY, size, size, null);

            }

        }
        else{



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
