package View;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.InputStream;

public class RangeCharacterSelectPanel extends JPanel {

    private JPanel top_panel, bottom_panel;
    private JPanel archer_button_panel, wizard_button_panel, elementalist_button_panel, cyborg_button_panel;
    private JButton archer_button, wizard_button, elementalist_button, cyborg_button;
    private JButton back_button, next_button;
    private JLabel text;

    private Image archer_pic, wizard_pic, elementalist_pic, cyborg_pic;

    public Font font, sizedFont;

    public RangeCharacterSelectPanel() {
        createComponents();
        setComponents();
    }

    public void createComponents(){

        top_panel = new JPanel();
        bottom_panel = new JPanel();

        archer_button_panel = new JPanel();
        wizard_button_panel = new JPanel();
        elementalist_button_panel = new JPanel();
        cyborg_button_panel = new JPanel();

        archer_button = new JButton("Archer");
        wizard_button = new JButton("Wizard");
        elementalist_button = new JButton("Elementalist");
        cyborg_button = new JButton("Cyborg");

        back_button = new JButton("<< Back");
        next_button = new JButton("Next >>");

        text = new JLabel("Select your range character");

        try {
            archer_pic = ImageIO.read(getClass().getResource("img/Character/Archer.png"));
            wizard_pic = ImageIO.read(getClass().getResource("img/Character/Wizard.png"));
            elementalist_pic = ImageIO.read(getClass().getResource("img/Character/Elementalist.png"));
            cyborg_pic = ImageIO.read(getClass().getResource("img/Character/Cyborg.png"));
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

        Image archer = archer_pic.getScaledInstance( 400, 400,  java.awt.Image.SCALE_SMOOTH );
        Image wizard = wizard_pic.getScaledInstance( 400, 400,  java.awt.Image.SCALE_SMOOTH );
        Image elementalist = elementalist_pic.getScaledInstance( 400, 400,  java.awt.Image.SCALE_SMOOTH );
        Image cyborg = cyborg_pic.getScaledInstance( 400, 400,  java.awt.Image.SCALE_SMOOTH );

        archer_button.setIcon(new ImageIcon(archer));
        archer_button.setVerticalTextPosition(SwingConstants.BOTTOM);
        archer_button.setHorizontalTextPosition(SwingConstants.CENTER);
        setButtonCharacter(archer_button);

        archer_button_panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 15));
        archer_button_panel.setLayout(new BorderLayout());
        archer_button_panel.setBackground(new Color(149, 69, 53));
        archer_button_panel.add(archer_button);

        wizard_button.setIcon(new ImageIcon(wizard));
        wizard_button.setVerticalTextPosition(SwingConstants.BOTTOM);
        wizard_button.setHorizontalTextPosition(SwingConstants.CENTER);
        setButtonCharacter(wizard_button);

        wizard_button_panel.setBorder(BorderFactory.createEmptyBorder(30, 15, 30, 15));
        wizard_button_panel.setLayout(new BorderLayout());
        wizard_button_panel.setBackground(new Color(149, 69, 53));
        wizard_button_panel.add(wizard_button);

        elementalist_button.setIcon(new ImageIcon(elementalist));
        elementalist_button.setVerticalTextPosition(SwingConstants.BOTTOM);
        elementalist_button.setHorizontalTextPosition(SwingConstants.CENTER);
        setButtonCharacter(elementalist_button);

        elementalist_button_panel.setBorder(BorderFactory.createEmptyBorder(30, 15, 30, 15));
        elementalist_button_panel.setLayout(new BorderLayout());
        elementalist_button_panel.setBackground(new Color(149, 69, 53));
        elementalist_button_panel.add(elementalist_button);

        cyborg_button.setIcon(new ImageIcon(cyborg));
        cyborg_button.setVerticalTextPosition(SwingConstants.BOTTOM);
        cyborg_button.setHorizontalTextPosition(SwingConstants.CENTER);
        setButtonCharacter(cyborg_button);

        cyborg_button_panel.setBorder(BorderFactory.createEmptyBorder(30, 15, 30, 30));
        cyborg_button_panel.setLayout(new BorderLayout());
        cyborg_button_panel.setBackground(new Color(149, 69, 53));
        cyborg_button_panel.add(cyborg_button);

        top_panel.setLayout(new GridLayout(1, 4));

        top_panel.add(archer_button_panel);
        top_panel.add(wizard_button_panel);
        top_panel.add(elementalist_button_panel);
        top_panel.add(cyborg_button_panel);

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

    public JButton getArcher_button() {
        return archer_button;
    }

    public void setArcher_button(JButton archer_button) {
        this.archer_button = archer_button;
    }

    public JButton getWizard_button() {
        return wizard_button;
    }

    public void setWizard_button(JButton wizard_button) {
        this.wizard_button = wizard_button;
    }

    public JButton getElementalist_button() {
        return elementalist_button;
    }

    public void setElementalist_button(JButton elementalist_button) {
        this.elementalist_button = elementalist_button;
    }

    public JButton getCyborg_button() {
        return cyborg_button;
    }

    public void setCyborg_button(JButton cyborg_button) {
        this.cyborg_button = cyborg_button;
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
