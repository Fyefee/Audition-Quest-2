package Controllers;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import Model.*;
import Model.Character;

public class AuditionController {

    private int x , y, state, width, arrow_count, arrow_score;
    private static int[] random;
    private ArrayList<Model.Character> speed = new ArrayList<Character>();
    private ArrayList<Model.AuditionObject> audition;
    private int press_button, max_turn = 4;
    private int turn = 1;
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

        speed.add(inGameController.getC1());
        speed.add(inGameController.getC2());
        speed.add(inGameController.getM1());
        speed.add(inGameController.getM2());

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
            System.out.println(now_time);
            System.out.println("WTF");
        }
        else if (now_time-100 < 0){
            timeBar.setSize_x(1000);
        }
        else{
            timeBar.setSize_x((int) (1000 - (1000 * (((double)now_time-100) / ((double)max_time)))));
        }
    }

    public void start_audition(int arrow_count, int max_time){
        setMax_time(max_time);
        setArrow_count(arrow_count);
        random();
        setAttack_percent(1);
        setAudition_is_timerun(true);
        setAudition_is_show(true);
        inGameController.getInGameRenderImage().setAudition(audition);
    }

    public void check_audition_key(int key){
        if (state < arrow_count) {
            if (audition.get(state).getType() == key) {
                audition.set(state, new Empty(audition.get(state).getPosition_x(), 100));
            } else {
                audition.set(state, new Wrong(audition.get(state).getPosition_x(), 100));
                attack_percent -= 0.2;
            }
            state++;
            if (state == arrow_count){
                setAudition_is_show(false);
                setAudition_is_timerun(false);
                attack(speed.get(turn-1));
            }
        }
    }

    public void checkAttack(Character c) {
        if (c.getType().equals("Player")) {
            if (c.getAttack_type().equals("attack")) {
                    if (c.getAttack_target().get(0) == inGameController.getC1() && inGameController.getC1().isAlive()) {
                        start_audition(5, 500);
                    } else if (c.getAttack_target().get(0) == inGameController.getC2() && inGameController.getC2().isAlive()) {
                        start_audition(5, 500);
                    } else if (c.getAttack_target().get(0) == inGameController.getM1() && inGameController.getM1().isAlive()) {
                        start_audition(5, 500);
                    } else if (c.getAttack_target().get(0) == inGameController.getM2() && inGameController.getM2().isAlive()) {
                        start_audition(5, 500);
                    } else {
                        for (int i = 0; i <= (4 - turn); i++) {
                            turn++;
                            if (speed.get(turn - 1).isAlive())
                                break;
                        }
                        inGameController.setText_Button();
                        inGameController.setText_showattack(true);
                    }
                }
            }
            else {
                setAttack_percent(1);
                setWho_attack(c);
                if (c.getAttack_target().get(0) == inGameController.getC1())
                    attack(c);
                else if (c.getAttack_target().get(0) == inGameController.getC2())
                    attack(c);
            }
    }

    public void attack(Character who_attack){
        try {
            String text = "";
            for (int i = 0; i < who_attack.getAttack_target().size(); i++) {
                text = who_attack.getName() + " Attack " + who_attack.getAttack_target().get(i).getName() + " " + ((int) ((double) who_attack.getAtk() * attack_percent - who_attack.getAttack_target().get(i).getDef()) + " Damage.");
                System.out.println(text);
                if (((int) ((double) who_attack.getAtk() * attack_percent - who_attack.getAttack_target().get(i).getDef())) > 0) {
                    who_attack.getAttack_target().get(i).setHp(who_attack.getAttack_target().get(i).getHp() - ((int) ((double) who_attack.getAtk() * attack_percent) - who_attack.getAttack_target().get(i).getDef()));
                }

                if (who_attack.getAttack_target().get(i).getHp() <= 0) {
                    who_attack.getAttack_target().get(i).setAlive(false);
                    who_attack.getAttack_target().get(i).setHp(0);
                }

            }
            inGameController.getInGameJPanel().getP1_hp().setText("HP : " + inGameController.getC1().getHp() + "/" + inGameController.getC1().getMax_hp());
            inGameController.getInGameJPanel().getP2_hp().setText("HP : " + inGameController.getC2().getHp() + "/" + inGameController.getC2().getMax_hp());
            inGameController.getInGameJPanel().getM1_hp().setText("HP : " + inGameController.getM1().getHp() + "/" + inGameController.getM1().getMax_hp());
            inGameController.getInGameJPanel().getM2_hp().setText("HP : " + inGameController.getM2().getHp() + "/" + inGameController.getM2().getMax_hp());

            inGameController.getInGameButtonJPanel().getCard_select().show(inGameController.getInGameButtonJPanel(), "text_button");
            inGameController.setText_Button(text);
            turn++;
            inGameController.setIs_start(false);
        } catch (Exception e) {
            System.out.println(e);
        }
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

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public double getAttack_percent() {
        return attack_percent;
    }

    public void setAttack_percent(double attack_percent) {
        this.attack_percent = attack_percent;
    }

    public Character getWho_attack() {
        return who_attack;
    }

    public void setWho_attack(Character who_attack) {
        this.who_attack = who_attack;
    }
}
