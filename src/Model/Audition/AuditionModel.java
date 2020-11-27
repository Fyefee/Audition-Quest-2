package Model.Audition;

import Model.Character.Character;

import java.util.ArrayList;

public class AuditionModel {

    private int x , y, state, width, arrow_count;
    private int[] random;
    private ArrayList<Character> speed;
    private ArrayList<AuditionObject> audition;
    private int turn = 1, overflow_count, audition_first_index, audition_final_index;
    private boolean is_show = false, time_run = false, is_random = false, can_type = false, is_arrow_overflow = false;
    private double attack_percent, damage;
    private Character who_attack;
    private int max_time, now_time;
    private Boolean audition_is_show = false, audition_is_timerun = false;

    public AuditionModel(){
        speed = new ArrayList<Character>();
    }

    public void checkAuditionOverflow(){
        if (audition.size() > 10){
            is_arrow_overflow = true;
            overflow_count = (int) Math.ceil((double) audition.size() / 10) - 1;
            audition_first_index = 0;
            audition_final_index = 10;
        }
    }

    public void checkState(){
        overflow_count -= 1;
        if (overflow_count == 0){
            is_arrow_overflow = false;

        } else {
            audition_final_index += 10;
            x = 100;
            y = 100;
        }
        audition_first_index += 10;
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

    public boolean isIs_arrow_overflow() {
        return is_arrow_overflow;
    }

    public void setIs_arrow_overflow(boolean is_arrow_overflow) {
        this.is_arrow_overflow = is_arrow_overflow;
    }

    public int getOverflow_count() {
        return overflow_count;
    }

    public void setOverflow_count(int overflow_count) {
        this.overflow_count = overflow_count;
    }

    public int getAudition_final_index() {
        return audition_final_index;
    }

    public void setAudition_final_index(int audition_final_index) {
        this.audition_final_index = audition_final_index;
    }

    public int getAudition_first_index() {
        return audition_first_index;
    }

    public void setAudition_first_index(int audition_first_index) {
        this.audition_first_index = audition_first_index;
    }
}
