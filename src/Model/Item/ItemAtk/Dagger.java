package Model.Item.ItemAtk;

import Model.Character.Character;
import Model.Item.ItemModel;
import Model.Item.ItemUse;
import java.util.ArrayList;
public class Dagger extends ItemModel implements ItemUse{
    public Dagger(){
        name = "Dagger";
        description = "Attack + 20";
        target_count = 1;
        target_type = 1;
        text_x = 555;
        text_y = 330;
    }

    @Override
    public void useItem(ArrayList<Character> target) {
        for (Character c : target) {
            c.setAtk(c.getAtk() + 20);
        }
    }
}
