import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Save {

    public static void save(String filepath) throws IOException {

        File save = new File(filepath);
        FileWriter fw = new FileWriter(save);
        PrintWriter pw = new PrintWriter(fw);

        pw.println(Main.games);
        pw.println(Main.wins);
        pw.println(Main.losses);
        pw.println(Main.player.getShields());
        pw.println(Main.player.getDamageBonus());
        pw.println(Main.codeDigit1);
        pw.println(Main.codeDigit2);
        pw.println(Main.codeDigit3);
        pw.println(Main.codeDigit4);
        if(Main.beatenPrateek){
            pw.println(1);
        }
        else{
            pw.println(0);
        }
        if(Main.beatenJack){
            pw.println(1);
        }
        else{
            pw.println(0);
        }
        if(Main.beatenRyan){
            pw.println(1);
        }
        else{
            pw.println(0);
        }
        if(Main.beatenLuke){
            pw.println(1);
        }
        else{
            pw.println(0);
        }

        pw.close();

    }

}
