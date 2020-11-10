package View;

import Controllers.InGameController;
import Controllers.MenuController;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.io.InputStream;

public class InGameButtonJPanel extends JPanel {

    private JPanel in_game_main_button_panel, empty_panel_bottom;
    private JPanel target_panel, text_button_panel;
    private static JButton text_button;
    private JButton button_attack, button_skill, button_defense, button_bag;
    private JButton c_target_button, m1_target_button, m2_target_button, back_button;

    private Icon bg;

    private CardLayout card_select;

    public Font font, sizedFont;
    private Font customFont;

    private Border border_white = new LineBorder(Color.WHITE, 4, true);
    private Border border_red = new LineBorder(new Color(255, 72, 59), 4, true);

    private Color button_select = new Color(120, 125, 129);

    private InGameController inGameController;

    public InGameButtonJPanel(InGameController igc){
        inGameController = igc;
        createComponents();
        setComponents();
    }

    private void createComponents(){

        in_game_main_button_panel = new JPanel();

        target_panel = new JPanel();

        text_button_panel = new JPanel();

        bg = new ImageIcon(getClass().getResource("img/text_click.png"));
        text_button = new JButton("", bg);

        button_attack = new JButton();
        button_skill = new JButton();
        button_defense = new JButton();
        button_bag = new JButton();

        c_target_button = new JButton();
        m1_target_button = new JButton();
        m2_target_button = new JButton();
        back_button = new JButton("Back");

        empty_panel_bottom = new JPanel();

        card_select = new CardLayout();

    }

    private void setComponents(){

        try {

            InputStream is = InGameJPanel.class.getResourceAsStream("Font/Retron2000.ttf");
            font = Font.createFont(Font.TRUETYPE_FONT, is);
            sizedFont = font.deriveFont(12f);

            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(font);

        } catch (Exception e){}

        this.setLayout(card_select);

        in_game_main_button_panel.setLayout(new GridLayout(2, 2));

        try {

            button_attack.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("img/b1.png"))));
            button_attack.setFocusable(false);
            button_attack.addMouseListener(inGameController);
            button_attack.addActionListener(inGameController);

            button_skill.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("img/b2.png"))));
            button_skill.setFocusable(false);
            button_skill.addMouseListener(inGameController);
            button_skill.addActionListener(inGameController);

            button_defense.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("img/b3.png"))));
            button_defense.setFocusable(false);
            button_defense.addMouseListener(inGameController);
            button_defense.addActionListener(inGameController);

            button_bag.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("img/b4.png"))));
            button_bag.setFocusable(false);
            button_bag.addMouseListener(inGameController);
            button_bag.addActionListener(inGameController);

        } catch (Exception e){}

        in_game_main_button_panel.add(button_attack);
        in_game_main_button_panel.add(button_skill);
        in_game_main_button_panel.add(button_defense);
        in_game_main_button_panel.add(button_bag);

        c_target_button.setBackground(button_select);
        c_target_button.setFont(sizedFont.deriveFont(Font.BOLD, 25f));
        c_target_button.setForeground(Color.WHITE);
        c_target_button.addMouseListener(inGameController);
        c_target_button.addActionListener(inGameController);

        m1_target_button.setBackground(button_select);
        m1_target_button.setFont(sizedFont.deriveFont(Font.BOLD, 25f));
        m1_target_button.setForeground(Color.WHITE);
        m1_target_button.addMouseListener(inGameController);
        m1_target_button.addActionListener(inGameController);

        m2_target_button.setBackground(button_select);
        m2_target_button.setFont(sizedFont.deriveFont(Font.BOLD, 25f));
        m2_target_button.setForeground(Color.WHITE);
        m2_target_button.addMouseListener(inGameController);
        m2_target_button.addActionListener(inGameController);

        back_button.setBackground(button_select);
        back_button.setFont(sizedFont.deriveFont(Font.BOLD, 25f));
        back_button.setForeground(Color.WHITE);
        back_button.addMouseListener(inGameController);
        back_button.addActionListener(inGameController);

        target_panel.setLayout(new GridLayout(2, 2));
        target_panel.add(back_button);
        target_panel.add(m1_target_button);
        target_panel.add(c_target_button);
        target_panel.add(m2_target_button);

        text_button_panel.setLayout(new BorderLayout());

        text_button.setBackground(button_select);
        text_button.setFont(sizedFont.deriveFont(Font.BOLD, 25f));
        text_button.setForeground(Color.WHITE);
        text_button.addMouseListener(inGameController);
        text_button.addActionListener(inGameController);
        text_button.setHorizontalTextPosition(JButton.CENTER);
        text_button.setVerticalTextPosition(JButton.CENTER);

        text_button_panel.add(text_button);

        empty_panel_bottom.setBackground(button_select);

        this.add("main_select", in_game_main_button_panel);
        this.add("target_select", target_panel);
        this.add("text_button", text_button_panel);
        this.add("empty", empty_panel_bottom);
        card_select.show(this, "main_select");

    }

    public CardLayout getCard_select() {
        return card_select;
    }

    public void setCard_select(CardLayout card_select) {
        this.card_select = card_select;
    }

    public static JButton getText_button() {
        return text_button;
    }

    public static void setText_button(JButton text_button) {
        InGameButtonJPanel.text_button = text_button;
    }

    public JButton getButton_attack() {
        return button_attack;
    }

    public void setButton_attack(JButton button_attack) {
        this.button_attack = button_attack;
    }

    public JButton getButton_skill() {
        return button_skill;
    }

    public void setButton_skill(JButton button_skill) {
        this.button_skill = button_skill;
    }

    public JButton getButton_defense() {
        return button_defense;
    }

    public void setButton_defense(JButton button_defense) {
        this.button_defense = button_defense;
    }

    public JButton getButton_bag() {
        return button_bag;
    }

    public void setButton_bag(JButton button_bag) {
        this.button_bag = button_bag;
    }

    public JButton getC_target_button() {
        return c_target_button;
    }

    public void setC_target_button(JButton c_target_button) {
        this.c_target_button = c_target_button;
    }

    public JButton getM1_target_button() {
        return m1_target_button;
    }

    public void setM1_target_button(JButton m1_target_button) {
        this.m1_target_button = m1_target_button;
    }

    public JButton getM2_target_button() {
        return m2_target_button;
    }

    public void setM2_target_button(JButton m2_target_button) {
        this.m2_target_button = m2_target_button;
    }

    public JButton getBack_button() {
        return back_button;
    }

    public void setBack_button(JButton back_button) {
        this.back_button = back_button;
    }

    public Border getBorder_white() {
        return border_white;
    }

    public void setBorder_white(Border border_white) {
        this.border_white = border_white;
    }

    public Border getBorder_red() {
        return border_red;
    }

    public void setBorder_red(Border border_red) {
        this.border_red = border_red;
    }
}
