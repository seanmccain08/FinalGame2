import javax.swing.*;
import java.awt.*;

public class OpponentSelect extends JPanel {

    static Font textBoxFont = new Font("SansSerif", Font.ITALIC, 50);
    static Font mainFont = new Font("SansSerif", Font.PLAIN, 30);
    static Font boldItalicFont = new Font("SansSerif", Font.BOLD | Font.ITALIC, 50);
    static Font boldFont = new Font("SansSerif", Font.BOLD, 30);

    public OpponentSelect(){



    }

    @Override
    public void paintComponent(Graphics g){

        //Changing the background color for a cool effect
        if(Menu.changeR && Menu.changeG){

            if(Menu.colorR > 0 && Menu.colorG < 255){

                Menu.colorR--;
                Menu.colorG++;

            }
            else{

                Menu.changeR = false;
                Menu.changeB = true;

            }

        }
        else if(Menu.changeG && Menu.changeB){

            if(Menu.colorG > 0 && Menu.colorB < 255){

                Menu.colorG--;
                Menu.colorB++;

            }
            else{

                Menu.changeG = false;
                Menu.changeR = true;

            }

        }
        else if(Menu.changeR && Menu.changeB){

            if(Menu.colorB > 0 && Menu.colorR < 255){

                Menu.colorB--;
                Menu.colorR++;

            }
            else{

                Menu.changeB = false;
                Menu.changeG = true;

            }

        }

        setBackground(new Color(Menu.colorR, Menu.colorG, Menu.colorB));

        g.setColor(Color.white);
        g.setFont(textBoxFont);
        g.drawString("Choose your opponent", 350, 50);
        g.setFont(mainFont);
        g.drawString("Damage Bonus: "+Main.player.getDamageBonus(), 200, 660);
        g.drawString("Games: "+Main.games, 700, 660);
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
