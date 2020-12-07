package View;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.InputStream;

public class SelectDifficultyPanel extends JPanel {

    public Image bg;

    public JPanel top_panel, bottom_panel;
    public JPanel easy_button_panel, medium_button_panel, hard_button_panel;
    public JLabel easy_button, medium_button, hard_button;
    private ImageIcon easy_button_pic, medium_button_pic, hard_button_pic;
    private ImageIcon easy_button_active_pic, medium_button_active_pic, hard_button_active_pic;
    private JButton back_button;

    public Font font, sizedFont;

    public SelectDifficultyPanel(){
        createComponents();
        setComponents();
    }

    public void paintComponent(Graphics g){
        super.repaint();
        g.drawImage(bg, 0, 0, 1200, 720, this);
    }

    public void createComponents(){

        bg = new ImageIcon(getClass().getResource("img/bg.gif")).getImage();

        top_panel = new JPanel();
        bottom_panel = new JPanel();

        easy_button_panel = new JPanel();
        medium_button_panel = new JPanel();
        hard_button_panel = new JPanel();

        easy_button = new JLabel();
        medium_button = new JLabel();
        hard_button = new JLabel();

        back_button = new JButton("<< Back");

        try {
            easy_button_pic = new ImageIcon(getClass().getResource("\\img\\easy_button.png"));
            medium_button_pic = new ImageIcon(getClass().getResource("\\img\\medium_button.png"));
            hard_button_pic = new ImageIcon(getClass().getResource("\\img\\hard_button.png"));
            easy_button_active_pic = new ImageIcon(getClass().getResource("\\img\\easy_button_active.png"));
            medium_button_active_pic = new ImageIcon(getClass().getResource("\\img\\medium_button_active.png"));
            hard_button_active_pic = new ImageIcon(getClass().getResource("\\img\\hard_button_active.png"));
        } catch (Exception e) {}
    }

    public void setComponents(){

        try {

            InputStream is = InGameJPanel.class.getResourceAsStream("Font/Retron2000.ttf");
            font = Font.createFont(Font.TRUETYPE_FONT, is);
            sizedFont = font.deriveFont(12f);

            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(font);

        } catch (Exception e){}

        easy_button.setIcon(easy_button_pic);
        medium_button.setIcon(medium_button_pic);
        hard_button.setIcon(hard_button_pic);

        easy_button_panel.setLayout(new FlowLayout());
        easy_button_panel.setBorder(BorderFactory.createEmptyBorder(90, 0, 0, 0));
        easy_button_panel.add(easy_button);
        easy_button_panel.setOpaque(false);

        medium_button_panel.setLayout(new FlowLayout());
        medium_button_panel.setBorder(BorderFactory.createEmptyBorder(50, 0, 0, 0));
        medium_button_panel.add(medium_button);
        medium_button_panel.setOpaque(false);

        hard_button_panel.setLayout(new FlowLayout());
        hard_button_panel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        hard_button_panel.add(hard_button);
        hard_button_panel.setOpaque(false);

        top_panel.setLayout(new GridLayout(3, 1));
        top_panel.add(easy_button_panel);
        top_panel.add(medium_button_panel);
        top_panel.add(hard_button_panel);
        top_panel.setOpaque(false);

        back_button.setFont(sizedFont.deriveFont(Font.BOLD, 35f));
        back_button.setContentAreaFilled(false);
        back_button.setForeground(Color.WHITE);
        back_button.setFocusPainted(false);
        back_button.setFocusable(false);
        back_button.setRolloverEnabled(false);
        back_button.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(5, 5, 5, 5),
                BorderFactory.createEmptyBorder(5, 5, 10, 10)));

        bottom_panel.setLayout(new BorderLayout());
        bottom_panel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 0));
        bottom_panel.add(back_button, BorderLayout.WEST);
        bottom_panel.setOpaque(false);

        this.setLayout(new BorderLayout());
        //this.add(easy_button);
        this.add(top_panel);
        this.add(bottom_panel, BorderLayout.SOUTH);
    }

    public JLabel getEasy_button() {
        return easy_button;
    }

    public void setEasy_button(JLabel easy_button) {
        this.easy_button = easy_button;
    }

    public JLabel getMedium_button() {
        return medium_button;
    }

    public void setMedium_button(JLabel medium_button) {
        this.medium_button = medium_button;
    }

    public JLabel getHard_button() {
        return hard_button;
    }

    public void setHard_button(JLabel hard_button) {
        this.hard_button = hard_button;
    }

    public ImageIcon getEasy_button_pic() {
        return easy_button_pic;
    }

    public void setEasy_button_pic(ImageIcon easy_button_pic) {
        this.easy_button_pic = easy_button_pic;
    }

    public ImageIcon getMedium_button_pic() {
        return medium_button_pic;
    }

    public void setMedium_button_pic(ImageIcon medium_button_pic) {
        this.medium_button_pic = medium_button_pic;
    }

    public ImageIcon getHard_button_pic() {
        return hard_button_pic;
    }

    public void setHard_button_pic(ImageIcon hard_button_pic) {
        this.hard_button_pic = hard_button_pic;
    }

    public ImageIcon getEasy_button_active_pic() {
        return easy_button_active_pic;
    }

    public void setEasy_button_active_pic(ImageIcon easy_button_active_pic) {
        this.easy_button_active_pic = easy_button_active_pic;
    }

    public ImageIcon getMedium_button_active_pic() {
        return medium_button_active_pic;
    }

    public void setMedium_button_active_pic(ImageIcon medium_button_active_pic) {
        this.medium_button_active_pic = medium_button_active_pic;
    }

    public ImageIcon getHard_button_active_pic() {
        return hard_button_active_pic;
    }

    public void setHard_button_active_pic(ImageIcon hard_button_active_pic) {
        this.hard_button_active_pic = hard_button_active_pic;
    }

    public JButton getBack_button() {
        return back_button;
    }

    public void setBack_button(JButton back_button) {
        this.back_button = back_button;
    }
}
