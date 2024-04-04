public class Item {

    private String name;
    private boolean isConsumable;
    public Item(String name){

        this.name = name;
    }
    public String getName(){

        return name;

    }

    //Exists for the subclasses
    public String getDescription(int line){

        return "";

    }
    public int getModifier(){

        return 0;

    }

}
