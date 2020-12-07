package Model.Character.Monster;

import Model.Character.Character;
import Model.Character.MonsterSkill;

import javax.swing.*;

public class FireDragon extends Character implements MonsterSkill {

    public FireDragon(int position) {
        super("Fire Dragon", 150, 300, 55, 65, 25, 480, 480, "Monster");
        switch (position){
            case 1: super.setX(580); super.setY(70); break;
            case 2: super.setX(765); super.setY(70); break;
            default: break;
        }
        super.setPic(new ImageIcon(getClass().getResource("img/firedragon/firedragon.gif")).getImage());
        skill1_name = "Charge Punch";
        skill2_name = "Tail Whip";
    }

    public void skill1() {
        returnStats();
        attack_percent = 1.6;
        target_count = 1;
        this.setAttack_text("used Charge Punch to ");
    }

    public void skill2() {
        returnStats();
        attack_percent = 1.4;
        target_count = 1;
        this.setAttack_text("used Tail Whip to ");
    }

}
