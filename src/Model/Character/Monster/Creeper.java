package Model.Character.Monster;

import Model.Character.Character;
import Model.Character.MonsterSkill;

import javax.swing.*;

public class Creeper extends Character implements MonsterSkill {

    public Creeper(int position) {
        super("Creeper", 10, 300, 10, 30, 20, 160, 160, "Monster");
        switch (position){
            case 1: super.setX(760); super.setY(340); break;
            case 2: super.setX(925); super.setY(340); break;
            default: break;
        }
        super.setPic(new ImageIcon(getClass().getResource("img/creeper/eye_idle.gif")).getImage());
        skill1_name = "Bump";
        skill2_name = "Defense Mode";
    }

    public void skill1() {
        returnStats();
        attack_percent = 1.25;
        target_count = 1;
        this.setAttack_text("used Bump to ");
    }

    public void skill2() {
        returnStats();
        defence_percent = 0.8;
        speed = 999;
        not_attack_type = 0;
        target_count = 0;
        this.setAttack_text("used Defense Mode");
    }
}
