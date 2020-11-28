package Model;

import javax.swing.*;
import java.awt.*;

public class ArrowRight extends AuditionObject{

    private Image image = new ImageIcon(getClass().getResource("/img/arrow/arrow_right.png")).getImage();

    public ArrowRight(int position_x, int position_y){
        super(position_x, position_y, 4);
        super.setImage(image);
    }

}
