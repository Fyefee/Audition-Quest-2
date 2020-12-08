package Model.Character.Monster;

import Model.Character.Character;
import Model.Character.MonsterSkill;

import javax.swing.*;

public class Creeper extends Character implements MonsterSkill {

    public Creeper(int position) {
        super("Creeper", 60, 300, 30, 50, 20, 160, 160, "Monster");
        switch (position){
            case 1: super.setX(760); super.setY(340); break;
            case 2: super.setX(925); super.setY(340); break;
            default: break;
        }
        super.setPic(new ImageIcon(getClass().getResource("img/creeper/eye_idle.gif")).getImage());
        skill1_name = "Bump";
        skill2_name = "Laser Beam";
    }

    public void skill1() {
        returnStats();
        attack_percent = 1.25;
        target_count = 1;
        this.setAttack_text("used Bump to ");
    }

    public void skill2() {
        returnStats();
        attack_percent = 1.50;
        target_count = 1;
        this.setAttack_text("used Laser Beam to ");
    }
}
