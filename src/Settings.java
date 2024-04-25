public class Settings {

    static int bgColor = 0;
    static int soundSettings = 0;
    public static int getBgColor(){

        return bgColor;

    }
    public static void toggleBGColor(){

        if(bgColor == 0){

            bgColor = 1;

        }
        else{

            bgColor = 0;

        }

    }
    public static int getSoundSettings(){

        return soundSettings;

    }
    public static void toggleSoundSettings(){

        if(soundSettings == 0){

            soundSettings = 1;

        }
        else{

            soundSettings = 0;

        }

    }

}
