import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;

public class SaveDataWindow extends JPanel{

    public SaveDataWindow(){}

    public static boolean saveMode = false;
    static Font mainFont = new Font("SansSerif", Font.PLAIN, 30);
    static Font boldFont = new Font("SansSerif", Font.BOLD, 30);
    static Font bodyFont = new Font("SansSerif", Font.PLAIN, 15);

    @Override
    public void paintComponent(Graphics g){

        if(saveMode){

            Main.saveDataWindow.setTitle("Save Game");

        }
        else{

            Main.saveDataWindow.setTitle("Load Game");

        }

        Menu.changeColor(this);

        g.setColor(Color.black);
        g.fillRect(300, 0, 300, 400);
        g.setColor(Color.white);

        if(Main.saveDataSelected == 0){

            g.setColor(Color.yellow);
            g.setFont(boldFont);
            g.drawString("Save I", 50, 125);
            g.setColor(Color.white);
            g.setFont(mainFont);
            g.drawString("Save II", 50, 175);
            g.drawString("Save III", 50, 225);
            g.drawString("Cancel", 50, 310);

            g.setFont(boldFont);
            g.drawString("Save I", 330, 65);
            g.setFont(bodyFont);
            try {
                Load.drawInfo(g, "save1.txt");
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

        }
        if(Main.saveDataSelected == 1){

            g.setFont(mainFont);
            g.setColor(Color.white);
            g.drawString("Save I", 50, 125);
            g.setColor(Color.yellow);
            g.setFont(boldFont);
            g.drawString("Save II", 50, 175);
            g.setColor(Color.white);
            g.setFont(mainFont);
            g.drawString("Save III", 50, 225);
            g.drawString("Cancel", 50, 310);

            g.setFont(boldFont);
            g.drawString("Save II", 330, 65);
            g.setFont(bodyFont);
            try {
                Load.drawInfo(g, "save2.txt");
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

        }
        if(Main.saveDataSelected == 2){

            g.setFont(mainFont);
            g.setColor(Color.white);
            g.drawString("Save I", 50, 125);
            g.drawString("Save II", 50, 175);
            g.setColor(Color.yellow);
            g.setFont(boldFont);
            g.drawString("Save III", 50, 225);
            g.setColor(Color.white);
            g.setFont(mainFont);
            g.drawString("Cancel", 50, 310);

            g.setFont(boldFont);
            g.drawString("Save III", 330, 65);
            g.setFont(bodyFont);
            try {
                Load.drawInfo(g, "save3.txt");
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

        }
        if(Main.saveDataSelected == 3){

            g.setFont(mainFont);
            g.setColor(Color.white);
            g.drawString("Save I", 50, 125);
            g.drawString("Save II", 50, 175);
            g.drawString("Save III", 50, 225);
            g.setColor(Color.yellow);
            g.setFont(boldFont);
            g.drawString("Cancel", 50, 310);
            g.setColor(Color.white);
            g.setFont(mainFont);

            g.setFont(boldFont);
            g.drawString("Cancel", 330, 65);
            g.setFont(bodyFont);
            g.drawString("Cancel save data action?", 330, 120);

        }


        try {
            Thread.sleep(25);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        repaint();

    }

}
