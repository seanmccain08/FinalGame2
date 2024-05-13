import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;

public class Load {

    public static void load(String filepath) throws FileNotFoundException {

        File file = new File(filepath);
        Scanner scan = new Scanner(file);

        String x = scan.nextLine();
        Main.games = Integer.parseInt(x);
        x = scan.nextLine();
        Main.wins = Integer.parseInt(x);
        x = scan.nextLine();
        Main.losses = Integer.parseInt(x);
        x = scan.nextLine();
        Main.player.setShields(Integer.parseInt(x));
        x = scan.nextLine();
        Main.player.setDamageBonus(Integer.parseInt(x));
        x = scan.nextLine();
        if(!x.equals("-1")){
            Main.codeDigit1 = Integer.parseInt(x);
        }
        else{
            Main.codeDigit1 = (int)(Math.random()*10);
        }
        x = scan.nextLine();
        if(!x.equals("-1")){
            Main.codeDigit2 = Integer.parseInt(x);
        }
        else{
            Main.codeDigit2 = (int)(Math.random()*10);
        }
        x = scan.nextLine();
        if(!x.equals("-1")){
            Main.codeDigit3 = Integer.parseInt(x);
        }
        else{
            Main.codeDigit3 = (int)(Math.random()*10);
        }
        x = scan.nextLine();
        if(!x.equals("-1")){
            Main.codeDigit4 = Integer.parseInt(x);
        }
        else{
            Main.codeDigit4 = (int)(Math.random()*10);
        }
        x = scan.nextLine();
        if(x.equals("1")){
            Main.beatenPrateek = true;
        }
        else{
            Main.beatenPrateek = false;
        }
        x = scan.nextLine();
        if(x.equals("1")){
            Main.beatenJack = true;
        }
        else{
            Main.beatenJack = false;
        }
        x = scan.nextLine();
        if(x.equals("1")){
            Main.beatenRyan = true;
        }
        else{
            Main.beatenRyan = false;
        }
        x = scan.nextLine();
        if(x.equals("1")){
            Main.beatenLuke = true;
        }
        else{
            Main.beatenLuke = false;
        }

    }

    public static void drawInfo(Graphics g, String filepath) throws FileNotFoundException {

        File temp = new File(filepath);
        Scanner scan = new Scanner(temp);

        g.drawString("Games: "+scan.nextLine(), 330, 120);
        g.drawString("Wins: "+scan.nextLine(), 330, 150);
        g.drawString("Losses: "+scan.nextLine(), 330, 180);
        g.drawString("Shields: "+scan.nextLine(), 330, 210);
        g.drawString("Damage Bonus: "+scan.nextLine(), 330, 240);
        String p;
        String j;
        String r;
        String l;
        String codeDigit = scan.nextLine();
        if(!Main.beatenPrateek || codeDigit.equals("-1")){
            p = "? ";
        }
        else{
            p = codeDigit+" ";
        }
        codeDigit = scan.nextLine();
        if(!Main.beatenJack || codeDigit.equals("-1")){
            j = "? ";
        }
        else{
            j = codeDigit+" ";
        }
        codeDigit = scan.nextLine();
        if(!Main.beatenRyan || codeDigit.equals("-1")){
            r = "? ";
        }
        else{
            r = codeDigit+" ";
        }
        codeDigit = scan.nextLine();
        if(!Main.beatenLuke || codeDigit.equals("-1")){
            l = "? ";
        }
        else{
            l = codeDigit+" ";
        }
        g.drawString("Seaver Code: "+p+j+r+l, 330, 270);

    }
}
