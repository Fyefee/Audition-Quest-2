package Controllers;

import Model.Background.Background;
import Model.Character.Character;
import Model.Character.Monster.Slime;
import Model.Character.Player.Archer;
import Model.Character.Player.Knight;
import Model.InGameModel;
import Model.Item.ItemModel;
import View.*;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.Timer;

public class InGameController implements Runnable, MouseListener, ActionListener , KeyEventDispatcher {

    private InGameJPanel inGameJPanel;
    private InGameRenderImage inGameRenderImage;
    private InGameButtonJPanel inGameButtonJPanel;
    private AuditionController auditionController;
    private ItemModel itemModel;
    private InGameModel inGameModel;
    private StageJPanel stageJPanel;

    public InGameController(){
        this.inGameModel = new InGameModel();
        this.stageJPanel = new StageJPanel();
        this.inGameJPanel = new InGameJPanel(this);
        this.inGameRenderImage = new InGameRenderImage(this);
        this.inGameButtonJPanel = new InGameButtonJPanel(this);
        this.auditionController = new AuditionController(this);

        this.itemModel = new ItemModel();

        inGameJPanel.getTop_panel().add(inGameRenderImage);
        inGameJPanel.getBottom_panel().add(inGameButtonJPanel);

        setComponents();
    }

    public void setComponents(){

        stageJPanel.getNext_stage_button().addActionListener(this);

    }

    public void addItem(){
        if (inGameModel.getDifficulty().equals("Easy")){
            this.itemModel.addItemsToArrayEasy();
        } else if (inGameModel.getDifficulty().equals("Medium")){
            this.itemModel.addItemsToArrayMedium();
        } else if (inGameModel.getDifficulty().equals("Hard")){
            this.itemModel.addItemsToArrayHard();
        }
    }

    public InGameJPanel getInGameJPanel() {
        return inGameJPanel;
    }

    @Override
    public void run() {
        while (true) {
            if((System.nanoTime() - inGameModel.getStart()) % 10000000 == 0){
                inGameModel.setNow(System.nanoTime());
                if (auditionController.getAuditionModel().getAudition_is_timerun()){
                    if (!inGameModel.getIs_start()){
                        inGameModel.setStart(System.nanoTime());
                        inGameModel.setIs_start(true);
                    }
                    auditionController.resize_bar((int)((inGameModel.getNow()-inGameModel.getStart())/ inGameModel.getMsp1()));
                }
                inGameRenderImage.repaint();
                inGameJPanel.requestFocusInWindow();
            }
        }
    }

    public void end_select() {

        inGameModel.setAttack_state(0);
        inGameJPanel.getP1_panel().setBorder(null);
        inGameJPanel.getP2_panel().setBorder(null);
        inGameJPanel.getM1_panel().setBorder(null);
        inGameJPanel.getM2_panel().setBorder(null);

        if (inGameModel.getM1().isAlive()){
            setMonsterTurn(inGameModel.getM1());
        }
        if (inGameModel.getM2().isAlive()){
            setMonsterTurn(inGameModel.getM2());
        }

        auditionController.getAuditionModel().getSpeed().clear();
        auditionController.getAuditionModel().getSpeed().add(inGameModel.getC1());
        auditionController.getAuditionModel().getSpeed().add(inGameModel.getC2());
        auditionController.getAuditionModel().getSpeed().add(inGameModel.getM1());
        auditionController.getAuditionModel().getSpeed().add(inGameModel.getM2());
        Collections.sort(auditionController.getAuditionModel().getSpeed(), Comparator.comparing(Character::getSpeed).reversed());

        inGameModel.getC1().decreaseMp();
        inGameModel.getC2().decreaseMp();
        inGameJPanel.refreshLabelWOSpeed(inGameModel);

        setText_Button();
        inGameModel.setText_showattack(true);
        inGameButtonJPanel.getCard_select().show(inGameButtonJPanel, "text_button");
    }

    public ArrayList<Character> createArrayTarget(Character target1) {
        ArrayList<Character> target = new ArrayList<Character>();
        target.add(target1);
        return target;
    }

    public ArrayList<Character> createArrayTarget(Character target1, Character target2) {
        ArrayList<Character> target = new ArrayList<Character>();
        target.add(target1);
        target.add(target2);
        return target;
    }

    public ArrayList<Character> createArrayTarget(Character target1, Character target2, Character target3) {
        ArrayList<Character> target = new ArrayList<Character>();
        target.add(target1);
        target.add(target2);
        target.add(target3);
        return target;
    }

    public void setMonsterTurn(Character c){
        int rand = (int) (Math.random() * 3);
        if (rand == 0){
            c.normalAttack();
        } else if (rand == 1){
            c.skill1();
        } else if (rand >= 2){
            c.skill2();
        }
        int target_count = c.getTarget_count();
        if (target_count == 1){
            rand = (int) (Math.random() * 2) + 1;
            if (rand == 1){
                if (inGameModel.getC1().isAlive()) {
                    c.setAttack_target(createArrayTarget(inGameModel.getC1()));
                } else {
                    c.setAttack_target(createArrayTarget(inGameModel.getC2()));
                }
            } else if (rand == 2){
                if (inGameModel.getC2().isAlive()) {
                    c.setAttack_target(createArrayTarget(inGameModel.getC2()));
                } else {
                    c.setAttack_target(createArrayTarget(inGameModel.getC1()));
                }
            }
        } else if (target_count == 2){
            c.setAttack_target(createArrayTarget(inGameModel.getC1(), inGameModel.getC2()));
        }
    }

    public void setText_Button() {

        String text_button_text = "";

        text_button_text = "<html><font face='Retron2000'><center>" + auditionController.getAuditionModel().getSpeed().get(auditionController.getAuditionModel().getTurn() - 1).getName() + " ";

        text_button_text += auditionController.getAuditionModel().getSpeed().get(auditionController.getAuditionModel().getTurn() - 1).getAttack_text();

        if (auditionController.getAuditionModel().getSpeed().get(auditionController.getAuditionModel().getTurn() - 1).getAttack_target() != null) {
            for (int i = 0; i < auditionController.getAuditionModel().getSpeed().get(auditionController.getAuditionModel().getTurn() - 1).getAttack_target().size(); i++) {
                text_button_text += auditionController.getAuditionModel().getSpeed().get(auditionController.getAuditionModel().getTurn() - 1).getAttack_target().get(i).getName() + " ";
            }
        }

        text_button_text += "...</html>";
        inGameButtonJPanel.getText_button().setText(text_button_text);
        //text_button_text = "";
    }

    public void setText_Button(String text) {
        String text_button_text = "";
        text_button_text = "<html><font face='Retron2000'><center>" + text + "...";
        inGameButtonJPanel.getText_button().setText(text_button_text);
    }

    public void endSelectTarget(Character who_attack, Character target){

        if (inGameModel.getTarget_count() == 1){
            who_attack.setAttack_target(createArrayTarget(target));
        } else if (inGameModel.getTarget_count() == 2 && target.getType().equals("Player")){
            who_attack.setAttack_target(createArrayTarget(target));
        } else if (inGameModel.getTarget_count() == 2 && target.getType().equals("Monster")){
            who_attack.setAttack_target(createArrayTarget(inGameModel.getM1(), inGameModel.getM2()));
        } else if (inGameModel.getTarget_count() == 3){
            who_attack.setAttack_target(createArrayTarget(target, inGameModel.getM1(), inGameModel.getM2()));
        }

        if (who_attack == inGameModel.getC1() && inGameModel.getC2().isAlive()) {
            inGameModel.setAttack_state(2);
            inGameButtonJPanel.getCard_select().show(inGameButtonJPanel, "main_select");
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    inGameJPanel.getP2_panel().setBorder(inGameJPanel.getBorder_white());
                }
            }, 200);

        } else {
            end_select();
        }
    }

    public void setTabtoSelect(){

        if (inGameModel.getC1().isAlive()) {
            auditionController.getAuditionModel().setTurn(1);
            inGameModel.setAttack_state(1);
            inGameJPanel.getP1_panel().setBorder(inGameJPanel.getBorder_white());
            inGameButtonJPanel.getCard_select().show(inGameButtonJPanel, "main_select");
            inGameModel.setText_showattack(false);
        } else if (inGameModel.getC2().isAlive()) {
            auditionController.getAuditionModel().setTurn(1);
            inGameModel.setAttack_state(2);
            inGameJPanel.getP2_panel().setBorder(inGameJPanel.getBorder_white());
            inGameButtonJPanel.getCard_select().show(inGameButtonJPanel, "main_select");
            inGameModel.setText_showattack(false);
        }

        if (!inGameModel.getM1().isAlive() && !inGameModel.getM2().isAlive()){
            setText_Button("All monsters are dead");
            inGameButtonJPanel.getCard_select().show(inGameButtonJPanel, "text_button");
            inGameModel.setAll_monster_dead(true);
            inGameJPanel.getP1_panel().setBorder(null);
        }

        inGameModel.getC1().returnStats();
        inGameModel.getC2().returnStats();
        inGameModel.getM1().returnStats();
        inGameModel.getM2().returnStats();

    }

    public void setBorderColor(MouseEvent e, Border border){
        if (border == null && (e.getSource().equals(inGameButtonJPanel.getC_target_button()) || e.getSource().equals(inGameButtonJPanel.getM1_target_button()) || e.getSource().equals(inGameButtonJPanel.getM2_target_button()))){
            inGameJPanel.getP1_panel().setBorder(null);
            inGameJPanel.getP2_panel().setBorder(null);
            inGameJPanel.getM1_panel().setBorder(null);
            inGameJPanel.getM2_panel().setBorder(null);
        }
        else if (e.getSource().equals(inGameButtonJPanel.getC_target_button()) && (inGameModel.getTarget_count() == 1 || inGameModel.getTarget_count() == 2) && inGameModel.getAttack_state() == 1) {
            if (border.equals(inGameButtonJPanel.getBorder_red()) || (border.equals(inGameButtonJPanel.getBorder_green())) && inGameModel.getTarget_count() == 1) {
                inGameJPanel.getP2_panel().setBorder(border);
            } else if (border.equals(inGameButtonJPanel.getBorder_green()) && inGameModel.getTarget_count() == 2) {
                inGameJPanel.getP1_panel().setBorder(border);
                inGameJPanel.getP2_panel().setBorder(border);
            }
        } else if (e.getSource().equals(inGameButtonJPanel.getC_target_button()) && (inGameModel.getTarget_count() == 1 || inGameModel.getTarget_count() == 2) && inGameModel.getAttack_state() == 2) {
            if (border == null || border.equals(inGameButtonJPanel.getBorder_red()) || (border.equals(inGameButtonJPanel.getBorder_green())) && inGameModel.getTarget_count() == 1) {
                inGameJPanel.getP1_panel().setBorder(border);
            } else if (border.equals(inGameButtonJPanel.getBorder_green()) && inGameModel.getTarget_count() == 2) {
                inGameJPanel.getP1_panel().setBorder(border);
                inGameJPanel.getP2_panel().setBorder(border);
            }
        } else if (e.getSource().equals(inGameButtonJPanel.getC_target_button()) && inGameModel.getTarget_count() == 3 && inGameModel.getAttack_state() == 1) {
            inGameJPanel.getP2_panel().setBorder(border);
            inGameJPanel.getM1_panel().setBorder(border);
            inGameJPanel.getM2_panel().setBorder(border);
        } else if (e.getSource().equals(inGameButtonJPanel.getC_target_button()) && inGameModel.getTarget_count() == 3 && inGameModel.getAttack_state() == 2) {
            inGameJPanel.getP1_panel().setBorder(border);
            inGameJPanel.getM1_panel().setBorder(border);
            inGameJPanel.getM2_panel().setBorder(border);
        } else if (e.getSource().equals(inGameButtonJPanel.getM1_target_button()) && inGameModel.getTarget_count() == 1) {
            if (border == null || border.equals(inGameButtonJPanel.getBorder_red())) {
                inGameJPanel.getM1_panel().setBorder(border);
            } else if (border.equals(inGameButtonJPanel.getBorder_green())){
                if (inGameModel.getAttack_state() == 1) {
                    inGameJPanel.getP1_panel().setBorder(border);
                } else {
                    inGameJPanel.getP2_panel().setBorder(border);
                }
            }
        } else if (e.getSource().equals(inGameButtonJPanel.getM1_target_button()) && inGameModel.getTarget_count() == 2) {
            if (border == null || border.equals(inGameButtonJPanel.getBorder_red())) {
                inGameJPanel.getM1_panel().setBorder(border);
                inGameJPanel.getM2_panel().setBorder(border);
            } else if (border.equals(inGameButtonJPanel.getBorder_green())){
                inGameJPanel.getP1_panel().setBorder(border);
                inGameJPanel.getP2_panel().setBorder(border);
            }
        } else if (e.getSource().equals(inGameButtonJPanel.getM1_target_button()) && inGameModel.getTarget_count() == 3 && inGameModel.getAttack_state() == 1) {
            inGameJPanel.getP2_panel().setBorder(border);
            inGameJPanel.getM1_panel().setBorder(border);
            inGameJPanel.getM2_panel().setBorder(border);
        } else if (e.getSource().equals(inGameButtonJPanel.getM1_target_button()) && inGameModel.getTarget_count() == 3 && inGameModel.getAttack_state() == 2) {
            inGameJPanel.getP1_panel().setBorder(border);
            inGameJPanel.getM1_panel().setBorder(border);
            inGameJPanel.getM2_panel().setBorder(border);
        } else if (e.getSource().equals(inGameButtonJPanel.getM2_target_button()) && inGameModel.getTarget_count() == 1) {
            if (border == null || border.equals(inGameButtonJPanel.getBorder_red())) {
                inGameJPanel.getM2_panel().setBorder(border);
            }
        } else if (e.getSource().equals(inGameButtonJPanel.getM2_target_button()) && inGameModel.getTarget_count() == 2) {
            if (border == null || border.equals(inGameButtonJPanel.getBorder_red())) {
                inGameJPanel.getM1_panel().setBorder(border);
                inGameJPanel.getM2_panel().setBorder(border);
            }
        } else if (e.getSource().equals(inGameButtonJPanel.getM2_target_button()) && inGameModel.getTarget_count() == 3 && inGameModel.getAttack_state() == 1) {
            inGameJPanel.getP2_panel().setBorder(border);
            inGameJPanel.getM1_panel().setBorder(border);
            inGameJPanel.getM2_panel().setBorder(border);
        } else if (e.getSource().equals(inGameButtonJPanel.getM2_target_button()) && inGameModel.getTarget_count() == 3 && inGameModel.getAttack_state() == 2) {
            inGameJPanel.getP1_panel().setBorder(border);
            inGameJPanel.getM1_panel().setBorder(border);
            inGameJPanel.getM2_panel().setBorder(border);
        }
    }

    public void toSelectTarget(){
        if (inGameModel.getTarget_type() == 0) {
            if (inGameModel.getAttack_state() == 1) {
                inGameButtonJPanel.getC_target_button().setText(inGameModel.getC2().getName());
            } else if (inGameModel.getAttack_state() == 2) {
                inGameModel.getC2().decreaseMp();
                inGameButtonJPanel.getC_target_button().setText(inGameModel.getC1().getName());
            }
            inGameButtonJPanel.getM1_target_button().setText(inGameModel.getM1().getName());
            inGameButtonJPanel.getM2_target_button().setText(inGameModel.getM2().getName());

        } else if (inGameModel.getTarget_type() == 1) {
            if (inGameModel.getAttack_state() == 1) {
                inGameButtonJPanel.getC_target_button().setText(inGameModel.getC2().getName());
                inGameButtonJPanel.getM1_target_button().setText(inGameModel.getC1().getName());
            } else if (inGameModel.getAttack_state() == 2) {
                inGameButtonJPanel.getC_target_button().setText(inGameModel.getC1().getName());
                inGameButtonJPanel.getM1_target_button().setText(inGameModel.getC2().getName());
            }
            inGameButtonJPanel.getM2_target_button().setText("");
        }
        inGameJPanel.getP1_panel().setBorder(null);
        inGameJPanel.getP2_panel().setBorder(null);
        inGameButtonJPanel.getCard_select().show(inGameButtonJPanel, "target_select");
    }

    public void setDefense(){
        if (inGameModel.getAttack_state() == 1 && inGameModel.getC1().getNot_attack_type() == 0) {
            if (inGameModel.getC2().isAlive()) {
                inGameModel.setAttack_state(2);
                inGameJPanel.getP1_panel().setBorder(null);
                inGameJPanel.getP2_panel().setBorder(inGameJPanel.getBorder_white());
                inGameButtonJPanel.getCard_select().show(inGameButtonJPanel, "main_select");
            }
            else {
                end_select();
                inGameJPanel.getP1_panel().setBorder(null);
            }

        } else if (inGameModel.getAttack_state() == 2 && inGameModel.getC2().getNot_attack_type() == 0) {
            end_select();
        }
    }

    public void checkDefenseOrAttack(){
        if (inGameModel.getTarget_count() == 0) {
            setDefense();
        } else {
            toSelectTarget();
        }
    }

    public void checkMp(){
        if (inGameModel.getAttack_state() == 1) {
            if (inGameModel.getC1().getMp() - inGameModel.getC1().getMp_used() < 0) {
                System.out.println("Not enough MP");
            }
            else {
                checkDefenseOrAttack();
            }
        } else if (inGameModel.getAttack_state() == 2) {
            if (inGameModel.getC2().getMp() - inGameModel.getC2().getMp_used() < 0) {
                System.out.println("Not enough MP");
            }
            else {
                checkDefenseOrAttack();
            }
        }
        inGameJPanel.refreshLabel(inGameModel);
    }

    public void checkItemUse(int index, Character c){
        inGameModel.setTarget_type(c.getBag().get(index).getTarget_type());
        inGameModel.setTarget_count(c.getBag().get(index).getTarget_count());
        inGameModel.setItem_index(index);
        toSelectTarget();
    }

    public ArrayList<Character> checkItemTarget(Character c){
        if (inGameModel.getTarget_count() == 1){
            return createArrayTarget(c);
        } else if (inGameModel.getTarget_count() == 2 && c.getType().equals("Player")){
            return createArrayTarget(inGameModel.getC1(), inGameModel.getC2());
        } else if (inGameModel.getTarget_count() == 2 && c.getType().equals("Monster")){
            return createArrayTarget(inGameModel.getM1(), inGameModel.getM2());
        } else if (inGameModel.getTarget_count() == 3){
            return createArrayTarget(c, inGameModel.getM1(), inGameModel.getM2());
        }
        return null;
    }

    public void useItem(Character who_use, Character target){
        who_use.getBag().get(inGameModel.getItem_index()).useItem(checkItemTarget(target));
        who_use.getBag().set(inGameModel.getItem_index(), null);
        inGameJPanel.refreshLabel(inGameModel);
        inGameButtonJPanel.getCard_select().show(inGameButtonJPanel, "main_select");
    }

    public void randomDropItem(){
        int rand = (int) (Math.random() * itemModel.getItemModels().size());
        inGameModel.setItem_drop(itemModel.getItemModels().get(rand));
    }

    public void ToGetSecondItem(){
        randomDropItem();
        inGameModel.setMonster2_drop(false);
        inGameModel.setShow_item(true);
        inGameButtonJPanel.getItem_get_label().setText("Do you want to keep this item ?");
        inGameButtonJPanel.getCard_select().show(inGameButtonJPanel, "yes_no");
    }

    public void toNextStage(){
        inGameModel.setStage(inGameModel.getStage() + 1);

        if (inGameModel.getDifficulty().equals("Easy") && inGameModel.getStage() > 10){
            stageJPanel.getStage_label().setText("You clear easy Difficulty!!");
        } else if (inGameModel.getDifficulty().equals("Medium") && inGameModel.getStage() > 15){
            stageJPanel.getStage_label().setText("You clear medium Difficulty!!");
        } else if (inGameModel.getDifficulty().equals("Hard") && inGameModel.getStage() > 20){
            stageJPanel.getStage_label().setText("You clear hard Difficulty!!");
        } else {
            stageJPanel.getStage_label().setText("Stage " + String.valueOf(inGameModel.getStage()));
        }
        MainJFrameController.getMainJFrame().getC_frame().show(MainJFrameController.getMainJFrame().getAll_card_panel(), "STAGE");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(inGameButtonJPanel.getButton_attack())) {
            inGameModel.setTarget_type(0);
            toSelectTarget();
            if (inGameModel.getAttack_state() == 1) {
                inGameModel.getC1().normalAttack();
            } else if (inGameModel.getAttack_state() == 2) {
                inGameModel.getC2().normalAttack();
            }
            inGameModel.setTarget_count(1);
        } else if (e.getSource().equals(inGameButtonJPanel.getButton_skill())) {
            inGameButtonJPanel.getCard_select().show(inGameButtonJPanel, "skill_select");
            inGameModel.setTarget_type(0);
            if (inGameModel.getAttack_state() == 1) {
                inGameButtonJPanel.setTextToSkillButton(inGameModel.getC1());
            } else if (inGameModel.getAttack_state() == 2) {
                inGameButtonJPanel.setTextToSkillButton(inGameModel.getC2());
            }
        } else if (e.getSource().equals(inGameButtonJPanel.getButton_bag())) {
            inGameButtonJPanel.getCard_select().show(inGameButtonJPanel, "item_select");
            if (inGameModel.getAttack_state() == 1) {
                inGameButtonJPanel.setTextToItemButton(inGameModel.getC1());
            } else if (inGameModel.getAttack_state() == 2) {
                inGameButtonJPanel.setTextToItemButton(inGameModel.getC2());
            }
        } else if (e.getSource().equals(inGameButtonJPanel.getButton_defense())) {
            if (inGameModel.getAttack_state() == 1) {
                inGameModel.getC1().defense();
            } else if (inGameModel.getAttack_state() == 2) {
                inGameModel.getC2().defense();
            }
            setDefense();
        } else if (e.getSource().equals(inGameButtonJPanel.getSkill1_button())){
            if (inGameModel.getAttack_state() == 1) {
                inGameModel.getC1().skill1();
                inGameModel.setTarget_count(inGameModel.getC1().getTarget_count());
            } else if (inGameModel.getAttack_state() == 2) {
                inGameModel.getC2().skill1();
                inGameModel.setTarget_count(inGameModel.getC2().getTarget_count());
            }
            checkMp();
        } else if (e.getSource().equals(inGameButtonJPanel.getSkill2_button())){
            if (inGameModel.getAttack_state() == 1) {
                inGameModel.getC1().skill2();
                inGameModel.setTarget_count(inGameModel.getC1().getTarget_count());
            } else if (inGameModel.getAttack_state() == 2) {
                inGameModel.getC2().skill2();
                inGameModel.setTarget_count(inGameModel.getC2().getTarget_count());
            }
            checkMp();
        } else if (e.getSource().equals(inGameButtonJPanel.getSkill3_button())){
            if (inGameModel.getAttack_state() == 1) {
                inGameModel.getC1().skill3();
                inGameModel.setTarget_count(inGameModel.getC1().getTarget_count());
            } else if (inGameModel.getAttack_state() == 2) {
                inGameModel.getC2().skill3();
                inGameModel.setTarget_count(inGameModel.getC2().getTarget_count());
            }
            checkMp();
        } else if (e.getSource().equals(inGameButtonJPanel.getItem1_button())){
            if (!inGameModel.isShow_item()) {
                if (inGameModel.getAttack_state() == 1 && inGameModel.getC1().getBag().get(0) != null) {
                    checkItemUse(0, inGameModel.getC1());
                } else if (inGameModel.getAttack_state() == 2 && inGameModel.getC2().getBag().get(0) != null) {
                    checkItemUse(0, inGameModel.getC2());
                }
            } else {
                if (inGameModel.getWho_get_item().getBag().get(0) == null){
                    inGameModel.getWho_get_item().getBag().set(0, inGameModel.getItem_drop());
                    inGameModel.setItem_drop(null);
                    inGameModel.setDrop_count(inGameModel.getDrop_count() - 1);
                    if (inGameModel.getDrop_count() == 0) {
                        inGameModel.setShow_item(false);
                        toNextStage();
                    } else {
                        ToGetSecondItem();
                    }
                } else {
                    inGameModel.setReplace_item(true);
                    inGameModel.setReplace_item_index(0);
                    inGameButtonJPanel.getItem_get_label().setText("Do you want to replace item ?");
                    inGameButtonJPanel.getCard_select().show(inGameButtonJPanel, "yes_no");
                }
            }
        } else if (e.getSource().equals(inGameButtonJPanel.getItem2_button())){
            if (!inGameModel.isShow_item()) {
                if (inGameModel.getAttack_state() == 1 && inGameModel.getC1().getBag().get(1) != null) {
                    checkItemUse(1, inGameModel.getC1());
                } else if (inGameModel.getAttack_state() == 2 && inGameModel.getC2().getBag().get(1) != null) {
                    checkItemUse(1, inGameModel.getC2());
                }
            } else {
                if (inGameModel.getWho_get_item().getBag().get(1) == null){
                    inGameModel.getWho_get_item().getBag().set(1, inGameModel.getItem_drop());
                    inGameModel.setItem_drop(null);
                    inGameModel.setDrop_count(inGameModel.getDrop_count() - 1);
                    if (inGameModel.getDrop_count() == 0) {
                        inGameModel.setShow_item(false);
                        toNextStage();
                    } else {
                        ToGetSecondItem();
                    }
                } else {
                    inGameModel.setReplace_item(true);
                    inGameModel.setReplace_item_index(1);
                    inGameButtonJPanel.getItem_get_label().setText("Do you want to replace item ?");
                    inGameButtonJPanel.getCard_select().show(inGameButtonJPanel, "yes_no");
                }
            }
        } else if (e.getSource().equals(inGameButtonJPanel.getItem3_button())){
            if (!inGameModel.isShow_item()) {
                if (inGameModel.getAttack_state() == 1 && inGameModel.getC1().getBag().get(2) != null) {
                    checkItemUse(2, inGameModel.getC1());
                } else if (inGameModel.getAttack_state() == 2 && inGameModel.getC2().getBag().get(2) != null) {
                    checkItemUse(2, inGameModel.getC2());
                }
            } else {
                if (inGameModel.getWho_get_item().getBag().get(2) == null){
                    inGameModel.getWho_get_item().getBag().set(2, inGameModel.getItem_drop());
                    inGameModel.setItem_drop(null);
                    inGameModel.setDrop_count(inGameModel.getDrop_count() - 1);
                    if (inGameModel.getDrop_count() == 0) {
                        inGameModel.setShow_item(false);
                        toNextStage();
                    } else {
                        ToGetSecondItem();
                    }

                } else {
                    inGameModel.setReplace_item(true);
                    inGameModel.setReplace_item_index(2);
                    inGameButtonJPanel.getItem_get_label().setText("Do you want to replace item ?");
                    inGameButtonJPanel.getCard_select().show(inGameButtonJPanel, "yes_no");
                }
            }
        } else if (e.getSource().equals(inGameButtonJPanel.getBack_button()) || e.getSource().equals(inGameButtonJPanel.getSkill_back_button()) || e.getSource().equals(inGameButtonJPanel.getItem_back_button())) {
            if (!inGameModel.isShow_item()) {
                inGameButtonJPanel.getCard_select().show(inGameButtonJPanel, "main_select");
                if (inGameModel.getAttack_state() == 1) {
                    inGameJPanel.getP1_panel().setBorder(inGameButtonJPanel.getBorder_white());
                } else if (inGameModel.getAttack_state() == 2) {
                    inGameJPanel.getP2_panel().setBorder(inGameButtonJPanel.getBorder_white());
                }
            } else {
                inGameButtonJPanel.getCard_select().show(inGameButtonJPanel, "item_target");
            }
        } else if (e.getSource().equals(inGameButtonJPanel.getText_button())) {
            if (inGameModel.isAll_monster_dead()){
                inGameModel.setDrop_count(0);
                if (inGameModel.isMonster1_drop() && inGameModel.isMonster2_drop()) {
                    inGameModel.setMonster1_drop(false);
                    inGameModel.setDrop_count(2);
                } else if (inGameModel.isMonster1_drop()){
                    inGameModel.setMonster1_drop(false);
                    inGameModel.setDrop_count(1);
                } else if (inGameModel.isMonster2_drop()){
                    inGameModel.setMonster2_drop(false);
                    inGameModel.setDrop_count(1);
                }

                if (inGameModel.getDrop_count() > 0) {
                    randomDropItem();
                    inGameModel.setShow_item(true);
                    inGameButtonJPanel.getItem_get_label().setText("Do you want to keep this item ?");
                    inGameButtonJPanel.getCard_select().show(inGameButtonJPanel, "yes_no");
                } else {
                    toNextStage();
                }
            }

            if (auditionController.getAuditionModel().getTurn() > auditionController.getAuditionModel().getSpeed().size() && !inGameModel.isAll_monster_dead()) {
                setTabtoSelect();
            }

            if (!inGameModel.isAll_monster_dead()) {
                if (inGameModel.isText_showattack()) {
                    if (auditionController.getAuditionModel().getSpeed().get(auditionController.getAuditionModel().getTurn() - 1).isAlive()) {
                        try {
                            inGameButtonJPanel.getCard_select().show(inGameButtonJPanel, "empty");
                            inGameModel.setText_showattack(false);
                            auditionController.checkAttack(auditionController.getAuditionModel().getSpeed().get(auditionController.getAuditionModel().getTurn() - 1));
                        } catch (IndexOutOfBoundsException ex) {
                            setTabtoSelect();
                        }
                    } else {
                        auditionController.getAuditionModel().setTurn(auditionController.getAuditionModel().getTurn() + 1);
                        setText_Button();
                    }
                } else {
                    inGameModel.setText_showattack(true);
                    try {
                        setText_Button();
                    } catch (IndexOutOfBoundsException ex) {
                        System.out.println("Game Over");
                    }
                }
            }
        } else if (e.getSource().equals(inGameButtonJPanel.getC_target_button())){
            if (inGameModel.getAttack_state() == 1 && inGameModel.getC2().isAlive()) {
                if (inGameModel.getTarget_type() == 0) {
                    endSelectTarget(inGameModel.getC1(), inGameModel.getC2());
                } else if (inGameModel.getTarget_type() == 1) {
                    useItem(inGameModel.getC1(), inGameModel.getC2());
                }
            } else if (inGameModel.getAttack_state() == 2 && inGameModel.getC1().isAlive()) {
                if (inGameModel.getTarget_type() == 0) {
                    endSelectTarget(inGameModel.getC2(), inGameModel.getC1());
                } else if (inGameModel.getTarget_type() == 1) {
                    useItem(inGameModel.getC2(), inGameModel.getC1());
                }
            }
        } else if (e.getSource().equals(inGameButtonJPanel.getM1_target_button())){
            if (inGameModel.getAttack_state() == 1 && inGameModel.getM1().isAlive()) {
                if (inGameModel.getTarget_type() == 0) {
                    endSelectTarget(inGameModel.getC1(), inGameModel.getM1());
                } else if (inGameModel.getTarget_type() == 1) {
                    useItem(inGameModel.getC1(), inGameModel.getC1());
                }
            } else if (inGameModel.getAttack_state() == 2 && inGameModel.getC1().isAlive()) {
                if (inGameModel.getTarget_type() == 0) {
                    endSelectTarget(inGameModel.getC2(), inGameModel.getM1());
                } else if (inGameModel.getTarget_type() == 1) {
                    useItem(inGameModel.getC2(), inGameModel.getC2());
                }
            }
        } else if (e.getSource().equals(inGameButtonJPanel.getM2_target_button())){
            if (inGameModel.getAttack_state() == 1 && inGameModel.getM2().isAlive()) {
                if (inGameModel.getTarget_type() == 0) {
                    endSelectTarget(inGameModel.getC1(), inGameModel.getM2());
                }
            } else if (inGameModel.getAttack_state() == 2 && inGameModel.getC2().isAlive()) {
                if (inGameModel.getTarget_type() == 0) {
                    endSelectTarget(inGameModel.getC2(), inGameModel.getM2());
                } else if (inGameModel.getTarget_type() == 1) {
                    useItem(inGameModel.getC2(), inGameModel.getM2());
                }
            }
        } else if (e.getSource().equals(inGameButtonJPanel.getButton_no())) {
            if (!inGameModel.isReplace_item()) {
                inGameModel.setShow_item(false);
                inGameModel.setDrop_count(inGameModel.getDrop_count() - 1);

                if (inGameModel.getDrop_count() > 0) {
                    randomDropItem();
                    inGameModel.setMonster2_drop(false);
                    inGameModel.setShow_item(true);
                } else {
                    toNextStage();
                }
            } else {
                inGameButtonJPanel.getCard_select().show(inGameButtonJPanel, "item_select");
            }
        } else if (e.getSource().equals(inGameButtonJPanel.getButton_yes())) {
            if (!inGameModel.isReplace_item()) {
                inGameButtonJPanel.getItem_target_c1_button().setText(inGameModel.getC1().getName());
                inGameButtonJPanel.getItem_target_c2_button().setText(inGameModel.getC2().getName());
                inGameButtonJPanel.getCard_select().show(inGameButtonJPanel, "item_target");
            } else {
                inGameModel.getWho_get_item().getBag().set(inGameModel.getReplace_item_index(), inGameModel.getItem_drop());
                inGameModel.setItem_drop(null);
                inGameModel.setDrop_count(inGameModel.getDrop_count() - 1);

                if (inGameModel.getDrop_count() == 0) {
                    inGameModel.setShow_item(false);
                    toNextStage();
                } else {
                    ToGetSecondItem();
                }
            }
        } else if (e.getSource().equals(inGameButtonJPanel.getItem_target_back_button())){
            inGameButtonJPanel.getCard_select().show(inGameButtonJPanel, "yes_no");
        } else if (e.getSource().equals(inGameButtonJPanel.getItem_target_c1_button())) {
            inGameButtonJPanel.setTextToItemButton(inGameModel.getC1());
            inGameModel.setWho_get_item(inGameModel.getC1());
            inGameButtonJPanel.getCard_select().show(inGameButtonJPanel, "item_select");
        } else if (e.getSource().equals(inGameButtonJPanel.getItem_target_c2_button())) {
            inGameButtonJPanel.setTextToItemButton(inGameModel.getC2());
            inGameModel.setWho_get_item(inGameModel.getC2());
            inGameButtonJPanel.getCard_select().show(inGameButtonJPanel, "item_select");
        } else if (e.getSource().equals(stageJPanel.getNext_stage_button())) {
            inGameModel.addMonsterToPool();
            inGameModel.randomMonster();
            inGameJPanel.refreshLabel(inGameModel);

            inGameModel.setAttack_state(1);
            auditionController.getAuditionModel().setTurn(1);
            inGameModel.setAll_monster_dead(false);
            inGameJPanel.getP1_panel().setBorder(inGameJPanel.getBorder_white());

            inGameButtonJPanel.getCard_select().show(inGameButtonJPanel, "main_select");
            MainJFrameController.getMainJFrame().getC_frame().show(MainJFrameController.getMainJFrame().getAll_card_panel(), "GAME");
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
        if (inGameModel.getTarget_type() == 0 && !inGameModel.isShow_item()){
            setBorderColor(e, inGameButtonJPanel.getBorder_red());
        } else if (inGameModel.getTarget_type() == 1 && !inGameModel.isShow_item()){
            setBorderColor(e, inGameButtonJPanel.getBorder_green());
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        setBorderColor(e, null);
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent e) {
        if (e.getID() == KeyEvent.KEY_PRESSED) {
            if (e.getKeyCode() == KeyEvent.VK_UP && inGameModel.getIs_press()) {
                if (auditionController.getAuditionModel().getAudition_is_timerun())
                auditionController.check_audition_key(1);
                inGameModel.setIs_press(false);
            } else if (e.getKeyCode() == KeyEvent.VK_DOWN && inGameModel.getIs_press()) {
                if (auditionController.getAuditionModel().getAudition_is_timerun())
                auditionController.check_audition_key(2);
                inGameModel.setIs_press(false);
            } else if (e.getKeyCode() == KeyEvent.VK_LEFT && inGameModel.getIs_press()) {
                if (auditionController.getAuditionModel().getAudition_is_timerun())
                auditionController.check_audition_key(3);
                inGameModel.setIs_press(false);
            } else if (e.getKeyCode() == KeyEvent.VK_RIGHT && inGameModel.getIs_press()) {
                if (auditionController.getAuditionModel().getAudition_is_timerun())
                auditionController.check_audition_key(4);
                inGameModel.setIs_press(false);
            }
        } else if (e.getID() == KeyEvent.KEY_RELEASED) {
            int keyCode = e.getKeyCode();
            switch( keyCode ) {
                case KeyEvent.VK_UP:
                case KeyEvent.VK_DOWN:
                case KeyEvent.VK_LEFT:
                case KeyEvent.VK_RIGHT :
                    inGameModel.setIs_press(true);
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

    public InGameRenderImage getInGameRenderImage() {
        return inGameRenderImage;
    }

    public void setInGameRenderImage(InGameRenderImage inGameRenderImage) {
        this.inGameRenderImage = inGameRenderImage;
    }

    public InGameModel getInGameModel() {
        return inGameModel;
    }

    public void setInGameModel(InGameModel inGameModel) {
        this.inGameModel = inGameModel;
    }

    public ItemModel getItemModel() {
        return itemModel;
    }

    public void setItemModel(ItemModel itemModel) {
        this.itemModel = itemModel;
    }

    public StageJPanel getStageJPanel() {
        return stageJPanel;
    }

    public void setStageJPanel(StageJPanel stageJPanel) {
        this.stageJPanel = stageJPanel;
    }
}
