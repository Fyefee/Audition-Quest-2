package Controllers;

import Model.Character;
import View.InGameButtonJPanel;
import View.InGameJPanel;
import Model.*;
import View.InGameRenderImage;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class InGameController implements Runnable, MouseListener, ActionListener , KeyEventDispatcher {

    private InGameJPanel inGameJPanel;
    private InGameRenderImage inGameRenderImage;
    private InGameButtonJPanel inGameButtonJPanel;
    private AuditionController auditionController;

    private Boolean is_press = true, is_start = false;

    public long start = System.nanoTime(), now;
    private int nano = 1000000000, msp1 = 10000000;

    private Character c1 = new Knight();
    private Character c2 = new Archer();
    private Character m1 = new Slime(1);
    private Character m2 = new Slime(2);

    public Background bg = new Background();

    public int target_count, attack_state = 1; //1 = c1 select
    public String text_button_text = "";
    public boolean text_showattack;
    private int rand;

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
                if (auditionController.getAuditionModel().getAudition_is_timerun()){
                    if (!is_start){
                        start = System.nanoTime();
                        is_start = true;
                    }
                    auditionController.resize_bar((int)((now-start)/ msp1));
                }
                inGameRenderImage.repaint();
                //requestFocusInWindow();
                inGameJPanel.requestFocusInWindow();
            }
        }
    }

    public void end_select() {

        attack_state = 0;
        inGameJPanel.getP1_panel().setBorder(null);
        inGameJPanel.getP2_panel().setBorder(null);
        inGameJPanel.getM1_panel().setBorder(null);
        inGameJPanel.getM2_panel().setBorder(null);

        Collections.sort(auditionController.getAuditionModel().getSpeed(), Comparator.comparing(Model.Character::getSpeed).reversed());

        rand = (int) (Math.random() * 2) + 1;
        if (rand == 1) {
            setAttackText(m1, c1);
        } else {
            setAttackText(m1, c2);
        }

        rand = (int) (Math.random() * 2) + 1;
        if (rand == 1) {
            setAttackText(m2, c1);
        } else {
            setAttackText(m2, c2);
        }

        m1.normalAttack();
        m2.normalAttack();

        setText_Button();
        text_showattack = true;
        inGameButtonJPanel.getCard_select().show(inGameButtonJPanel, "text_button");
    }

    public void setAttackText(Model.Character c, Model.Character target1) {
        c.setAttack_target(new ArrayList<Character>());
        c.getAttack_target().add(target1);
    }

    public void setAttackText(Model.Character c, Model.Character target1, Model.Character target2) {
        c.setAttack_target(new ArrayList<Character>());
        c.getAttack_target().add(target1);
        c.getAttack_target().add(target2);
    }

    public void setAttackText(Model.Character c, Model.Character target1, Model.Character target2, Model.Character target3) {
        c.setAttack_target(new ArrayList<Character>());
        c.getAttack_target().add(target1);
        c.getAttack_target().add(target2);
        c.getAttack_target().add(target3);
    }

    public void setText_Button() {

        text_button_text = "<html><font face='Retron2000'><center>" + auditionController.getAuditionModel().getSpeed().get(auditionController.getAuditionModel().getTurn() - 1).getName() + " ";

        text_button_text += auditionController.getAuditionModel().getSpeed().get(auditionController.getAuditionModel().getTurn() - 1).getAttack_text();

        if (auditionController.getAuditionModel().getSpeed().get(auditionController.getAuditionModel().getTurn() - 1).getAttack_target() != null) {
            for (int i = 0; i < auditionController.getAuditionModel().getSpeed().get(auditionController.getAuditionModel().getTurn() - 1).getAttack_target().size(); i++) {
                text_button_text += auditionController.getAuditionModel().getSpeed().get(auditionController.getAuditionModel().getTurn() - 1).getAttack_target().get(i).getName() + " ";
            }
        }

        text_button_text += "...</html>";
        inGameButtonJPanel.getText_button().setText(text_button_text);
        text_button_text = "";
    }

    public void setText_Button(String text) {
        text_button_text = "<html><font face='Retron2000'><center>" + text + "...";
        inGameButtonJPanel.getText_button().setText(text_button_text);
        text_button_text = "";
    }

    public void endSelectTarget(Character who_attack, Character target){

        if (target_count == 1){
            setAttackText(who_attack, target);
        } else if (target_count == 2 && target.getType().equals("Player")){
            setAttackText(who_attack, target);
        } else if (target_count == 2 && target.getType().equals("Monster")){
            setAttackText(who_attack, m1, m2);
        } else if (target_count == 3){
            setAttackText(who_attack, c2, m1, m2);
        }

        if (who_attack == c1 && c2.isAlive()) {
            attack_state = 2;
            inGameButtonJPanel.getCard_select().show(inGameButtonJPanel, "main_select");
            inGameJPanel.getP2_panel().setBorder(inGameJPanel.getBorder_white());
        } else {
            end_select();
        }
    }

    public void setTabtoSelect(){

        if (c1.isAlive()) {
            auditionController.getAuditionModel().setTurn(1);
            attack_state = 1;
            inGameJPanel.getP1_panel().setBorder(inGameJPanel.getBorder_white());
            inGameButtonJPanel.getCard_select().show(inGameButtonJPanel, "main_select");
            text_showattack = false;
        } else if (c2.isAlive()) {
            auditionController.getAuditionModel().setTurn(1);
            attack_state = 2;
            inGameJPanel.getP2_panel().setBorder(inGameJPanel.getBorder_white());
            inGameButtonJPanel.getCard_select().show(inGameButtonJPanel, "main_select");
            text_showattack = false;
        } else {
            MainJFrameController.getMainJFrame().getC_frame().show(MainJFrameController.getMainJFrame().getAll_card_panel(), "MENU");
        }

        c1.setAttack_target(null);
        c2.setAttack_target(null);

        c1.returnStats();
        c2.returnStats();
        m1.returnStats();
        m2.returnStats();

    }

    public void setTextToSkillButton(Character c){
        inGameButtonJPanel.getSkill1_button().setText("<html><font face='Retron2000'><center>" + c.getSkill1_name() + "</html>");
        inGameButtonJPanel.getSkill1_button().setToolTipText("<html><font face='Retron2000'><center><p style='text-align: left'>" + c.getSkill1_description() + "</p></html>");

        inGameButtonJPanel.getSkill2_button().setText("<html><font face='Retron2000'><center>" + c.getSkill2_name() + "</html>");
        inGameButtonJPanel.getSkill2_button().setToolTipText("<html><font face='Retron2000'><center><p style='text-align: left'>" + c.getSkill2_description() + "</p></html>");

        inGameButtonJPanel.getSkill3_button().setText("<html><font face='Retron2000'><center>" + c.getSkill3_name() + "</html>");
        inGameButtonJPanel.getSkill3_button().setToolTipText("<html><font face='Retron2000'><center><p style='text-align: left'>" + c.getSkill3_description() + "</p></html>");
    }

    public void toSelectTarget(){
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
    }

    public void setDefense(){
        if (attack_state == 1 && c1.getNot_attack_type() == 0) {
            if (c2.isAlive()) {
                attack_state = 2;
                inGameJPanel.getP1_panel().setBorder(null);
                inGameJPanel.getP2_panel().setBorder(inGameJPanel.getBorder_white());
                inGameButtonJPanel.getCard_select().show(inGameButtonJPanel, "main_select");
            }
            else {
                end_select();
                inGameJPanel.getP1_panel().setBorder(null);
            }

        } else if (attack_state == 2 && c2.getNot_attack_type() == 0) {
            end_select();
        }
    }

    public void checkDefenseOrAttack(){
        if (target_count == 0) {
            setDefense();
        } else {
            toSelectTarget();
        }
    }

    public void checkMp(){
        if (attack_state == 1) {
            if (c1.getMp() - c1.getMp_used() < 0) {
                System.out.println("Not enough MP");
            }
            else {
                c1.decreaseMp();
                inGameJPanel.getP1_mp().setText("MP : " + c1.getMp() + "/" + c1.getMax_mp());
                checkDefenseOrAttack();
            }
        } else if (attack_state == 2) {
            if (c2.getMp() - c2.getMp_used() < 0) {
                System.out.println("Not enough MP");
            }
            else {
                c2.decreaseMp();
                inGameJPanel.getP2_mp().setText("MP : " + c2.getMp() + "/" + c2.getMax_mp());
                checkDefenseOrAttack();
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(inGameButtonJPanel.getButton_attack())) {//กดเริ่มเกมใหม่
            toSelectTarget();
            if (attack_state == 1) {
                c1.normalAttack();
            } else if (attack_state == 2) {
                c2.normalAttack();
            }
            target_count = 1;
        } else if (e.getSource().equals(inGameButtonJPanel.getButton_skill())) {
            inGameButtonJPanel.getCard_select().show(inGameButtonJPanel, "skill_select");
            if (attack_state == 1) {
                setTextToSkillButton(c1);
            } else if (attack_state == 2) {
                setTextToSkillButton(c2);
            }
        } else if (e.getSource().equals(inGameButtonJPanel.getButton_defense())) {
            if (attack_state == 1) {
                c1.defense();
            } else if (attack_state == 2) {
                c2.defense();
            }
            setDefense();
        } else if (e.getSource().equals(inGameButtonJPanel.getSkill1_button())){
            if (attack_state == 1) {
                c1.skill1();
                target_count = c1.getTarget_count();
            } else if (attack_state == 2) {
                c2.skill1();
                target_count = c2.getTarget_count();
            }
            checkMp();
        } else if (e.getSource().equals(inGameButtonJPanel.getSkill2_button())){
            if (attack_state == 1) {
                c1.skill2();
                target_count = c1.getTarget_count();
            } else if (attack_state == 2) {
                c2.skill2();
                target_count = c2.getTarget_count();
            }
            checkMp();
        } else if (e.getSource().equals(inGameButtonJPanel.getSkill3_button())){
            if (attack_state == 1) {
                c1.skill3();
                target_count = c1.getTarget_count();
            } else if (attack_state == 2) {
                c2.skill3();
                target_count = c2.getTarget_count();
            }
            checkMp();
        } else if (e.getSource().equals(inGameButtonJPanel.getBack_button()) || e.getSource().equals(inGameButtonJPanel.getSkill_back_button())) {
            inGameButtonJPanel.getCard_select().show(inGameButtonJPanel, "main_select");
            if (attack_state == 1) {
                inGameJPanel.getP1_panel().setBorder(inGameButtonJPanel.getBorder_white());
            } else if (attack_state == 2) {
                inGameJPanel.getP2_panel().setBorder(inGameButtonJPanel.getBorder_white());
            }
        } else if (e.getSource().equals(inGameButtonJPanel.getText_button())) {
            if (auditionController.getAuditionModel().getTurn() > auditionController.getAuditionModel().getSpeed().size()){
                setTabtoSelect();
            }
            if (text_showattack){
                if (auditionController.getAuditionModel().getSpeed().get(auditionController.getAuditionModel().getTurn() - 1).isAlive()) {
                    try {
                        inGameButtonJPanel.getCard_select().show(inGameButtonJPanel, "empty");
                        text_showattack = false;
                        auditionController.checkAttack(auditionController.getAuditionModel().getSpeed().get(auditionController.getAuditionModel().getTurn() - 1));
                    } catch (IndexOutOfBoundsException ex){
                        setTabtoSelect();
                    }
                } else{
                    auditionController.getAuditionModel().setTurn(auditionController.getAuditionModel().getTurn() + 1);
                    setText_Button();
                }
            }
            else{
                text_showattack = true;
                try {
                    setText_Button();
                } catch (IndexOutOfBoundsException ex){
                    System.out.println("Game Over");
                }
            }
        } else if (e.getSource().equals(inGameButtonJPanel.getC_target_button())){
            if (attack_state == 1  && c2.isAlive()) {
                endSelectTarget(c1, c2);
            } else if (attack_state == 2  && c1.isAlive()) {
                endSelectTarget(c2, c1);
            }
        } else if (e.getSource().equals(inGameButtonJPanel.getM1_target_button())){
            if (attack_state == 1  && m1.isAlive()) {
                endSelectTarget(c1, m1);
            } else if (attack_state == 2  && c1.isAlive()) {
                endSelectTarget(c2, m1);
            }
        } else if (e.getSource().equals(inGameButtonJPanel.getM2_target_button())){
            if (attack_state == 1  && m2.isAlive()) {
                endSelectTarget(c1, m2);
            } else if (attack_state == 2  && c2.isAlive()) {
                endSelectTarget(c2, m2);
            }
        }
        System.out.println(auditionController.getAuditionModel().getTurn());
        System.out.println(text_showattack);
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
        if (e.getSource().equals(inGameButtonJPanel.getC_target_button()) && (target_count == 1 || target_count == 2) && attack_state == 1) {
            inGameJPanel.getP2_panel().setBorder(inGameButtonJPanel.getBorder_red());
        } else if (e.getSource().equals(inGameButtonJPanel.getC_target_button()) && (target_count == 1 || target_count == 2) && attack_state == 2) {
            inGameJPanel.getP1_panel().setBorder(inGameButtonJPanel.getBorder_red());
        } else if (e.getSource().equals(inGameButtonJPanel.getC_target_button()) && target_count == 3 && attack_state == 1) {
            inGameJPanel.getP2_panel().setBorder(inGameButtonJPanel.getBorder_red());
            inGameJPanel.getM1_panel().setBorder(inGameButtonJPanel.getBorder_red());
            inGameJPanel.getM2_panel().setBorder(inGameButtonJPanel.getBorder_red());
        } else if (e.getSource().equals(inGameButtonJPanel.getC_target_button()) && target_count == 3 && attack_state == 2) {
            inGameJPanel.getP1_panel().setBorder(inGameButtonJPanel.getBorder_red());
            inGameJPanel.getM1_panel().setBorder(inGameButtonJPanel.getBorder_red());
            inGameJPanel.getM2_panel().setBorder(inGameButtonJPanel.getBorder_red());
        } else if (e.getSource().equals(inGameButtonJPanel.getM1_target_button()) && target_count == 1) {
            inGameJPanel.getM1_panel().setBorder(inGameButtonJPanel.getBorder_red());
        } else if (e.getSource().equals(inGameButtonJPanel.getM1_target_button()) && target_count == 2) {
            inGameJPanel.getM1_panel().setBorder(inGameButtonJPanel.getBorder_red());
            inGameJPanel.getM2_panel().setBorder(inGameButtonJPanel.getBorder_red());
        } else if (e.getSource().equals(inGameButtonJPanel.getM1_target_button()) && target_count == 3 && attack_state == 1) {
            inGameJPanel.getP2_panel().setBorder(inGameButtonJPanel.getBorder_red());
            inGameJPanel.getM1_panel().setBorder(inGameButtonJPanel.getBorder_red());
            inGameJPanel.getM2_panel().setBorder(inGameButtonJPanel.getBorder_red());
        } else if (e.getSource().equals(inGameButtonJPanel.getM1_target_button()) && target_count == 3 && attack_state == 2) {
            inGameJPanel.getP1_panel().setBorder(inGameButtonJPanel.getBorder_red());
            inGameJPanel.getM1_panel().setBorder(inGameButtonJPanel.getBorder_red());
            inGameJPanel.getM2_panel().setBorder(inGameButtonJPanel.getBorder_red());
        } else if (e.getSource().equals(inGameButtonJPanel.getM2_target_button()) && target_count == 1) {
            inGameJPanel.getM2_panel().setBorder(inGameButtonJPanel.getBorder_red());
        } else if (e.getSource().equals(inGameButtonJPanel.getM2_target_button()) && target_count == 2) {
            inGameJPanel.getM1_panel().setBorder(inGameButtonJPanel.getBorder_red());
            inGameJPanel.getM2_panel().setBorder(inGameButtonJPanel.getBorder_red());
        } else if (e.getSource().equals(inGameButtonJPanel.getM2_target_button()) && target_count == 3 && attack_state == 1) {
            inGameJPanel.getP2_panel().setBorder(inGameButtonJPanel.getBorder_red());
            inGameJPanel.getM1_panel().setBorder(inGameButtonJPanel.getBorder_red());
            inGameJPanel.getM2_panel().setBorder(inGameButtonJPanel.getBorder_red());
        } else if (e.getSource().equals(inGameButtonJPanel.getM2_target_button()) && target_count == 3 && attack_state == 2) {
            inGameJPanel.getP1_panel().setBorder(inGameButtonJPanel.getBorder_red());
            inGameJPanel.getM1_panel().setBorder(inGameButtonJPanel.getBorder_red());
            inGameJPanel.getM2_panel().setBorder(inGameButtonJPanel.getBorder_red());
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource().equals(inGameButtonJPanel.getC_target_button()) && (target_count == 1 || target_count == 2) && attack_state == 1) {
            inGameJPanel.getP2_panel().setBorder(null);
        } else if (e.getSource().equals(inGameButtonJPanel.getC_target_button()) && (target_count == 1 || target_count == 2) && attack_state == 2) {
            inGameJPanel.getP1_panel().setBorder(null);
        } else if (e.getSource().equals(inGameButtonJPanel.getC_target_button()) && target_count == 3 && attack_state == 1) {
            inGameJPanel.getP2_panel().setBorder(null);
            inGameJPanel.getM1_panel().setBorder(null);
            inGameJPanel.getM2_panel().setBorder(null);
        } else if (e.getSource().equals(inGameButtonJPanel.getC_target_button()) && target_count == 3 && attack_state == 2) {
            inGameJPanel.getP1_panel().setBorder(null);
            inGameJPanel.getM1_panel().setBorder(null);
            inGameJPanel.getM2_panel().setBorder(null);
        } else if (e.getSource().equals(inGameButtonJPanel.getM1_target_button()) && target_count == 1) {
            inGameJPanel.getM1_panel().setBorder(null);
        } else if (e.getSource().equals(inGameButtonJPanel.getM1_target_button()) && target_count == 2) {
            inGameJPanel.getM1_panel().setBorder(null);
            inGameJPanel.getM2_panel().setBorder(null);
        } else if (e.getSource().equals(inGameButtonJPanel.getM1_target_button()) && target_count == 3 && attack_state == 1) {
            inGameJPanel.getP2_panel().setBorder(null);
            inGameJPanel.getM1_panel().setBorder(null);
            inGameJPanel.getM2_panel().setBorder(null);
        } else if (e.getSource().equals(inGameButtonJPanel.getM1_target_button()) && target_count == 3 && attack_state == 2) {
            inGameJPanel.getP1_panel().setBorder(null);
            inGameJPanel.getM1_panel().setBorder(null);
            inGameJPanel.getM2_panel().setBorder(null);
        } else if (e.getSource().equals(inGameButtonJPanel.getM2_target_button()) && target_count == 1) {
            inGameJPanel.getM2_panel().setBorder(null);
        } else if (e.getSource().equals(inGameButtonJPanel.getM2_target_button()) && target_count == 2) {
            inGameJPanel.getM1_panel().setBorder(null);
            inGameJPanel.getM2_panel().setBorder(null);
        } else if (e.getSource().equals(inGameButtonJPanel.getM2_target_button()) && target_count == 3 && attack_state == 1) {
            inGameJPanel.getP2_panel().setBorder(null);
            inGameJPanel.getM1_panel().setBorder(null);
            inGameJPanel.getM2_panel().setBorder(null);
        } else if (e.getSource().equals(inGameButtonJPanel.getM2_target_button()) && target_count == 3 && attack_state == 2) {
            inGameJPanel.getP1_panel().setBorder(null);
            inGameJPanel.getM1_panel().setBorder(null);
            inGameJPanel.getM2_panel().setBorder(null);
        }
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent e) {
        if (e.getID() == KeyEvent.KEY_PRESSED) {
            if (e.getKeyCode() == KeyEvent.VK_UP && is_press) {
                if (auditionController.getAuditionModel().getAudition_is_timerun())
                auditionController.check_audition_key(1);
                is_press = false;
            } else if (e.getKeyCode() == KeyEvent.VK_DOWN && is_press) {
                if (auditionController.getAuditionModel().getAudition_is_timerun())
                auditionController.check_audition_key(2);
                is_press = false;
            } else if (e.getKeyCode() == KeyEvent.VK_LEFT && is_press) {
                if (auditionController.getAuditionModel().getAudition_is_timerun())
                auditionController.check_audition_key(3);
                is_press = false;
            } else if (e.getKeyCode() == KeyEvent.VK_RIGHT && is_press) {
                if (auditionController.getAuditionModel().getAudition_is_timerun())
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

    public boolean isText_showattack() {
        return text_showattack;
    }

    public void setText_showattack(boolean text_showattack) {
        this.text_showattack = text_showattack;
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public Boolean getIs_start() {
        return is_start;
    }

    public void setIs_start(Boolean is_start) {
        this.is_start = is_start;
    }
}
