import javax.swing.*;
import java.awt.*;

public class PrateekFight extends JPanel {

    static int frame = 0;
    static int rand = 0;
    static boolean reason = false;
    static int reasonDuration = 0;
    static boolean checkHP = true;

    int criticalHealth = 0;
    static Font mainFont = new Font("SansSerif", Font.PLAIN, 25);
    static Font playerHPFont = new Font("SansSerif", Font.BOLD, 10);
    static Font numShieldFont = new Font("SansSerif", Font.PLAIN, 40);
    static Font numShieldFontBold = new Font("SansSerif", Font.BOLD, 30);
    String[] phrases = {"Ok buddy", "You're an idiot", "Alright bro"};
    static int prateekHP;
    private int phase = 0;
    public PrateekFight(){

        setBackground(Color.gray);
        prateekHP = 150;
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
        g.drawImage(shieldIcon.getImage(), 25, 350, 30, 30, null);
        g.setFont(numShieldFont);
        g.drawString("|", 58, 378);
        g.drawString(Main.player.getShields()+"", 70, 378);
        g.setColor(Color.red);
        g.fillRect(490, 20, 300, 50);
        g.fillRect(0, 680, 1280, 20);
        g.setColor(Color.green);
        g.fillRect(490, 20, prateekHP*2, 50);
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
        g.drawString("HP: "+prateekHP, 590, 55);
        ImageIcon prateekImage = new ImageIcon("Images/Prateek.png");
        g.drawImage(prateekImage.getImage(), 490, 75, 300, 300, null);
        switch(phase){

            case 0:
                TextBox.drawOptions(g);
                if(reason){

                    if(reasonDuration == 50){

                        reason = false;

                    }
                    else{

                        reasonDuration++;
                        TextBox.draw(g, phrases[rand], "Prateek");


                    }
                }
                if(Main.player.getHP() <= 20 && checkHP){

                    TextBox.draw(g, "Careful buddy", "Prateek");
                    if(frame > 100){

                        checkHP = false;

                    }

                }
                break;
            case 1:
                break;

        }

        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        frame++;
        repaint();

    }
    public void reason(){



    }

}
