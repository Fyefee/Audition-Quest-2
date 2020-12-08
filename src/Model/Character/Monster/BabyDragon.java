package Model.Character.Monster;

import Model.Character.Character;
import Model.Character.MonsterSkill;

import javax.swing.*;

public class BabyDragon extends Character implements MonsterSkill {

    public BabyDragon(int position) {
        super("Baby Dragon", 80, 300, 50, 55, 20, 430, 430, "Monster");
        switch (position){
            case 1: super.setX(610); super.setY(100); break;
            case 2: super.setX(795); super.setY(100); break;
            default: break;
        }
        super.setPic(new ImageIcon(getClass().getResource("img/babydragon/babydragon.gif")).getImage());
        skill1_name = "Fireball";
        skill2_name = "Firestorm";
    }

    public void skill1() {
        returnStats();
        attack_percent = 1.3;
        target_count = 1;
        this.setAttack_text("used Fireball to ");
    }

    public void skill2() {
        returnStats();
        attack_percent = 0.8;
        target_count = 2;
        this.setAttack_text("used Firestorm to");
    }

}
