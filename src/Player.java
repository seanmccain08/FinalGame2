import javax.swing.*;

public class Player {

    private Item[] inventory;
    private int hp;
    private int shields;
    private int damageBonus;
    public Player(){

        inventory = new Item[4];
        hp = 100;
        damageBonus = 0;
        shields = 0;

    }
    public void giveItems(){

        for(int i = 0; i < 4; i++){

            if(i == 0){

                inventory[i] = new Bandage();

            }
            else if(i == 1){

                inventory[i] = new Shield();

            }
            else{

                int rand = (int)(Math.random()*10+1);

                if(rand == 7){

                    inventory[i] = new Mullet();

                }
                else if(rand <=5){

                    inventory[i] = new Bandage();

                }
                else{

                    inventory[i] = new Shield();

                }

            }

        }

    }
    public int getHP(){

        return hp;

    }
    public void setHP(int hp){

        this.hp = hp;

    }
    public void setInventory(int index, Item item){

        inventory[index] = item;

    }
    public Item[] getInventory(){

        return inventory;

    }
    public int getDamageBonus(){

        return damageBonus;

    }
    public void setShields(int s){

        shields = s;

    }
    public int getShields(){

        return shields;

    }

    public void useBandage(Item item, int index){

        int e = item.getModifier();
        int x = Main.player.getHP();
        if(x == 100){

            JOptionPane.showMessageDialog(null, "You already have max health!");

        }
        else{

            Main.player.setHP(x+e);
            if(Main.player.getHP() > 100){

                Main.player.setHP(100);

            }

        }
        Main.player.setInventory(index, new Empty());

    }

}
