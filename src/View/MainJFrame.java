package View;

import Controllers.InGameController;
import Controllers.MenuController;

import javax.swing.*;
import java.awt.*;

public class MainJFrame extends JFrame{

    private static JFrame frame;
    private static JPanel all_card_panel;
    private static CardLayout c_frame;

    public MainJFrame() {
        super("Audition Quest 2");
        createComponents();
        setComponents();

    }

    public static void createAndShowGUI(int width, int height){
        frame = new MainJFrame();
        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
        frame.add(all_card_panel);

    }

    private void createComponents(){

        all_card_panel = new JPanel();

        c_frame = new CardLayout();

    }

    private void setComponents(){

        all_card_panel.setLayout(c_frame);
        all_card_panel.add(new MenuController().getMenuJPanel(), "MENU");
        all_card_panel.add(new InGameController().getInGameJPanel(), "GAME");
        c_frame.show(all_card_panel, "MENU");

    }

    public static JFrame getFrame() {
        return frame;
    }

    public static void setFrame(JFrame frame) {
        MainJFrame.frame = frame;
    }

    public static JPanel getAll_card_panel() {
        return all_card_panel;
    }

    public static void setAll_card_panel(JPanel all_card_panel) {
        MainJFrame.all_card_panel = all_card_panel;
    }

    public static CardLayout getC_frame() {
        return c_frame;
    }

    public static void setC_frame(CardLayout c_frame) {
        MainJFrame.c_frame = c_frame;
    }
}
