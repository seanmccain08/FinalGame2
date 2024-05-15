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

    public static int logoChoice = (int)(Math.random()*6+1);


    @Override
    public void paintComponent(Graphics g){

        if(Main.starting == false){

            changeColor(this);

            g.setFont(defaultFont);
            g.setColor(Color.white);
            g.setColor(Color.WHITE);
            g.setFont(titleFont);
            ImageIcon logo = new ImageIcon();
            switch(logoChoice){

                case 1:
                    logo = new ImageIcon("Images/logo1.png");
                    break;
                case 2:
                    logo = new ImageIcon("Images/logo2.png");
                    break;
                case 3:
                    logo = new ImageIcon("Images/logo3.png");
                    break;
                case 4:
                    logo = new ImageIcon("Images/logo4.png");
                    break;
                case 5:
                    logo = new ImageIcon("Images/logo5.png");
                    break;
                case 6:
                    logo = new ImageIcon("Images/logo6.png");
                    break;

            }
            g.drawImage(logo.getImage(), 140, 85, 1000, 200, null);
            g.setFont(optionFont);
            if(Main.menuSelected == 0){

                g.setFont(selectedFont);
                g.setColor(Color.yellow);
                g.drawString("Start", 570, 350);
                g.setColor(Color.white);
                g.setFont(optionFont);
                g.drawString("Settings", 535, 425);
                g.drawString("Quit", 575, 500);


            }
            else if(Main.menuSelected == 1){

                g.drawString("Start", 575, 350);
                g.setFont(selectedFont);
                g.setColor(Color.yellow);
                g.drawString("Settings", 530, 425);
                g.setColor(Color.white);
                g.setFont(optionFont);
                g.drawString("Quit", 575, 500);

            }
            else{

                g.drawString("Start", 575, 350);
                g.drawString("Settings", 535, 425);
                g.setFont(selectedFont);
                g.setColor(Color.yellow);
                g.drawString("Quit", 570, 500);
                g.setColor(Color.white);
                g.setFont(optionFont);

            }

        }
        else{

            Main.starting = false;
            start(g);

        }

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        repaint();

    }
    public static void quit(){

        Sound.expandSound();
        int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to quit?\nYou will lose all unsaved progress!", "Quit?", 0, 2);
        Sound.backSound();
        if(choice == JOptionPane.YES_OPTION){

            System.exit(0);

        }

    }
    public void start(Graphics g){

        Main.frame.setVisible(false);
        Main.frame1.setVisible(true);

    }

    public static void changeColor(JPanel p){

        if(Settings.getBgColor() == 0){

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
            p.setBackground(new Color(Menu.colorR, Menu.colorG, Menu.colorB));


        }
        else{

            p.setBackground(Color.gray);

        }

    }

}
