package Model.Item.ItemAtk;

import Model.Character.Character;
import Model.Item.ItemModel;
import Model.Item.ItemUse;
import java.util.ArrayList;
public class Smoke extends ItemModel implements ItemUse{
    public Smoke(){
        name = "Smoke";
        description = "Attack + 10 and Heal HP 20";
        target_count = 1;
        target_type = 1;
    }

    @Override
    public void useItem(ArrayList<Character> target) {
        for (Character c : target) {
            c.setAtk(c.getAtk() + 10);
            if (c.getHp() + 20 >= c.getMax_hp()) {
                c.setHp(c.getMax_hp());
            } else {
                c.setHp(c.getHp() + 20);
            }
        }
    }
}
