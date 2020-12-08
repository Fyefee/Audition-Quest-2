package Model.Character.Player;

import Model.Character.Character;
import Model.Character.PlayerSkill;

import javax.swing.*;

public class Duelist extends Character implements PlayerSkill {

    public Duelist() {
        super("Duelist", 205, 90, 75, 75, 20, 380, 380, "Player");
        super.setX(215);
        super.setY(150);
        super.setPic(new ImageIcon(getClass().getResource("img/Duelist/Duelist.gif")).getImage());
        skill1_name = "Sonic Acceleration";
        skill1_description = "Increase speed 10, atk 10 and Deals 120% damage to 1 enemy<br>Use 15 mp";
        skill2_name = "Grimtooth";
        skill2_description = "Deals 140% damage to 1 enemy<br>*Ignore Def*<br>Use 20 mp";
        skill3_name = "Sonic Blow";
        skill3_description = "Deals 190% damage to 1 enemy<br>*Ignore Def*<br>Use 30 mp";
    }

    public void skill1() {
        returnStats();
        attack_percent = 1.2;
        speed += 10;
        atk += 10;
        mp_used = 15;
        arrow_count = 13;
        audition_time = 600;
        target_count = 1;
        this.setAttack_text("used Sonic Acceleration to ");
    }

    public void skill2() {
        returnStats();
        attack_percent = 1.4;
        mp_used = 20;
        arrow_count = 17;
        audition_time = 650;
        target_count = 1;
        ignore_def = true;
        this.setAttack_text("used Grimtooth to ");
    }

    public void skill3() {
        returnStats();
        attack_percent = 1.9;
        mp_used = 30;
        arrow_count = 20;
        audition_time = 650;
        target_count = 1;
        ignore_def = true;
        this.setAttack_text("used Sonic Blow to ");
    }

}
