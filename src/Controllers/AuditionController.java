package Controllers;

import java.awt.*;
import java.util.ArrayList;

import Model.Arrow;
import Model.Character;

public class AuditionController {

    public Image arrow_up, arrow_down, arrow_left, arrow_right, empty, wrong;
    private int x , y, state, width, arrow_count, arrow_score;
    private static int[] random;
    private static ArrayList<Model.Character> speed = new ArrayList<Character>();
    private int press_button, max_turn = 4;
    public int turn = 1;
    private boolean is_show = false, time_run = false, is_random = false;
    private double attack_percent;
    private Character target_c, who_attack;
    private Arrow arrow;
    private int max_time, now_time;

    private InGameController inGameController;

    public AuditionController(InGameController inGameController){
        this.inGameController = inGameController;
        arrow = new Arrow();
        speed.add(InGameController.getC1());
        speed.add(InGameController.getC2());
        speed.add(InGameController.getM1());
        speed.add(InGameController.getM2());
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
        for (int i = 0; i < arrow_count; i++){
            int rand = (int)(Math.random() * 4) + 1;
            random = addX(i, random, rand);
        }
        state = 0;
    }

    public void audition(Graphics g){
        now_time -= 100;
        x = 100;
        y = 100;

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

//        if (is_show){
//            g.setColor(new Color(120,120,120));
//            g.fillRect(100, 100, 1000, 100);
//
//            g.setColor(new Color(0,255,0));
//            if (now_time >= max_time){
//                time_run = false;
//                width = 0;
//            }
//            else if ((int)now_time < 0){
//                width = 1000;
//            }
//            else{
//                width = (int) (1000 - (1000 * (((double)now_time) / ((double)max_time))));
//            }
//            g.fillRect(100, 200, width, 10);
//            for (int i = 0; i < random.length; i++){
//                switch (random[i]){
//                    case 0: g.drawImage(empty, x, y, 100, 100, this); break;
//                    case 1: g.drawImage(arrow_up, x, y, 100, 100, this); break;
//                    case 2: g.drawImage(arrow_down, x, y, 100, 100, this); break;
//                    case 3: g.drawImage(arrow_left, x, y, 100, 100, this); break;
//                    case 4: g.drawImage(arrow_right, x, y, 100, 100, this); break;
//                    case 5: g.drawImage(wrong, x, y, 100, 100, this); break;
//                    default: break;
//                }
//                x += 100;
//            }
//        }

        press_button = 0;
    }

    public static ArrayList<Character> getSpeed() {
        return speed;
    }

    public static void setSpeed(ArrayList<Character> speed) {
        AuditionController.speed = speed;
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
}
