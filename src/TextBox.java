import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public abstract class TextBox {

    static Font textBoxFont = new Font("SansSerif", Font.PLAIN, 50);
    static Font body = new Font("SansSerif", Font.ITALIC, 30);
    static Font boldFont = new Font("SansSerif", Font.BOLD, 50);

    static int previousReason = 0;

    public static void draw(Graphics g, String s, String t){

        g.setFont(textBoxFont);
        g.setColor(Color.black);
        g.fillRect(100, 50, 350, 250);
        g.setColor(Color.white);
        g.drawString(t ,110, 100);
        g.setFont(body);
        g.drawString(s, 110, 190);
        g.setFont(textBoxFont);

    }

    public static void select(){

        if(Main.gameSelected == 0){

            Sound.altSelectSound();
            Sound.expandSound();
//            Main.player.setHP(Main.player.getHP()-1);
//            PrateekFight.frame = 0;
//            PrateekFight.checkHP = true;

            while(true){

                String s = JOptionPane.showInputDialog("To attack Prateek, you must type in a number between 1-12.\nA random number between 1-12 will be selected to compare,\nand the difference between the two is how much you hit the opponent for.\n\n(If you enter 3 and the number is 7, you will do\n4 damage because 7-3 = 4)");
                if(s.equals("1") || s.equals("2") || s.equals("3") || s.equals("4") || s.equals("5") || s.equals("6") || s.equals("7") || s.equals("8") || s.equals("9") || s.equals("10") || s.equals("11") || s.equals("12")){

                    Sound.altSelectSound();
                    int x = Integer.parseInt(s);
                    int comparison = (int)(Math.random()*12+1);
                    if(comparison == x){

                        JOptionPane.showMessageDialog(null, "You picked the same number as the number generator,\ndealing 0 damage to Prateek. Unlucky.");
                        Sound.altSelectSound();
                        int damage = (int)(Math.random()*6);
                        Main.player.setHP(Main.player.getHP()-damage);
                        if(damage == 0){

                            JOptionPane.showMessageDialog(null, "Prateek somehow managed to miss you,\ndealing no damage!");
                            Sound.altSelectSound();

                        }
                        else{

                            JOptionPane.showMessageDialog(null, "Prateek hit you for "+damage+" damage!");
                            Sound.altSelectSound();

                        }
                        Sound.backSound();
                        break;

                    }
                    else if(comparison < x){

                        int damage = (x-comparison);
                        PrateekFight.prateekHP -= damage;
                        JOptionPane.showMessageDialog(null, "You picked "+s+", and the generator chose "+comparison+".\nYou dealt "+damage+" damage to Prateek!");
                        Sound.altSelectSound();

                    }
                    else{

                        int damage = (comparison-x);
                        PrateekFight.prateekHP -= damage;
                        JOptionPane.showMessageDialog(null, "You picked "+s+", and the generator chose "+comparison+".\nYou dealt "+damage+" damage to Prateek!");
                        Sound.altSelectSound();

                    }
                    int damage = (int)(Math.random()*10+1);
                    Main.player.setHP(Main.player.getHP()-damage);
                    JOptionPane.showMessageDialog(null, "Prateek hit you back for "+damage+" damage!");
                    Sound.altSelectSound();
                    Sound.backSound();
                    if(Main.player.getHP() <= 0){

                        Main.prateekFightWindow.setVisible(false);
                        int close = JOptionPane.showConfirmDialog(null, "You Lost");
                        if(close == JOptionPane.YES_OPTION){

                            Sound.backSound();
                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            System.exit(0);

                        }
                        else{

                            Sound.introSound();
                            Main.prateekFightWindow.setVisible(false);
                            Main.frame.setVisible(true);

                        }

                    }
                    break;

                }
                else{

                    Sound.errorSound();
                    JOptionPane.showMessageDialog(null, "Please enter a number 1-15.");
                    Sound.expandSound();

                }

            }

        }
        else if(Main.gameSelected == 1){

            Sound.altSelectSound();
            PrateekFight.rand = (int)(Math.random()*3);
            while(true){

                if(PrateekFight.rand == previousReason){

                    PrateekFight.rand = (int)(Math.random()*3);

                }
                else{

                    break;

                }

            }
            previousReason = PrateekFight.rand;
            PrateekFight.reason = true;
            PrateekFight.reasonDuration = 0;

        }
        else if(Main.gameSelected == 2){

            Sound.altSelectSound();
            Sound.expandSound();
            Main.inventoryWindow.setVisible(true);
            Main.inventorySelected = 0;

        }
        else{

            Sound.errorSound();
            Sound.backSound();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.exit(0);

        }

    }
    public static void setGameSelected(KeyEvent e){

        int key = e.getKeyCode();
        //arrow keys -- Up/Down
        if(key == 38 || key == 40 || key == 87 || key == 83){

            Sound.optionSound();
            if(Main.gameSelected == 0){

                Main.gameSelected = 1;

            }
            else if(Main.gameSelected == 1){

                Main.gameSelected = 0;

            }
            else if(Main.gameSelected == 2){

                Main.gameSelected = 3;

            }
            else{

                Main.gameSelected = 2;

            }

        }
        //arrow keys -- Left/Right
        if(key == 37 || key == 39 || key == 65 || key == 68){

            Sound.optionSound();
            if(Main.gameSelected == 0){

                Main.gameSelected = 2;

            }
            else if(Main.gameSelected == 1){

                Main.gameSelected = 3;

            }
            else if(Main.gameSelected == 2){

                Main.gameSelected = 0;

            }
            else{

                Main.gameSelected = 1;

            }

        }

    }

    public static void drawOptions(Graphics g){

        int n = Main.gameSelected;
        g.setColor(Color.black);
        g.fillRect(0, 400, 1280, 280);
        if(n == 0){

            //Top left
            g.setFont(boldFont);
            g.setColor(Color.yellow);
            g.drawString("Fight", 260, 490);
            g.drawRect(25, 425, 600, 100);
            //Bottom Left
            g.setFont(textBoxFont);
            g.setColor(Color.white);
            g.drawString("Reason", 240, 615);
            g.drawRect(25, 550, 600, 100);
            //Top right
            g.drawString("Item", 905, 490);
            g.drawRect(650, 425, 600, 100);
            //Bottom Right
            g.drawString("Quit", 905, 615);
            g.drawRect(650, 550, 600, 100);

        }
        else if(n == 1){

            g.setFont(textBoxFont);
            g.setColor(Color.white);
            g.drawString("Fight", 265, 490);
            g.drawRect(25, 425, 600, 100);
            g.setColor(Color.yellow);
            g.drawRect(25, 550, 600, 100);
            g.setFont(boldFont);
            g.drawString("Reason", 235, 615);
            g.setFont(textBoxFont);
            g.setColor(Color.white);
            g.drawString("Item", 905, 490);
            g.drawRect(650, 425, 600, 100);
            g.drawString("Quit", 905, 615);
            g.drawRect(650, 550, 600, 100);

        }
        else if(n == 2){

            g.setFont(textBoxFont);
            g.setColor(Color.white);
            g.drawString("Fight", 265, 490);
            g.drawRect(25, 425, 600, 100);
            g.drawRect(25, 550, 600, 100);
            g.setColor(Color.yellow);
            g.setFont(boldFont);
            g.drawString("Item", 900, 490);
            g.setFont(textBoxFont);
            g.drawRect(650, 425, 600, 100);
            g.setColor(Color.white);
            g.drawString("Reason", 240, 615);
            g.drawString("Quit", 905, 615);
            g.drawRect(650, 550, 600, 100);

        }
        else{

            g.setFont(textBoxFont);
            g.setColor(Color.white);
            g.drawString("Fight", 265, 490);
            g.drawRect(25, 425, 600, 100);
            g.drawRect(25, 550, 600, 100);
            g.drawString("Item", 905, 490);
            g.drawRect(650, 425, 600, 100);
            g.drawString("Reason", 240, 615);
            g.setColor(Color.yellow);
            g.setFont(boldFont);
            g.drawRect(650, 550, 600, 100);
            g.drawString("Quit", 900, 615);
            g.setFont(textBoxFont);
            g.setColor(Color.white);

        }

    }

}
