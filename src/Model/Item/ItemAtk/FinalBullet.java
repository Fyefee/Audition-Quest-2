package Model.Item.ItemAtk;

import Model.Character.Character;
import Model.Item.ItemModel;
import Model.Item.ItemUse;
import java.util.ArrayList;
public class FinalBullet extends ItemModel implements ItemUse{
    public FinalBullet(){
        name = "Final Bullet";
        description = "Attack + 70";
        target_count = 1;
        target_type = 1;
    }

    @Override
    public void useItem(ArrayList<Character> target) {
        for (Character c : target) {
            c.setAtk(c.getAtk() + 70);
        }
    }
}
