package Controllers;

import java.awt.*;
import java.util.ArrayList;
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

    public AuditionController(){
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
}
