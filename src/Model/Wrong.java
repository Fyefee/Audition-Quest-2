package Model;

import javax.swing.*;
import java.awt.*;

public class Wrong extends AuditionObject{

    private Image image = new ImageIcon(getClass().getResource("/img/x.png")).getImage();

    public Wrong(int position_x, int position_y){
        super(position_x, position_y, 5);
        super.setImage(image);
    }

}
