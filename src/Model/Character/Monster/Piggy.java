package Model.Character.Monster;

import Model.Character.Character;
import Model.Character.MonsterSkill;

import javax.swing.*;

public class Piggy extends Character implements MonsterSkill {

    public Piggy(int position) {
        super("Piggy", 110, 300, 55, 55, 20, 430, 430, "Monster");
        switch (position){
            case 1: super.setX(610); super.setY(120); break;
            case 2: super.setX(795); super.setY(120); break;
            default: break;
        }
        super.setPic(new ImageIcon(getClass().getResource("img/piggy/piggy.gif")).getImage());
        skill1_name = "Take Down";
        skill2_name = "Quick Attack";
    }

    public void skill1() {
        returnStats();
        attack_percent = 1.4;
        target_count = 1;
        this.setAttack_text("used Takedown to ");
    }

    public void skill2() {
        returnStats();
        speed += 20;
        attack_percent = 0.85;
        target_count = 1;
        this.setAttack_text("used Quick Attack to ");
    }

}
