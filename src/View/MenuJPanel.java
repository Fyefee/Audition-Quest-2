package View;

import Controllers.MenuController;

import javax.swing.*;
import java.awt.*;

public class MenuJPanel extends JPanel{

    private JPanel menu_panel, menu_button_panel, empty_panel_top;
    private static JButton menu_button_play;
    private MenuController mc;

    public MenuJPanel(MenuController mc) {
        this.mc = mc;
        createComponents();
        setComponents();
    }

    private void createComponents(){

        menu_button_panel = new JPanel();

        menu_button_play = new JButton("Start");

        empty_panel_top = new JPanel();
        empty_panel_top.setPreferredSize(new Dimension(1200, 100));

    }

    private void setComponents(){

        this.setLayout(new BorderLayout());

        menu_button_panel.setLayout(new FlowLayout());

        menu_button_play.addActionListener(this.mc);
        menu_button_panel.add(menu_button_play);

        this.add(empty_panel_top, BorderLayout.NORTH);
        this.add(menu_button_panel, BorderLayout.CENTER);

    }

    public JPanel getMenu_panel() {
        return menu_panel;
    }

    public void setMenu_panel(JPanel menu_panel) {
        this.menu_panel = menu_panel;
    }

    public JPanel getMenu_button_panel() {
        return menu_button_panel;
    }

    public void setMenu_button_panel(JPanel menu_button_panel) {
        this.menu_button_panel = menu_button_panel;
    }

    public JPanel getEmpty_panel_top() {
        return empty_panel_top;
    }

    public void setEmpty_panel_top(JPanel empty_panel_top) {
        this.empty_panel_top = empty_panel_top;
    }

    public JButton getMenu_button_play() {
        return menu_button_play;
    }

    public void setMenu_button_play(JButton menu_button_play) {
        this.menu_button_play = menu_button_play;
    }

    public MenuController getMc() {
        return mc;
    }

    public void setMc(MenuController mc) {
        this.mc = mc;
    }
}
