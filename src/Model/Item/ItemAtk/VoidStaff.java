package Model.Item.ItemAtk;
import Model.Character.Character;
import Model.Item.ItemModel;
import Model.Item.ItemUse;
import java.util.ArrayList;
public class VoidStaff extends ItemModel implements ItemUse {
    public VoidStaff(){
        name = "Void Staff";
        description = "Attack + 100 and Mana + 70";
        target_count = 1;
        target_type = 1;
    }

    @Override
    public void useItem(ArrayList<Character> target) {
        for (Character c : target) {
            c.setAtk(c.getAtk() + 100);
            if (c.getMp() + 70 >= c.getMax_mp()) {
                c.setMp(c.getMax_mp());
            } else {
                c.setMp(c.getMp() + 70);
            }
        }
    }
}
