package Model.Item.Mana;
import Model.Character.Character;
import Model.Item.ItemModel;
import Model.Item.ItemUse;

import java.util.ArrayList;
public class ManaPotionS extends ItemModel implements ItemUse{
    public ManaPotionS(){
        name = "Mana Potion S";
        description = "Heal mana 50 MP to 1 target";
        target_count = 1;
        target_type = 1;
    }

    @Override
    public void useItem(ArrayList<Character> target) {
        for (Character c : target) {
            if (c.getMp() + 50 >= c.getMax_mp()) {
                c.setMp(c.getMax_mp());
            } else {
                c.setMp(c.getMp() + 50);
            }
        }
    }
}
