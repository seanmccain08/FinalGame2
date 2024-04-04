public class Bandage extends Item{

    private int healingPower;
    private int modifier;

    public Bandage(){

        super("Bandage");
        healingPower = (int)(Math.random()*25+25);
        modifier = healingPower;

    }
    public int getHealingPower(){

        return healingPower;

    }
    public int getModifier(){

        return modifier;

    }
    public String getDescription(int line){

        switch(line){

            case 1:
                return "Heals an amount of health based";

            case 2:
                return "on a random number between";

            case 3:
                return "25-50, indicated below.";

        }
        return "";

    }

}
