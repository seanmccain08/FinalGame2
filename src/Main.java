import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {


    public static boolean firstLoad = true;
    public static String version = "Version 1.1";

    //For Seaver fight (Will be saved to the file)
    public static int codeDigit1 = (int)(Math.random()*10);
    public static int codeDigit2 = (int)(Math.random()*10);
    public static int codeDigit3 = (int)(Math.random()*10);
    public static int codeDigit4 = (int)(Math.random()*10);

    public static boolean beatenPrateek = false;
    public static boolean beatenJack = false;
    public static boolean beatenRyan = false;
    public static boolean beatenLuke = false;

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
    public static int settingsSelected = 0;
    public static boolean starting = false;
    public static JFrame frame = new JFrame("Battle Simulator - Menu");
    public static JFrame frame1 = new JFrame("Opponent Select");
    public static Menu menu = new Menu();

    //Misc Windows
    public static JFrame settingsWindow = new JFrame("Settings");
    public static JFrame inventoryWindow = new JFrame("Inventory");
    public static JFrame coinFlipWindow = new JFrame("Flip a coin");
    public static JFrame saveDataWindow = new JFrame("Load Game");
    public static JFrame timerDamageWindow = new JFrame("Spam");
    public static JFrame burgerWindow = new JFrame("Spam");
    public static SettingsWindow settings = new SettingsWindow();
    public static InventoryWindow inventory = new InventoryWindow();
    public static CoinFlipWindow coinFlip = new CoinFlipWindow();
    public static SaveDataWindow saveData = new SaveDataWindow();
    public static TimerDamageWindow timerDamage = new TimerDamageWindow();
    public static BurgerWindow burger = new BurgerWindow();

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
        else {

            Sound.selectSound();
            Sound.introSound();
            frame.setVisible(true);

        }
        firstLoad = false;
        inventoryWindow.add(inventory);
        inventoryWindow.setSize(600, 400);
        inventoryWindow.setLocationRelativeTo(null);
        inventoryWindow.setResizable(false);
        settingsWindow.add(settings);
        settingsWindow.setSize(600, 400);
        settingsWindow.setLocationRelativeTo(null);
        settingsWindow.setResizable(false);
        coinFlipWindow.add(coinFlip);
        coinFlipWindow.setSize(600, 400);
        coinFlipWindow.setLocationRelativeTo(null);
        coinFlipWindow.setResizable(false);
        timerDamageWindow.add(timerDamage);
        timerDamageWindow.setSize(600, 400);
        timerDamageWindow.setLocationRelativeTo(null);
        timerDamageWindow.setResizable(false);
        burgerWindow.add(burger);
        burgerWindow.setSize(600, 400);
        burgerWindow.setLocationRelativeTo(null);
        burgerWindow.setResizable(false);
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
                    else if(menuSelected == 1){

                        Main.settingsSelected = 0;
                        settingsWindow.setVisible(true);
                        Sound.expandSound();

                    }
                    else{

                        Menu.quit();

                    }

                }

                //Up & Down arrow
                if(key == 40 || key == 83){

                    Sound.optionSound();
                    if(menuSelected == 0){

                        menuSelected = 1;

                    }
                    else if(menuSelected == 1){

                        menuSelected = 2;

                    }
                    else{

                        menuSelected = 0;

                    }

                }
                else if(key == 38 || key == 87){

                    Sound.optionSound();
                    if(menuSelected == 0){

                        menuSelected = 2;

                    }
                    else if(menuSelected == 1){

                        menuSelected = 0;

                    }
                    else{

                        menuSelected = 1;

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
                        SaveDataWindow.saveDataMode = 1;
                        saveDataWindow.setVisible(true);

                    }
                    Sound.selectSound();

                }
                else if(key == 83){

                    Sound.errorSound();
                    int x = JOptionPane.showConfirmDialog(null, "Are you sure you want to save?\nThis could overwrite previous save data!", "Save?", 0, 2);
                    if(x == 0){

                        Sound.expandSound();
                        SaveDataWindow.saveDataMode = 0;
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
        timerDamageWindow.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                int key = e.getKeyCode();
                // Keys for menu interaction: "E", "Space", "Enter/Return"
                if(key == 32){

                    if(TimerDamageWindow.phase == 0){

                        TimerDamageWindow.score++;

                    }
                    else{

                        int x = (int)(TimerDamageWindow.scoreMultiplier*10);
                        x++;
                        TimerDamageWindow.scoreMultiplier = ((double)x)/10.0;

                    }

                }

            }
        });
        burgerWindow.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                int key = e.getKeyCode();
                // Keys for menu interaction: "E", "Space", "Enter/Return"
                if(key == 32){

                    if(BurgerWindow.phase == 0){

                        BurgerWindow.burgerEaten--;

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
        settingsWindow.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                int key = e.getKeyCode();
                //System.out.println(key);
                // Keys for menu interaction: "E", "Space", "Enter/Return"
                if(key == 27){

                    settingsWindow.setVisible(false);

                }
                if(key == 32 || key == 10 || key == 69){

                    if(settingsSelected == 0){

                        Settings.toggleBGColor();
                        settingsWindow.setVisible(false);
                        settingsWindow.setVisible(true);

                    }
                    else if(settingsSelected == 1){

                        Settings.toggleSoundSettings();

                    }
                    else if(settingsSelected == 2){

                        int x = JOptionPane.showConfirmDialog(null, "Are you sure you want to wipe a save?\nYou cannot undo this action!", "Wipe save data?", 0, 2);
                        if(x == 0){

                            SaveDataWindow.saveDataMode = 2;
                            settingsWindow.setVisible(false);
                            saveDataWindow.setVisible(true);

                        }

                    }
                    else{

                        Sound.errorSound();
                        Sound.backSound();
                        settingsWindow.setVisible(false);

                    }

                }
                //arrow keys -- Up/Down
                if(key == 38 || key == 87){
                    if(settingsSelected == 0){

                        settingsSelected = 3;

                    }
                    else if(settingsSelected == 1){

                        settingsSelected--;

                    }
                    else if(settingsSelected == 2){

                        settingsSelected--;

                    }
                    else if(settingsSelected == 3){

                        settingsSelected--;

                    }
                    Sound.optionSound();

                }
                else if(key == 40 || key == 83){
                    if(settingsSelected == 0){

                        settingsSelected++;

                    }
                    else if(settingsSelected == 1){

                        settingsSelected++;

                    }
                    else if(settingsSelected == 2){

                        settingsSelected++;

                    }
                    else if(settingsSelected == 3){

                        settingsSelected = 0;

                    }
                    Sound.optionSound();

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

                        if(SaveDataWindow.saveDataMode == 0){

                            try {
                                Save.save("save1.txt");
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }

                        }
                        else if(SaveDataWindow.saveDataMode == 1){

                            try {
                                Load.load("save1.txt");
                            } catch (FileNotFoundException ex) {
                                throw new RuntimeException(ex);
                            }

                        }
                        else{

                            try {
                                Wipe.wipe("save1.txt");
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }

                        }

                    }
                    else if(saveDataSelected == 1){

                        if(SaveDataWindow.saveDataMode == 0){

                            try {
                                Save.save("save2.txt");
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }

                        }
                        else if(SaveDataWindow.saveDataMode == 1){

                            try {
                                Load.load("save2.txt");
                            } catch (FileNotFoundException ex) {
                                throw new RuntimeException(ex);
                            }

                        }
                        else{

                            try {
                                Wipe.wipe("save2.txt");
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }

                        }

                    }
                    else if(saveDataSelected == 2){

                        if(SaveDataWindow.saveDataMode == 0){

                            try {
                                Save.save("save3.txt");
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }

                        }
                        else if(SaveDataWindow.saveDataMode == 1){

                            try {
                                Load.load("save3.txt");
                            } catch (FileNotFoundException ex) {
                                throw new RuntimeException(ex);
                            }

                        }
                        else{

                            try {
                                Wipe.wipe("save3.txt");
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }

                        }

                    }
                    Sound.backSound();
                    saveDataWindow.setVisible(false);
                    saveDataSelected = 0;
                    if(firstLoad){

                        frame.setVisible(true);

                    }

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