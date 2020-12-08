package Model.Character.Player;

import Model.Character.Character;
import Model.Character.PlayerSkill;

import javax.swing.*;

public class Knight extends Character implements PlayerSkill {
    
    public Knight() {
        super("Knight", 260, 60, 55, 60, 35, 340, 340, "Player");
        super.setX(230);
        super.setY(200);
        super.setPic(new ImageIcon(getClass().getResource("img/knight/knight.gif")).getImage());
        skill1_name = "Unbreakable";
        skill1_description = "Increase def 10 and decrease damage taken 50%<br>Use 15 mp";
        skill2_name = "Shield Bash";
        skill2_description = "Increase attack damage equals def stats<br>Use 10 mp";
        skill3_name = "Sword of Condemnation";
        skill3_description = "Deals 190% damage to 1 enemy<br>Use 20 mp";
    }

    public void skill1() {
        returnStats();
        def += 10;
        defence_percent = 0.5;
        mp_used = 15;
        speed = 999;
        not_attack_type = 0;
        target_count = 0;
        this.setAttack_text("used Unbreakable Skill");
    }

    public void skill2() {
        returnStats();
        atk += def;
        mp_used = 10;
        arrow_count = 12;
        audition_time = 500;
        target_count = 1;
        this.setAttack_text("used Shield Bash to ");
    }

    public void skill3() {
        returnStats();
        attack_percent = 1.9;
        mp_used = 20;
        arrow_count = 20;
        audition_time = 600;
        target_count = 1;
        this.setAttack_text("used Sword of Condemnation to ");
    }

}
