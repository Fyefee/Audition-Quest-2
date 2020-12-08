package Controllers;

import java.util.ArrayList;

import Model.Audition.*;
import Model.Character.Character;
import Model.InGameModel;

public class AuditionController {

    private AuditionModel auditionModel;

    private InGameController inGameController;
    private InGameModel inGameModel;
    private TimeBar timeBar;

    public AuditionController(InGameController inGameController){
        this.inGameController = inGameController;
        this.inGameModel = inGameController.getInGameModel();
        auditionModel = new AuditionModel();

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
        auditionModel.setAudition_first_index(0);
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
            auditionModel.setCan_type(false);
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
                    inGameModel.setText_showattack(true);
                    inGameController.getInGameButtonJPanel().getCard_select().show(inGameController.getInGameButtonJPanel(), "text_button");
                }
            }
            else if (c.getAttack_target().size() == 1) {
                if (c.getAttack_target().get(0) == inGameModel.getC1() && inGameModel.getC1().isAlive()) {
                    start_audition(c.getArrow_count(), c.getAudition_time());
                } else if (c.getAttack_target().get(0) == inGameModel.getC2() && inGameModel.getC2().isAlive()) {
                    start_audition(c.getArrow_count(), c.getAudition_time());
                } else if (c.getAttack_target().get(0) == inGameModel.getM1() && inGameModel.getM1().isAlive()) {
                    start_audition(c.getArrow_count(), c.getAudition_time());
                } else if (c.getAttack_target().get(0) == inGameModel.getM2() && inGameModel.getM2().isAlive()) {
                    start_audition(c.getArrow_count(), c.getAudition_time());
                } else {
                    skipTurn();
                }
            }
            else if (c.getAttack_target().size() == 2){
                if (c.getAttack_target().get(0) == inGameModel.getC1() && inGameModel.getC1().isAlive()) {
                    start_audition(c.getArrow_count(), c.getAudition_time());
                } else if (c.getAttack_target().get(0) == inGameModel.getC2() && inGameModel.getC2().isAlive()) {
                    start_audition(c.getArrow_count(), c.getAudition_time());
                } else if ((c.getAttack_target().get(0) == inGameModel.getM1() || c.getAttack_target().get(0) == inGameModel.getM2()) && (inGameModel.getM1().isAlive() || inGameModel.getM2().isAlive())){
                    start_audition(c.getArrow_count(), c.getAudition_time());
                } else {
                    skipTurn();
                }
            }
        }
        else {
            auditionModel.setAttack_percent(1);
            auditionModel.setWho_attack(c);
            if (c.getAttack_target() == null){
                if (c.getNot_attack_type() == 0){
                    auditionModel.setTurn(auditionModel.getTurn() + 1);
                    inGameController.setText_Button();
                    inGameModel.setText_showattack(true);
                    inGameController.getInGameButtonJPanel().getCard_select().show(inGameController.getInGameButtonJPanel(), "text_button");
                }
            } else {
                attack(c);
            }
        }
    }

    public void skipTurn(){
        for (int i = 0; i <= (auditionModel.getSpeed().size() - auditionModel.getTurn()); i++) {
            auditionModel.setTurn(auditionModel.getTurn() + 1);
            if (auditionModel.getSpeed().get(auditionModel.getTurn() - 1).isAlive())
                break;
        }
        inGameController.setText_Button();
        inGameModel.setText_showattack(true);
        inGameController.getInGameButtonJPanel().getCard_select().show(inGameController.getInGameButtonJPanel(), "text_button");
    }

    public void attack(Character who_attack){
        try {
            String text = "";
            for (int i = 0; i < who_attack.getAttack_target().size(); i++) {
                if (who_attack.isIgnore_def()){
                    auditionModel.setDamage((int) ((double) who_attack.getAtk() * auditionModel.getAttack_percent() * who_attack.getAttack_percent()));
                } else {
                    auditionModel.setDamage((int) (((double) who_attack.getAtk() * auditionModel.getAttack_percent() * who_attack.getAttack_percent()  - who_attack.getAttack_target().get(i).getDef())) * who_attack.getAttack_target().get(i).getDefence_percent());
                }

                if ((int) auditionModel.getDamage() <= 0)
                    text = who_attack.getName() + " Attack " + who_attack.getAttack_target().get(i).getName() + " 0 Damage.";
                else
                    text = who_attack.getName() + " Attack " + who_attack.getAttack_target().get(i).getName() + " " + (int) auditionModel.getDamage() + " Damage.";
                System.out.println(text);

                if (auditionModel.getDamage() > 0) {
                    who_attack.getAttack_target().get(i).setHp(who_attack.getAttack_target().get(i).getHp() - (int) auditionModel.getDamage());
                }

                if (who_attack.getAttack_target().get(i).getHp() <= 0) {
                    who_attack.getAttack_target().get(i).setHp(0);
                    who_attack.getAttack_target().get(i).setAlive(false);

                    if (auditionModel.getSpeed().indexOf(who_attack.getAttack_target().get(i)) < auditionModel.getTurn()){
                        auditionModel.setTurn(auditionModel.getTurn() - 1);
                    }

                    auditionModel.getSpeed().remove(who_attack.getAttack_target().get(i));
                    System.out.println(auditionModel.getSpeed());



                    int rand = (int) (Math.random() * 100) + 1;
                    if (rand > 20){
                        if (who_attack.getAttack_target().get(i) == inGameModel.getM1()){
                            inGameModel.setMonster1_drop(true);
                        } else if (who_attack.getAttack_target().get(i) == inGameModel.getM2()){
                            inGameModel.setMonster2_drop(true);
                        }
                    }

                    if (!inGameModel.getM1().isAlive() && !inGameModel.getM2().isAlive()){
                        inGameModel.setAll_monster_dead(true);
                    }
                }

            }

            inGameController.getInGameJPanel().refreshLabelWOSpeed(inGameModel);

            inGameController.getInGameButtonJPanel().getCard_select().show(inGameController.getInGameButtonJPanel(), "text_button");
            inGameController.setText_Button(text);
            auditionModel.setTurn(auditionModel.getTurn() + 1);
            inGameModel.setIs_start(false);
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
