package Model.Item.Boots;

import Model.Character.Character;
import Model.Item.ItemModel;
import Model.Item.ItemUse;
import java.util.ArrayList;

public class NinjaTabi extends ItemModel implements ItemUse {
    public NinjaTabi(){
        name = "Ninja Tabi";
        description = "Speed + 20 and Defend + 30";
        target_count = 1;
        target_type = 1;
    }

    @Override
    public void useItem(ArrayList<Character> target) {
        for (Character c : target) {
            c.setSpeed(c.getSpeed() + 20);
            c.setDef(c.getDef() + 30);
        }
    }
}
