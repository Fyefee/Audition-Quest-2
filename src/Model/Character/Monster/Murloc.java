package Model.Character.Monster;

import Model.Character.Character;
import Model.Character.MonsterSkill;

import javax.swing.*;

public class Murloc extends Character implements MonsterSkill {

    public Murloc(int position) {
        super("Murloc", 110, 300, 55, 60, 20, 380, 380, "Monster");
        switch (position){
            case 1: super.setX(610); super.setY(160); break;
            case 2: super.setX(795); super.setY(160); break;
            default: break;
        }
        super.setPic(new ImageIcon(getClass().getResource("img/murloc/murloc.gif")).getImage());
        skill1_name = "Slash";
        skill2_name = "Rage Punch";
    }

    public void skill1() {
        returnStats();
        attack_percent = 1.4;
        target_count = 1;
        this.setAttack_text("used Slash to ");
    }

    public void skill2() {
        returnStats();
        attack_percent = 1.3;
        target_count = 1;
        this.setAttack_text("used Rage Punch to ");
    }

}
