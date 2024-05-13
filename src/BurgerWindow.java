import javax.swing.*;
import java.awt.*;

public class BurgerWindow extends JPanel {

    public BurgerWindow(){}

    public static boolean first = true;
    static Font mainFont = new Font("SansSerif", Font.PLAIN, 30);
    static Font boldFont = new Font("SansSerif", Font.BOLD, 30);
    static Font bodyFont = new Font("SansSerif", Font.PLAIN, 15);
    public static int lukeBurgerEaten = (int)(Math.random()*12+1);
    public static int burgerEaten = 15;
    boolean shield = false;
    boolean removeShield = false;
    public static int phase = 0;
    int damager = 0;
    int damage1 = 0;
    int frame = 40;
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
                if(Main.player.getShields() > 0){

                    shield = true;

                }

            }
            else{

                Main.burgerWindow.setVisible(false);
                frame = 40;
                phase = 0;
                if(damager == 0){

                    int damage = (15-burgerEaten)*2;
                    LukeFight.lukeHP -= (damage+Main.player.getDamageBonus());

                }
                else{

                    if(!shield){

                        Main.player.setHP(Main.player.getHP()-damage1);
                        damage1 = 0;

                    }

                }
                if(shield && removeShield){

                    Main.player.setShields(Main.player.getShields()-1);
                    shield = false;
                    removeShield = false;

                }
                lukeBurgerEaten = (int)(Math.random()*12+1);
                burgerEaten = 15;
                if(Main.player.getHP() <= 0){

                    Main.lukeFightWindow.setVisible(false);
                    JOptionPane.showMessageDialog(null, "You Lost! All bonuses have been removed.");
                    Menu.logoChoice = (int)(Math.random()*6+1);
                    Main.losses++;
                    Main.player.setShields(0);
                    Main.player.setDamageBonus(0);
                    Sound.introSound();
                    Main.frame.setVisible(true);

                }
                else if(LukeFight.lukeHP <= 0){

                    LukeFight.lukeHP = 0;
                    Main.lukeFightWindow.setVisible(false);
                    Sound.expandSound();
                    JOptionPane.showMessageDialog(null, "You Won! You will keep\nyour damage bonus & shields!");
                    Main.beatenLuke = true;
                    LukeFight.lukeHP = 450;
                    Sound.backSound();
                    Sound.introSound();
                    Main.wins++;
                    Menu.logoChoice = (int)(Math.random()*6+1);
                    Main.frame.setVisible(true);

                }

            }

        }
        if(phase == 0){

            g.setColor(Color.white);
            g.setFont(mainFont);
            g.drawString("Spam the Space Bar!", 160, 320);
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

            g.setColor(Color.white);
            boldFont = new Font("SansSerif", Font.BOLD, 30);
            g.setFont(boldFont);
            if(burgerEaten < lukeBurgerEaten){

                damager = 0;
                g.drawString("You ate more of the burger and", 60, 145);
                if(burgerEaten < 0){

                    burgerEaten = 0;

                }
                g.drawString("hit Luke for "+(((15-burgerEaten)*2)+Main.player.getDamageBonus())+" damage!", 100, 180);


            }
            else{

                damager = 1;
                if(shield){

                    g.drawString("Luke ate more of his burger and", 50, 145);
                    g.drawString("also ate your shield.", 120, 180);
                    removeShield = true;

                }
                else{

                    damage1 = 15-lukeBurgerEaten;
                    if(damage1 > 10){

                        damage1-=5;

                    }
                    g.drawString("Luke ate more of his burger and", 60, 145);
                    g.drawString("hit you for "+damage1+" damage!", 110, 180);

                }

            }


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
