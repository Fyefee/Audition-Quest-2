package Model.Character.Monster;

import Model.Character.Character;
import Model.Character.MonsterSkill;

import javax.swing.*;

public class FireFang extends Character implements MonsterSkill {

    public FireFang(int position) {
        super("Fire Fang", 90, 300, 55, 45, 20, 400, 400, "Monster");
        switch (position){
            case 1: super.setX(630); super.setY(160); break;
            case 2: super.setX(815); super.setY(160); break;
            default: break;
        }
        super.setPic(new ImageIcon(getClass().getResource("img/firefang/firefang.gif")).getImage());
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
        this.setAttack_text("used Laser Beam Mode");
    }
}
