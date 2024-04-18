import javax.swing.*;
import java.awt.*;

public class TimerDamageWindow extends JPanel {

    public TimerDamageWindow(){



    }

    static Font mainFont = new Font("SansSerif", Font.PLAIN, 30);
    static Font boldFont = new Font("SansSerif", Font.BOLD, 50);

    static boolean increase = false;
    static int fontSize = 50;
    static int posX0 = 175;
    static int posX1 = 160;
    public static int phase = 0;
    public static boolean first = true;
    static int frame = 20;
    public static int score = 0;
    public static double scoreMultiplier = 0.0;

    @Override
    public void paintComponent(Graphics g){

        Menu.changeColor(this);

        if(frame == 0){

            if(phase == 0){

                phase = 1;
                frame = 30;

            }
            else{

                Main.timerDamageWindow.setVisible(false);
                score = 0;
                frame = 30;
                phase = 0;
                scoreMultiplier = 0.0;

            }

        }

        g.setColor(Color.red);
        g.fillRect(0, 0, 600, 50);
        g.setColor(Color.green);
        int timerBarSizeX = frame*20;
        g.fillRect(0, 0, timerBarSizeX, 50);

        g.setColor(Color.white);
        g.setFont(mainFont);
        g.drawString("Spam the Space Bar!", 160, 300);
        g.setFont(boldFont);
        g.setColor(Color.yellow);
        if(phase == 0){

            g.drawString(score+" Damage", posX0, 200);
            if(increase){

                fontSize++;
                posX0-=2;
                boldFont = new Font("SansSerif", Font.BOLD, fontSize);
                if(boldFont.getSize() == 50){

                    increase = false;

                }

            }
            else{

                fontSize--;
                posX0+=2;
                boldFont = new Font("SansSerif", Font.BOLD, fontSize);
                if(boldFont.getSize() == 30){

                    increase = true;

                }

            }

        }
        else{

            g.drawString(score+" Damage * "+scoreMultiplier, posX1, 200);
            if(increase){

                fontSize++;
                posX1-=4;
                boldFont = new Font("SansSerif", Font.BOLD, fontSize);
                if(boldFont.getSize() == 50){

                    increase = false;

                }

            }
            else{

                fontSize--;
                posX1+=4;
                boldFont = new Font("SansSerif", Font.BOLD, fontSize);
                if(boldFont.getSize() == 30){

                    increase = true;

                }

            }

        }

        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        frame--;
        repaint();

    }

}
