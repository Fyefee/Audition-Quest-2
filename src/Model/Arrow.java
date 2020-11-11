package Model;

import javax.swing.*;
import java.awt.*;

public class Arrow {

    private Image arrow_up, arrow_down, arrow_left, arrow_right, empty, wrong;

    public Arrow() {
        try {
            arrow_up = new ImageIcon(getClass().getResource("/img/arrow/arrow_up.png")).getImage();
            arrow_down = new ImageIcon(getClass().getResource("/img/arrow/arrow_down.png")).getImage();
            arrow_left = new ImageIcon(getClass().getResource("/img/arrow/arrow_left.png")).getImage();
            arrow_right = new ImageIcon(getClass().getResource("/img/arrow/arrow_right.png")).getImage();
            empty = new ImageIcon(getClass().getResource("/img/empty.png")).getImage();
            wrong = new ImageIcon(getClass().getResource("/img/x.png")).getImage();
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public Image getArrow_up() {
        return arrow_up;
    }

    public void setArrow_up(Image arrow_up) {
        this.arrow_up = arrow_up;
    }

    public Image getArrow_down() {
        return arrow_down;
    }

    public void setArrow_down(Image arrow_down) {
        this.arrow_down = arrow_down;
    }

    public Image getArrow_left() {
        return arrow_left;
    }

    public void setArrow_left(Image arrow_left) {
        this.arrow_left = arrow_left;
    }

    public Image getArrow_right() {
        return arrow_right;
    }

    public void setArrow_right(Image arrow_right) {
        this.arrow_right = arrow_right;
    }

    public Image getEmpty() {
        return empty;
    }

    public void setEmpty(Image empty) {
        this.empty = empty;
    }

    public Image getWrong() {
        return wrong;
    }

    public void setWrong(Image wrong) {
        this.wrong = wrong;
    }
}
