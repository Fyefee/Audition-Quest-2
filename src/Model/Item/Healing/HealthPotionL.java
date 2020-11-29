package Model.Item.Healing;

import Model.Character.Character;
import Model.Item.ItemModel;
import Model.Item.ItemUse;

import java.util.ArrayList;

public class HealthPotionL extends ItemModel implements ItemUse{
    public HealthPotionL(){
        name = "Health Potion L";
        description = "Heal 80 HP to 1 target";
        target_count = 1;
        target_type = 1;
    }

    @Override
    public void useItem(ArrayList<Character> target) {
        for (Character c : target) {
            if (c.getHp() + 80 >= c.getMax_hp()) {
                c.setHp(c.getMax_hp());
            } else {
                c.setHp(c.getHp() + 80);
            }
        }
    }
}
