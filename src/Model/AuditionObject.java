package Model;

import javax.swing.*;
import java.awt.*;

public class AuditionObject {

    private Image empty, wrong;
    private Image image;
    private int size_x, size_y;
    private int position_x, position_y;
    private int type;

    public AuditionObject(){

    }

    public AuditionObject(int position_x, int position_y, int type) {
        size_x = 100;
        size_y = 100;
        this.position_x = position_x;
        this.position_y = position_y;
        this.type = type;
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

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
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

    public int getPosition_x() {
        return position_x;
    }

    public void setPosition_x(int position_x) {
        this.position_x = position_x;
    }

    public int getPosition_y() {
        return position_y;
    }

    public void setPosition_y(int position_y) {
        this.position_y = position_y;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
