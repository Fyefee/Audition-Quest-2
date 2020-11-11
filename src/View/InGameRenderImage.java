package View;

import Controllers.AuditionController;
import Controllers.InGameController;
import Model.Arrow;

import javax.swing.*;
import java.awt.*;

public class InGameRenderImage extends JPanel {

    private InGameController inGameController;
    private Arrow arrow;
    private Graphics g;

    private int x, y;

    public InGameRenderImage(InGameController run){
        inGameController = run;
        arrow = new Arrow();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(inGameController.bg.bg, 0, 0, this);
        audition(g);
        g.drawImage(inGameController.getC1().getPic(), inGameController.getC1().getX(), inGameController.getC1().getY(), inGameController.getC1().getSize_x(), inGameController.getC1().getSize_y(), this);
        g.drawImage(inGameController.getC2().getPic(), inGameController.getC2().getX(), inGameController.getC2().getY(), inGameController.getC2().getSize_x(), inGameController.getC2().getSize_y(), this);
        g.drawImage(inGameController.getM1().getPic(), inGameController.getM1().getX(), inGameController.getM1().getY(), inGameController.getM1().getSize_x(), inGameController.getM1().getSize_y(), this);
        g.drawImage(inGameController.getM2().getPic(), inGameController.getM2().getX(), inGameController.getM2().getY(), inGameController.getM2().getSize_x(), inGameController.getM2().getSize_y(), this);
        g.dispose();
    }

    public void audition(Graphics g){
        if (inGameController.getAuditionController().isIs_show()){
            x = 100;
            y = 100;

            g.setColor(new Color(120,120,120));
            g.fillRect(100, 100, 1000, 100);

            g.setColor(new Color(0,255,0));
            g.fillRect(100, 200, inGameController.getAuditionController().getWidth(), 10);
            for (int i = 0; i < inGameController.getAuditionController().getRandom().length; i++){
                switch (inGameController.getAuditionController().getRandom()[i]){
                    case 0: g.drawImage(arrow.getEmpty(), x, y, 100, 100, this); break;
                    case 1: g.drawImage(arrow.getArrow_up(), x, y, 100, 100, this); break;
                    case 2: g.drawImage(arrow.getArrow_down(), x, y, 100, 100, this); break;
                    case 3: g.drawImage(arrow.getArrow_left(), x, y, 100, 100, this); break;
                    case 4: g.drawImage(arrow.getArrow_right(), x, y, 100, 100, this); break;
                    case 5: g.drawImage(arrow.getWrong(), x, y, 100, 100, this); break;
                    default: break;
                }
                x += 100;
            }
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1200,520);
    }
}
