import javax.swing.*;
import java.awt.*;

public class TimerDamageWindow extends JPanel {

    public TimerDamageWindow(){



    }

    static Font mainFont = new Font("SansSerif", Font.PLAIN, 30);
    static Font boldFont = new Font("SansSerif", Font.BOLD, 30);
    static Font bodyFont = new Font("SansSerif", Font.PLAIN, 15);

    public static int phase = 0;
    public static boolean first = true;
    static int frame = 50;
    public static int score = 0;

    @Override
    public void paintComponent(Graphics g){

        Menu.changeColor(this);

        if(frame == 0){

            Main.timerDamageWindow.setVisible(false);
            score = 0;
            frame = 50;

        }

        g.setColor(Color.red);
        g.fillRect(0, 0, 600, 50);
        g.setColor(Color.green);
        int timerBarSizeX = frame*12;
        g.fillRect(0, 0, timerBarSizeX, 50);

        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        frame--;
        repaint();

    }

}
