public class Empty extends Item{

    public Empty(){

        super("Empty");

    }
    public String getDescription(int line){

        switch(line){

            case 1:
                return "No item here. Selecting will";

            case 2:
                return "do nothing.";

        }
        return "";

    }

}
