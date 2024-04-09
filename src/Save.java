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

        pw.close();

    }

}
