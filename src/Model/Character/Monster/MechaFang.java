package Model.Character.Monster;

import Model.Character.Character;
import Model.Character.MonsterSkill;

import javax.swing.*;

public class MechaFang extends Character implements MonsterSkill {

    public MechaFang(int position) {
        super("Mecha Fang", 90, 300, 60, 45, 30, 450, 450, "Monster");
        switch (position){
            case 1: super.setX(610); super.setY(90); break;
            case 2: super.setX(795); super.setY(90); break;
            default: break;
        }
        super.setPic(new ImageIcon(getClass().getResource("img/mechafang/mechafang.gif")).getImage());
        skill1_name = "Crunch";
        skill2_name = "Thunder Fang";
    }

    public void skill1() {
        returnStats();
        attack_percent = 1.4;
        target_count = 1;
        this.setAttack_text("used Crunch to ");
    }

    public void skill2() {
        returnStats();
        attack_percent = 1.8;
        target_count = 1;
        this.setAttack_text("used Thunder Fang to ");
    }

}
