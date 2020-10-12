package project;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;
public abstract class Character extends JPanel implements Skill{
    private int hp;
    private int mp;
    private int speed;
    private int atk;
    private int def;
    private Image pic;

    public Character(int hp, int mp, int speed, int atk, int def) {
        this.hp = hp;
        this.mp = mp;
        this.speed = speed;
        this.def = def;
        this.atk = atk;
    }
    
    public void draw(Graphics g, int x) {
        g.drawImage(pic, x, 325, 140 ,180, this);
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
    
}
