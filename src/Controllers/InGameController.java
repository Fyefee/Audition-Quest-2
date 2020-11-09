package Controllers;

import Model.Character;
import View.InGameJPanel;
import Model.*;
import View.InGameRenderImage;

public class InGameController implements Runnable{

    private InGameJPanel inGameJPanel;
    private InGameRenderImage inGameRenderImage;

    private Thread th;
    private boolean running = false;

    private int nano = 1000000000, msp1 = 10000000;
    public static long start = System.nanoTime(), now;

    private Character c1 = new Knight();
    private Character c2 = new Archer();
    private Character m1 = new Slime(1);
    private Character m2 = new Slime(2);

    public Background bg = new Background();

    public InGameController(){
        this.inGameJPanel = new InGameJPanel(this);
        this.inGameRenderImage = new InGameRenderImage(this);
        inGameJPanel.getTop_panel().add(inGameRenderImage);
    }

    public InGameJPanel getInGameJPanel() {
        return inGameJPanel;
    }

    public synchronized void start(){
        th = new Thread(this);
        th.start();
        running = true;
    }

    public synchronized void stop(){
        try{
            running = false;
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (running) {
            if((System.nanoTime() - start) % msp1 == 0){
                inGameRenderImage.repaint();
                //requestFocusInWindow();
            }
        }
        stop();
    }

    public Background getBg() {
        return bg;
    }

    public void setBg(Background bg) {
        this.bg = bg;
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
}
