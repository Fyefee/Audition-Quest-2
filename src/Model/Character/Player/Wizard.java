package Model.Character.Player;

import Model.Character.Character;
import Model.Character.PlayerSkill;

import javax.swing.*;

public class Wizard extends Character implements PlayerSkill {

    public Wizard() {
        super("Wizard", 130, 100, 75, 65, 10, 275, 275, "Player");
        super.setX(100);
        super.setY(260);
        super.setPic(new ImageIcon(getClass().getResource("img/Wizard/Wizard.gif")).getImage());
        skill1_name = "Frostbolt";
        skill1_description = "Deals 150% damage to 1 enemy<br>Use 15 mp";
        skill2_name = "Pyroblast";
        skill2_description = "Deals 200% damage to 1 enemy<br>Use 25 mp";
        skill3_name = "Arcane Explosion";
        skill3_description = "Deals 130% damage to 2 enemy<br>Use 40 mp";
    }

    public void skill1() {
        returnStats();
        attack_percent = 1.3;
        mp_used = 15;
        arrow_count = 10;
        audition_time = 400;
        target_count = 1;
        this.setAttack_text("used Frostbolt to ");
    }

    public void skill2() {
        returnStats();
        attack_percent = 2;
        mp_used = 25;
        arrow_count = 15;
        audition_time = 600;
        target_count = 1;
        this.setAttack_text("used Pyroblast to ");
    }
    public void skill3() {
        returnStats();
        attack_percent = 1.3;
        mp_used = 40;
        arrow_count = 25;
        audition_time = 700;
        target_count = 2;
        this.setAttack_text("used Arcane Explosion to ");
    }

}
