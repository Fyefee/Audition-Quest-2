package project;
import java.awt.Graphics;
import java.awt.Image;
import java.util.HashSet;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public abstract class Character extends JPanel implements Skill{
    private String name, attack_type = "", target = "";
    private int hp, max_hp;
    private int mp, max_mp;
    private int speed;
    private int atk;
    private int def;
    private Image pic;
    private int x, y, size_x, size_y;

    public Character(String name, int hp, int mp, int speed, int atk, int def, int size_x, int size_y) {
        this.name = name;
        this.hp = hp;
        max_hp = hp;
        this.mp = mp;
        max_mp = mp;
        this.speed = speed;
        this.def = def;
        this.atk = atk;
        this.size_x = size_x;
        this.size_y = size_y;
    }
    
    public void checkAttack() {
        if (this.getAttack_target().equals("attack")) {
            if (this.getTarget().equals("c1"))
            this.start_attack(Run.c1, 5);
            else if (this.getTarget().equals("c2"))
            this.start_attack(Run.c2, 5);
            else if (this.getTarget().equals("m1"))
            this.start_attack(Run.m1, 5);
            else if (this.getTarget().equals("m2"))
            this.start_attack(Run.m2, 5);
        }
    }
    
    public void start_attack(Character c, int arrow_count){
        if (this == Run.c1 || this == Run.c2){
            Run.start = System.nanoTime();
            Run.setMax_time(500);
            Audition.setArrow_count(arrow_count);
            Audition.setIs_random(true);
            Audition.setTime_run(true);
            Audition.setIs_show(true);
            Audition.setAttack_percent(1);

            Audition.setTarget_c(c);
            Audition.setWho_attack(this);
        }   
    }
    
    public void attack(Character c){
        try {
            System.out.println(Audition.getWho_attack().getName() + " Attack " + c.getName() + " " + ((int)((double)Audition.getWho_attack().getAtk() * Audition.getAttack_percent() - c.getDef()) + " Damage."));
            if (((int)((double)Audition.getWho_attack().getAtk() * Audition.getAttack_percent() - c.getDef())) > 0)
            c.setHp(c.getHp() - ((int)((double)Audition.getWho_attack().getAtk() * Audition.getAttack_percent()) - c.getDef()));
            
            Window.p1_hp.setText("HP : " + Run.c1.getHp() + "/" + Run.c1.getMax_hp());
            Window.p2_hp.setText("HP : " + Run.c2.getHp() + "/" + Run.c2.getMax_hp());
            Window.m1_hp.setText("HP : " + Run.m1.getHp() + "/" + Run.m1.getMax_hp());
            Window.m2_hp.setText("HP : " + Run.m2.getHp() + "/" + Run.m2.getMax_hp());
        } catch (Exception e) {}  
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

    public int getMax_mp() {
        return max_mp;
    }

    public void setMax_mp(int max_mp) {
        this.max_mp = max_mp;
    }

    public String getAttack_target() {
        return attack_type;
    }

    public void setAttack_target(String attack_target) {
        this.attack_type = attack_target;
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

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }    
    
}
