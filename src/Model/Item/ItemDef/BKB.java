package Model.Item.ItemDef;
import Model.Character.Character;
import Model.Item.ItemModel;
import Model.Item.ItemUse;
import java.util.ArrayList;
public class BKB extends ItemModel implements ItemUse {
    public BKB(){
        name = "Black King Bar";
        description = "Def + 150";
        target_count = 1;
        target_type = 1;
    }

    @Override
    public void useItem(ArrayList<Character> target) {
        for (Character c : target) {
            c.setDef(c.getDef() + 150);
        }
    }
}
