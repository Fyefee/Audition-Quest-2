/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Character.Monster;

import Model.Character.Character;

import javax.swing.*;

public class Slime extends Character {
    
    public Slime(int position) {
        super("Slime", 50, 300, 10, 30, 20, 120, 120, "Monster");
        switch (position){
            case 1: super.setX(760); super.setY(375); break;
            case 2: super.setX(925); super.setY(375); break;
            default: break;
        }
        super.setPic(new ImageIcon(getClass().getResource("img/slime/slime_idle.gif")).getImage());
    }

    public void skill1() {
    }

    public void skill2() {

    }

    public void skill3() {

    }
    
}
