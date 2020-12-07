package Model.Character.Monster;

import Model.Character.Character;
import Model.Character.MonsterSkill;

import javax.swing.*;

public class Golem extends Character implements MonsterSkill {

    public Golem(int position) {
        super("Golem", 150, 300, 30, 55, 30, 430, 430, "Monster");
        switch (position){
            case 1: super.setX(610); super.setY(100); break;
            case 2: super.setX(795); super.setY(100); break;
            default: break;
        }
        super.setPic(new ImageIcon(getClass().getResource("img/golem/golem.gif")).getImage());
        skill1_name = "Rock Edge";
        skill2_name = "Earthquake";
    }

    public void skill1() {
        returnStats();
        attack_percent = 1.55;
        target_count = 1;
        this.setAttack_text("used Rock Edge to ");
    }

    public void skill2() {
        returnStats();
        attack_percent = 1.2;
        target_count = 2;
        this.setAttack_text("used Earthquake to");
    }

}
