import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;

public class SettingsWindow extends JPanel {

    public SettingsWindow(){

        setBackground(Color.gray);

    }

    static Font mainFont = new Font("SansSerif", Font.PLAIN, 30);
    static Font boldFont = new Font("SansSerif", Font.BOLD, 30);
    static Font bodyFont = new Font("SansSerif", Font.PLAIN, 15);

    @Override
    public void paintComponent(Graphics g){


        if(Menu.changeR && Menu.changeG){

            if(Menu.colorR > 0 && Menu.colorG < 155){

                Menu.colorR--;
                Menu.colorG++;

            }
            else{

                Menu.changeR = false;
                Menu.changeB = true;

            }

        }
        else if(Menu.changeG && Menu.changeB){

            if(Menu.colorG > 0 && Menu.colorB < 155){

                Menu.colorG--;
                Menu.colorB++;

            }
            else{

                Menu.changeG = false;
                Menu.changeR = true;

            }

        }
        else if(Menu.changeR && Menu.changeB){

            if(Menu.colorB > 0 && Menu.colorR < 155){

                Menu.colorB--;
                Menu.colorR++;

            }
            else{

                Menu.changeB = false;
                Menu.changeG = true;

            }

        }
        setBackground(new Color(Menu.colorR, Menu.colorG, Menu.colorB));

        g.setColor(Color.black);
        g.fillRect(300, 0, 300, 400);
        g.setColor(Color.white);

        if(Main.settingsSelected == 0){

            g.setColor(Color.yellow);
            g.setFont(boldFont);
            g.drawString("Background", 50, 125);
            g.setColor(Color.white);
            g.setFont(mainFont);
            g.drawString("Sound", 50, 175);
            g.drawString("Wipe Save Data", 50, 225);
            g.drawString("Back", 50, 310);

            g.setFont(boldFont);
            g.drawString("Background", 330, 65);
            g.setFont(bodyFont);
            g.drawString("Press enter to change the", 330, 150);
            g.drawString("background color.", 330, 170);
            g.drawString("WARNING: May cause settings", 330, 200);
            g.drawString("menu to freeze up if set to", 330, 220);
            g.drawString("gray.", 330, 240);
            g.drawString("(Won't affect this window)", 330, 340);
            if(Settings.getBgColor() == 0){

                g.drawString("Current Setting: Colored", 330, 320);

            }
            else{

                g.drawString("Current Setting: Gray", 330, 320);

            }


        }
        if(Main.settingsSelected == 1){

            g.setColor(Color.white);
            g.setFont(mainFont);
            g.drawString("Background", 50, 125);
            g.setColor(Color.yellow);
            g.setFont(boldFont);
            g.drawString("Sound", 50, 175);
            g.setColor(Color.white);
            g.setFont(mainFont);
            g.drawString("Wipe Save Data", 50, 225);
            g.drawString("Back", 50, 310);

            g.setFont(boldFont);
            g.drawString("Sound", 330, 65);
            g.setFont(bodyFont);
            g.drawString("Press enter to mute/unmute", 330, 150);
            g.drawString("sound effects.", 330, 170);
            if(Settings.getSoundSettings() == 0){

                g.drawString("Current Setting: Unmuted", 330, 320);

            }
            else{

                g.drawString("Current Setting: Muted", 330, 320);

            }


        }
        if(Main.settingsSelected == 2){

            g.setColor(Color.white);
            g.setFont(mainFont);
            g.drawString("Background", 50, 125);
            g.drawString("Sound", 50, 175);
            g.setColor(Color.yellow);
            g.setFont(boldFont);
            g.drawString("Wipe Save Data", 50, 225);
            g.setColor(Color.white);
            g.setFont(mainFont);
            g.drawString("Back", 50, 310);

            g.setFont(boldFont);
            g.drawString("Wipe Save Data", 330, 65);
            g.setFont(bodyFont);
            g.drawString("Press enter to open save menu", 330, 150);
            g.drawString("and choose a file to wipe.", 330, 170);


        }
        if(Main.settingsSelected == 3){

            g.setColor(Color.white);
            g.setFont(mainFont);
            g.drawString("Background", 50, 125);
            g.drawString("Sound", 50, 175);
            g.drawString("Wipe Save Data", 50, 225);
            g.setColor(Color.yellow);
            g.setFont(boldFont);
            g.drawString("Back", 50, 310);

            g.setColor(Color.white);
            g.setFont(mainFont);
            g.setFont(boldFont);
            g.drawString("Back", 330, 65);
            g.setFont(bodyFont);
            g.drawString("Exit the settings menu?", 330, 150);

        }

        try {
            Thread.sleep(25);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
