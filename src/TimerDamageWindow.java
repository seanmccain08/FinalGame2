import javax.swing.*;
import java.awt.*;

public class TimerDamageWindow extends JPanel {

    public TimerDamageWindow(){



    }

    static Font mainFont = new Font("SansSerif", Font.PLAIN, 30);
    static Font boldFont = new Font("SansSerif", Font.BOLD, 50);

    public static int damage0 = (int)(Math.random()*10+1);
    static boolean increase = false;
    static int fontSize = 50;
    static int posX0 = 175;
    static int posX1 = 160;
    public static int phase = 0;
    public static boolean first = true;
    static int frame = 20;
    public static int score = 0;
    public static double scoreMultiplier = 0.3;

    public static double damage = 0.0;

    @Override
    public void paintComponent(Graphics g){

        Menu.changeColor(this);

        if(frame == 0){

            if(phase == 0){

                phase = 1;
                frame = 30;

            }
            else if(phase == 1){

                frame = 60;
                phase++;

            }
            else{

                damage = (int)(score * scoreMultiplier * 100);
                damage /= 100;

                Main.player.setHP(Main.player.getHP()-damage0);
                RyanFight.ryanHP-=damage;

                score = 0;
                frame = 30;
                phase = 0;
                scoreMultiplier = 0.3;

                Main.timerDamageWindow.setVisible(false);

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
        else if(phase == 1){

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
        else{

            g.setColor(Color.white);
            boldFont = new Font("SansSerif", Font.BOLD, 30);
            g.setFont(boldFont);
            g.drawString("You hit Ryan for "+damage+" damage!", 100, 75);
            g.drawString("He hit you back for "+damage0+" damage!", 100, 175);

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
