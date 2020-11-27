package Model.Item;

public class ItemModel {

    private String name, description;

    public ItemModel(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void useItem(){

    }

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

}
