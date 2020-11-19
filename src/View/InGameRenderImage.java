package View;

import Controllers.InGameController;
import Model.ArrowUp;
import Model.AuditionObject;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class InGameRenderImage extends JPanel {

    private InGameController inGameController;
    private Graphics g;
    private ArrayList<AuditionObject> audition = new ArrayList<AuditionObject>();

    private int x, y;


    public InGameRenderImage(InGameController run){
        inGameController = run;

    }

    public void paintComponent(Graphics g) {
        g.drawImage(inGameController.bg.bg, 0, 0, this);
        audition(g);
        if (inGameController.getC1().isAlive()) {
            g.drawImage(inGameController.getC1().getPic(), inGameController.getC1().getX(), inGameController.getC1().getY(), inGameController.getC1().getSize_x(), inGameController.getC1().getSize_y(), this);
        }
        if (inGameController.getC2().isAlive()) {
            g.drawImage(inGameController.getC2().getPic(), inGameController.getC2().getX(), inGameController.getC2().getY(), inGameController.getC2().getSize_x(), inGameController.getC2().getSize_y(), this);
        }
        if (inGameController.getM1().isAlive()) {
            g.drawImage(inGameController.getM1().getPic(), inGameController.getM1().getX(), inGameController.getM1().getY(), inGameController.getM1().getSize_x(), inGameController.getM1().getSize_y(), this);
        }
        if (inGameController.getM2().isAlive()) {
            g.drawImage(inGameController.getM2().getPic(), inGameController.getM2().getX(), inGameController.getM2().getY(), inGameController.getM2().getSize_x(), inGameController.getM2().getSize_y(), this);
        }
        g.dispose();
    }

    public void audition(Graphics g){

        if (inGameController.getAuditionController().getAudition_is_show()){
            x = 100;
            y = 100;

            g.setColor(new Color(120,120,120));
            g.fillRect(100, 100, 1000, 100);

            g.setColor(new Color(0,255,0));
            g.fillRect(inGameController.getAuditionController().getTimeBar().getPosition_x(), inGameController.getAuditionController().getTimeBar().getPosition_y(), inGameController.getAuditionController().getTimeBar().getSize_x(), inGameController.getAuditionController().getTimeBar().getSize_y());

            for (int i = 0; i < audition.size(); i++){
                g.drawImage(audition.get(i).getImage(), audition.get(i).getPosition_x(), audition.get(i).getPosition_y(), audition.get(i).getSize_x(), audition.get(i).getSize_y(), this);
            }
        }

    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1200,520);
    }

    public ArrayList<AuditionObject> getAudition() {
        return audition;
    }

    public void setAudition(ArrayList<AuditionObject> audition) {
        this.audition = audition;
    }

}
