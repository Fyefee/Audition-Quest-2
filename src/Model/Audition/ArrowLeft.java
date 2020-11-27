package Model.Audition;

import javax.swing.*;
import java.awt.*;

public class ArrowLeft extends AuditionObject{

    private Image image = new ImageIcon(getClass().getResource("/img/arrow/arrow_left.png")).getImage();

    public ArrowLeft(int position_x, int position_y){
        super(position_x, position_y, 3);
        super.setImage(image);
    }

}
