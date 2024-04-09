import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Load {

    public static void load(String filepath) throws FileNotFoundException {

        File file = new File(filepath);
        Scanner scan = new Scanner(file);

        Main.games = Integer.parseInt(scan.nextLine());
        Main.wins = Integer.parseInt(scan.nextLine());
        Main.losses = Integer.parseInt(scan.nextLine());
        Main.player.setShields(Integer.parseInt(scan.nextLine()));
        Main.player.setDamageBonus(Integer.parseInt(scan.nextLine()));

    }

    public static void drawInfo(Graphics g, String filepath) throws FileNotFoundException {

        File temp = new File(filepath);
        Scanner scan = new Scanner(temp);

        g.drawString("Games: "+scan.nextLine(), 330, 120);
        g.drawString("Wins: "+scan.nextLine(), 330, 150);
        g.drawString("Losses: "+scan.nextLine(), 330, 180);
        g.drawString("Shields: "+scan.nextLine(), 330, 210);
        g.drawString("Damage Bonus: "+scan.nextLine(), 330, 240);

    }
}
