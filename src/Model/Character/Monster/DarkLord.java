package Model.Character.Monster;

import Model.Character.Character;
import Model.Character.MonsterSkill;

import javax.swing.*;

public class DarkLord extends Character implements MonsterSkill {

    public DarkLord(int position) {
        super("Dark Lord", 250, 300, 65, 70, 35, 430, 430, "Monster");
        switch (position){
            case 1: super.setX(610); super.setY(100); break;
            case 2: super.setX(795); super.setY(100); break;
            default: break;
        }
        super.setPic(new ImageIcon(getClass().getResource("img/darkLord/darkLord.gif")).getImage());
        skill1_name = "Reaper's Judgment";
        skill2_name = "Boundary of Death";
    }

    public void skill1() {
        returnStats();
        attack_percent = 1.7;
        target_count = 1;
        this.setAttack_text("used Reaper's Judgment to ");
    }

    public void skill2() {
        returnStats();
        speed += 10;
        attack_percent = 1.3;
        target_count = 2;
        this.setAttack_text("used Boundary of Death to ");
    }

}
