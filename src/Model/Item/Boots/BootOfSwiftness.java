package Model.Item.Boots;

import Model.Character.Character;
import Model.Item.ItemModel;
import Model.Item.ItemUse;
import java.util.ArrayList;

public class BootOfSwiftness extends ItemModel implements ItemUse {
    public BootOfSwiftness(){
        name = "Boot of Swiftness";
        description = "Speed + 50";
        target_count = 1;
        target_type = 1;
    }

    @Override
    public void useItem(ArrayList<Character> target) {
        for (Character c : target) {
            c.setSpeed(c.getSpeed() + 50);
        }
    }
}
