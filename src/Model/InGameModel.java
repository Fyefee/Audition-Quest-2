package Model;

import Model.Background.Background;
import Model.Character.Character;
import Model.Character.Monster.*;
import Model.Character.Player.*;
import Model.Item.ItemModel;

import java.util.ArrayList;

public class InGameModel {

    private Boolean is_press = true, is_start = false;

    private long start = System.nanoTime(), now;
    private int nano = 1000000000, msp1 = 10000000;

    private String difficulty;
    private int stage;

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

    private boolean isMonster1_drop, isMonster2_drop, show_item, replace_item;
    private int drop_count = 0, replace_item_index;
    private ItemModel item_drop;
    private Character who_get_item;

    private ArrayList<Character> monster_pool1, monster_pool2;
    private ArrayList<Character> monster_in_stage;

    private boolean all_monster_dead;

    public InGameModel(){
        c1 = new Druid();
        c2 = new Wizard();
        m1 = new Golem(1);
        m2 = new Golem(2);

        monster_in_stage = new ArrayList<Character>();
        monster_in_stage.add(m1);
        monster_in_stage.add(m2);
    }

    public void setStageEasy(){

        difficulty = "Easy";

        monster_pool1 = new ArrayList<Character>();
        monster_pool1.add(new Slime(1));
        monster_pool1.add(new Creeper(1));

        monster_pool2 = new ArrayList<Character>();
        monster_pool2.add(new Slime(2));
        monster_pool2.add(new Creeper(2));

    }

    public void addMonsterToPool(){

        if (difficulty.equals("Easy")){
            if (stage == 3) {
                monster_pool1.add(new FireFang(1));
                monster_pool2.add(new FireFang(2));
            } else if (stage == 6) {
                monster_pool1.add(new MechaFang(1));
                monster_pool2.add(new MechaFang(2));

                monster_pool1.remove(0);
                monster_pool2.remove(0);
            } else if (stage == 10) {
                monster_pool2 = new ArrayList<Character>();
                monster_pool2.add(new Golem(2));
            }
        }

        System.out.println(monster_pool2);

    }

    public void randomMonster(){
        int rand = (int) (Math.random() * monster_pool1.size());

        m1 = monster_pool1.get(rand);
        resetMonsterInPosition(rand, 1, monster_pool1);

        rand = (int) (Math.random() * monster_pool2.size());
        m2 = monster_pool2.get(rand);
        resetMonsterInPosition(rand, 2, monster_pool2);

    }

    public void resetMonsterInPosition(int rand, int index, ArrayList<Character> pool){
        if (pool.get(rand).getName().equals("Slime")) {
            pool.set(rand, new Slime(index));
        } else if  (pool.get(rand).getName().equals("Creeper")) {
            pool.set(rand, new Creeper(index));
        } else if  (pool.get(rand).getName().equals("Fire Fang")) {
            pool.set(rand, new FireFang(index));
        } else if  (pool.get(rand).getName().equals("Mecha Fang")) {
            pool.set(rand, new MechaFang(index));
        } else if  (pool.get(rand).getName().equals("Golem")) {
            pool.set(rand, new Golem(index));
        }
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

    public Character getWho_get_item() {
        return who_get_item;
    }

    public void setWho_get_item(Character who_get_item) {
        this.who_get_item = who_get_item;
    }

    public boolean isReplace_item() {
        return replace_item;
    }

    public void setReplace_item(boolean replace_item) {
        this.replace_item = replace_item;
    }

    public int getReplace_item_index() {
        return replace_item_index;
    }

    public void setReplace_item_index(int replace_item_index) {
        this.replace_item_index = replace_item_index;
    }

    public int getStage() {
        return stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }
}
