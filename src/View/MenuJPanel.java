package View;

import Controllers.MenuController;

import javax.swing.*;
import java.awt.*;

public class MenuJPanel extends JPanel{

    public Image bg;

    private JPanel menu_button_panel, logo_panel, play_button_panel, exit_button_panel;
    private JLabel logo_label, play_button, exit_button;
    private ImageIcon logo, play_button_pic, play_button_active_pic, exit_button_pic, exit_button_active_pic;
    private MenuController mc;

    public MenuJPanel() {
        createComponents();
        setComponents();
    }

    public void paintComponent(Graphics g){
        super.repaint();
        g.drawImage(bg, 0, 0, 1200, 720, this);
    }

    private void createComponents(){

        bg = new ImageIcon(getClass().getResource("img/bg.gif")).getImage();

        menu_button_panel = new JPanel();
        logo_panel = new JPanel();
        play_button_panel = new JPanel();
        exit_button_panel = new JPanel();

        logo_label = new JLabel();

        play_button = new JLabel();
        exit_button = new JLabel();

        try {
            logo = new ImageIcon(getClass().getResource("\\img\\logo.png"));
            play_button_pic = new ImageIcon(getClass().getResource("\\img\\play_button.png"));
            play_button_active_pic = new ImageIcon(getClass().getResource("\\img\\play_button_active.png"));
            exit_button_pic = new ImageIcon(getClass().getResource("\\img\\exit_button.png"));
            exit_button_active_pic = new ImageIcon(getClass().getResource("\\img\\exit_button_active.png"));
        } catch (Exception e) {}

    }

    private void setComponents(){

        this.setLayout(new GridLayout(2,1));

        logo_label.setIcon(logo);

        logo_panel.setBorder(BorderFactory.createEmptyBorder(100, 0, 0, 0));
        logo_panel.setOpaque(false);
        logo_panel.add(logo_label);

        play_button.setIcon(play_button_pic);
        exit_button.setIcon(exit_button_pic);

        menu_button_panel.setLayout(new GridLayout(2,1));
        menu_button_panel.setOpaque(false);

        play_button_panel.setLayout(new FlowLayout());
        play_button_panel.setBorder(BorderFactory.createEmptyBorder(40, 0, 0, 0));
        play_button_panel.setOpaque(false);
        play_button_panel.add(play_button);

        exit_button_panel.setLayout(new FlowLayout());
        exit_button_panel.setOpaque(false);
        exit_button_panel.add(exit_button);

        menu_button_panel.add(play_button_panel);
        menu_button_panel.add(exit_button_panel);

        this.add(logo_panel);
        this.add(menu_button_panel);

    }

    public JPanel getMenu_button_panel() {
        return menu_button_panel;
    }

    public void setMenu_button_panel(JPanel menu_button_panel) {
        this.menu_button_panel = menu_button_panel;
    }

    public JPanel getLogo_panel() {
        return logo_panel;
    }

    public void setLogo_panel(JPanel logo_panel) {
        this.logo_panel = logo_panel;
    }

    public MenuController getMc() {
        return mc;
    }

    public void setMc(MenuController mc) {
        this.mc = mc;
    }

    public JLabel getPlay_button() {
        return play_button;
    }

    public void setPlay_button(JLabel play_button) {
        this.play_button = play_button;
    }

    public JLabel getExit_button() {
        return exit_button;
    }

    public void setExit_button(JLabel exit_button) {
        this.exit_button = exit_button;
    }

    public ImageIcon getPlay_button_pic() {
        return play_button_pic;
    }

    public void setPlay_button_pic(ImageIcon play_button_pic) {
        this.play_button_pic = play_button_pic;
    }

    public ImageIcon getPlay_button_active_pic() {
        return play_button_active_pic;
    }

    public void setPlay_button_active_pic(ImageIcon play_button_active_pic) {
        this.play_button_active_pic = play_button_active_pic;
    }

    public ImageIcon getExit_button_pic() {
        return exit_button_pic;
    }

    public void setExit_button_pic(ImageIcon exit_button_pic) {
        this.exit_button_pic = exit_button_pic;
    }

    public ImageIcon getExit_button_active_pic() {
        return exit_button_active_pic;
    }

    public void setExit_button_active_pic(ImageIcon exit_button_active_pic) {
        this.exit_button_active_pic = exit_button_active_pic;
    }
}
