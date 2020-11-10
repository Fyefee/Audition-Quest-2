package View;

import Controllers.AuditionController;
import Controllers.InGameController;

import javax.swing.*;
import java.awt.*;

public class InGameRenderImage extends JPanel {

    private InGameController inGameController;
    private Graphics g;

    public InGameRenderImage(InGameController run){
        inGameController = run;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(inGameController.bg.bg, 0, 0, this);
        test(g);
        g.drawImage(inGameController.getC1().getPic(), inGameController.getC1().getX(), inGameController.getC1().getY(), inGameController.getC1().getSize_x(), inGameController.getC1().getSize_y(), this);
        g.drawImage(inGameController.getC2().getPic(), inGameController.getC2().getX(), inGameController.getC2().getY(), inGameController.getC2().getSize_x(), inGameController.getC2().getSize_y(), this);
        g.drawImage(inGameController.getM1().getPic(), inGameController.getM1().getX(), inGameController.getM1().getY(), inGameController.getM1().getSize_x(), inGameController.getM1().getSize_y(), this);
        g.drawImage(inGameController.getM2().getPic(), inGameController.getM2().getX(), inGameController.getM2().getY(), inGameController.getM2().getSize_x(), inGameController.getM2().getSize_y(), this);
        g.dispose();
    }

    public void test(Graphics g){
        if (AuditionController.getRandom() != null){
            g.drawImage(inGameController.getC1().getPic(), 100, 100, inGameController.getC1().getSize_x(), inGameController.getC1().getSize_y(), this);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1200,520);
    }
}
