package Model.Item.ItemDef;
import Model.Character.Character;
import Model.Item.ItemModel;
import Model.Item.ItemUse;
import java.util.ArrayList;
public class ShieldBreaker extends ItemModel implements ItemUse {
    public ShieldBreaker(){
        name = "Shield Breaker";
        description = "Def + 50";
        target_count = 1;
        target_type = 1;
    }

    @Override
    public void useItem(ArrayList<Character> target) {
        for (Character c : target) {
            c.setDef(c.getDef() + 50);
        }
    }
}
