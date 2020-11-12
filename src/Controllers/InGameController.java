package Controllers;

import Model.Character;
import View.InGameButtonJPanel;
import View.InGameJPanel;
import Model.*;
import View.InGameRenderImage;

import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class InGameController implements Runnable, MouseListener, ActionListener , KeyEventDispatcher {

    private InGameJPanel inGameJPanel;
    private InGameRenderImage inGameRenderImage;
    private InGameButtonJPanel inGameButtonJPanel;
    private AuditionController auditionController;

    private Boolean is_press = true;

    public long start = System.nanoTime(), now;
    private int nano = 1000000000, msp1 = 10000000;

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
        this.auditionController = new AuditionController(this);
        inGameJPanel.getTop_panel().add(inGameRenderImage);
        inGameJPanel.getBottom_panel().add(inGameButtonJPanel);
    }

    public InGameJPanel getInGameJPanel() {
        return inGameJPanel;
    }

    @Override
    public void run() {
        while (true) {
            if((System.nanoTime() - start) % msp1 == 0){
                now = System.nanoTime();
                if (auditionController.getAudition_is_timerun()){
                    auditionController.resize_bar((int)((now-start)/ msp1));
                }
                inGameRenderImage.repaint();
                //requestFocusInWindow();
                inGameJPanel.requestFocusInWindow();
            }
        }
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
            Collections.sort(auditionController.getSpeed(), Comparator.comparing(Model.Character::getSpeed).reversed());
            AuditionController.addX(0, AuditionController.getRandom(), 0);
        } else if (e.getSource().equals(inGameButtonJPanel.getM1_target_button())){
            auditionController.start_audition(10, 400);
            inGameRenderImage.setAudition(auditionController.getAudition());
            start = System.nanoTime();
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

    @Override
    public boolean dispatchKeyEvent(KeyEvent e) {
        if (e.getID() == KeyEvent.KEY_PRESSED) {
            if (e.getKeyCode() == KeyEvent.VK_UP && is_press) {
                auditionController.check_audition_key(1);
                is_press = false;
            } else if (e.getKeyCode() == KeyEvent.VK_DOWN && is_press) {
                auditionController.check_audition_key(2);
                is_press = false;
            } else if (e.getKeyCode() == KeyEvent.VK_LEFT && is_press) {
                auditionController.check_audition_key(3);
                is_press = false;
            } else if (e.getKeyCode() == KeyEvent.VK_RIGHT && is_press) {
                auditionController.check_audition_key(4);
                is_press = false;
            }
        } else if (e.getID() == KeyEvent.KEY_RELEASED) {
            int keyCode = e.getKeyCode();
            switch( keyCode ) {
                case KeyEvent.VK_UP:
                case KeyEvent.VK_DOWN:
                case KeyEvent.VK_LEFT:
                case KeyEvent.VK_RIGHT :
                    is_press = true;
                    break;
                default: break;
            }
        } else if (e.getID() == KeyEvent.KEY_TYPED) {
            System.out.println("3test3");
        }
        return false;
    }

    public void setInGameJPanel(InGameJPanel inGameJPanel) {
        this.inGameJPanel = inGameJPanel;
    }

    public InGameButtonJPanel getInGameButtonJPanel() {
        return inGameButtonJPanel;
    }

    public void setInGameButtonJPanel(InGameButtonJPanel inGameButtonJPanel) {
        this.inGameButtonJPanel = inGameButtonJPanel;
    }

    public AuditionController getAuditionController() {
        return auditionController;
    }

    public void setAuditionController(AuditionController auditionController) {
        this.auditionController = auditionController;
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

    public InGameRenderImage getInGameRenderImage() {
        return inGameRenderImage;
    }

    public void setInGameRenderImage(InGameRenderImage inGameRenderImage) {
        this.inGameRenderImage = inGameRenderImage;
    }

    public int getNano() {
        return nano;
    }

    public void setNano(int nano) {
        this.nano = nano;
    }

    public int getMsp1() {
        return msp1;
    }

    public void setMsp1(int msp1) {
        this.msp1 = msp1;
    }
}
