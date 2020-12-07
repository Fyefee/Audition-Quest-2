package View;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.InputStream;

public class MeleeCharacterSelectPanel extends JPanel {

    private JPanel top_panel, bottom_panel;
    private JPanel knight_button_panel, duelist_button_panel, berserker_button_panel, druid_button_panel;
    private JButton knight_button, duelist_button, berserker_button, druid_button;
    private JButton back_button, next_button;
    private JLabel text;

    private Image knight_pic, duelist_pic, berserker_pic, druid_pic;

    public Font font, sizedFont;

    public MeleeCharacterSelectPanel() {
        createComponents();
        setComponents();
    }

    public void createComponents(){

        top_panel = new JPanel();
        bottom_panel = new JPanel();

        knight_button_panel = new JPanel();
        duelist_button_panel = new JPanel();
        berserker_button_panel = new JPanel();
        druid_button_panel = new JPanel();

        knight_button = new JButton("Knight");
        duelist_button = new JButton("Duelist");
        berserker_button = new JButton("Berserker");
        druid_button = new JButton("Druid");

        back_button = new JButton("<< Back");
        next_button = new JButton("Next >>");

        text = new JLabel("Select your melee character");

        try {
            knight_pic = ImageIO.read(getClass().getResource("img/Character/Knight.png"));
            duelist_pic = ImageIO.read(getClass().getResource("img/Character/Duelist.png"));
            berserker_pic = ImageIO.read(getClass().getResource("img/Character/Berserker.png"));
            druid_pic = ImageIO.read(getClass().getResource("img/Character/Druid.png"));
        } catch (Exception e){
            System.out.println(e);
        }

    }

    public void setComponents(){

        try {
            InputStream is = InGameJPanel.class.getResourceAsStream("Font/Retron2000.ttf");
            font = Font.createFont(Font.TRUETYPE_FONT, is);
            sizedFont = font.deriveFont(12f);

            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(font);

        } catch (Exception e){}

        Image knight = knight_pic.getScaledInstance( 400, 400,  java.awt.Image.SCALE_SMOOTH );
        Image duelist = duelist_pic.getScaledInstance( 400, 400,  java.awt.Image.SCALE_SMOOTH );
        Image berserker = berserker_pic.getScaledInstance( 400, 400,  java.awt.Image.SCALE_SMOOTH );
        Image druid = druid_pic.getScaledInstance( 400, 400,  java.awt.Image.SCALE_SMOOTH );

        knight_button.setIcon(new ImageIcon(knight));
        knight_button.setVerticalTextPosition(SwingConstants.BOTTOM);
        knight_button.setHorizontalTextPosition(SwingConstants.CENTER);
        setButtonCharacter(knight_button);

        knight_button_panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 15));
        knight_button_panel.setLayout(new BorderLayout());
        knight_button_panel.setBackground(new Color(149, 69, 53));
        knight_button_panel.add(knight_button);

        duelist_button.setIcon(new ImageIcon(duelist));
        duelist_button.setVerticalTextPosition(SwingConstants.BOTTOM);
        duelist_button.setHorizontalTextPosition(SwingConstants.CENTER);
        setButtonCharacter(duelist_button);

        duelist_button_panel.setBorder(BorderFactory.createEmptyBorder(30, 15, 30, 15));
        duelist_button_panel.setLayout(new BorderLayout());
        duelist_button_panel.setBackground(new Color(149, 69, 53));
        duelist_button_panel.add(duelist_button);

        berserker_button.setIcon(new ImageIcon(berserker));
        berserker_button.setVerticalTextPosition(SwingConstants.BOTTOM);
        berserker_button.setHorizontalTextPosition(SwingConstants.CENTER);
        setButtonCharacter(berserker_button);

        berserker_button_panel.setBorder(BorderFactory.createEmptyBorder(30, 15, 30, 15));
        berserker_button_panel.setLayout(new BorderLayout());
        berserker_button_panel.setBackground(new Color(149, 69, 53));
        berserker_button_panel.add(berserker_button);

        druid_button.setIcon(new ImageIcon(druid));
        druid_button.setVerticalTextPosition(SwingConstants.BOTTOM);
        druid_button.setHorizontalTextPosition(SwingConstants.CENTER);
        setButtonCharacter(druid_button);

        druid_button_panel.setBorder(BorderFactory.createEmptyBorder(30, 15, 30, 30));
        druid_button_panel.setLayout(new BorderLayout());
        druid_button_panel.setBackground(new Color(149, 69, 53));
        druid_button_panel.add(druid_button);

        top_panel.setLayout(new GridLayout(1, 4));

        top_panel.add(knight_button_panel);
        top_panel.add(duelist_button_panel);
        top_panel.add(berserker_button_panel);
        top_panel.add(druid_button_panel);

        setButtonNextBack(back_button);
        setButtonNextBack(next_button);

        text.setFont(sizedFont.deriveFont(Font.BOLD, 40f));
        text.setForeground(Color.WHITE);
        text.setBorder(BorderFactory.createEmptyBorder(0, 60, 12, 0));

        bottom_panel.setLayout(new BorderLayout());
        bottom_panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        bottom_panel.setPreferredSize(new Dimension(1200, 60));
        bottom_panel.setBackground(new Color(149, 69, 53));

        bottom_panel.add(back_button, BorderLayout.WEST);
        bottom_panel.add(next_button, BorderLayout.EAST);
        bottom_panel.add(text);

        this.setLayout(new BorderLayout());
        this.add(top_panel);
        this.add(bottom_panel, BorderLayout.SOUTH);

    }

    public void setButtonNextBack(JButton b){
        b.setFont(sizedFont.deriveFont(Font.BOLD, 30f));
        b.setContentAreaFilled(false);
        b.setForeground(Color.WHITE);
        b.setFocusPainted(false);
        b.setFocusable(false);
        b.setRolloverEnabled(false);
        b.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(5, 5, 5, 5),
                BorderFactory.createEmptyBorder(5, 5, 10, 10)));
    }

    public void setButtonCharacter(JButton b){
        b.setFont(sizedFont.deriveFont(Font.BOLD, 35f));
        b.setForeground(Color.WHITE);
        b.setFocusPainted(false);
        b.setContentAreaFilled(false);
        b.setRolloverEnabled(false);
        b.setBorder(null);
    }

    public JButton getKnight_button() {
        return knight_button;
    }

    public void setKnight_button(JButton knight_button) {
        this.knight_button = knight_button;
    }

    public JButton getDuelist_button() {
        return duelist_button;
    }

    public void setDuelist_button(JButton duelist_button) {
        this.duelist_button = duelist_button;
    }

    public JButton getBerserker_button() {
        return berserker_button;
    }

    public void setBerserker_button(JButton berserker_button) {
        this.berserker_button = berserker_button;
    }

    public JButton getDruid_button() {
        return druid_button;
    }

    public void setDruid_button(JButton druid_button) {
        this.druid_button = druid_button;
    }

    public JButton getBack_button() {
        return back_button;
    }

    public void setBack_button(JButton back_button) {
        this.back_button = back_button;
    }

    public JButton getNext_button() {
        return next_button;
    }

    public void setNext_button(JButton next_button) {
        this.next_button = next_button;
    }
}
