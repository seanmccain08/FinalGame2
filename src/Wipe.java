import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Wipe {

    public static void wipe(String filepath) throws IOException {

        File save = new File(filepath);
        FileWriter fw = new FileWriter(save);
        PrintWriter pw = new PrintWriter(fw);

        pw.println(0);
        pw.println(0);
        pw.println(0);
        pw.println(0);
        pw.println(0);
        pw.println(-1);
        pw.println(-1);
        pw.println(-1);
        pw.println(-1);
        pw.println(0);
        pw.println(0);
        pw.println(0);
        pw.println(0);

        pw.close();

    }

}
