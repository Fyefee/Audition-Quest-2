package View;

import Controllers.InGameController;
import Model.Audition.AuditionObject;
import Model.InGameModel;

import javax.swing.*;
import java.awt.*;
import java.io.InputStream;
import java.util.ArrayList;

public class InGameRenderImage extends JPanel {

    private InGameController inGameController;
    private InGameModel inGameModel;
    private ArrayList<AuditionObject> audition = new ArrayList<AuditionObject>();
    private Image sack, empty_card;

    public Font font, sizedFont, sizedFont2;

    public InGameRenderImage(InGameController run){
        inGameController = run;
        inGameModel = inGameController.getInGameModel();

        try {

            InputStream is = InGameJPanel.class.getResourceAsStream("Font/Retron2000.ttf");
            font = Font.createFont(Font.TRUETYPE_FONT, is);
            sizedFont = font.deriveFont(45f);
            sizedFont2  = font.deriveFont(25f);

            sack = new ImageIcon(getClass().getResource("img/sack.png")).getImage();
            empty_card = new ImageIcon(getClass().getResource("img/empty_card.png")).getImage();

        } catch (Exception e){}

    }

    public void paintComponent(Graphics g) {
        g.setFont(sizedFont2);
        g.drawImage(inGameModel.getBg().bg, 0, 0, this);
        audition(g);
        if (inGameModel.getC1().isAlive()) {
            g.drawImage(inGameModel.getC1().getPic(), inGameModel.getC1().getX(), inGameModel.getC1().getY() + inGameModel.getChangeY(), inGameModel.getC1().getSize_x(), inGameModel.getC1().getSize_y(), this);
        }
        if (inGameModel.getC2().isAlive()) {
            g.drawImage(inGameModel.getC2().getPic(), inGameModel.getC2().getX(), inGameModel.getC2().getY() + inGameModel.getChangeY(), inGameModel.getC2().getSize_x(), inGameModel.getC2().getSize_y(), this);
        }
        if (inGameModel.getM1().isAlive()) {
            g.drawImage(inGameModel.getM1().getPic(), inGameModel.getM1().getX(), inGameModel.getM1().getY() + inGameModel.getChangeY(), inGameModel.getM1().getSize_x(), inGameModel.getM1().getSize_y(), this);
        } else if (!inGameModel.getM1().isAlive() && inGameModel.isMonster1_drop()){
            g.drawImage(sack, 790, 410 + inGameModel.getChangeY(), 60, 60, this);
        }
        if (inGameModel.getM2().isAlive()) {
            g.drawImage(inGameModel.getM2().getPic(), inGameModel.getM2().getX(), inGameModel.getM2().getY() + inGameModel.getChangeY(), inGameModel.getM2().getSize_x(), inGameModel.getM2().getSize_y(), this);
        } else if (!inGameModel.getM2().isAlive() && inGameModel.isMonster2_drop()){
            g.drawImage(sack, 960, 410 + inGameModel.getChangeY(), 60, 60, this);
        }

        if (inGameModel.isShow_item()){
            g.drawImage(empty_card, 500, 30, 260, 470, this);
            g.setColor(new Color(255,255,255));
            g.drawString(inGameModel.getItem_drop().getName(), inGameModel.getItem_drop().getText_x(), inGameModel.getItem_drop().getText_y());
        }

        g.dispose();
    }

    public void audition(Graphics g){

        if (inGameController.getAuditionController().getAuditionModel().getAudition_is_show()){
            g.setFont(sizedFont);

            g.setColor(new Color(120,120,120));
            g.fillRect(100, 100, 1000, 100);

            g.setColor(new Color(0,255,0));
            g.fillRect(inGameController.getAuditionController().getTimeBar().getPosition_x(), inGameController.getAuditionController().getTimeBar().getPosition_y(), inGameController.getAuditionController().getTimeBar().getSize_x(), inGameController.getAuditionController().getTimeBar().getSize_y());

            if (inGameController.getAuditionController().getAuditionModel().isIs_arrow_overflow()){

                g.setColor(new Color(120,120,120));
                g.fillRect(1100, 150, 50, 50);
                g.setColor(new Color(0,255,0));
                g.drawString(Integer.toString(inGameController.getAuditionController().getAuditionModel().getOverflow_count()), 1110, 192);

                for (int i = inGameController.getAuditionController().getAuditionModel().getAudition_first_index(); i < inGameController.getAuditionController().getAuditionModel().getAudition_final_index(); i++){
                    g.drawImage(audition.get(i).getImage(), audition.get(i).getPosition_x(), audition.get(i).getPosition_y(), audition.get(i).getSize_x(), audition.get(i).getSize_y(), this);
                }
            } else {
                for (int i = inGameController.getAuditionController().getAuditionModel().getAudition_first_index(); i < inGameController.getAuditionController().getAuditionModel().getArrow_count(); i++){
                    g.drawImage(audition.get(i).getImage(), audition.get(i).getPosition_x(), audition.get(i).getPosition_y(), audition.get(i).getSize_x(), audition.get(i).getSize_y(), this);
                }
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
