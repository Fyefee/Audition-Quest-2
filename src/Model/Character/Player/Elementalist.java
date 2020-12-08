package Model.Character.Player;

import Model.Character.Character;
import Model.Character.PlayerSkill;

import javax.swing.*;

public class Elementalist extends Character implements PlayerSkill {

    public Elementalist() {
        super("Elementalist", 170, 110, 80, 65, 15, 360, 360, "Player");
        super.setX(40);
        super.setY(180);
        super.setPic(new ImageIcon(getClass().getResource("img/Elementalist/Elementalist.gif")).getImage());
        skill1_name = "Meteor Shower";
        skill1_description = "Deals 180% damage to 2 enemy<br>Use 45 mp";
        skill2_name = "Chain Lightning";
        skill2_description = "Deals 80% damage to 2 enemy<br>Use 15 mp";
        skill3_name = "Eruption";
        skill3_description = "Deals 220% damage to 2 enemy<br>Use 70 mp";
    }

    public void skill1() {
        returnStats();
        attack_percent = 1.9;
        mp_used = 45;
        arrow_count = 18;
        audition_time = 725;
        target_count = 2;
        this.setAttack_text("used Meteor Shower to ");
    }

    public void skill2() {
        returnStats();
        attack_percent = 0.8;
        mp_used = 15;
        arrow_count = 12;
        audition_time = 650;
        target_count = 2;
        this.setAttack_text("used Chain Lightning to ");
    }
    public void skill3() {
        returnStats();
        attack_percent = 2.2;
        mp_used = 70;
        arrow_count = 26;
        audition_time = 825;
        target_count = 2;
        this.setAttack_text("used Eruption to ");
    }

}
