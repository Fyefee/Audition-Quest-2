package View;

import Controllers.InGameController;
import Controllers.MenuController;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.io.InputStream;

public class InGameJPanel extends JPanel {

    private JPanel top_panel, bottom_panel;

    private JPanel player_panel, monster_panel;

    private JPanel p1_stat_panel, p2_stat_panel, p1_panel, p2_panel;
    private static JLabel p1_name, p2_name, p1_hp, p2_hp, p1_mp, p2_mp, p1_speed, p2_speed;
    private JPanel m1_stat_panel, m2_stat_panel, m1_panel, m2_panel;
    private static JLabel m1_name, m2_name, m1_hp, m2_hp, m1_speed, m2_speed;

    private JPanel card_bottom_panel, in_game_main_button_panel, empty_panel_bottom;
    private JPanel target_panel, text_button_panel;
    private static JButton text_button;
    private JButton button_attack, button_skill, button_defense, button_bag;
    private JButton c_target_button, m1_target_button, m2_target_button, back_button;

    private CardLayout card_select;

    private Icon bg;

    public Font font, sizedFont;
    private Font customFont;

    private Border border_white = new LineBorder(Color.WHITE, 4, true);
    private Border border_red = new LineBorder(new Color(255, 72, 59), 4, true);

    private Color button_select = new Color(120, 125, 129);

    private InGameController igc;

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

        p1_name = new JLabel(InGameController.getC1().getName(), SwingConstants.CENTER);
        p2_name = new JLabel(InGameController.getC2().getName(), SwingConstants.CENTER);

        p1_stat_panel = new JPanel();
        p1_hp = new JLabel("HP : " + InGameController.getC1().getHp() + "/" + InGameController.getC1().getMax_hp(), SwingConstants.CENTER);
        p1_mp = new JLabel("MP : " + InGameController.getC1().getMp() + "/" + InGameController.getC1().getMax_mp(), SwingConstants.CENTER);
        p1_speed = new JLabel("Speed : " + InGameController.getC1().getSpeed(), SwingConstants.CENTER);

        p2_stat_panel = new JPanel();
        p2_hp = new JLabel("HP : " + InGameController.getC2().getHp() + "/" + InGameController.getC2().getMax_hp(), SwingConstants.CENTER);
        p2_mp = new JLabel("MP : " + InGameController.getC2().getMp() + "/" + InGameController.getC2().getMax_mp(), SwingConstants.CENTER);
        p2_speed = new JLabel("Speed : " + InGameController.getC2().getSpeed(), SwingConstants.CENTER);

        m1_panel = new JPanel();
        m2_panel = new JPanel();

        m1_name = new JLabel(InGameController.getM1().getName(), SwingConstants.CENTER);
        m2_name = new JLabel(InGameController.getM2().getName(), SwingConstants.CENTER);

        m1_stat_panel = new JPanel();
        m1_hp = new JLabel("HP : " + InGameController.getM1().getHp() + "/" + InGameController.getM1().getMax_hp(), SwingConstants.CENTER);
        m1_speed = new JLabel("Speed : " + InGameController.getM1().getSpeed(), SwingConstants.CENTER);

        m2_stat_panel = new JPanel();
        m2_hp = new JLabel("HP : " + InGameController.getM2().getHp() + "/" + InGameController.getM2().getMax_hp(), SwingConstants.CENTER);
        m2_speed = new JLabel("Speed : " + InGameController.getM2().getSpeed(), SwingConstants.CENTER);

        card_select = new CardLayout();
        card_bottom_panel = new JPanel();
        in_game_main_button_panel = new JPanel();

        button_attack = new JButton();
        button_skill = new JButton();
        button_defense = new JButton();
        button_bag = new JButton();

        c_target_button = new JButton();
        m1_target_button = new JButton();
        m2_target_button = new JButton();
        back_button = new JButton("Back");

        target_panel = new JPanel();

        bg = new ImageIcon(getClass().getResource("img/text_click.png"));
        text_button = new JButton("", bg);

        empty_panel_bottom = new JPanel();

    }

    private void setComponents(){

        try {

            InputStream is = InGameJPanel.class.getResourceAsStream("Font/Retron2000.ttf");
            font = Font.createFont(Font.TRUETYPE_FONT, is);
            sizedFont = font.deriveFont(12f);

            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(font);

        } catch (Exception e){}

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

        bottom_panel.add(player_panel);
        bottom_panel.add(monster_panel);

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

}
