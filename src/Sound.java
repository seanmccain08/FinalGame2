import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
public class Sound {

    public static void selectSound(){

        String filepath = "Sounds/select1.wav";
        playSound(filepath);

    }
    public static void unavailableSound(){

        String filepath = "Sounds/unavailable.wav";
        playSound(filepath);

    }
    public static void errorSound(){

        String filepath = "Sounds/error.wav";
        playSound(filepath);

    }
    public static void altSelectSound(){

        String filepath = "Sounds/select2.wav";
        playSound(filepath);

    }
    public static void introSound(){

        String filepath = "";
        int rand = (int)(Math.random()*5+1);
        switch (rand){

            case 1:
                filepath = "Sounds/intro1.wav";
                break;

            case 2:
                filepath = "Sounds/intro2.wav";
                break;

            case 3:
                filepath = "Sounds/intro3.wav";
                break;

            case 4:
                filepath = "Sounds/intro4.wav";
                break;

            case 5:
                filepath = "Sounds/intro5.wav";
                break;

        }
        playSound(filepath);

    }
    public static void expandSound(){

        String filepath = "Sounds/expand.wav";
        playSound(filepath);

    }
    public static void reasonSound(){

        String filepath = "";
        int rand = (int)(Math.random()*2+1);
        switch (rand){

            case 1:
                filepath = "Sounds/reason1.wav";
                break;

            case 2:
                filepath = "Sounds/reason2.wav";
                break;

        }
        playSound(filepath);

    }
    public static void optionSound(){

        String filepath = "Sounds/option.wav";
        playSound(filepath);

    }
    public static void backSound(){

        String filepath = "Sounds/back1.wav";
        playSound(filepath);

    }
    public static void altBackSound(){

        String filepath = "Sounds/back2.wav";
        playSound(filepath);

    }
    public static void playSound(String location){

        if(Settings.getSoundSettings() == 0){

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

}
