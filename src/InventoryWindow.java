import javax.swing.*;
import java.awt.*;

public class InventoryWindow extends JPanel {

    public InventoryWindow(){



    }

    static Font mainFont = new Font("SansSerif", Font.PLAIN, 30);
    static Font boldFont = new Font("SansSerif", Font.BOLD, 30);
    static Font bodyFont = new Font("SansSerif", Font.PLAIN, 15);


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

        if(Main.inventorySelected == 0){

            g.setColor(Color.yellow);
            g.setFont(boldFont);
            g.drawString(Main.player.getInventory()[0].getName(), 50, 75);
            g.setColor(Color.white);
            g.setFont(mainFont);
            g.drawString(Main.player.getInventory()[1].getName(), 50, 125);
            g.drawString(Main.player.getInventory()[2].getName(), 50, 175);
            g.drawString(Main.player.getInventory()[3].getName(), 50, 225);
            g.drawString("Back", 50, 310);

        }
        else if(Main.inventorySelected == 1){

            g.setColor(Color.white);
            g.setFont(mainFont);
            g.drawString(Main.player.getInventory()[0].getName(), 50, 75);
            g.setColor(Color.yellow);
            g.setFont(boldFont);
            g.drawString(Main.player.getInventory()[1].getName(), 50, 125);
            g.setColor(Color.white);
            g.setFont(mainFont);
            g.drawString(Main.player.getInventory()[2].getName(), 50, 175);
            g.drawString(Main.player.getInventory()[3].getName(), 50, 225);
            g.drawString("Back", 50, 310);

        }
        else if(Main.inventorySelected == 2){

            g.setColor(Color.white);
            g.setFont(mainFont);
            g.drawString(Main.player.getInventory()[0].getName(), 50, 75);
            g.drawString(Main.player.getInventory()[1].getName(), 50, 125);
            g.setColor(Color.yellow);
            g.setFont(boldFont);
            g.drawString(Main.player.getInventory()[2].getName(), 50, 175);
            g.setColor(Color.white);
            g.setFont(mainFont);
            g.drawString(Main.player.getInventory()[3].getName(), 50, 225);
            g.drawString("Back", 50, 310);

        }
        else if(Main.inventorySelected == 3){

            g.setColor(Color.white);
            g.setFont(mainFont);
            g.drawString(Main.player.getInventory()[0].getName(), 50, 75);
            g.drawString(Main.player.getInventory()[1].getName(), 50, 125);
            g.drawString(Main.player.getInventory()[2].getName(), 50, 175);
            g.setColor(Color.yellow);
            g.setFont(boldFont);
            g.drawString(Main.player.getInventory()[3].getName(), 50, 225);
            g.setColor(Color.white);
            g.setFont(mainFont);
            g.drawString("Back", 50, 310);

        }
        else{

            g.setColor(Color.white);
            g.setFont(mainFont);
            g.drawString(Main.player.getInventory()[0].getName(), 50, 75);
            g.drawString(Main.player.getInventory()[1].getName(), 50, 125);
            g.drawString(Main.player.getInventory()[2].getName(), 50, 175);
            g.drawString(Main.player.getInventory()[3].getName(), 50, 225);
            g.setColor(Color.yellow);
            g.setFont(boldFont);
            g.drawString("Back", 50, 310);
            g.setColor(Color.white);
            g.setFont(mainFont);

        }

        g.setColor(Color.black);
        g.fillRect(300, 0, 300, 400);

        if(Main.inventorySelected < 4){

            g.setFont(boldFont);
            if(Main.player.getInventory()[Main.inventorySelected].getName().equals("Mullet")){

                g.setColor(new Color(Menu.colorR, Menu.colorG, Menu.colorB));
                g.drawString(Main.player.getInventory()[Main.inventorySelected].getName(), 330, 65);

            }
            else{

                g.setColor(Color.white);
                g.drawString(Main.player.getInventory()[Main.inventorySelected].getName(), 330, 65);

            }
            g.setFont(bodyFont);
            g.drawString(Main.player.getInventory()[Main.inventorySelected].getDescription(1), 330, 120);
            g.drawString(Main.player.getInventory()[Main.inventorySelected].getDescription(2), 330, 140);
            g.drawString(Main.player.getInventory()[Main.inventorySelected].getDescription(3), 330, 160);
            g.drawString(Main.player.getInventory()[Main.inventorySelected].getDescription(4), 330, 180);
            g.drawString(Main.player.getInventory()[Main.inventorySelected].getDescription(5), 330, 200);

            g.drawString("This Item: "+Main.player.getInventory()[Main.inventorySelected].getModifier(), 330, 280);

            if(!Main.player.getInventory()[Main.inventorySelected].getName().equals("Bandage") && !Main.player.getInventory()[Main.inventorySelected].getName().equals("Empty")){

                g.drawString("(Stackable)", 330, 300);

            }
        }
        else{

            g.setColor(Color.white);
            g.setFont(boldFont);
            g.drawString("Back", 330, 65);
            g.setFont(bodyFont);
            g.drawString("Would you like to close", 330, 120);
            g.drawString("the inventory?", 330, 140);

        }


        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        repaint();

    }

}
