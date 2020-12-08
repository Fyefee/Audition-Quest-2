package Model.Character.Monster;

import Model.Character.Character;
import Model.Character.MonsterSkill;

import javax.swing.*;

public class Warlord extends Character implements MonsterSkill {

    public Warlord(int position) {
        super("Warlord", 130, 300, 59, 65, 30, 460, 460, "Monster");
        switch (position){
            case 1: super.setX(610); super.setY(70); break;
            case 2: super.setX(795); super.setY(70); break;
            default: break;
        }
        super.setPic(new ImageIcon(getClass().getResource("img/warlord/warlord.gif")).getImage());
        skill1_name = "X Slash";
        skill2_name = "Spin Slash";
    }

    public void skill1() {
        returnStats();
        attack_percent = 1.5;
        target_count = 1;
        this.setAttack_text("used X Slash to ");
    }

    public void skill2() {
        returnStats();
        attack_percent = 1.1;
        target_count = 2;
        this.setAttack_text("used Spin Slash to");
    }

}
