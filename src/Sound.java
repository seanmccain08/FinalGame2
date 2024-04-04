import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
public class Sound {

    public static void selectSound(){

        String filepath = "Sounds/select.wav";
        playSound(filepath);

    }
    public static void errorSound(){

        String filepath = "Sounds/error.wav";
        playSound(filepath);

    }
    public static void altSelectSound(){

        String filepath = "Sounds/altSelect.wav";
        playSound(filepath);

    }
    public static void introSound(){

        String filepath = "Sounds/intro.wav";
        playSound(filepath);

    }
    public static void expandSound(){

        String filepath = "Sounds/expand.wav";
        playSound(filepath);

    }
    public static void optionSound(){

        String filepath = "Sounds/option.wav";
        playSound(filepath);

    }
    public static void backSound(){

        String filepath = "Sounds/back.wav";
        playSound(filepath);

    }
    public static void playSound(String location){

        try {
            File musicPath = new File(location);

            if(musicPath.exists()){

                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();

            }
            else{

                System.out.println("Can't find file");

            }

        }
        catch (Exception e){

            System.out.println(e);

        }

    }

}
