package Model.Character.Player;

import Model.Character.Character;
import Model.Character.PlayerSkill;

import javax.swing.*;

public class Druid extends Character implements PlayerSkill {

    public Druid() {
        super("Druid", 180, 85, 70, 55, 20, 440, 440, "Player");
        super.setX(190);
        super.setY(125);
        super.setPic(new ImageIcon(getClass().getResource("img/Druid/Druid.gif")).getImage());
        skill1_name = "Gift of the Wild";
        skill1_description = "Increase def 8, atk 10 and Deals 120% damage to 1 enemy<br>Use 10 mp";
        skill2_name = "Tiger's Fury";
        skill2_description = "Increase atk 5 and Deals 175% damage to 1 enemy<br>Use 20 mp";
        skill3_name = "Moonfire";
        skill3_description = "Increase atk 5 and Deals 90% damage to 2 enemy<br>Use 25 mp";
    }

    public void skill1() {
        returnStats();
        def += 8;
        atk += 8;
        mp_used = 10;
        arrow_count = 10;
        audition_time = 500;
        target_count = 1;
        this.setAttack_text("used Gift of the Wild to ");
    }

    public void skill2() {
        returnStats();
        attack_percent = 1.75;
        atk += 5;
        mp_used = 20;
        arrow_count = 16;
        audition_time = 600;
        target_count = 1;
        this.setAttack_text("used Tiger's Fury to ");
    }

    public void skill3() {
        returnStats();
        atk += 5;
        attack_percent = 0.9;
        mp_used = 25;
        arrow_count = 20;
        audition_time = 700;
        target_count = 2;
        this.setAttack_text("used Moonfire to ");
    }

}
