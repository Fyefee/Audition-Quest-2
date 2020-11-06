package View;

import Controllers.MenuController;
import project.Run;

import javax.swing.*;
import java.awt.*;

public class MainJFrame extends JFrame{

    private static JFrame frame;
    private static JPanel all_card_panel;
    private CardLayout c_frame;

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
        c_frame.show(all_card_panel, "MENU");
    }

}
