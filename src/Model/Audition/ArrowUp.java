package Model.Audition;

import javax.swing.*;
import java.awt.*;

public class ArrowUp extends AuditionObject{

    private Image image = new ImageIcon(getClass().getResource("/img/arrow/arrow_up.png")).getImage();

    public ArrowUp(int position_x, int position_y){
        super(position_x, position_y, 1);
        super.setImage(image);
    }

}
