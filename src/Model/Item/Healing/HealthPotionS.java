package Model.Item.Healing;

import Model.Character.Character;
import Model.Item.ItemModel;
import Model.Item.ItemUse;

import java.util.ArrayList;

public class HealthPotionS  extends ItemModel implements ItemUse {

    public HealthPotionS(){
        name = "Health Potion S";
        description = "Heal 50 HP to 1 target";
        target_count = 2;
        target_type = 1;
    }

    @Override
    public void useItem(ArrayList<Character> target) {
        for (Character c : target) {
            if (c.getHp() + 50 >= c.getMax_hp()) {
                c.setHp(c.getMax_hp());
            } else {
                c.setHp(c.getHp() + 50);
            }
        }
    }

}
