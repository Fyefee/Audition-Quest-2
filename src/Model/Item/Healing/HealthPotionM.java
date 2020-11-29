package Model.Item.Healing;

import Model.Character.Character;
import Model.Item.ItemModel;
import Model.Item.ItemUse;

import java.util.ArrayList;

public class HealthPotionM extends ItemModel implements ItemUse{
    public HealthPotionM(){
        name = "Health Potion M";
        description = "Heal 60 HP to 1 target";
        target_count = 1;
        target_type = 1;
    }

    @Override
    public void useItem(ArrayList<Character> target) {
        for (Character c : target) {
            if (c.getHp() + 60 >= c.getMax_hp()) {
                c.setHp(c.getMax_hp());
            } else {
                c.setHp(c.getHp() + 60);
            }
        }
    }
}
