package Model.Item.ItemDef;
import Model.Character.Character;
import Model.Item.ItemModel;
import Model.Item.ItemUse;
import java.util.ArrayList;
public class GuardianAngel extends ItemModel implements ItemUse {
    public GuardianAngel(){
        name = "Guardian Angel";
        description = "Def + 20";
        target_count = 1;
        target_type = 1;
        text_x = 525;
        text_y = 330;
    }

    @Override
    public void useItem(ArrayList<Character> target) {
        for (Character c : target) {
            c.setDef(c.getDef() + 20);
        }
    }
}
