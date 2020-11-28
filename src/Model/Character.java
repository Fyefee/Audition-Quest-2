package Model;

import java.awt.*;
import java.util.ArrayList;

public class Character implements PlayerSkill{

    private String name, attack_text = "", target = "", type = "";
    protected String skill1_name, skill2_name, skill3_name;
    protected String skill1_description, skill2_description, skill3_description;
    protected int not_attack_type; // 0 = defense, 1 = use item 1, 2 = use item 2, 3 = use item 3,
    protected int target_count, arrow_count, audition_time; // time/100 = 1 sec
    protected int hp, max_hp;
    protected int mp, max_mp, mp_used;
    protected int speed, base_speed;
    protected int atk, base_atk;
    protected int def, base_def;
    protected double attack_percent, defence_percent;
    private Image pic;
    private int x, y, size_x, size_y;
    private boolean alive = true;
    private int rand;
    private ArrayList<Character> attack_target;

    public Character(String name, int hp, int mp, int speed, int atk, int def, int size_x, int size_y, String type) {

        this.name = name;

        this.hp = hp;
        max_hp = hp;

        this.mp = mp;
        max_mp = mp;

        this.speed = speed;
        base_speed = speed;

        this.def = def;
        base_def = def;

        this.atk = atk;
        base_atk = atk;

        this.size_x = size_x;
        this.size_y = size_y;

        this.type = type;

        attack_percent = 1;
        defence_percent = 1;
        target_count = 1;

    }

    public void skill1(){}
    public void skill2(){}
    public void skill3(){}

    public void normalAttack(){
        returnStats();
        arrow_count = 5;
        audition_time = 500;
        this.setAttack_text("used attack to ");
    }

    public void defense(){
        returnStats();
        not_attack_type = 0;
        this.setAttack_text("used defense");
        setDefence_percent(0.70);
        setSpeed(999);
    }

    public void returnStats(){
        mp_used = 0;
        speed = base_speed;
        atk = base_atk;
        def = base_def;
        attack_percent = 1;
        defence_percent = 1;
    }

    public void decreaseMp(){
        mp -= mp_used;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAttack_text() {
        return attack_text;
    }

    public void setAttack_text(String attack_text) {
        this.attack_text = attack_text;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMax_hp() {
        return max_hp;
    }

    public void setMax_hp(int max_hp) {
        this.max_hp = max_hp;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public int getMax_mp() {
        return max_mp;
    }

    public void setMax_mp(int max_mp) {
        this.max_mp = max_mp;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public Image getPic() {
        return pic;
    }

    public void setPic(Image pic) {
        this.pic = pic;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSize_x() {
        return size_x;
    }

    public void setSize_x(int size_x) {
        this.size_x = size_x;
    }

    public int getSize_y() {
        return size_y;
    }

    public void setSize_y(int size_y) {
        this.size_y = size_y;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public int getRand() {
        return rand;
    }

    public void setRand(int rand) {
        this.rand = rand;
    }

    public ArrayList<Character> getAttack_target() {
        return attack_target;
    }

    public void setAttack_target(ArrayList<Character> attack_target) {
        this.attack_target = attack_target;
    }

    public int getBase_speed() {
        return base_speed;
    }

    public void setBase_speed(int base_speed) {
        this.base_speed = base_speed;
    }

    public int getBase_atk() {
        return base_atk;
    }

    public void setBase_atk(int base_atk) {
        this.base_atk = base_atk;
    }

    public int getBase_def() {
        return base_def;
    }

    public void setBase_def(int base_def) {
        this.base_def = base_def;
    }

    public double getAttack_percent() {
        return attack_percent;
    }

    public void setAttack_percent(double attack_percent) {
        this.attack_percent = attack_percent;
    }

    public double getDefence_percent() {
        return defence_percent;
    }

    public void setDefence_percent(double defence_percent) {
        this.defence_percent = defence_percent;
    }

    public int getNot_attack_type() {
        return not_attack_type;
    }

    public void setNot_attack_type(int not_attack_type) {
        this.not_attack_type = not_attack_type;
    }

    public int getTarget_count() {
        return target_count;
    }

    public void setTarget_count(int target_count) {
        this.target_count = target_count;
    }

    public String getSkill1_name() {
        return skill1_name;
    }

    public void setSkill1_name(String skill1_name) {
        this.skill1_name = skill1_name;
    }

    public String getSkill2_name() {
        return skill2_name;
    }

    public void setSkill2_name(String skill2_name) {
        this.skill2_name = skill2_name;
    }

    public String getSkill3_name() {
        return skill3_name;
    }

    public void setSkill3_name(String skill3_name) {
        this.skill3_name = skill3_name;
    }

    public String getSkill1_description() {
        return skill1_description;
    }

    public void setSkill1_description(String skill1_description) {
        this.skill1_description = skill1_description;
    }

    public String getSkill2_description() {
        return skill2_description;
    }

    public void setSkill2_description(String skill2_description) {
        this.skill2_description = skill2_description;
    }

    public String getSkill3_description() {
        return skill3_description;
    }

    public void setSkill3_description(String skill3_description) {
        this.skill3_description = skill3_description;
    }

    public int getMp_used() {
        return mp_used;
    }

    public void setMp_used(int mp_used) {
        this.mp_used = mp_used;
    }

    public int getArrow_count() {
        return arrow_count;
    }

    public void setArrow_count(int arrow_count) {
        this.arrow_count = arrow_count;
    }

    public int getAudition_time() {
        return audition_time;
    }

    public void setAudition_time(int audition_time) {
        this.audition_time = audition_time;
    }
}

