import javax.swing.*;
import java.awt.*;

public class OpponentSelect extends JPanel {

    static Font textBoxFont = new Font("SansSerif", Font.ITALIC, 50);
    static Font mainFont = new Font("SansSerif", Font.PLAIN, 30);
    static Font boldItalicFont = new Font("SansSerif", Font.BOLD | Font.ITALIC, 50);
    static Font boldFont = new Font("SansSerif", Font.BOLD, 30);
    static Font bodyFont = new Font("SansSerif", Font.PLAIN, 15);


    public OpponentSelect(){



    }

    @Override
    public void paintComponent(Graphics g){

        //Changing the background color for a cool effect
        Menu.changeColor(this);

        g.setColor(Color.white);
        g.setFont(bodyFont);
        g.drawString("Press ESC to return to the Main Menu", 5, 20);
        g.drawString("Press S to save your game", 5, 40);
        g.drawString("Press L to load save data", 5, 60);
        g.setFont(textBoxFont);
        g.drawString("Choose your opponent", 350, 50);
        g.setFont(mainFont);
        g.drawString("Damage Bonus: "+Main.player.getDamageBonus(), 50, 660);
        g.drawString("Games: "+Main.games, 750, 660);
        g.drawString("Shields: "+Main.player.getShields(), 450, 660);
        if(Main.games > 0){

            g.setColor(Color.black);
            g.fillRect(950, 625, 200, 40);
            g.setFont(bodyFont);
            int x = 200/Main.games;
            g.setColor(Color.green);
            g.drawString("W", 932, 640);
            g.fillRect(950, 625, x*Main.wins, 20);
            g.setColor(Color.red);
            g.drawString("L", 934, 662);
            g.fillRect(950, 645, x*Main.losses, 20);
            g.setColor(Color.black);
            if(Main.wins > 0){

                int winPercentage = (int)((double)(x*Main.wins)/2);
                g.drawString(winPercentage+"%", (((x*Main.wins)/2)+935), 640);

            }
            if(Main.losses > 0){

                int lossPercentage = (int)((double)(x*Main.losses)/2);
                g.drawString(lossPercentage+"%", (((x*Main.losses)/2)+935), 662);

            }
            g.setColor(Color.white);

        }
        g.setFont(textBoxFont);

//      Creating Images
//        ImageIcon icon = new ImageIcon("");
//        g.drawImage(icon.getImage(), x, y, sizex, sizey, null);

        if(Main.opponentSelected == 0){

            //Prateek - Opponent 1
            g.setColor(Color.yellow);
            g.fillRect(50, 100, 200, 200);
            ImageIcon prateekImage = new ImageIcon("Images/Prateek.png");
            g.drawImage(prateekImage.getImage(), 55, 105, 190, 190, null);
            g.setFont(boldItalicFont);
            g.drawString("Prateek", 275, 150);
            g.setFont(boldFont);
            g.drawString("HP: 150", 275, 200);
            g.setFont(textBoxFont);
            g.setColor(Color.white);

            //Jack - Opponent 2
            ImageIcon jackImage = new ImageIcon("Images/Jack.png");
            g.drawImage(jackImage.getImage(), 55, 405, 190, 190, null);
            g.drawRect(50, 400, 200, 200);
            g.drawString("Jack", 275, 450);
            g.setFont(mainFont);
            g.drawString("HP: 200", 275, 500);
            g.setFont(textBoxFont);

            //Ryan - Opponent 3
            g.drawRect(600, 100, 200, 200);
            g.drawString("Ryan", 825, 150);
            ImageIcon ryanImage = new ImageIcon("Images/ryan.png");
            g.drawImage(ryanImage.getImage(), 605, 105, 190, 190, null);
            g.setFont(mainFont);
            g.drawString("HP: 300", 825, 200);
            g.setFont(textBoxFont);

            //Luke - Opponent 4
            ImageIcon lukeImage = new ImageIcon("Images/luke.png");
            g.drawImage(lukeImage.getImage(), 605, 405, 190, 190, null);
            g.drawRect(600, 400, 200, 200);
            g.drawString("Luke", 825, 450);
            g.setFont(mainFont);
            g.drawString("HP: 450", 825, 500);
            g.setFont(textBoxFont);

        }
        else if(Main.opponentSelected == 1){

            //Prateek - Opponent 1
            ImageIcon prateekImage = new ImageIcon("Images/Prateek.png");
            g.drawImage(prateekImage.getImage(), 55, 105, 190, 190, null);
            g.drawRect(50, 100, 200, 200);

            g.drawString("Prateek", 275, 150);
            g.setFont(mainFont);
            g.drawString("HP: 150", 275, 200);
            g.setFont(textBoxFont);

            //Jack - Opponent 1
            g.setColor(Color.yellow);
            g.fillRect(50, 400, 200, 200);
            ImageIcon jackImage = new ImageIcon("Images/jack.png");
            g.drawImage(jackImage.getImage(), 55, 405, 190, 190, null);
            g.setFont(boldItalicFont);
            g.drawString("Jack", 275, 450);
            g.setFont(boldFont);
            g.drawString("HP: 200", 275, 500);
            g.setFont(textBoxFont);
            g.setColor(Color.white);

            //Ryan - Opponent 3
            g.drawRect(600, 100, 200, 200);
            g.drawString("Ryan", 825, 150);
            ImageIcon ryanImage = new ImageIcon("Images/ryan.png");
            g.drawImage(ryanImage.getImage(), 605, 105, 190, 190, null);
            g.setFont(mainFont);
            g.drawString("HP: 300", 825, 200);
            g.setFont(textBoxFont);

            //Luke - Opponent 4
            ImageIcon lukeImage = new ImageIcon("Images/luke.png");
            g.drawImage(lukeImage.getImage(), 605, 405, 190, 190, null);
            g.drawRect(600, 400, 200, 200);
            g.drawString("Luke", 825, 450);
            g.setFont(mainFont);
            g.drawString("HP: 450", 825, 500);
            g.setFont(textBoxFont);

        }
        else if(Main.opponentSelected == 2){

            //Prateek - Opponent 1
            ImageIcon prateekImage = new ImageIcon("Images/Prateek.png");
            g.drawImage(prateekImage.getImage(), 55, 105, 190, 190, null);
            g.drawRect(50, 100, 200, 200);
            g.drawString("Prateek", 275, 150);
            g.setFont(mainFont);
            g.drawString("HP: 150", 275, 200);
            g.setFont(textBoxFont);

            //Jack - Opponent 2
            ImageIcon jackImage = new ImageIcon("Images/Jack.png");
            g.drawImage(jackImage.getImage(), 55, 405, 190, 190, null);
            g.drawRect(50, 400, 200, 200);
            g.drawString("Jack", 275, 450);
            g.setFont(mainFont);
            g.drawString("HP: 200", 275, 500);
            g.setFont(textBoxFont);

            //Ryan - Opponent 3
            g.setColor(Color.yellow);
            g.fillRect(600, 100, 200, 200);
            ImageIcon ryanImage = new ImageIcon("Images/ryan.png");
            g.drawImage(ryanImage.getImage(), 605, 105, 190, 190, null);
            g.setFont(boldItalicFont);
            g.drawString("Ryan", 825, 150);
            g.setFont(boldFont);
            g.drawString("HP: 300", 825, 200);
            g.setFont(textBoxFont);
            g.setColor(Color.white);

            //Luke - Opponent 4
            ImageIcon lukeImage = new ImageIcon("Images/luke.png");
            g.drawImage(lukeImage.getImage(), 605, 405, 190, 190, null);
            g.drawRect(600, 400, 200, 200);
            g.drawString("Luke", 825, 450);
            g.setFont(mainFont);
            g.drawString("HP: 450", 825, 500);
            g.setFont(textBoxFont);

        }
        else{

            //Prateek - Opponent 1
            ImageIcon prateekImage = new ImageIcon("Images/Prateek.png");
            g.drawImage(prateekImage.getImage(), 55, 105, 190, 190, null);
            g.drawRect(50, 100, 200, 200);
            g.drawString("Prateek", 275, 150);
            g.setFont(mainFont);
            g.drawString("HP: 150", 275, 200);
            g.setFont(textBoxFont);

            //Jack - Opponent 2
            ImageIcon jackImage = new ImageIcon("Images/Jack.png");
            g.drawImage(jackImage.getImage(), 55, 405, 190, 190, null);
            g.drawRect(50, 400, 200, 200);
            g.drawString("Jack", 275, 450);
            g.setFont(mainFont);
            g.drawString("HP: 200", 275, 500);
            g.setFont(textBoxFont);

            //Ryan - Opponent 3
            g.drawRect(600, 100, 200, 200);
            g.drawString("Ryan", 825, 150);
            ImageIcon ryanImage = new ImageIcon("Images/ryan.png");
            g.drawImage(ryanImage.getImage(), 605, 105, 190, 190, null);
            g.setFont(mainFont);
            g.drawString("HP: 300", 825, 200);
            g.setFont(textBoxFont);

            //Luke - Opponent 4
            g.setColor(Color.yellow);
            g.fillRect(600, 400, 200, 200);
            ImageIcon lukeImage = new ImageIcon("Images/luke.png");
            g.drawImage(lukeImage.getImage(), 605, 405, 190, 190, null);
            g.setFont(boldItalicFont);
            g.drawString("Luke", 825, 450);
            g.setFont(boldFont);
            g.drawString("HP: 450", 825, 500);
            g.setFont(textBoxFont);
            g.setColor(Color.white);

        }

        try {
            Thread.sleep(16);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        repaint();

    }

}
