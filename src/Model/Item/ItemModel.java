package Model.Item;

import Model.Character.Character;

import java.util.ArrayList;

public class ItemModel implements ItemUse{

    protected String name, description;
    protected int target_count, target_type; //type 0 = Attack. 1 = Heal/Buff

    public ItemModel(){
        this.name = null;
        this.description = null;
        this.target_count = 0;
    }

    public ItemModel(String name, String description, int target_count) {
        this.name = name;
        this.description = description;
        this.target_count = target_count;
    }

    public void useItem(ArrayList<Character> target){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTarget_count() {
        return target_count;
    }

    public void setTarget_count(int target_count) {
        this.target_count = target_count;
    }

    public int getTarget_type() {
        return target_type;
    }

    public void setTarget_type(int target_type) {
        this.target_type = target_type;
    }
}
