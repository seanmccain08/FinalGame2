import javax.swing.*;
import java.awt.*;

public class LukeFight extends JPanel {

    static int frame = 0;
    static int rand = 0;
    static boolean reason = false;
    static int reasonDuration = 0;
    static boolean checkHP = true;

    int criticalHealth = 0;
    static Font mainFont = new Font("SansSerif", Font.PLAIN, 25);
    static Font playerHPFont = new Font("SansSerif", Font.BOLD, 10);
    static Font numShieldFont = new Font("SansSerif", Font.PLAIN, 40);
    String[] phrases = {"Put the phone down","What the sigma?","Shut up man"};
    static int lukeHP;
    public LukeFight(){

        setBackground(Color.gray);
        lukeHP = 450;
        criticalHealth = 0;
        checkHP = true;
        reasonDuration = 0;
        reason = false;
        rand = 0;
        frame = 0;

    }

    @Override
    public void paintComponent(Graphics g){

        g.setColor(Color.black);
        ImageIcon shieldIcon = new ImageIcon("Images/shield.png");
        ImageIcon starIcon = new ImageIcon("Images/star.png");
        g.drawImage(shieldIcon.getImage(), 25, 350, 30, 30, null);
        g.drawImage(starIcon.getImage(), 20, 295, 40, 40, null);
        g.setFont(numShieldFont);
        g.drawString("|", 58, 378);
        g.drawString("|", 58, 328);
        g.drawString(Main.player.getShields()+"", 70, 378);
        g.drawString(Main.player.getDamageBonus()+"", 70, 328);
        g.setColor(Color.red);
        g.fillRect(190, 20, 900, 50);
        g.fillRect(0, 680, 1280, 20);
        g.setColor(Color.green);
        g.fillRect(190, 20, lukeHP*2, 50);
        int playerHealth = (int)(Main.player.getHP()*12.8);
        if(Main.player.getHP() <= 20){

            if(criticalHealth < 5){

                criticalHealth++;
                g.setColor(Color.red);
                g.fillRect(0, 680, playerHealth, 20);

            }
            else{

                criticalHealth++;
                if(criticalHealth == 10){

                    criticalHealth = 0;

                }
                g.setColor(Color.yellow);
                g.fillRect(0, 680, playerHealth, 20);

            }

        }
        else{

            g.setColor(Color.green);
            g.fillRect(0, 680, playerHealth, 20);

        }
        g.setFont(playerHPFont);
        g.setColor(Color.black);
        g.drawString(Main.player.getHP()+"", (playerHealth/2)-5, 690);
        g.setFont(mainFont);
        g.drawString("HP: "+lukeHP, 590, 55);
        ImageIcon lukeImage = new ImageIcon("Images/luke.png");
        g.drawImage(lukeImage.getImage(), 490, 75, 300, 300, null);
        TextBox.drawOptions(g);
        if(reason){

            if(reasonDuration == 50){

                reason = false;

            }
            else{

                reasonDuration++;
                TextBox.draw(g, phrases[rand], "Luke");


            }
        }
        if(Main.player.getHP() <= 20 && checkHP){

            TextBox.draw(g, "Careful buddy", "Luke");
            if(frame > 100){

                checkHP = false;

            }

        }

        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        frame++;
        repaint();

    }

}
