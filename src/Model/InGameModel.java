package Model;

import Model.Background.Background;
import Model.Character.Character;
import Model.Character.Monster.Creeper;
import Model.Character.Monster.Slime;
import Model.Character.Player.Archer;
import Model.Character.Player.Knight;
import Model.Item.ItemModel;

public class InGameModel {

    private Boolean is_press = true, is_start = false;

    private long start = System.nanoTime(), now;
    private int nano = 1000000000, msp1 = 10000000;

    private Character c1;
    private Character c2;
    private Character m1;
    private Character m2;

    private Background bg = new Background();

    private int target_count, attack_state = 1, item_index; //1 = c1 select
    private int target_type; // 0 = Attack, 1 = Heal
    //private String text_button_text = "";
    private boolean text_showattack;
    private int rand;

    private boolean isMonster1_drop, isMonster2_drop, show_item;
    private int drop_count = 0;
    private ItemModel item_drop;

    private boolean all_monster_dead;

    public InGameModel(){
        c1 = new Knight();
        c2 = new Archer();
        m1 = new Slime(1);
        m2 = new Slime(2);
    }

    public Boolean getIs_press() {
        return is_press;
    }

    public void setIs_press(Boolean is_press) {
        this.is_press = is_press;
    }

    public Boolean getIs_start() {
        return is_start;
    }

    public void setIs_start(Boolean is_start) {
        this.is_start = is_start;
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public long getNow() {
        return now;
    }

    public void setNow(long now) {
        this.now = now;
    }

    public int getNano() {
        return nano;
    }

    public void setNano(int nano) {
        this.nano = nano;
    }

    public int getMsp1() {
        return msp1;
    }

    public void setMsp1(int msp1) {
        this.msp1 = msp1;
    }

    public Character getC1() {
        return c1;
    }

    public void setC1(Character c1) {
        this.c1 = c1;
    }

    public Character getC2() {
        return c2;
    }

    public void setC2(Character c2) {
        this.c2 = c2;
    }

    public Character getM1() {
        return m1;
    }

    public void setM1(Character m1) {
        this.m1 = m1;
    }

    public Character getM2() {
        return m2;
    }

    public void setM2(Character m2) {
        this.m2 = m2;
    }

    public Background getBg() {
        return bg;
    }

    public void setBg(Background bg) {
        this.bg = bg;
    }

    public int getTarget_count() {
        return target_count;
    }

    public void setTarget_count(int target_count) {
        this.target_count = target_count;
    }

    public int getAttack_state() {
        return attack_state;
    }

    public void setAttack_state(int attack_state) {
        this.attack_state = attack_state;
    }

    public int getItem_index() {
        return item_index;
    }

    public void setItem_index(int item_index) {
        this.item_index = item_index;
    }

    public int getTarget_type() {
        return target_type;
    }

    public void setTarget_type(int target_type) {
        this.target_type = target_type;
    }

    public boolean isText_showattack() {
        return text_showattack;
    }

    public void setText_showattack(boolean text_showattack) {
        this.text_showattack = text_showattack;
    }

    public int getRand() {
        return rand;
    }

    public void setRand(int rand) {
        this.rand = rand;
    }

    public boolean isMonster1_drop() {
        return isMonster1_drop;
    }

    public void setMonster1_drop(boolean monster1_drop) {
        isMonster1_drop = monster1_drop;
    }

    public boolean isMonster2_drop() {
        return isMonster2_drop;
    }

    public void setMonster2_drop(boolean monster2_drop) {
        isMonster2_drop = monster2_drop;
    }

    public boolean isAll_monster_dead() {
        return all_monster_dead;
    }

    public void setAll_monster_dead(boolean all_monster_dead) {
        this.all_monster_dead = all_monster_dead;
    }

    public int getDrop_count() {
        return drop_count;
    }

    public void setDrop_count(int drop_count) {
        this.drop_count = drop_count;
    }

    public boolean isShow_item() {
        return show_item;
    }

    public void setShow_item(boolean show_item) {
        this.show_item = show_item;
    }

    public ItemModel getItem_drop() {
        return item_drop;
    }

    public void setItem_drop(ItemModel item_drop) {
        this.item_drop = item_drop;
    }
}
