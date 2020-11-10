package Controllers;

import Model.Character;
import View.InGameButtonJPanel;
import View.InGameJPanel;
import Model.*;
import View.InGameRenderImage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Collections;
import java.util.Comparator;

public class InGameController implements Runnable, MouseListener, ActionListener {

    private InGameJPanel inGameJPanel;
    private InGameRenderImage inGameRenderImage;
    private InGameButtonJPanel inGameButtonJPanel;
    private AuditionController auditionController;

    private Thread th;
    private boolean running = false;

    private int nano = 1000000000, msp1 = 10000000;
    public static long start = System.nanoTime(), now;

    private static Character c1 = new Knight();
    private static Character c2 = new Archer();
    private static Character m1 = new Slime(1);
    private static Character m2 = new Slime(2);

    public Background bg = new Background();

    public static int target, attack_state = 1; //1 = c1 select
    public static String attackText, text_button_text = "";
    public static boolean text_showattack;

    public InGameController(){
        this.inGameJPanel = new InGameJPanel(this);
        this.inGameRenderImage = new InGameRenderImage(this);
        this.inGameButtonJPanel = new InGameButtonJPanel(this);
        this.auditionController = new AuditionController();
        inGameJPanel.getTop_panel().add(inGameRenderImage);
        inGameJPanel.getBottom_panel().add(inGameButtonJPanel);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(inGameButtonJPanel.getButton_attack())) {//กดเริ่มเกมใหม่
            inGameButtonJPanel.getCard_select().show(inGameButtonJPanel, "target_select");
            if (attack_state == 1) {
                inGameButtonJPanel.getC_target_button().setText(c2.getName());
            } else if (attack_state == 2) {
                inGameButtonJPanel.getC_target_button().setText(c1.getName());
            }
            inGameButtonJPanel.getM1_target_button().setText(m1.getName());
            inGameButtonJPanel.getM2_target_button().setText(m2.getName());
            inGameJPanel.getP1_panel().setBorder(null);
            inGameJPanel.getP2_panel().setBorder(null);
            target = 1;
            attackText = "attack";
        } else if (e.getSource().equals(inGameButtonJPanel.getBack_button())) {
            inGameButtonJPanel.getCard_select().show(inGameButtonJPanel, "main_select");
            if (attack_state == 1) {
                inGameJPanel.getP1_panel().setBorder(inGameButtonJPanel.getBorder_white());
            } else if (attack_state == 2) {
                inGameJPanel.getP2_panel().setBorder(inGameButtonJPanel.getBorder_white());
            }
        } else if (e.getSource().equals(inGameButtonJPanel.getC_target_button())){
            Collections.sort(AuditionController.getSpeed(), Comparator.comparing(Model.Character::getSpeed).reversed());
            AuditionController.addX(0, AuditionController.getRandom(), 0);
        } else if (e.getSource().equals(inGameButtonJPanel.getM1_target_button())){
            AuditionController.setRandom(null);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource().equals(inGameButtonJPanel.getC_target_button()) && (target == 1 || target == 2) && attack_state == 1) {
            inGameJPanel.getP2_panel().setBorder(inGameButtonJPanel.getBorder_red());
        } else if (e.getSource().equals(inGameButtonJPanel.getC_target_button()) && (target == 1 || target == 2) && attack_state == 2) {
            inGameJPanel.getP1_panel().setBorder(inGameButtonJPanel.getBorder_red());
        } else if (e.getSource().equals(inGameButtonJPanel.getC_target_button()) && target == 3 && attack_state == 1) {
            inGameJPanel.getP2_panel().setBorder(inGameButtonJPanel.getBorder_red());
            inGameJPanel.getM1_panel().setBorder(inGameButtonJPanel.getBorder_red());
            inGameJPanel.getM2_panel().setBorder(inGameButtonJPanel.getBorder_red());
        } else if (e.getSource().equals(inGameButtonJPanel.getC_target_button()) && target == 3 && attack_state == 2) {
            inGameJPanel.getP1_panel().setBorder(inGameButtonJPanel.getBorder_red());
            inGameJPanel.getM1_panel().setBorder(inGameButtonJPanel.getBorder_red());
            inGameJPanel.getM2_panel().setBorder(inGameButtonJPanel.getBorder_red());
        } else if (e.getSource().equals(inGameButtonJPanel.getM1_target_button()) && target == 1) {
            inGameJPanel.getM1_panel().setBorder(inGameButtonJPanel.getBorder_red());
        } else if (e.getSource().equals(inGameButtonJPanel.getM1_target_button()) && target == 2) {
            inGameJPanel.getM1_panel().setBorder(inGameButtonJPanel.getBorder_red());
            inGameJPanel.getM2_panel().setBorder(inGameButtonJPanel.getBorder_red());
        } else if (e.getSource().equals(inGameButtonJPanel.getM1_target_button()) && target == 3 && attack_state == 1) {
            inGameJPanel.getP2_panel().setBorder(inGameButtonJPanel.getBorder_red());
            inGameJPanel.getM1_panel().setBorder(inGameButtonJPanel.getBorder_red());
            inGameJPanel.getM2_panel().setBorder(inGameButtonJPanel.getBorder_red());
        } else if (e.getSource().equals(inGameButtonJPanel.getM1_target_button()) && target == 3 && attack_state == 2) {
            inGameJPanel.getP1_panel().setBorder(inGameButtonJPanel.getBorder_red());
            inGameJPanel.getM1_panel().setBorder(inGameButtonJPanel.getBorder_red());
            inGameJPanel.getM2_panel().setBorder(inGameButtonJPanel.getBorder_red());
        } else if (e.getSource().equals(inGameButtonJPanel.getM2_target_button()) && target == 1) {
            inGameJPanel.getM2_panel().setBorder(inGameButtonJPanel.getBorder_red());
        } else if (e.getSource().equals(inGameButtonJPanel.getM2_target_button()) && target == 2) {
            inGameJPanel.getM1_panel().setBorder(inGameButtonJPanel.getBorder_red());
            inGameJPanel.getM2_panel().setBorder(inGameButtonJPanel.getBorder_red());
        } else if (e.getSource().equals(inGameButtonJPanel.getM2_target_button()) && target == 3 && attack_state == 1) {
            inGameJPanel.getP2_panel().setBorder(inGameButtonJPanel.getBorder_red());
            inGameJPanel.getM1_panel().setBorder(inGameButtonJPanel.getBorder_red());
            inGameJPanel.getM2_panel().setBorder(inGameButtonJPanel.getBorder_red());
        } else if (e.getSource().equals(inGameButtonJPanel.getM2_target_button()) && target == 3 && attack_state == 2) {
            inGameJPanel.getP1_panel().setBorder(inGameButtonJPanel.getBorder_red());
            inGameJPanel.getM1_panel().setBorder(inGameButtonJPanel.getBorder_red());
            inGameJPanel.getM2_panel().setBorder(inGameButtonJPanel.getBorder_red());
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource().equals(inGameButtonJPanel.getC_target_button()) && (target == 1 || target == 2) && attack_state == 1) {
            inGameJPanel.getP2_panel().setBorder(null);
        } else if (e.getSource().equals(inGameButtonJPanel.getC_target_button()) && (target == 1 || target == 2) && attack_state == 2) {
            inGameJPanel.getP1_panel().setBorder(null);
        } else if (e.getSource().equals(inGameButtonJPanel.getC_target_button()) && target == 3 && attack_state == 1) {
            inGameJPanel.getP2_panel().setBorder(null);
            inGameJPanel.getM1_panel().setBorder(null);
            inGameJPanel.getM2_panel().setBorder(null);
        } else if (e.getSource().equals(inGameButtonJPanel.getC_target_button()) && target == 3 && attack_state == 2) {
            inGameJPanel.getP1_panel().setBorder(null);
            inGameJPanel.getM1_panel().setBorder(null);
            inGameJPanel.getM2_panel().setBorder(null);
        } else if (e.getSource().equals(inGameButtonJPanel.getM1_target_button()) && target == 1) {
            inGameJPanel.getM1_panel().setBorder(null);
        } else if (e.getSource().equals(inGameButtonJPanel.getM1_target_button()) && target == 2) {
            inGameJPanel.getM1_panel().setBorder(null);
            inGameJPanel.getM2_panel().setBorder(null);
        } else if (e.getSource().equals(inGameButtonJPanel.getM1_target_button()) && target == 3 && attack_state == 1) {
            inGameJPanel.getP2_panel().setBorder(null);
            inGameJPanel.getM1_panel().setBorder(null);
            inGameJPanel.getM2_panel().setBorder(null);
        } else if (e.getSource().equals(inGameButtonJPanel.getM1_target_button()) && target == 3 && attack_state == 2) {
            inGameJPanel.getP1_panel().setBorder(null);
            inGameJPanel.getM1_panel().setBorder(null);
            inGameJPanel.getM2_panel().setBorder(null);
        } else if (e.getSource().equals(inGameButtonJPanel.getM2_target_button()) && target == 1) {
            inGameJPanel.getM2_panel().setBorder(null);
        } else if (e.getSource().equals(inGameButtonJPanel.getM2_target_button()) && target == 2) {
            inGameJPanel.getM1_panel().setBorder(null);
            inGameJPanel.getM2_panel().setBorder(null);
        } else if (e.getSource().equals(inGameButtonJPanel.getM2_target_button()) && target == 3 && attack_state == 1) {
            inGameJPanel.getP2_panel().setBorder(null);
            inGameJPanel.getM1_panel().setBorder(null);
            inGameJPanel.getM2_panel().setBorder(null);
        } else if (e.getSource().equals(inGameButtonJPanel.getM2_target_button()) && target == 3 && attack_state == 2) {
            inGameJPanel.getP1_panel().setBorder(null);
            inGameJPanel.getM1_panel().setBorder(null);
            inGameJPanel.getM2_panel().setBorder(null);
        }
    }

    public Background getBg() {
        return bg;
    }

    public void setBg(Background bg) {
        this.bg = bg;
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

    public void setM2(Character m2) {
        this.m2 = m2;
    }
}
