package Model;

import java.util.ArrayList;

public class AuditionModel {

    private int x , y, state, width, arrow_count;
    private int[] random;
    private ArrayList<Character> speed;
    private ArrayList<Model.AuditionObject> audition;
    private int turn = 1;
    private boolean is_show = false, time_run = false, is_random = false, can_type = false;
    private double attack_percent, damage;
    private Character who_attack;
    private int max_time, now_time;
    private Boolean audition_is_show = false, audition_is_timerun = false;

    public AuditionModel(){
        speed = new ArrayList<Character>();
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

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getArrow_count() {
        return arrow_count;
    }

    public void setArrow_count(int arrow_count) {
        this.arrow_count = arrow_count;
    }

    public int[] getRandom() {
        return random;
    }

    public void setRandom(int[] random) {
        this.random = random;
    }

    public ArrayList<Character> getSpeed() {
        return speed;
    }

    public void setSpeed(ArrayList<Character> speed) {
        this.speed = speed;
    }

    public ArrayList<AuditionObject> getAudition() {
        return audition;
    }

    public void setAudition(ArrayList<AuditionObject> audition) {
        this.audition = audition;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public boolean isIs_show() {
        return is_show;
    }

    public void setIs_show(boolean is_show) {
        this.is_show = is_show;
    }

    public boolean isTime_run() {
        return time_run;
    }

    public void setTime_run(boolean time_run) {
        this.time_run = time_run;
    }

    public boolean isIs_random() {
        return is_random;
    }

    public void setIs_random(boolean is_random) {
        this.is_random = is_random;
    }

    public boolean isCan_type() {
        return can_type;
    }

    public void setCan_type(boolean can_type) {
        this.can_type = can_type;
    }

    public double getAttack_percent() {
        return attack_percent;
    }

    public void setAttack_percent(double attack_percent) {
        this.attack_percent = attack_percent;
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public Character getWho_attack() {
        return who_attack;
    }

    public void setWho_attack(Character who_attack) {
        this.who_attack = who_attack;
    }

    public int getMax_time() {
        return max_time;
    }

    public void setMax_time(int max_time) {
        this.max_time = max_time;
    }

    public int getNow_time() {
        return now_time;
    }

    public void setNow_time(int now_time) {
        this.now_time = now_time;
    }

    public Boolean getAudition_is_show() {
        return audition_is_show;
    }

    public void setAudition_is_show(Boolean audition_is_show) {
        this.audition_is_show = audition_is_show;
    }

    public Boolean getAudition_is_timerun() {
        return audition_is_timerun;
    }

    public void setAudition_is_timerun(Boolean audition_is_timerun) {
        this.audition_is_timerun = audition_is_timerun;
    }
}
