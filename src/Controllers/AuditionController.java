package Controllers;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import Model.*;
import Model.Character;

public class AuditionController {

    private AuditionModel auditionModel;

    private InGameController inGameController;
    private TimeBar timeBar;

    public AuditionController(InGameController inGameController){
        this.inGameController = inGameController;
        auditionModel = new AuditionModel();

        auditionModel.getSpeed().add(inGameController.getC1());
        auditionModel.getSpeed().add(inGameController.getC2());
        auditionModel.getSpeed().add(inGameController.getM1());
        auditionModel.getSpeed().add(inGameController.getM2());

        timeBar = new TimeBar();
    }

    public void random(){
        auditionModel.setAudition(new ArrayList<AuditionObject>());
        auditionModel.setX(100);
        auditionModel.setY(100);
        for (int i = 0; i < auditionModel.getArrow_count(); i++){
            int rand = (int)(Math.random() * 4) + 1;
            switch (rand){
                case 1: auditionModel.getAudition().add(new ArrowUp(auditionModel.getX(), 100)); break;
                case 2: auditionModel.getAudition().add(new ArrowDown(auditionModel.getX(), 100)); break;
                case 3: auditionModel.getAudition().add(new ArrowLeft(auditionModel.getX(), 100)); break;
                case 4: auditionModel.getAudition().add(new ArrowRight(auditionModel.getX(), 100)); break;
                default: break;
            }
            auditionModel.setX(auditionModel.getX() + 100);
            if (auditionModel.getX() > 1000){
                auditionModel.setX(100);
            }
        }
        auditionModel.setState(0);
    }

    public void resize_bar(int now_time){
        if (now_time-100 >= auditionModel.getMax_time()){
            auditionModel.setCan_type(false);
            auditionModel.setAudition_is_timerun(false);
            auditionModel.setAudition_is_show(false);
            timeBar.setSize_x(0);
            auditionModel.setAttack_percent(auditionModel.getAttack_percent() - ((double) (auditionModel.getArrow_count() - auditionModel.getState())) * 0.2);
            System.out.println("Audition : You Fail " + (auditionModel.getArrow_count() - auditionModel.getState()) + " times.");
            attack(auditionModel.getSpeed().get(auditionModel.getTurn()-1));
        }
        else if (now_time-100 < 0){
            timeBar.setSize_x(1000);
            auditionModel.setCan_type(true);
        }
        else{
            auditionModel.setCan_type(true);
            timeBar.setSize_x((int) (1000 - (1000 * (((double)now_time-100) / ((double) auditionModel.getMax_time())))));
        }
    }

    public void start_audition(int arrow_count, int max_time){
        auditionModel.setMax_time(max_time);
        auditionModel.setArrow_count(arrow_count);
        random();
        auditionModel.checkAuditionOverflow();        auditionModel.setAttack_percent(1);
        auditionModel.setAudition_is_timerun(true);
        auditionModel.setAudition_is_show(true);
        inGameController.getInGameRenderImage().setAudition(auditionModel.getAudition());
    }

    public void check_audition_key(int key) {
        if (auditionModel.getState() < auditionModel.getArrow_count() && auditionModel.isCan_type()) {
            if (auditionModel.getAudition().get(auditionModel.getState()).getType() == key) {
                auditionModel.getAudition().set(auditionModel.getState(), new Empty(auditionModel.getAudition().get(auditionModel.getState()).getPosition_x(), 100));
            } else {
                auditionModel.getAudition().set(auditionModel.getState(), new Wrong(auditionModel.getAudition().get(auditionModel.getState()).getPosition_x(), 100));
                auditionModel.setAttack_percent(auditionModel.getAttack_percent() - 0.2);
                System.out.println("Audition : Fail!!");
            }
            auditionModel.setState(auditionModel.getState() + 1);
            if (auditionModel.getState() % 10 == 0){
                auditionModel.checkState();
            }
            if (auditionModel.getState() == auditionModel.getArrow_count()){
                auditionModel.setAudition_is_show(false);
                auditionModel.setAudition_is_timerun(false);
                attack(auditionModel.getSpeed().get(auditionModel.getTurn()-1));
            }
        }
    }

    public void checkAttack(Character c) {
        if (c.getType().equals("Player")) {
            if (c.getAttack_target() == null){
                if (c.getNot_attack_type() == 0){
                    auditionModel.setTurn(auditionModel.getTurn() + 1);
                    inGameController.setText_Button();
                    inGameController.setText_showattack(true);
                    inGameController.getInGameButtonJPanel().getCard_select().show(inGameController.getInGameButtonJPanel(), "text_button");
                }
            }
            else if (c.getAttack_target().size() == 1) {
                if (c.getAttack_target().get(0) == inGameController.getC1() && inGameController.getC1().isAlive()) {
                    start_audition(c.getArrow_count(), c.getAudition_time());
                } else if (c.getAttack_target().get(0) == inGameController.getC2() && inGameController.getC2().isAlive()) {
                    start_audition(c.getArrow_count(), c.getAudition_time());
                } else if (c.getAttack_target().get(0) == inGameController.getM1() && inGameController.getM1().isAlive()) {
                    start_audition(c.getArrow_count(), c.getAudition_time());
                } else if (c.getAttack_target().get(0) == inGameController.getM2() && inGameController.getM2().isAlive()) {
                    start_audition(c.getArrow_count(), c.getAudition_time());
                } else {
                    for (int i = 0; i <= (auditionModel.getSpeed().size() - auditionModel.getTurn()); i++) {
                        auditionModel.setTurn(auditionModel.getTurn() + 1);
                        if (auditionModel.getSpeed().get(auditionModel.getTurn() - 1).isAlive())
                            break;
                    }
                    inGameController.setText_Button();
                    inGameController.setText_showattack(true);
                    inGameController.getInGameButtonJPanel().getCard_select().show(inGameController.getInGameButtonJPanel(), "text_button");
                }
            }
        }
        else {
            auditionModel.setAttack_percent(1);
            auditionModel.setWho_attack(c);
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
                auditionModel.setDamage((int) (((double) who_attack.getAtk() * auditionModel.getAttack_percent() * who_attack.getAttack_percent()  - who_attack.getAttack_target().get(i).getDef())) * who_attack.getAttack_target().get(i).getDefence_percent());
                text = who_attack.getName() + " Attack " + who_attack.getAttack_target().get(i).getName() + " " + (int) auditionModel.getDamage() + " Damage.";
                System.out.println(text);

                if (auditionModel.getDamage() > 0) {
                    who_attack.getAttack_target().get(i).setHp(who_attack.getAttack_target().get(i).getHp() - (int) auditionModel.getDamage());
                }

                if (who_attack.getAttack_target().get(i).getHp() <= 0) {
                    who_attack.getAttack_target().get(i).setHp(0);
                    who_attack.getAttack_target().get(i).setAlive(false);
                    auditionModel.getSpeed().remove(who_attack.getAttack_target().get(i));
                }

            }
            inGameController.getInGameJPanel().getP1_hp().setText("HP : " + inGameController.getC1().getHp() + "/" + inGameController.getC1().getMax_hp());
            inGameController.getInGameJPanel().getP2_hp().setText("HP : " + inGameController.getC2().getHp() + "/" + inGameController.getC2().getMax_hp());
            inGameController.getInGameJPanel().getM1_hp().setText("HP : " + inGameController.getM1().getHp() + "/" + inGameController.getM1().getMax_hp());
            inGameController.getInGameJPanel().getM2_hp().setText("HP : " + inGameController.getM2().getHp() + "/" + inGameController.getM2().getMax_hp());

            inGameController.getInGameButtonJPanel().getCard_select().show(inGameController.getInGameButtonJPanel(), "text_button");
            inGameController.setText_Button(text);
            auditionModel.setTurn(auditionModel.getTurn() + 1);
            inGameController.setIs_start(false);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public AuditionModel getAuditionModel() {
        return auditionModel;
    }

    public void setAuditionModel(AuditionModel auditionModel) {
        this.auditionModel = auditionModel;
    }

    public TimeBar getTimeBar() {
        return timeBar;
    }

    public void setTimeBar(TimeBar timeBar) {
        this.timeBar = timeBar;
    }

}
