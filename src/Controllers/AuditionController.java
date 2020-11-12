package Controllers;

import java.awt.*;
import java.util.ArrayList;

import Model.*;
import Model.Character;

public class AuditionController {

    private int x , y, state, width, arrow_count, arrow_score;
    private static int[] random;
    private ArrayList<Model.Character> speed = new ArrayList<Character>();
    private ArrayList<Model.AuditionObject> audition;
    private int press_button, max_turn = 4;
    public int turn = 1;
    private boolean is_show = false, time_run = false, is_random = false;
    private double attack_percent;
    private Character target_c, who_attack;
    private AuditionObject auditionObject;
    private int max_time, now_time;
    private Boolean audition_is_show = false, audition_is_timerun = false;

    private InGameController inGameController;
    private TimeBar timeBar;

    public AuditionController(InGameController inGameController){
        this.inGameController = inGameController;

        speed.add(InGameController.getC1());
        speed.add(InGameController.getC2());
        speed.add(InGameController.getM1());
        speed.add(InGameController.getM2());

        timeBar = new TimeBar();
    }

    public static int[] addX(int n, int arr[], int x)
    {
        int i;
        int newarr[] = new int[n + 1];

        for (i = 0; i < n; i++)
            newarr[i] = arr[i];

        newarr[n] = x;

        random = newarr;

        return newarr;
    }

    public static Integer[] deleteSpeed(Integer arr[])
    {
        int i;
        Integer newarr[] = new Integer[arr.length-1];
        for (i = 0; i < arr.length-1; i++)
            newarr[i] = arr[i+1];

        return newarr;
    }

    public void random(){
        audition = new ArrayList<AuditionObject>();
        x = 100;
        y = 100;
        for (int i = 0; i < arrow_count; i++){
            int rand = (int)(Math.random() * 4) + 1;
            switch (rand){
                case 1: audition.add(new ArrowUp(x, 100)); break;
                case 2: audition.add(new ArrowDown(x, 100)); break;
                case 3: audition.add(new ArrowLeft(x, 100)); break;
                case 4: audition.add(new ArrowRight(x, 100)); break;
                default: break;
            }
            x += 100;
        }
        state = 0;
    }

    public void resize_bar(int now_time){
        if (now_time-100 >= max_time){
            audition_is_timerun = false;
            timeBar.setSize_x(0);
        }
        else if (now_time-100 < 0){
            timeBar.setSize_x(1000);
        }
        else{
            timeBar.setSize_x((int) (1000 - (1000 * (((double)now_time-100) / ((double)max_time)))));
        }
    }

    public void start_audition(int arrow_count, int max_time){
        setArrow_count(arrow_count);
        random();
        setMax_time(max_time);
        setAudition_is_show(true);
        setAudition_is_timerun(true);

    }

    public void check_audition_key(int key){
        if (state < arrow_count) {
            if (audition.get(state).getType() == key) {
                audition.set(state, new Empty(audition.get(state).getPosition_x(), 100));
            } else {
                audition.set(state, new Wrong(audition.get(state).getPosition_x(), 100));
            }
            state++;
        }
    }

    public void audition(Graphics g){
        now_time -= 100;

        if (time_run && random[state] == press_button && (int)now_time >= 0){
            random[state] = 0;
            arrow_score++;
            if (state < arrow_count){
                state++;
            }
        }
        else if (time_run && (random[state] != press_button && press_button != 0 && (int)now_time >= 0)){
            random[state] = 5;
            press_button = 0;
            if (state < arrow_count){
                state++;
            }
            if (attack_percent > 0){
                attack_percent -= 0.2;
            }
        }

        if (state > arrow_count-1 && time_run){
            time_run = false;
            is_show = false;
            //who_attack.attack(target_c);
        }

        press_button = 0;
    }

    public ArrayList<Character> getSpeed() {
        return speed;
    }

    public void setSpeed(ArrayList<Character> speed) {
        this.speed = speed;
    }

    public static int[] getRandom() {
        return random;
    }

    public static void setRandom(int[] random) {
        AuditionController.random = random;
    }

    public boolean isIs_show() {
        return is_show;
    }

    public void setIs_show(boolean is_show) {
        this.is_show = is_show;
    }

    public boolean isIs_random() {
        return is_random;
    }

    public void setIs_random(boolean is_random) {
        this.is_random = is_random;
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

    public ArrayList<AuditionObject> getAudition() {
        return audition;
    }

    public void setAudition(ArrayList<AuditionObject> audition) {
        this.audition = audition;
    }

    public TimeBar getTimeBar() {
        return timeBar;
    }

    public void setTimeBar(TimeBar timeBar) {
        this.timeBar = timeBar;
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
