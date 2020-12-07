package Controllers;

import View.MainJFrame;
import View.MenuJPanel;

import javax.swing.*;
import java.awt.event.*;

public class MenuController implements ActionListener, MouseListener {

    private MenuJPanel menuJPanel;

    public MenuController() {
        this.menuJPanel = new MenuJPanel();
        setComponents();
    }

    public JPanel getMenuJPanel(){
        return menuJPanel;
    }

    private void setComponents(){
        menuJPanel.getMenu_button_play().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(menuJPanel.getMenu_button_play())){
//            MainJFrameController.getInGameController().getInGameModel().setStageEasy();
//            MainJFrameController.getInGameController().getInGameModel().setStage(1);
//            MainJFrameController.getInGameController().getStageJPanel().getStage_label().setText("Stage " + String.valueOf(MainJFrameController.getInGameController().getInGameModel().getStage()));
//            MainJFrameController.getMainJFrame().getC_frame().show(MainJFrameController.getMainJFrame().getAll_card_panel(), "STAGE");
            MainJFrameController.getMainJFrame().getC_frame().show(MainJFrameController.getMainJFrame().getAll_card_panel(), "SELECT_DIFFICULTY");
            //MainJFrameController.getMainJFrame().getC_frame().show(MainJFrameController.getMainJFrame().getAll_card_panel(), "SELECT_MELEE");
            //MainJFrameController.getMainJFrame().getC_frame().show(MainJFrameController.getMainJFrame().getAll_card_panel(), "SELECT_RANGE");
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
