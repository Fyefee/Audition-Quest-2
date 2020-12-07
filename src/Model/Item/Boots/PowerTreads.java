package Model.Item.Boots;

import Model.Character.Character;
import Model.Item.ItemModel;
import Model.Item.ItemUse;
import java.util.ArrayList;

public class PowerTreads extends ItemModel implements ItemUse {
    public PowerTreads(){
        name = "Power Treads";
        description = "Speed + 30, Mana + 50 and HP + 100";
        target_count = 1;
        target_type = 1;
    }

    @Override
    public void useItem(ArrayList<Character> target) {
        for (Character c : target) {
            c.setSpeed(c.getSpeed() + 30);
            if (c.getMp() + 50 >= c.getMax_mp()) {
                c.setMp(c.getMax_mp());
            } else {
                c.setMp(c.getMp() + 50);
            }
            if (c.getHp() + 100 >= c.getMax_hp()) {
                c.setHp(c.getMax_hp());
            } else {
                c.setHp(c.getHp() + 100);
            }
        }
    }
}
