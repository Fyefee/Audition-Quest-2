package project;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;
public abstract class Character extends JPanel implements Skill{
    private double hp;
    private double mp;
    private double speed;
    private double atk;
    private double def;
    private Image pic;

    public Character(double hp, double mp, double speed, double atk, double def) {
        this.hp = hp;
        this.mp = mp;
        this.speed = speed;
        this.def = def;
        this.atk = atk;
    }
    
    public void draw(Graphics g, int x) {
        g.drawImage(pic, x, 325, 140 ,180, this);
    }
    
    public void setHp(double hp) {
        this.hp = hp;
    }

    public void setMp(double mp) {
        this.mp = mp;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setAtk(double atk) {
        this.atk = atk;
    }
    
    public void setDef(double def) {
        this.def = def;
    }

    public void setPic(Image pic) {
        this.pic = pic;
    }

    public Image getPic() {
        return pic;
    }
    
    public double getHp() {
        return hp;
    }

    public double getMp() {
        return mp;
    }

    public double getSpeed() {
        return speed;
    }

    public double getAtk() {
        return atk;
    }
    
    public double getDef() {
        return def;
    }
    
}
