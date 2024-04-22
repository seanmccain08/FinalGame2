import javax.swing.*;
import java.awt.*;

public class TimerDamageWindow extends JPanel {

    public TimerDamageWindow(){



    }

    static Font mainFont = new Font("SansSerif", Font.PLAIN, 30);
    static Font boldFont = new Font("SansSerif", Font.BOLD, 50);

    static boolean shield = false;
    public static int damage0 = (int)(Math.random()*10+5);
    static boolean increase = false;
    static int fontSize = 50;
    static int posX0 = 175;
    static int posX1 = 160;
    public static int phase = 0;
    public static boolean first = true;
    static int frame = 20;
    public static int score = 0;
    public static double scoreMultiplier = 1;

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

                frame = 45;
                phase++;

                damage = (int)(score * scoreMultiplier * 10);
                damage /= 10;
                damage += Main.player.getDamageBonus();

                RyanFight.ryanHP-=damage;
                RyanFight.ryanHP=(int)(RyanFight.ryanHP*10);
                RyanFight.ryanHP/=10;
                if (RyanFight.ryanHP <= 0.0) {

                    RyanFight.ryanHP = 0.0;
                    Main.ryanFightWindow.setVisible(false);
                    Main.timerDamageWindow.setVisible(false);
                    Sound.expandSound();
                    JOptionPane.showMessageDialog(null, "You Won! You will keep\nyour damage bonus & shields!");
                    Sound.backSound();
                    Sound.introSound();
                    Main.wins++;
                    Menu.logoChoice = (int)(Math.random()*6+1);
                    Main.frame.setVisible(true);

                }
                if(Main.player.getShields() > 0){

                    shield = true;

                }
                if(!shield){

                    Main.player.setHP(Main.player.getHP()-damage0);

                }
                if (Main.player.getHP() < 1) {

                    Main.ryanFightWindow.setVisible(false);
                    Main.timerDamageWindow.setVisible(false);
                    JOptionPane.showMessageDialog(null, "You Lost! All bonuses have been removed.");
                    Menu.logoChoice = (int)(Math.random()*6+1);
                    Main.losses++;
                    Main.player.setShields(0);
                    Main.player.setDamageBonus(0);
                    Sound.introSound();
                    Main.frame.setVisible(true);

                }

            }
            else{

                score = 0;
                frame = 30;
                phase = 0;
                scoreMultiplier = 1;
                damage0 = (int)(Math.random()*10+5);
                if(Main.player.getShields() > 0){

                    Main.player.setShields(Main.player.getShields()-1);

                }
                shield = false;

                Main.timerDamageWindow.setVisible(false);

            }

        }

        g.setColor(Color.red);
        g.fillRect(0, 0, 600, 50);
        g.setColor(Color.green);
        int timerBarSizeX = frame*20;
        g.fillRect(0, 0, timerBarSizeX, 50);

        if(phase == 0){

            g.setColor(Color.white);
            g.setFont(mainFont);
            g.drawString("Spam the Space Bar!", 160, 300);
            g.setFont(boldFont);
            g.setColor(Color.yellow);

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

            g.setColor(Color.white);
            g.setFont(mainFont);
            g.drawString("Spam the Space Bar!", 160, 300);
            g.setFont(boldFont);
            g.setColor(Color.yellow);

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
            g.drawString("You hit Ryan for "+damage+" damage!", 80, 145);
            if(shield){

                g.drawString("He kicked your shield", 120, 225);
                g.drawString("and it broke", 180, 265);

            }
            else{

                g.drawString("He hit you back for "+damage0+" damage!", 65, 225);

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
