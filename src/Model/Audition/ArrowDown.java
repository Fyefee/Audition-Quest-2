package Model.Audition;

import javax.swing.*;
import java.awt.*;

public class ArrowDown extends AuditionObject{

    private Image image = new ImageIcon(getClass().getResource("/img/arrow/arrow_down.png")).getImage();

    public ArrowDown(int position_x, int position_y){
        super(position_x, position_y, 2);
        super.setImage(image);
    }

}
