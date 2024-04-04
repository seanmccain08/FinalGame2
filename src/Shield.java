public class Shield extends Item{

    private int extraTurns;
    private int modifier;

    public Shield(){

        super("Shield");
        int x = (int)(Math.random()*20+1);
        if(x == 7){

            extraTurns = 2;

        }
        else{

            extraTurns = 1;

        }
        modifier = extraTurns;

    }

    public String getDescription(int line){

        switch(line){

            case 1:
                return "Prevents your opponent from";

            case 2:
                return "hitting you for a number of";

            case 3:
                return "turns decided by a random";

            case 4:
                return "number between 1-2.";

            case 5:
                return "(95% chance to get 1)";

        }
        return "";

    }
    public int getModifier(){

        return modifier;

    }

}
