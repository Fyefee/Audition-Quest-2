package project;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;
public abstract class Character extends JPanel implements Skill{
    private String name;
    private int hp, max_hp;
    private int mp, max_mp;
    private int speed;
    private int atk;
    private int def;
    private Image pic;
    private int size_x, size_y;

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
    
    public void draw(Graphics g, int x) {
        g.drawImage(pic, x, 290, size_x , size_y, this);
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
    
    
}
