package Controllers;

import Model.SelectCharacterModel;
import View.MeleeCharacterSelectPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SelectCharacterController implements ActionListener, MouseListener {

    private MeleeCharacterSelectPanel meleeCharacterSelectPanel;

    private SelectCharacterModel selectCharacterModel;

    public SelectCharacterController(){
        createComponents();
        setComponents();
    }

    public void createComponents(){
        meleeCharacterSelectPanel = new MeleeCharacterSelectPanel();
        selectCharacterModel = new SelectCharacterModel();
    }

    public void setComponents(){

        meleeCharacterSelectPanel.getKnight_button().addActionListener(this);
        meleeCharacterSelectPanel.getKnight_button().addMouseListener(this);

        meleeCharacterSelectPanel.getDuelist_button().addActionListener(this);
        meleeCharacterSelectPanel.getDuelist_button().addMouseListener(this);

        meleeCharacterSelectPanel.getBerserker_button().addActionListener(this);
        meleeCharacterSelectPanel.getBerserker_button().addMouseListener(this);

        meleeCharacterSelectPanel.getDruid_button().addActionListener(this);
        meleeCharacterSelectPanel.getDruid_button().addMouseListener(this);

        meleeCharacterSelectPanel.getNext_button().addActionListener(this);
        meleeCharacterSelectPanel.getNext_button().addMouseListener(this);

        meleeCharacterSelectPanel.getBack_button().addActionListener(this);
        meleeCharacterSelectPanel.getBack_button().addMouseListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(meleeCharacterSelectPanel.getKnight_button())){
            meleeCharacterSelectPanel.getKnight_button().setBorder(BorderFactory.createLineBorder(Color.YELLOW, 4));
            selectCharacterModel.setCharacter_select_melee(1);
            meleeCharacterSelectPanel.getDuelist_button().setBorder(null);
            meleeCharacterSelectPanel.getDruid_button().setBorder(null);
            meleeCharacterSelectPanel.getBerserker_button().setBorder(null);
        } else if (e.getSource().equals(meleeCharacterSelectPanel.getDuelist_button())){
            meleeCharacterSelectPanel.getDuelist_button().setBorder(BorderFactory.createLineBorder(Color.YELLOW, 4));
            selectCharacterModel.setCharacter_select_melee(2);
            meleeCharacterSelectPanel.getKnight_button().setBorder(null);
            meleeCharacterSelectPanel.getDruid_button().setBorder(null);
            meleeCharacterSelectPanel.getBerserker_button().setBorder(null);
        } else if (e.getSource().equals(meleeCharacterSelectPanel.getBerserker_button())){
            meleeCharacterSelectPanel.getBerserker_button().setBorder(BorderFactory.createLineBorder(Color.YELLOW, 4));
            selectCharacterModel.setCharacter_select_melee(3);
            meleeCharacterSelectPanel.getKnight_button().setBorder(null);
            meleeCharacterSelectPanel.getDruid_button().setBorder(null);
            meleeCharacterSelectPanel.getDuelist_button().setBorder(null);
        } else if (e.getSource().equals(meleeCharacterSelectPanel.getDruid_button())){
            meleeCharacterSelectPanel.getDruid_button().setBorder(BorderFactory.createLineBorder(Color.YELLOW, 4));
            selectCharacterModel.setCharacter_select_melee(4);
            meleeCharacterSelectPanel.getKnight_button().setBorder(null);
            meleeCharacterSelectPanel.getDuelist_button().setBorder(null);
            meleeCharacterSelectPanel.getBerserker_button().setBorder(null);
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
        if (e.getSource().equals(meleeCharacterSelectPanel.getKnight_button()) && selectCharacterModel.getCharacter_select_melee() != 1){
            meleeCharacterSelectPanel.getKnight_button().setBorder(BorderFactory.createLineBorder(Color.WHITE, 4));;
        } else if (e.getSource().equals(meleeCharacterSelectPanel.getDuelist_button()) && selectCharacterModel.getCharacter_select_melee() != 2){
            meleeCharacterSelectPanel.getDuelist_button().setBorder(BorderFactory.createLineBorder(Color.WHITE, 4));
        } else if (e.getSource().equals(meleeCharacterSelectPanel.getBerserker_button()) && selectCharacterModel.getCharacter_select_melee() != 3){
            meleeCharacterSelectPanel.getBerserker_button().setBorder(BorderFactory.createLineBorder(Color.WHITE, 4));
        } else if (e.getSource().equals(meleeCharacterSelectPanel.getDruid_button()) && selectCharacterModel.getCharacter_select_melee() != 4){
            meleeCharacterSelectPanel.getDruid_button().setBorder(BorderFactory.createLineBorder(Color.WHITE, 4));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource().equals(meleeCharacterSelectPanel.getKnight_button()) && selectCharacterModel.getCharacter_select_melee() != 1){
            meleeCharacterSelectPanel.getKnight_button().setBorder(null);
        } else if (e.getSource().equals(meleeCharacterSelectPanel.getDuelist_button()) && selectCharacterModel.getCharacter_select_melee() != 2){
            meleeCharacterSelectPanel.getDuelist_button().setBorder(null);
        } else if (e.getSource().equals(meleeCharacterSelectPanel.getBerserker_button()) && selectCharacterModel.getCharacter_select_melee() != 3){
            meleeCharacterSelectPanel.getBerserker_button().setBorder(null);
        } else if (e.getSource().equals(meleeCharacterSelectPanel.getDruid_button()) && selectCharacterModel.getCharacter_select_melee() != 4){
            meleeCharacterSelectPanel.getDruid_button().setBorder(null);
        }
    }

    public MeleeCharacterSelectPanel getMeleeCharacterSelectPanel() {
        return meleeCharacterSelectPanel;
    }

    public void setMeleeCharacterSelectPanel(MeleeCharacterSelectPanel meleeCharacterSelectPanel) {
        this.meleeCharacterSelectPanel = meleeCharacterSelectPanel;
    }

}
