package Model.Character.Monster;

import Model.Character.Character;
import Model.Character.MonsterSkill;

import javax.swing.*;

public class Unknown extends Character implements MonsterSkill {

    public Unknown(int position) {
        super("Unknown", 120, 300, 58, 55, 27, 450, 450, "Monster");
        switch (position){
            case 1: super.setX(610); super.setY(80); break;
            case 2: super.setX(795); super.setY(80); break;
            default: break;
        }
        super.setPic(new ImageIcon(getClass().getResource("img/unknown/unknown.gif")).getImage());
        skill1_name = "Crazy Move";
        skill2_name = "Acid Rain";
    }

    public void skill1() {
        returnStats();
        speed += 10;
        attack_percent = 1.35;
        target_count = 1;
        this.setAttack_text("used Crazy Move to ");
    }

    public void skill2() {
        returnStats();
        attack_percent = 0.9;
        target_count = 2;
        this.setAttack_text("used Acid Rain to");
    }

}
