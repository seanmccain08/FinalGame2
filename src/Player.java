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
    public void setDamageBonus(int x){

        damageBonus = x;

    }
    public void setShields(int s){

        shields = s;

    }
    public int getShields(){

        return shields;

    }

    public void useBandage(Item item, int index){

        int e = item.getModifier();
        int x = getHP();
        if(x == 100){

            Sound.expandSound();
            JOptionPane.showMessageDialog(null, "You already have max health!");
            Sound.backSound();

        }
        else{

            setHP(x+e);
            if(getHP() > 100){

                setHP(100);

            }
            setInventory(index, new Empty());

        }

    }
    public void useShield(Item item, int index){

        int e = item.getModifier();
        setShields(getShields()+e);
        inventory[index] = new Empty();

    }
    public void useMullet(Item item, int index){

        int e = item.getModifier();
        setDamageBonus(getDamageBonus()+e);
        inventory[index] = new Empty();

    }

}
