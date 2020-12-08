package Model.Character.Player;

import Model.Character.Character;
import Model.Character.PlayerSkill;
import Model.Item.Mana.ManaPotionXL;

import javax.swing.*;

public class Berserker extends Character implements PlayerSkill {

    public Berserker() {
        super("Berserker", 220, 90, 65, 70, 25, 430, 430, "Player");
        super.setX(180);
        super.setY(110);
        super.setPic(new ImageIcon(getClass().getResource("img/Berserker/Berserker.gif")).getImage());
        skill1_name = "Radiant Attack";
        skill1_description = "Deal 125% damage to 2 enemy<br>Use 20 mp";
        skill2_name = "Predatory Hunt";
        skill2_description = "Deal 150% damage to 1 enemy<br>*Ignore Def*<br>Use 20 mp";
        skill3_name = "Raging Thunder";
        skill3_description = "Deals 215% damage to 1 enemy<br>Use 30 mp";
    }

    public void skill1() {
        returnStats();
        attack_percent = 1.25;
        mp_used = 20;
        arrow_count = 12;
        audition_time = 625;
        target_count = 2;
        this.setAttack_text("used Radiant Attack to ");
    }

    public void skill2() {
        returnStats();
        attack_percent = 1.5;
        mp_used = 20;
        arrow_count = 18;
        audition_time = 650;
        target_count = 1;
        ignore_def = true;
        this.setAttack_text("used Predatory Hunt to ");
    }

    public void skill3() {
        returnStats();
        attack_percent = 2.15;
        mp_used = 30;
        arrow_count = 25;
        audition_time = 725;
        target_count = 1;
        this.setAttack_text("used Raging Thunder to ");
    }

}
