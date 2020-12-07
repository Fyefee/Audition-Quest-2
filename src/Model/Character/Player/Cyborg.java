package Model.Character.Player;

import Model.Character.Character;
import Model.Character.PlayerSkill;

import javax.swing.*;

public class Cyborg extends Character implements PlayerSkill {

    public Cyborg() {
        super("Cyborg", 160, 70, 70, 70, 15, 410, 410, "Player");
        super.setX(0);
        super.setY(120);
        super.setPic(new ImageIcon(getClass().getResource("img/Cyborg/Cyborg.gif")).getImage());
        skill1_name = "Arms Cannon";
        skill1_description = "Deals 200% damage to 1 enemy<br>Use 35 mp";
        skill2_name = "Flame Launcher";
        skill2_description = "Deals 100% damage to 2 enemy<br>Use 30 mp";
        skill3_name = "Acceleration";
        skill3_description = "Increase Speed 10 and Deals 130% damage to 1 enemy<br>Use 20 mp";
    }

    public void skill1() {
        returnStats();
        attack_percent = 2;
        mp_used = 35;
        arrow_count = 20;
        audition_time = 725;
        target_count = 1;
        this.setAttack_text("used Arms Cannon to ");
    }

    public void skill2() {
        returnStats();
        attack_percent = 1;
        mp_used = 30;
        arrow_count = 18;
        audition_time = 700;
        target_count = 2;
        this.setAttack_text("used Flame Launcher to ");
    }
    public void skill3() {
        returnStats();
        speed += 10;
        attack_percent = 1.3;
        mp_used = 20;
        arrow_count = 10;
        audition_time = 650;
        target_count = 1;
        this.setAttack_text("used Acceleration to ");
    }

}
