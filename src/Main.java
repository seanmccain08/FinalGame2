import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {


    public static String version = "Update 0.8";
    public static String currentOpponent = "";
    public static Player player = new Player();
    public static int games = 0;
    public static int wins = 0;
    public static int losses = 0;
    public static int saveDataSelected = 0;
    public static int menuSelected = 0;
    public static int coinFlipSelected = 0;
    public static int inventorySelected = 0;
    public static int opponentSelected = 0;
    public static int gameSelected = 0;
    public static boolean starting = false;
    public static JFrame frame = new JFrame("Battle Simulator - Menu");
    public static JFrame frame1 = new JFrame("Opponent Select");
    public static Menu menu = new Menu();

    //Inventory Window
    public static JFrame inventoryWindow = new JFrame("Inventory");
    public static JFrame coinFlipWindow = new JFrame("Flip a coin");
    public static JFrame saveDataWindow = new JFrame("Load Game");
    public static InventoryWindow inventory = new InventoryWindow();
    public static CoinFlipWindow coinFlip = new CoinFlipWindow();
    public static SaveDataWindow saveData = new SaveDataWindow();

    //Game Windows
    public static JFrame prateekFightWindow = new JFrame("Battle Simulator - Prateek");
    public static JFrame jackFightWindow = new JFrame("Battle Simulator - Jack");
    public static JFrame ryanFightWindow = new JFrame("Battle Simulator - Ryan");
    public static JFrame lukeFightWindow = new JFrame("Battle Simulator - Luke");
    public static PrateekFight prateekFight = new PrateekFight();
    public static JackFight jackFight = new JackFight();
    public static RyanFight ryanFight = new RyanFight();
    public static LukeFight lukeFight = new LukeFight();

    public static void main(String[] args) {
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(1280, 720);
        frame.setBackground(Color.black);
        frame.setLocationRelativeTo(null);
        frame.add(menu);
        frame.setResizable(false);
        saveDataWindow.add(saveData);
        saveDataWindow.setSize(600, 400);
        saveDataWindow.setLocationRelativeTo(null);
        saveDataWindow.setResizable(false);
        Sound.expandSound();
        int x = JOptionPane.showConfirmDialog(null, "Do you want to load previous\nsave data?", "Load?", 0, 2);
        Sound.selectSound();
        if(x == 0){

            saveDataWindow.setVisible(true);

        }
        else{

            Sound.selectSound();
            Sound.introSound();
            frame.setVisible(true);

        }
        inventoryWindow.add(inventory);
        inventoryWindow.setSize(600, 400);
        inventoryWindow.setLocationRelativeTo(null);
        inventoryWindow.setResizable(false);
        coinFlipWindow.add(coinFlip);
        coinFlipWindow.setSize(600, 400);
        coinFlipWindow.setLocationRelativeTo(null);
        coinFlipWindow.setResizable(false);
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
        jackFightWindow.add(jackFight);
        ryanFightWindow.setSize(1280, 720);
        ryanFightWindow.setLocationRelativeTo(null);
        ryanFightWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ryanFightWindow.setResizable(false);
        ryanFightWindow.setBackground(Color.black);
        ryanFightWindow.add(ryanFight);
        lukeFightWindow.setSize(1280, 720);
        lukeFightWindow.setLocationRelativeTo(null);
        lukeFightWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        lukeFightWindow.setResizable(false);
        lukeFightWindow.setBackground(Color.black);
        lukeFightWindow.add(lukeFight);

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
                if(key == 27){

                    Sound.altBackSound();
                    frame1.setVisible(false);
                    frame.setVisible(true);

                }
                else if(key == 76){

                    Sound.errorSound();
                    int x = JOptionPane.showConfirmDialog(null, "Are you sure you want to load?\nThis will overwrite unsaved data!", "Load?", 0, 2);
                    if(x == 0){

                        Sound.expandSound();
                        SaveDataWindow.saveMode = false;
                        saveDataWindow.setVisible(true);

                    }
                    Sound.selectSound();

                }
                else if(key == 83){

                    Sound.errorSound();
                    int x = JOptionPane.showConfirmDialog(null, "Are you sure you want to save?\nThis will overwrite previous save data!", "Save?", 0, 2);
                    if(x == 0){

                        Sound.expandSound();
                        SaveDataWindow.saveMode = true;
                        saveDataWindow.setVisible(true);

                    }
                    Sound.selectSound();

                }
                else if(key == 32 || key == 10 || key == 69){

                    Sound.selectSound();
                    player.setHP(100);
                    player.giveItems();
                    if(opponentSelected == 0){

                        //Prateek
                        games++;
                        currentOpponent = "Prateek";
                        frame1.setVisible(false);
                        prateekFight = new PrateekFight();
                        prateekFightWindow.setVisible(true);

                    }
                    else if(opponentSelected == 1){

                        //Jack
                        games++;
                        currentOpponent = "Jack";
                        CoinFlipWindow.value = 0;
                        frame1.setVisible(false);
                        jackFight = new JackFight();
                        jackFightWindow.setVisible(true);

                    }
                    else if(opponentSelected == 2){

                        //Ryan
                        games++;
                        currentOpponent = "Ryan";
                        frame1.setVisible(false);
                        ryanFight = new RyanFight();
                        ryanFightWindow.setVisible(true);

                    }
                    else{

                        //Luke
                        games++;
                        currentOpponent = "Luke";
                        frame1.setVisible(false);
                        lukeFightWindow.setVisible(true);

                    }

                }
                //arrow keys -- Up/Down
                if(key == 38 || key == 40){
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
                if(key == 37 || key == 39){
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

        jackFightWindow.addKeyListener(new KeyAdapter() {
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
        ryanFightWindow.addKeyListener(new KeyAdapter() {
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
        lukeFightWindow.addKeyListener(new KeyAdapter() {
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

                        if(player.getInventory()[inventorySelected].getName().equals("Empty")) {

                            Sound.errorSound();

                        }
                        else if(player.getInventory()[inventorySelected].getName().equals("Bandage")){

                            player.useBandage(player.getInventory()[inventorySelected], inventorySelected);
                            Sound.altSelectSound();

                        }
                        else if(player.getInventory()[inventorySelected].getName().equals("Shield")){

                            player.useShield(player.getInventory()[inventorySelected], inventorySelected);
                            Sound.altSelectSound();

                        }
                        else if(player.getInventory()[inventorySelected].getName().equals("Mullet")){

                            player.useMullet(player.getInventory()[inventorySelected], inventorySelected);
                            Sound.altSelectSound();

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
                    if(inventorySelected < 4 && Main.player.getInventory()[inventorySelected].getName().equals("Empty")){

                        Sound.unavailableSound();

                    }
                    else{

                        Sound.optionSound();

                    }

                }
                else if(key == 40 || key == 83){
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
                    if(inventorySelected < 4 && Main.player.getInventory()[inventorySelected].getName().equals("Empty")){

                        Sound.unavailableSound();

                    }
                    else{

                        Sound.optionSound();

                    }

                }

            }
        });
        coinFlipWindow.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                int key = e.getKeyCode();
                // Keys for menu interaction: "E", "Space", "Enter/Return"
                if(key == 32 || key == 10 || key == 69){

                    if(coinFlipSelected == 0){

                        CoinFlipWindow.value = 1;

                    }
                    else{

                        CoinFlipWindow.value = 2;

                    }
                    coinFlipWindow.setVisible(false);
                    Sound.altSelectSound();
                    TextBox.select();

                }
                else if(key == 38 || key == 87 || key == 40 || key == 83){

                    Sound.optionSound();
                    if(coinFlipSelected == 0){

                        coinFlipSelected = 1;

                    }
                    else{

                        coinFlipSelected = 0;

                    }

                }

            }
        });

        saveDataWindow.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                int key = e.getKeyCode();
                //System.out.println(key);
                // Keys for menu interaction: "E", "Space", "Enter/Return"
                if(key == 32 || key == 10 || key == 69){

                    Sound.selectSound();
                    Sound.introSound();
                    if(saveDataSelected == 0){

                        if(SaveDataWindow.saveMode){

                            try {
                                Save.save("save1.txt");
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }

                        }
                        else{

                            try {
                                Load.load("save1.txt");
                            } catch (FileNotFoundException ex) {
                                throw new RuntimeException(ex);
                            }

                        }

                    }
                    else if(saveDataSelected == 1){

                        if(SaveDataWindow.saveMode){

                            try {
                                Save.save("save2.txt");
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }

                        }
                        else{

                            try {
                                Load.load("save2.txt");
                            } catch (FileNotFoundException ex) {
                                throw new RuntimeException(ex);
                            }

                        }

                    }
                    else if(saveDataSelected == 2){

                        if(SaveDataWindow.saveMode){

                            try {
                                Save.save("save3.txt");
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }

                        }
                        else{

                            try {
                                Load.load("save3.txt");
                            } catch (FileNotFoundException ex) {
                                throw new RuntimeException(ex);
                            }

                        }

                    }
                    Sound.backSound();
                    Main.saveDataWindow.setVisible(false);
                    Main.frame1.setVisible(false);
                    Main.frame.setVisible(true);

                }
                //arrow keys -- Up/Down
                if(key == 38 || key == 87){
                    Sound.optionSound();
                    if(saveDataSelected == 0){

                        saveDataSelected = 3;

                    }
                    else if(saveDataSelected == 1){

                        saveDataSelected--;

                    }
                    else if(saveDataSelected == 2){

                        saveDataSelected--;

                    }
                    else{

                        saveDataSelected--;

                    }

                }
                else if(key == 40 || key == 83){
                    Sound.optionSound();
                    if(saveDataSelected == 0){

                        saveDataSelected++;

                    }
                    else if(saveDataSelected == 1){

                        saveDataSelected++;

                    }
                    else if(saveDataSelected == 2){

                        saveDataSelected++;

                    }
                    else{

                        saveDataSelected = 0;

                    }

                }

            }
        });

    }


}