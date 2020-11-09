package Controllers;

import Model.Character;
import View.InGameJPanel;
import Model.*;

public class InGameController implements Runnable{

    private InGameJPanel inGameJPanel;

    private static Character c1 = new Knight();
    private static Character c2 = new Archer();
    private static Character m1 = new Slime(1);
    private static Character m2 = new Slime(2);

    public InGameController(){
        this.inGameJPanel = new InGameJPanel(this);
    }

    public InGameJPanel getInGameJPanel() {
        return inGameJPanel;
    }

    @Override
    public void run() {

    }

    public static Character getC1() {
        return c1;
    }

    public static void setC1(Character c1) {
        InGameController.c1 = c1;
    }

    public static Character getC2() {
        return c2;
    }

    public static void setC2(Character c2) {
        InGameController.c2 = c2;
    }

    public static Character getM1() {
        return m1;
    }

    public static void setM1(Character m1) {
        InGameController.m1 = m1;
    }

    public static Character getM2() {
        return m2;
    }

    public static void setM2(Character m2) {
        InGameController.m2 = m2;
    }
}
