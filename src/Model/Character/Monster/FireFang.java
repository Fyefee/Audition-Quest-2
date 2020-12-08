package Model.Character.Monster;

import Model.Character.Character;
import Model.Character.MonsterSkill;

import javax.swing.*;

public class FireFang extends Character implements MonsterSkill {

    public FireFang(int position) {
        super("Fire Fang", 80, 300, 55, 40, 20, 400, 400, "Monster");
        switch (position){
            case 1: super.setX(630); super.setY(160); break;
            case 2: super.setX(815); super.setY(160); break;
            default: break;
        }
        super.setPic(new ImageIcon(getClass().getResource("img/firefang/firefang.gif")).getImage());
        skill1_name = "Crunch";
        skill2_name = "Quick Attack";
    }

    public void skill1() {
        returnStats();
        attack_percent = 1.4;
        target_count = 1;
        this.setAttack_text("used Crunch to ");
    }

    public void skill2() {
        returnStats();
        speed += 10;
        attack_percent = 1;
        target_count = 1;
        this.setAttack_text("used Quick Attack to ");
    }
}
