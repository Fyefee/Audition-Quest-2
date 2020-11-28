package View;

import Controllers.InGameController;
import Controllers.MenuController;

import javax.swing.*;
import java.awt.*;

public class MainJFrame extends JFrame{

    private JFrame frame;
    private JPanel all_card_panel;
    private CardLayout c_frame;

    public MainJFrame() {
        super("Audition Quest 2");
        createComponents();
        setComponents();

    }

    public void createAndShowGUI(int width, int height){
        frame = new MainJFrame();
        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.add(all_card_panel);
        frame.pack();
        frame.validate();

    }

    private void createComponents(){

        all_card_panel = new JPanel();

        c_frame = new CardLayout();

    }

    private void setComponents(){

        all_card_panel.setLayout(c_frame);

        c_frame.show(all_card_panel, "MENU");

    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JPanel getAll_card_panel() {
        return all_card_panel;
    }

    public void setAll_card_panel(JPanel all_card_panel) {
        this.all_card_panel = all_card_panel;
    }

    public CardLayout getC_frame() {
        return c_frame;
    }

    public void setC_frame(CardLayout c_frame) {
        this.c_frame = c_frame;
    }
}
