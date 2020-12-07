package Controllers;

import Model.SelectCharacterModel;
import View.MeleeCharacterSelectPanel;
import View.SelectDifficultyPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SelectDifficultyController implements ActionListener, MouseListener {

    private SelectDifficultyPanel selectDifficultyPanel;

    public SelectDifficultyController(){
        createComponents();
        setComponents();
    }

    public void createComponents(){
        selectDifficultyPanel = new SelectDifficultyPanel();
    }

    public void setComponents(){

        selectDifficultyPanel.getEasy_button().addMouseListener(this);
        selectDifficultyPanel.getMedium_button().addMouseListener(this);
        selectDifficultyPanel.getHard_button().addMouseListener(this);

        selectDifficultyPanel.getBack_button().addMouseListener(this);
        selectDifficultyPanel.getBack_button().addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(selectDifficultyPanel.getEasy_button())){
            MainJFrameController.getInGameController().getInGameModel().setDifficulty("Easy");
            MainJFrameController.getMainJFrame().getC_frame().show(MainJFrameController.getMainJFrame().getAll_card_panel(), "SELECT_MELEE");
        } else if (e.getSource().equals(selectDifficultyPanel.getMedium_button())){
            MainJFrameController.getInGameController().getInGameModel().setDifficulty("Medium");
            MainJFrameController.getMainJFrame().getC_frame().show(MainJFrameController.getMainJFrame().getAll_card_panel(), "SELECT_MELEE");
        } else if (e.getSource().equals(selectDifficultyPanel.getHard_button())){
            MainJFrameController.getInGameController().getInGameModel().setDifficulty("Hard");
            MainJFrameController.getMainJFrame().getC_frame().show(MainJFrameController.getMainJFrame().getAll_card_panel(), "SELECT_MELEE");
        } else if (e.getSource().equals(selectDifficultyPanel.getBack_button())){
            MainJFrameController.getMainJFrame().getC_frame().show(MainJFrameController.getMainJFrame().getAll_card_panel(), "MENU");
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
        if (e.getSource().equals(selectDifficultyPanel.getEasy_button())){
            selectDifficultyPanel.getEasy_button().setIcon(selectDifficultyPanel.getEasy_button_active_pic());
        } else if (e.getSource().equals(selectDifficultyPanel.getMedium_button())){
            selectDifficultyPanel.getMedium_button().setIcon(selectDifficultyPanel.getMedium_button_active_pic());
        } else if (e.getSource().equals(selectDifficultyPanel.getHard_button())){
            selectDifficultyPanel.getHard_button().setIcon(selectDifficultyPanel.getHard_button_active_pic());
        } else if (e.getSource().equals(selectDifficultyPanel.getBack_button())){
            selectDifficultyPanel.getBack_button().setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(Color.CYAN, 5),
                    BorderFactory.createEmptyBorder(5, 5, 10, 10)));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource().equals(selectDifficultyPanel.getEasy_button())){
            selectDifficultyPanel.getEasy_button().setIcon(selectDifficultyPanel.getEasy_button_pic());
        } else if (e.getSource().equals(selectDifficultyPanel.getMedium_button())){
            selectDifficultyPanel.getMedium_button().setIcon(selectDifficultyPanel.getMedium_button_pic());
        } else if (e.getSource().equals(selectDifficultyPanel.getHard_button())){
            selectDifficultyPanel.getHard_button().setIcon(selectDifficultyPanel.getHard_button_pic());
        } else if (e.getSource().equals(selectDifficultyPanel.getBack_button())){
            selectDifficultyPanel.getBack_button().setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createEmptyBorder(5, 5, 5, 5),
                    BorderFactory.createEmptyBorder(5, 5, 10, 10)));
        }
    }

    public SelectDifficultyPanel getSelectDifficultyPanel() {
        return selectDifficultyPanel;
    }

    public void setSelectDifficultyPanel(SelectDifficultyPanel selectDifficultyPanel) {
        this.selectDifficultyPanel = selectDifficultyPanel;
    }
}
