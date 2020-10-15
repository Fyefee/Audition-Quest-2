/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

/**
 *
 * @author Administrator
 */
public abstract class Monster extends JPanel implements Skill{
    private String name;
    private int hp, max_hp;
    private int mp;
    private int speed;
    private int atk;
    private int def;
    private Image pic;
    private int x, y, size_x, size_y;
    
    public Monster() {
    }
    
    public Monster(String name, int hp, int mp, int speed, int atk, int def, int size_x, int size_y) {
        this.name = name;
        this.hp = hp;
        this.max_hp = hp;
        this.mp = mp;
        this.speed = speed;
        this.def = def;
        this.atk = atk;
        this.size_x = size_x;
        this.size_y = size_y;
    }
    
    public int getSize_x() {
        return size_x;
    }

    public void setSize_x(int size_x) {
        this.size_x = size_x;
    }

    public int getSize_y() {
        return size_y;
    }

    public void setSize_y(int size_y) {
        this.size_y = size_y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public void draw(Graphics g) {
        g.drawImage(pic, x, y, size_x , size_y, this);
    }
    
    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }
    
    public void setDef(int def) {
        this.def = def;
    }

    public void setPic(Image pic) {
        this.pic = pic;
    }

    public Image getPic() {
        return pic;
    }
    
    public int getHp() {
        return hp;
    }

    public int getMp() {
        return mp;
    }

    public int getSpeed() {
        return speed;
    }

    public int getAtk() {
        return atk;
    }
    
    public int getDef() {
        return def;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMax_hp() {
        return max_hp;
    }

    public void setMax_hp(int max_hp) {
        this.max_hp = max_hp;
    }
    
    
}
