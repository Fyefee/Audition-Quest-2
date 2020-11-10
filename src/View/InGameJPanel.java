package View;

import Controllers.InGameController;
import Controllers.MenuController;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.io.InputStream;
import Controllers.*;
public class InGameJPanel extends JPanel {

    private JPanel top_panel, bottom_panel;

    private JPanel player_panel, monster_panel;

    private JPanel p1_stat_panel, p2_stat_panel, p1_panel, p2_panel;
    private static JLabel p1_name, p2_name, p1_hp, p2_hp, p1_mp, p2_mp, p1_speed, p2_speed;
    private JPanel m1_stat_panel, m2_stat_panel, m1_panel, m2_panel;
    private static JLabel m1_name, m2_name, m1_hp, m2_hp, m1_speed, m2_speed;

    private Icon bg;

    public Font font, sizedFont;
    private Font customFont;

    private Border border_white = new LineBorder(Color.WHITE, 4, true);
    private Border border_red = new LineBorder(new Color(255, 72, 59), 4, true);

    private Color button_select = new Color(120, 125, 129);

    private InGameController igc;

    private InGameButtonJPanel inGameButtonJPanel;

    public InGameJPanel(InGameController igc){
        this.igc = igc;
        createComponents();
        setComponents();
    }

    private void createComponents(){

        top_panel = new JPanel();
        bottom_panel = new JPanel();

        player_panel = new JPanel();
        monster_panel = new JPanel();

        p1_panel = new JPanel();
        p2_panel = new JPanel();

        p1_name = new JLabel(igc.getC1().getName(), SwingConstants.CENTER);
        p2_name = new JLabel(igc.getC2().getName(), SwingConstants.CENTER);

        p1_stat_panel = new JPanel();
        p1_hp = new JLabel("HP : " + igc.getC1().getHp() + "/" + igc.getC1().getMax_hp(), SwingConstants.CENTER);
        p1_mp = new JLabel("MP : " + igc.getC1().getMp() + "/" + igc.getC1().getMax_mp(), SwingConstants.CENTER);
        p1_speed = new JLabel("Speed : " + igc.getC1().getSpeed(), SwingConstants.CENTER);

        p2_stat_panel = new JPanel();
        p2_hp = new JLabel("HP : " + igc.getC2().getHp() + "/" + igc.getC2().getMax_hp(), SwingConstants.CENTER);
        p2_mp = new JLabel("MP : " + igc.getC2().getMp() + "/" + igc.getC2().getMax_mp(), SwingConstants.CENTER);
        p2_speed = new JLabel("Speed : " + igc.getC2().getSpeed(), SwingConstants.CENTER);

        m1_panel = new JPanel();
        m2_panel = new JPanel();

        m1_name = new JLabel(igc.getM1().getName(), SwingConstants.CENTER);
        m2_name = new JLabel(igc.getM2().getName(), SwingConstants.CENTER);

        m1_stat_panel = new JPanel();
        m1_hp = new JLabel("HP : " + igc.getM1().getHp() + "/" + igc.getM1().getMax_hp(), SwingConstants.CENTER);
        m1_speed = new JLabel("Speed : " + igc.getM1().getSpeed(), SwingConstants.CENTER);

        m2_stat_panel = new JPanel();
        m2_hp = new JLabel("HP : " + igc.getM2().getHp() + "/" + igc.getM2().getMax_hp(), SwingConstants.CENTER);
        m2_speed = new JLabel("Speed : " + igc.getM2().getSpeed(), SwingConstants.CENTER);

    }

    private void setComponents(){

        try {

            InputStream is = InGameJPanel.class.getResourceAsStream("Font/Retron2000.ttf");
            font = Font.createFont(Font.TRUETYPE_FONT, is);
            sizedFont = font.deriveFont(12f);

            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(font);

        } catch (Exception e){}

        this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

        bottom_panel.setLayout(new GridLayout(1, 3));
        bottom_panel.setPreferredSize(new Dimension(1200, 200));

        player_panel.setLayout(new GridLayout(2, 1));

        p1_panel.setLayout(new GridLayout(1, 2));
        p1_panel.setBackground(new Color(64, 72, 80));
        p1_panel.setBorder(border_white);

        p1_stat_panel.setBackground(new Color(64, 72, 80));
        p1_stat_panel.setLayout(new GridLayout(3, 1));
        p1_name.setFont(sizedFont.deriveFont(Font.BOLD, 30f));
        p1_name.setForeground(Color.WHITE);
        p1_hp.setFont(sizedFont.deriveFont(Font.BOLD, 20f));
        p1_hp.setForeground(Color.WHITE);
        p1_mp.setFont(sizedFont.deriveFont(Font.BOLD, 20f));
        p1_mp.setForeground(Color.WHITE);
        p1_speed.setFont(sizedFont.deriveFont(Font.BOLD, 20f));
        p1_speed.setForeground(Color.WHITE);

        p2_panel.setLayout(new GridLayout(1, 2));
        p2_panel.setBackground(new Color(64, 72, 80));

        p2_stat_panel.setBackground(new Color(64, 72, 80));
        p2_stat_panel.setLayout(new GridLayout(3, 1));
        p2_name.setFont(sizedFont.deriveFont(Font.BOLD, 30f));
        p2_name.setForeground(Color.WHITE);
        p2_hp.setFont(sizedFont.deriveFont(Font.BOLD, 20f));
        p2_hp.setForeground(Color.WHITE);
        p2_mp.setFont(sizedFont.deriveFont(Font.BOLD, 20f));
        p2_mp.setForeground(Color.WHITE);
        p2_speed.setFont(sizedFont.deriveFont(Font.BOLD, 20f));
        p2_speed.setForeground(Color.WHITE);

        monster_panel.setLayout(new GridLayout(2, 1));

        m1_panel.setLayout(new GridLayout(1, 2));
        m1_panel.setBackground(new Color(64, 72, 80));

        m1_stat_panel.setBackground(new Color(64, 72, 80));
        m1_stat_panel.setLayout(new GridLayout(2, 1));
        m1_name.setFont(sizedFont.deriveFont(Font.BOLD, 30f));
        m1_name.setForeground(Color.WHITE);
        m1_hp.setFont(sizedFont.deriveFont(Font.BOLD, 20f));
        m1_hp.setForeground(Color.WHITE);
        m1_speed.setFont(sizedFont.deriveFont(Font.BOLD, 20f));
        m1_speed.setForeground(Color.WHITE);

        m2_panel.setLayout(new GridLayout(1, 2));
        m2_panel.setBackground(new Color(64, 72, 80));

        m2_stat_panel.setBackground(new Color(64, 72, 80));
        m2_stat_panel.setLayout(new GridLayout(2, 1));
        m2_name.setFont(sizedFont.deriveFont(Font.BOLD, 30f));
        m2_name.setForeground(Color.WHITE);
        m2_hp.setFont(sizedFont.deriveFont(Font.BOLD, 20f));
        m2_hp.setForeground(Color.WHITE);
        m2_speed.setFont(sizedFont.deriveFont(Font.BOLD, 20f));
        m2_speed.setForeground(Color.WHITE);

        this.add(top_panel);
        this.add(bottom_panel);
        this.setBorder(BorderFactory.createEmptyBorder(-10, 0, 0, 0));

        bottom_panel.add(player_panel);
        bottom_panel.add(monster_panel);
        top_panel.setBorder(BorderFactory.createEmptyBorder(-5, 0, -5, 0));

        player_panel.add(p1_panel);
        player_panel.add(p2_panel);

        monster_panel.add(m1_panel);
        monster_panel.add(m2_panel);

        p1_panel.add(p1_name);
        p1_panel.add(p1_stat_panel);

        p1_stat_panel.add(p1_hp);
        p1_stat_panel.add(p1_mp);
        p1_stat_panel.add(p1_speed);

        p2_panel.add(p2_name);
        p2_panel.add(p2_stat_panel);

        p2_stat_panel.add(p2_hp);
        p2_stat_panel.add(p2_mp);
        p2_stat_panel.add(p2_speed);

        m1_panel.add(m1_name);
        m1_panel.add(m1_stat_panel);

        m1_stat_panel.add(m1_hp);
        m1_stat_panel.add(m1_speed);

        m2_panel.add(m2_name);
        m2_panel.add(m2_stat_panel);

        m2_stat_panel.add(m2_hp);
        m2_stat_panel.add(m2_speed);

    }

    public JPanel getTop_panel() {
        return top_panel;
    }

    public void setTop_panel(JPanel top_panel) {
        this.top_panel = top_panel;
    }

    @Override
    public Font getFont() {
        return font;
    }

    @Override
    public void setFont(Font font) {
        this.font = font;
    }

    public Font getSizedFont() {
        return sizedFont;
    }

    public void setSizedFont(Font sizedFont) {
        this.sizedFont = sizedFont;
    }

    public Font getCustomFont() {
        return customFont;
    }

    public void setCustomFont(Font customFont) {
        this.customFont = customFont;
    }

    public JPanel getBottom_panel() {
        return bottom_panel;
    }

    public void setBottom_panel(JPanel bottom_panel) {
        this.bottom_panel = bottom_panel;
    }

    public JPanel getP1_panel() {
        return p1_panel;
    }

    public void setP1_panel(JPanel p1_panel) {
        this.p1_panel = p1_panel;
    }

    public JPanel getP2_panel() {
        return p2_panel;
    }

    public void setP2_panel(JPanel p2_panel) {
        this.p2_panel = p2_panel;
    }

    public JPanel getM1_panel() {
        return m1_panel;
    }

    public void setM1_panel(JPanel m1_panel) {
        this.m1_panel = m1_panel;
    }

    public JPanel getM2_panel() {
        return m2_panel;
    }

    public void setM2_panel(JPanel m2_panel) {
        this.m2_panel = m2_panel;
    }
}
