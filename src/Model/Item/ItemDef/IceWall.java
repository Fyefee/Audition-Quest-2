package Model.Item.ItemDef;
import Model.Character.Character;
import Model.Item.ItemModel;
import Model.Item.ItemUse;
import java.util.ArrayList;
public class IceWall extends ItemModel implements ItemUse {
    public IceWall(){
        name = "Ice Wall";
        description = "Def + 100 and Mana + 100";
        target_count = 1;
        target_type = 1;
    }

    @Override
    public void useItem(ArrayList<Character> target) {
        for (Character c : target) {
            c.setDef(c.getDef() + 100);
            if (c.getMp() + 100 >= c.getMax_mp()) {
                c.setMp(c.getMax_mp());
            } else {
                c.setMp(c.getMp() + 100);
            }
        }
    }
}
