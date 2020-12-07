package Model.Item.Healing;

import Model.Character.Character;
import Model.Item.ItemModel;
import Model.Item.ItemUse;

import java.util.ArrayList;

public class HighPotion extends ItemModel implements ItemUse {

    public HighPotion() {
        name = "High Potion";
        description = "Heal Max HP to 1 target";
        target_count = 1;
        target_type = 1;
    }

    @Override
    public void useItem(ArrayList<Character> target) {
        for (Character c : target) {
            c.setHp(c.getMax_hp());
        }
    }
}
