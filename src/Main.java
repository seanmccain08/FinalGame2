import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Main {

    public static Player player = new Player();
    public static int games = 0;
    public static int menuSelected = 0;
    public static int inventorySelected = 0;
    public static int opponentSelected = 0;
    public static int gameSelected = 0;
    public static boolean starting = false;
    public static JFrame frame = new JFrame("Battle Simulator - Menu");
    public static JFrame frame1 = new JFrame("Opponent Select");
    public static Menu menu = new Menu();

    //Inventory Window
    public static JFrame inventoryWindow = new JFrame("Inventory");
    public static InventoryWindow inventory = new InventoryWindow();

    //Game Windows
    public static JFrame prateekFightWindow = new JFrame("Battle Simulator - Prateek");
    public static JFrame jackFightWindow = new JFrame("Battle Simulator - Jack");
    public static JFrame ryanFightWindow = new JFrame("Battle Simulator - Ryan");
    public static JFrame lukeFightWindow = new JFrame("Battle Simulator - Luke");
    public static PrateekFight prateekFight = new PrateekFight();

    public static void main(String[] args) {

        Sound.introSound();
        inventoryWindow.add(inventory);
        inventoryWindow.setSize(600, 400);
        inventoryWindow.setLocationRelativeTo(null);
        inventoryWindow.setResizable(false);
        prateekFightWindow.setSize(1280, 720);
        prateekFightWindow.setLocationRelativeTo(null);
        prateekFightWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        prateekFightWindow.setResizable(false);
        prateekFightWindow.setBackground(Color.black);
        prateekFightWindow.add(prateekFight);
        jackFightWindow.setSize(1280, 720);
        jackFightWindow.setLocationRelativeTo(null);
        jackFightWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jackFightWindow.setResizable(false);
        jackFightWindow.setBackground(Color.black);
        ryanFightWindow.setSize(1280, 720);
        ryanFightWindow.setLocationRelativeTo(null);
        ryanFightWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ryanFightWindow.setResizable(false);
        ryanFightWindow.setBackground(Color.black);
        lukeFightWindow.setSize(1280, 720);
        lukeFightWindow.setLocationRelativeTo(null);
        lukeFightWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        lukeFightWindow.setResizable(false);
        lukeFightWindow.setBackground(Color.black);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(1280, 720);
        frame.setBackground(Color.black);
        frame.setLocationRelativeTo(null);

        frame.add(menu);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                int key = e.getKeyCode();
                // Keys for menu interaction: "E", "Space", "Enter/Return"
                if(key == 32 || key == 10 || key == 69){

                    if(menuSelected == 0){

                        Sound.selectSound();
                        starting = true;

                    }
                    else{

                        Sound.backSound();
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException ex) {
                            throw new RuntimeException(ex);
                        }
                        Menu.quit();

                    }

                }

                //Up & Down arrow
                if(key == 38 || key == 40 || key == 87 || key == 83){

                    Sound.optionSound();
                    if(menuSelected == 0){

                        menuSelected = 1;

                    }
                    else{

                        menuSelected = 0;

                    }

                }

            }
        });

        //Opponent Select Window
        OpponentSelect game = new OpponentSelect();
        frame1.setSize(1280, 720);
        frame1.setLocationRelativeTo(null);
        frame1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame1.setResizable(false);
        frame1.setBackground(Color.black);
        frame1.add(game);
        frame1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                int key = e.getKeyCode();
                // Keys for menu interaction: "E", "Space", "Enter/Return"
                if(key == 32 || key == 10 || key == 69){

                    Sound.selectSound();
                    player.setHP(100);
                    player.giveItems();
                    if(opponentSelected == 0){

                        //Prateek
                        games++;
                        frame1.setVisible(false);
                        prateekFight = new PrateekFight();
                        prateekFightWindow.setVisible(true);

                    }
                    else if(opponentSelected == 1){

                        //Jack
                        games++;
                        frame1.setVisible(false);
                        jackFightWindow.setVisible(true);

                    }
                    else if(opponentSelected == 2){

                        //Ryan
                        games++;
                        frame1.setVisible(false);
                        ryanFightWindow.setVisible(true);

                    }
                    else{

                        //Luke
                        games++;
                        frame1.setVisible(false);
                        lukeFightWindow.setVisible(true);

                    }

                }
                //arrow keys -- Up/Down
                if(key == 38 || key == 40 || key == 87 || key == 83){
                    Sound.optionSound();
                    if(opponentSelected == 0){

                        opponentSelected = 1;

                    }
                    else if(opponentSelected == 1){

                        opponentSelected = 0;

                    }
                    else if(opponentSelected == 2){

                        opponentSelected = 3;

                    }
                    else{

                        opponentSelected = 2;

                    }

                }
                //arrow keys -- Left/Right
                if(key == 37 || key == 39 || key == 65 || key == 68){
                    Sound.optionSound();
                    if(opponentSelected == 0){

                        opponentSelected = 2;

                    }
                    else if(opponentSelected == 1){

                        opponentSelected = 3;

                    }
                    else if(opponentSelected == 2){

                        opponentSelected = 0;

                    }
                    else{

                        opponentSelected = 1;

                    }

                }

            }
        });

        prateekFightWindow.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                int key = e.getKeyCode();
                // Keys for menu interaction: "E", "Space", "Enter/Return"
                if(key == 32 || key == 10 || key == 69){

                    TextBox.select();

                }
                else{

                    TextBox.setGameSelected(e);

                }

            }
        });

        inventoryWindow.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                int key = e.getKeyCode();
                //System.out.println(key);
                // Keys for menu interaction: "E", "Space", "Enter/Return"
                if(key == 32 || key == 10 || key == 69){

                    if(inventorySelected == 0 || inventorySelected == 1 || inventorySelected == 2 || inventorySelected == 3){

                        Sound.altSelectSound();
                        if(player.getInventory()[inventorySelected].getName().equals("Bandage")){

                            player.useBandage(player.getInventory()[inventorySelected], inventorySelected);

                        }

                    }
                    else{

                        Sound.errorSound();
                        Sound.backSound();
                        inventoryWindow.setVisible(false);

                    }

                }
                //arrow keys -- Up/Down
                if(key == 38 || key == 87){
                    Sound.optionSound();
                    if(inventorySelected == 0){

                        inventorySelected = 4;

                    }
                    else if(inventorySelected == 1){

                        inventorySelected--;

                    }
                    else if(inventorySelected == 2){

                        inventorySelected--;

                    }
                    else if(inventorySelected == 3){

                        inventorySelected--;

                    }
                    else{

                        inventorySelected--;

                    }

                }
                else if(key == 40 || key == 83){
                    Sound.optionSound();
                    if(inventorySelected == 0){

                        inventorySelected++;

                    }
                    else if(inventorySelected == 1){

                        inventorySelected++;

                    }
                    else if(inventorySelected == 2){

                        inventorySelected++;

                    }
                    else if(inventorySelected == 3){

                        inventorySelected++;

                    }
                    else{

                        inventorySelected = 0;

                    }

                }

            }
        });

    }


}