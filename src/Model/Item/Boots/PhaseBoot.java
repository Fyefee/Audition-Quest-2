package Model.Item.Boots;

import Model.Character.Character;
import Model.Item.ItemModel;
import Model.Item.ItemUse;
import java.util.ArrayList;

public class PhaseBoot extends ItemModel implements ItemUse {
    public PhaseBoot(){
        name = "Phase Boot";
        description = "Speed + 35 and Attack + 50";
        target_count = 1;
        target_type = 1;
    }

    @Override
    public void useItem(ArrayList<Character> target) {
        for (Character c : target) {
            c.setSpeed(c.getSpeed() + 35);
            c.setAtk(c.getAtk() + 50);
        }
    }
}
