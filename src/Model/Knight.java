package Model;

import javax.swing.*;

public class Knight extends Character implements PlayerSkill{
    
    
    public Knight() {
        super("Knight", 250, 100, 60, 60, 25, 140, 180, "Player");
        super.setX(300); 
        super.setY(320);
        super.setPic(new ImageIcon(getClass().getResource("img/human_idle.gif")).getImage());
        skill1_name = "Unbreakable";
        skill1_description = "Increase def 10 and decrease damage taken 50%\nUse 15 mp";
        skill2_name = "Shield Bash";
        skill2_description = "Increase attack damage equals def stats\nUse 10 mp";
        skill3_name = "Sword of Condemnation";
        skill3_description = "Deals 160% damage to 1 enemy\nUse 20 mp";
    }

    public void skill1() {
        def += 10;
        defence_percent = 0.5;
        mp_used = 15;
    }

    public void skill2() {

    }

    public void skill3() {

    }

}
