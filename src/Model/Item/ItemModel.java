package Model.Item;

import Model.Character.Character;
import Model.Item.Healing.HealthPotionS;

import java.util.ArrayList;

public class ItemModel implements ItemUse{

    protected String name, description;
    protected int text_x, text_y;
    protected int target_count, target_type; //type 0 = Attack. 1 = Heal/Buff
    protected ArrayList<ItemModel> itemModels  = new ArrayList<ItemModel>();

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

    public void addItemsToArrayEasy(){
        itemModels.add(new HealthPotionS());
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

    public ArrayList<ItemModel> getItemModels() {
        return itemModels;
    }

    public void setItemModels(ArrayList<ItemModel> itemModels) {
        this.itemModels = itemModels;
    }

    public int getText_x() {
        return text_x;
    }

    public void setText_x(int text_x) {
        this.text_x = text_x;
    }

    public int getText_y() {
        return text_y;
    }

    public void setText_y(int text_y) {
        this.text_y = text_y;
    }
}
