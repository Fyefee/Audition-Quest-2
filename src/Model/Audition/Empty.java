package Model.Audition;

import javax.swing.*;
import java.awt.*;

public class Empty extends AuditionObject{

    private Image image = new ImageIcon(getClass().getResource("/img/empty.png")).getImage();

    public Empty(int position_x, int position_y){
        super(position_x, position_y, 0);
        super.setImage(image);
    }

}
