package View;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.InputStream;

public class StageJPanel extends JPanel {

    private JLabel stage_label;
    private JPanel top_panel, mid_panel, bottom_panel;
    private JButton next_stage_button;

    public Font font, sizedFont;

    public StageJPanel(){
        createComponents();
        setComponents();
    }

    public void createComponents(){

        stage_label = new JLabel();

        top_panel = new JPanel();
        bottom_panel = new JPanel();

        next_stage_button = new JButton("Next Stage >");

    }

    public void setComponents(){

        try {

            InputStream is = InGameJPanel.class.getResourceAsStream("Font/Retron2000.ttf");
            font = Font.createFont(Font.TRUETYPE_FONT, is);
            sizedFont = font.deriveFont(12f);

            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(font);

        } catch (Exception e){}

        stage_label.setFont(sizedFont.deriveFont(Font.BOLD, 80));
        stage_label.setForeground(new Color(255, 255, 255));
        stage_label.setHorizontalTextPosition(JButton.CENTER);
        stage_label.setVerticalTextPosition(JButton.BOTTOM);

        top_panel.setLayout(new FlowLayout());
        top_panel.setBackground(new Color(0, 0, 0));
        top_panel.setBorder(BorderFactory.createEmptyBorder(200, 0, 0, 0));
        top_panel.add(stage_label);

        next_stage_button.setBackground(new Color(0, 0, 0));
        next_stage_button.setFont(sizedFont.deriveFont(Font.BOLD, 40f));
        next_stage_button.setForeground(Color.WHITE);
        next_stage_button.setFocusPainted(false);
        next_stage_button.setFocusable(false);
        next_stage_button.setBorderPainted(false);
        next_stage_button.setRolloverEnabled(false);

        bottom_panel.setLayout(new FlowLayout());
        bottom_panel.setBackground(new Color(0, 0, 0));
        bottom_panel.add(next_stage_button);

        this.add(top_panel);
        this.add(bottom_panel);
        this.setLayout(new GridLayout(2,1));

    }

    public JLabel getStage_label() {
        return stage_label;
    }

    public void setStage_label(JLabel stage_label) {
        this.stage_label = stage_label;
    }

    public JButton getNext_stage_button() {
        return next_stage_button;
    }

    public void setNext_stage_button(JButton next_stage_button) {
        this.next_stage_button = next_stage_button;
    }
}
