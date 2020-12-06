package Model.Character.Player;

import Model.Character.Character;
import Model.Character.PlayerSkill;

import javax.swing.*;

public class Archer extends Character implements PlayerSkill {

    public Archer() {
        super("Archer", 150, 70, 80, 75, 10, 200, 200, "Player");
        super.setX(100); 
        super.setY(300);
        super.setPic(new ImageIcon(getClass().getResource("img/Archer/archer2.gif")).getImage());
        skill1_name = "Snipe";
        skill1_description = "Deals 130% damage to 1 enemy<br>*Ignore Def*<br>Use 20 mp";
        skill2_name = "Multi Shot";
        skill2_description = "Deals 175% damage to 1 enemy<br>Use 15 mp";
        skill3_name = "Arrows Rain";
        skill3_description = "Deals 90% damage to all enemy<br>Use 25 mp";
    }

    public void skill1() {
        returnStats();
        attack_percent = 1.3;
        mp_used = 20;
        arrow_count = 18;
        audition_time = 600;
        target_count = 1;
        ignore_def = true;
        this.setAttack_text("used Snipe to ");
    }

    public void skill2() {
        returnStats();
        attack_percent = 1.75;
        mp_used = 15;
        arrow_count = 15;
        audition_time = 600;
        target_count = 1;
        this.setAttack_text("used Multi Shot to ");
    }
    public void skill3() {
        returnStats();
        attack_percent = 0.9;
        mp_used = 25;
        arrow_count = 25;
        audition_time = 725;
        target_count = 2;
        this.setAttack_text("used Arrows Rain to ");
    }
    
}
