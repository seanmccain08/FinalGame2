public class Mullet extends Item{

    private int damageBuff;
    private int modifier;

    public Mullet(){

        super("Mullet");
        damageBuff = (int)(Math.random()*4+2);
        modifier = damageBuff;

    }
    public int getModifier(){

        return modifier;

    }

    public String getDescription(int line){

        switch(line){

            case 1:
                return "Offers a brand new haircut,";

            case 2:
                return "giving you a damage buff";

            case 3:
                return "decided by a random number";

            case 4:
                return "between 2-5 extra damage,";

            case 5:
                return "indicated below.";

        }
        return "";

    }

}
