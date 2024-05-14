import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public abstract class TextBox {

    static Font textBoxFont = new Font("SansSerif", Font.PLAIN, 50);
    static Font body = new Font("SansSerif", Font.ITALIC, 30);
    static Font boldFont = new Font("SansSerif", Font.BOLD, 50);

    static int previousReason = 0;

    public static void draw(Graphics g, String s, String t){

        int xPos = 825;
        int yPos = 110;
        g.setFont(textBoxFont);
        g.setColor(Color.black);
        g.fillRect(xPos, yPos, 350, 250);
        g.setColor(Color.white);
        g.drawString(t ,xPos+10, yPos+50);
        g.setFont(body);
        g.drawString(s, xPos+10, yPos+145);
        g.setFont(textBoxFont);

    }

    public static void select(){

        if(Main.gameSelected == 0){

            if(Main.currentOpponent.equals("Prateek")) {
                Sound.altSelectSound();
                Sound.expandSound();
                while (true) {

                    String s = JOptionPane.showInputDialog("To attack Prateek, you must type in a number between 1-10.\nA random number between 1-10 will be selected to compare,\nand the difference between the two is how much you hit the opponent for.\n\n(If you enter 3 and the number is 7, you will do\n4 damage because 7-3 = 4)");
                    if (s != null && (s.equals("1") || s.equals("2") || s.equals("3") || s.equals("4") || s.equals("5") || s.equals("6") || s.equals("7") || s.equals("8") || s.equals("9") || s.equals("10"))) {

                        Sound.altSelectSound();
                        int x = Integer.parseInt(s);
                        int comparison = (int) (Math.random() * 10 + 1);
                        if (comparison == x) {

                            JOptionPane.showMessageDialog(null, "You picked the same number as the number generator,\ndealing " + (0 + Main.player.getDamageBonus()) + " damage to Prateek.");
                            PrateekFight.prateekHP = PrateekFight.prateekHP - Main.player.getDamageBonus();
                            if (PrateekFight.prateekHP <= 0) {

                                PrateekFight.prateekHP = 0;
                                Main.prateekFightWindow.setVisible(false);
                                Sound.expandSound();
                                JOptionPane.showMessageDialog(null, "You Won! You will keep\nyour damage bonus & shields!");
                                Main.beatenPrateek = true;
                                Main.wins++;
                                Sound.backSound();
                                Sound.introSound();
                                Menu.logoChoice = (int)(Math.random()*6+1);
                                Main.frame.setVisible(true);
                                break;

                            }
                            Sound.altSelectSound();
                            if (Main.player.getShields() == 0) {
                                int damage = (int) (Math.random() * 6);
                                Main.player.setHP(Main.player.getHP() - damage);
                                if (damage == 0) {

                                    JOptionPane.showMessageDialog(null, "Prateek somehow managed to miss you,\ndealing no damage! If you have a shield,\nit will not be used!");
                                    Sound.altSelectSound();

                                } else {

                                    JOptionPane.showMessageDialog(null, "Prateek hit you for " + damage + " damage!");

                                }
                            } else {

                                JOptionPane.showMessageDialog(null, "Prateek bounced off of your shield & broke it!");
                                Main.player.setShields(Main.player.getShields() - 1);

                            }
                            Sound.altSelectSound();
                            Sound.backSound();
                            break;

                        } else if (comparison < x) {

                            int damage = (x - comparison);
                            PrateekFight.prateekHP -= (damage + Main.player.getDamageBonus());
                            JOptionPane.showMessageDialog(null, "You picked " + s + ", and the generator chose " + comparison + ".\nYou dealt " + (damage + Main.player.getDamageBonus()) + " damage to Prateek!");
                            Sound.altSelectSound();

                        } else {

                            int damage = (comparison - x);
                            PrateekFight.prateekHP -= (damage + Main.player.getDamageBonus());
                            JOptionPane.showMessageDialog(null, "You picked " + s + ", and the generator chose " + comparison + ".\nYou dealt " + (damage + Main.player.getDamageBonus()) + " damage to Prateek!");
                            Sound.altSelectSound();

                        }
                        if (PrateekFight.prateekHP <= 0) {

                            PrateekFight.prateekHP = 0;
                            Main.prateekFightWindow.setVisible(false);
                            Sound.expandSound();
                            JOptionPane.showMessageDialog(null, "You Won! You will keep\nyour damage bonus & shields!");
                            Main.beatenPrateek = true;
                            Sound.backSound();
                            Sound.introSound();
                            Menu.logoChoice = (int)(Math.random()*6+1);
                            Main.frame.setVisible(true);
                            Main.wins++;
                            break;

                        }
                        if (Main.player.getShields() == 0) {

                            int damage = (int) (Math.random() * 9 + 1);
                            Main.player.setHP(Main.player.getHP() - damage);
                            JOptionPane.showMessageDialog(null, "Prateek hit you for " + damage + " damage!");

                        } else {

                            JOptionPane.showMessageDialog(null, "Prateek bounced off of your shield & broke it!");
                            Main.player.setShields(Main.player.getShields() - 1);

                        }
                        Sound.altSelectSound();
                        Sound.backSound();
                        if (Main.player.getHP() < 1) {

                            Main.prateekFightWindow.setVisible(false);
                            JOptionPane.showMessageDialog(null, "You Lost! All bonuses have been removed.");
                            Menu.logoChoice = (int)(Math.random()*6+1);
                            Main.player.setShields(0);
                            Main.player.setDamageBonus(0);
                            Sound.introSound();
                            Main.losses++;
                            Main.prateekFightWindow.setVisible(false);
                            Main.frame.setVisible(true);

                        }
                        break;

                    }
                    else {

                        Sound.errorSound();
                        JOptionPane.showMessageDialog(null, "Please enter a number 1-10.");
                        Sound.expandSound();

                    }

                }
            }
            else if(Main.currentOpponent == "Jack"){

                while (true) {
                    int x = 0;
                    if(CoinFlipWindow.value == 0){

                        Sound.expandSound();
                        Main.coinFlipWindow.setVisible(true);

                    }
                    else{

                        x = CoinFlipWindow.value;
                        int comparison = (int)(Math.random()*2+1);
                        if(x == comparison){

                            int damage = (int)(Math.random()*10+5)+Main.player.getDamageBonus();
                            JackFight.jackHP-=damage;
                            JOptionPane.showMessageDialog(null, "You won the coin toss! You did "+damage+" damage to Jack!");
                            if (JackFight.jackHP <= 0) {

                                JackFight.jackHP = 0;
                                Main.jackFightWindow.setVisible(false);
                                Sound.expandSound();
                                JOptionPane.showMessageDialog(null, "You Won! You will keep\nyour damage bonus & shields!");
                                Main.beatenJack = true;
                                Sound.backSound();
                                Sound.introSound();
                                Main.wins++;
                                Menu.logoChoice = (int)(Math.random()*6+1);
                                Main.frame.setVisible(true);
                                break;

                            }

                        }
                        else{

                            if (Main.player.getShields() == 0) {

                                int damage = (int) (Math.random() * 12 + 5);
                                Main.player.setHP(Main.player.getHP() - damage);
                                JOptionPane.showMessageDialog(null, "You lost the coin toss!\nJack hit you for " + damage + " damage!");

                            }
                            else {

                                JOptionPane.showMessageDialog(null, "You lost the coin toss!\nJack stared at your shield and it broke.");
                                Main.player.setShields(Main.player.getShields() - 1);

                            }

                        }
                        Sound.altSelectSound();
                        Sound.backSound();

                    }
                    if (Main.player.getHP() < 1) {

                        Main.jackFightWindow.setVisible(false);
                        JOptionPane.showMessageDialog(null, "You Lost! All bonuses have been removed.");
                        Menu.logoChoice = (int)(Math.random()*6+1);
                        Main.losses++;
                        Main.player.setShields(0);
                        Main.player.setDamageBonus(0);
                        Sound.introSound();
                        Main.jackFight.setVisible(false);
                        Main.frame.setVisible(true);

                    }
                    CoinFlipWindow.value = 0;
                    break;

                }

            }
            else if(Main.currentOpponent == "Ryan"){

                Sound.altSelectSound();
                Sound.expandSound();
                if(TimerDamageWindow.first){

                    JOptionPane.showMessageDialog(null, "When you press OK, you will have to\nspam the Space Bar to increase the\namount of damage you deal\n(given a small amount of time).\nThen you will spam for the multiplier\nwhich starts at 0.\n\nThis message will only show once");
                    TimerDamageWindow.first = false;
                    Sound.altSelectSound();

                }
                Main.timerDamageWindow.setVisible(true);

            }
            else if(Main.currentOpponent == "Luke"){

                Sound.altSelectSound();
                Sound.expandSound();
                if(BurgerWindow.first){

                    JOptionPane.showMessageDialog(null, "When you press OK, you will have to\nspam the Space Bar to eat a burger.\nIf you manage to eat more than luke,\nyou will deal damage.");
                    BurgerWindow.first = false;
                    Sound.altSelectSound();

                }
                Main.burgerWindow.setVisible(true);

            }
        }
        else if(Main.gameSelected == 1){

            if(Main.currentOpponent.equals("Prateek")){

                Sound.reasonSound();
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
            else if(Main.currentOpponent.equals("Jack")){

                Sound.reasonSound();
                JackFight.rand = (int)(Math.random()*3);
                while(true){

                    if(JackFight.rand == previousReason){

                        JackFight.rand = (int)(Math.random()*3);

                    }
                    else{

                        break;

                    }

                }
                previousReason = JackFight.rand;
                JackFight.reason = true;
                JackFight.reasonDuration = 0;

            }
            else if(Main.currentOpponent == "Ryan"){

                Sound.reasonSound();
                RyanFight.rand = (int)(Math.random()*3);
                while(true){

                    if(RyanFight.rand == previousReason){

                        RyanFight.rand = (int)(Math.random()*3);

                    }
                    else{

                        break;

                    }

                }
                previousReason = RyanFight.rand;
                RyanFight.reason = true;
                RyanFight.reasonDuration = 0;

            }
            else if(Main.currentOpponent == "Luke"){

                Sound.reasonSound();
                LukeFight.rand = (int)(Math.random()*3);
                while(true){

                    if(LukeFight.rand == previousReason){

                        LukeFight.rand = (int)(Math.random()*3);

                    }
                    else{

                        break;

                    }

                }
                previousReason = LukeFight.rand;
                LukeFight.reason = true;
                LukeFight.reasonDuration = 0;

            }

        }
        else if(Main.gameSelected == 2){

            Sound.altSelectSound();
            Sound.expandSound();
            Main.inventoryWindow.setVisible(true);
            Main.inventorySelected = 0;

        }
        else{

            Sound.errorSound();
            Sound.expandSound();
            int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit the battle?\nAll shields & bonuses will be lost!", "Quit?",0, 2);
            Sound.backSound();
            if(choice == JOptionPane.YES_OPTION){

                Sound.introSound();
                TimerDamageWindow.first = true;
                Main.games--;
                Menu.logoChoice = (int)(Math.random()*6+1);
                Main.gameSelected = 0;
                Main.opponentSelected = 0;
                Main.prateekFightWindow.setVisible(false);
                Main.jackFightWindow.setVisible(false);
                Main.ryanFightWindow.setVisible(false);
                Main.lukeFightWindow.setVisible(false);
                Main.frame.setVisible(true);
                Main.player.setDamageBonus(0);
                Main.player.setShields(0);

            }

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
