package Model.Item.Mana;
import Model.Character.Character;
import Model.Item.ItemModel;
import Model.Item.ItemUse;

import java.util.ArrayList;
public class ManaPotionM extends ItemModel implements ItemUse{
    public ManaPotionM(){
        name = "Mana Potion M";
        description = "Heal mana 60 MP to 1 target";
        target_count = 1;
        target_type = 1;
    }

    @Override
    public void useItem(ArrayList<Character> target) {
        for (Character c : target) {
            if (c.getMp() + 60 >= c.getMax_mp()) {
                c.setMp(c.getMax_mp());
            } else {
                c.setMp(c.getMp() + 60);
            }
        }
    }
}
