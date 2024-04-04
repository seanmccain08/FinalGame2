import javax.swing.*;
import java.awt.*;

public class Menu extends JPanel {

    static int colorR = 255;
    static int colorG = 0;
    static int colorB = 0;

    public Menu(){

        setBackground(new Color(colorR, colorG, colorB));

    }
    Font titleFont = new Font("SansSerif", Font.ITALIC, 100);
    Font optionFont = new Font("SansSerif", Font.PLAIN, 50);
    Font selectedFont = new Font("SansSerif", Font.BOLD, 50);
    Font defaultFont = new Font("SansSerif", Font.ITALIC, 20);
    static boolean changeR = true;
    static boolean changeG = true;
    static boolean changeB = false;


    @Override
    public void paintComponent(Graphics g){

        if(Main.starting == false){

            //Changing the background color for a cool effect
            if(changeR && changeG){

                if(colorR > 0 && colorG < 255){

                    colorR--;
                    colorG++;

                }
                else{

                    changeR = false;
                    changeB = true;

                }

            }
            else if(changeG && changeB){

                if(colorG > 0 && colorB < 255){

                    colorG--;
                    colorB++;

                }
                else{

                    changeG = false;
                    changeR = true;

                }

            }
            else if(changeR && changeB){

                if(colorB > 0 && colorR < 255){

                    colorB--;
                    colorR++;

                }
                else{

                    changeB = false;
                    changeG = true;

                }

            }


            setBackground(new Color(colorR, colorG, colorB));
            g.setFont(defaultFont);
            g.drawString("Use the arrow keys & press enter to select an option.", 0, 20);
            g.drawString("Alpha 1.7", 0, 685);
            g.setColor(Color.WHITE);
            g.setFont(titleFont);
            g.drawString("Battle Simulator", 250, 200);
            g.setFont(optionFont);
            if(Main.menuSelected == 0){

                g.setFont(selectedFont);
                g.setColor(Color.yellow);
                g.drawString("Start", 575, 350);
                g.setColor(Color.white);
                g.setFont(optionFont);
                g.drawString("Quit", 575, 425);

            }
            else{

                g.drawString("Start", 575, 350);
                g.setFont(selectedFont);
                g.setColor(Color.yellow);
                g.drawString("Quit", 575, 425);
                g.setColor(Color.white);
                g.setFont(optionFont);

            }

        }
        else{

            Main.starting = false;
            start(g);

        }

        try {
            Thread.sleep(7);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        repaint();

    }
    public static void quit(){

        System.exit(0);

    }
    public void start(Graphics g){

        Main.frame.setVisible(false);
        Main.frame1.setVisible(true);

    }

}
