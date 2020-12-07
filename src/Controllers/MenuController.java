package Controllers;

import View.MainJFrame;
import View.MenuJPanel;

import javax.swing.*;
import java.awt.event.*;

public class MenuController implements MouseListener {

    private MenuJPanel menuJPanel;

    public MenuController() {
        this.menuJPanel = new MenuJPanel();
        setComponents();
    }

    public JPanel getMenuJPanel(){
        return menuJPanel;
    }

    private void setComponents(){

        menuJPanel.getPlay_button().addMouseListener(this);
        menuJPanel.getExit_button().addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(menuJPanel.getPlay_button())){
            MainJFrameController.getMainJFrame().getC_frame().show(MainJFrameController.getMainJFrame().getAll_card_panel(), "SELECT_DIFFICULTY");
            //MainJFrameController.getMainJFrame().getC_frame().show(MainJFrameController.getMainJFrame().getAll_card_panel(), "GAME");
        } else if (e.getSource().equals(menuJPanel.getExit_button())){
            System.exit(0);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource().equals(menuJPanel.getPlay_button())){
            menuJPanel.getPlay_button().setIcon(menuJPanel.getPlay_button_active_pic());
        } else if (e.getSource().equals(menuJPanel.getExit_button())){
            menuJPanel.getExit_button().setIcon(menuJPanel.getExit_button_active_pic());
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource().equals(menuJPanel.getPlay_button())){
            menuJPanel.getPlay_button().setIcon(menuJPanel.getPlay_button_pic());
        } else if (e.getSource().equals(menuJPanel.getExit_button())){
            menuJPanel.getExit_button().setIcon(menuJPanel.getExit_button_pic());
        }
    }
}
