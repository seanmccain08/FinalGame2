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

        Menu.changeColor(this);

        if(Main.inventorySelected == 0){

            g.setColor(Color.yellow);
            g.setFont(boldFont);
            g.drawString(Main.player.getInventory()[0].getName(), 50, 75);
            g.setColor(Color.white);
            g.setFont(mainFont);
            if(Main.player.getInventory()[1].getName().equals("Empty")){

                g.setColor(Color.gray);
                g.drawString(Main.player.getInventory()[1].getName(), 50, 125);
                g.setColor(Color.white);

            }
            else{

                g.drawString(Main.player.getInventory()[1].getName(), 50, 125);

            }
            if(Main.player.getInventory()[2].getName().equals("Empty")){

                g.setColor(Color.gray);
                g.drawString(Main.player.getInventory()[2].getName(), 50, 175);
                g.setColor(Color.white);

            }
            else{

                g.drawString(Main.player.getInventory()[2].getName(), 50, 175);

            }
            if(Main.player.getInventory()[3].getName().equals("Empty")){

                g.setColor(Color.gray);
                g.drawString(Main.player.getInventory()[3].getName(), 50, 225);
                g.setColor(Color.white);

            }
            else{

                g.drawString(Main.player.getInventory()[3].getName(), 50, 225);

            }
            g.drawString("Back", 50, 310);

        }
        else if(Main.inventorySelected == 1){

            g.setColor(Color.white);
            g.setFont(mainFont);
            if(Main.player.getInventory()[0].getName().equals("Empty")){

                g.setColor(Color.gray);
                g.drawString(Main.player.getInventory()[0].getName(), 50, 75);
                g.setColor(Color.white);

            }
            else{

                g.drawString(Main.player.getInventory()[0].getName(), 50, 75);

            }            g.setColor(Color.yellow);
            g.setFont(boldFont);
            g.drawString(Main.player.getInventory()[1].getName(), 50, 125);
            g.setColor(Color.white);
            g.setFont(mainFont);
            if(Main.player.getInventory()[2].getName().equals("Empty")){

                g.setColor(Color.gray);
                g.drawString(Main.player.getInventory()[2].getName(), 50, 175);
                g.setColor(Color.white);

            }
            else{

                g.drawString(Main.player.getInventory()[2].getName(), 50, 175);

            }
            if(Main.player.getInventory()[3].getName().equals("Empty")){

                g.setColor(Color.gray);
                g.drawString(Main.player.getInventory()[3].getName(), 50, 225);
                g.setColor(Color.white);

            }
            else{

                g.drawString(Main.player.getInventory()[3].getName(), 50, 225);

            }
            g.drawString("Back", 50, 310);

        }
        else if(Main.inventorySelected == 2){

            g.setColor(Color.white);
            g.setFont(mainFont);
            if(Main.player.getInventory()[0].getName().equals("Empty")){

                g.setColor(Color.gray);
                g.drawString(Main.player.getInventory()[0].getName(), 50, 75);
                g.setColor(Color.white);

            }
            else{

                g.drawString(Main.player.getInventory()[0].getName(), 50, 75);

            }
            if(Main.player.getInventory()[1].getName().equals("Empty")){

                g.setColor(Color.gray);
                g.drawString(Main.player.getInventory()[1].getName(), 50, 125);
                g.setColor(Color.white);

            }
            else{

                g.drawString(Main.player.getInventory()[1].getName(), 50, 125);

            }
            g.setColor(Color.yellow);
            g.setFont(boldFont);
            g.drawString(Main.player.getInventory()[2].getName(), 50, 175);
            g.setColor(Color.white);
            g.setFont(mainFont);
            if(Main.player.getInventory()[3].getName().equals("Empty")){

                g.setColor(Color.gray);
                g.drawString(Main.player.getInventory()[3].getName(), 50, 225);
                g.setColor(Color.white);

            }
            else{

                g.drawString(Main.player.getInventory()[3].getName(), 50, 225);

            }
            g.drawString("Back", 50, 310);

        }
        else if(Main.inventorySelected == 3){

            g.setColor(Color.white);
            g.setFont(mainFont);
            if(Main.player.getInventory()[0].getName().equals("Empty")){

                g.setColor(Color.gray);
                g.drawString(Main.player.getInventory()[0].getName(), 50, 75);
                g.setColor(Color.white);

            }
            else{

                g.drawString(Main.player.getInventory()[0].getName(), 50, 75);

            }
            if(Main.player.getInventory()[1].getName().equals("Empty")){

                g.setColor(Color.gray);
                g.drawString(Main.player.getInventory()[1].getName(), 50, 125);
                g.setColor(Color.white);

            }
            else{

                g.drawString(Main.player.getInventory()[1].getName(), 50, 125);

            }
            if(Main.player.getInventory()[2].getName().equals("Empty")){

                g.setColor(Color.gray);
                g.drawString(Main.player.getInventory()[2].getName(), 50, 175);
                g.setColor(Color.white);

            }
            else{

                g.drawString(Main.player.getInventory()[2].getName(), 50, 175);

            }
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
            if(Main.player.getInventory()[0].getName().equals("Empty")){

                g.setColor(Color.gray);
                g.drawString(Main.player.getInventory()[0].getName(), 50, 75);
                g.setColor(Color.white);

            }
            else{

                g.drawString(Main.player.getInventory()[0].getName(), 50, 75);

            }
            if(Main.player.getInventory()[1].getName().equals("Empty")){

                g.setColor(Color.gray);
                g.drawString(Main.player.getInventory()[1].getName(), 50, 125);
                g.setColor(Color.white);

            }
            else{

                g.drawString(Main.player.getInventory()[1].getName(), 50, 125);

            }
            if(Main.player.getInventory()[2].getName().equals("Empty")){

                g.setColor(Color.gray);
                g.drawString(Main.player.getInventory()[2].getName(), 50, 175);
                g.setColor(Color.white);

            }
            else{

                g.drawString(Main.player.getInventory()[2].getName(), 50, 175);

            }
            if(Main.player.getInventory()[3].getName().equals("Empty")){

                g.setColor(Color.gray);
                g.drawString(Main.player.getInventory()[3].getName(), 50, 225);
                g.setColor(Color.white);

            }
            else{

                g.drawString(Main.player.getInventory()[3].getName(), 50, 225);

            }
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
            Thread.sleep(25);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        repaint();

    }

}
