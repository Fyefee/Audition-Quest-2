package View;

import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;

public class ItemGUI extends JFrame{

    private JPanel panel, all_panel;
    private JButton item1_button, item2_button, item3_button;
    private JLabel head, space1, space2;
    public Image bg;

    public ItemGUI() {
        createComponents();
        setComponents();
    }

    public void createComponents(){

        all_panel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(bg, 0, 0, null);
            };
        };

        panel = new JPanel();

        head = new JLabel("Choose Your Item");
        space1 = new JLabel(" ");
        space2 = new JLabel(" ");

        item1_button = new JButton();
        item2_button = new JButton();
        item3_button = new JButton();

        bg = new ImageIcon(getClass().getResource("img/bg_item_room.png")).getImage();
    }

    public void setComponents(){

        head.setPreferredSize(new Dimension(100, 40));

        item1_button.setPreferredSize(new Dimension(170, 300));
        item1_button.setFocusable(false);
        item1_button.setFocusPainted(false);
        item1_button.setBorderPainted(false);
        item1_button.setContentAreaFilled(false);
        item1_button.setRolloverEnabled(false);
        item1_button.setBorder(null);

        item2_button.setPreferredSize(new Dimension(170, 300));
        item2_button.setFocusable(false);
        item2_button.setBorderPainted(false);
        item2_button.setContentAreaFilled(false);
        item2_button.setRolloverEnabled(false);
        item2_button.setFocusPainted(false);

        item3_button.setPreferredSize(new Dimension(170, 300));
        item3_button.setFocusable(false);
        item3_button.setBorderPainted(false);
        item3_button.setContentAreaFilled(false);
        item3_button.setRolloverEnabled(false);
        item3_button.setFocusPainted(false);

        try {
            item1_button.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("img/card.png"))));
            item2_button.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("img/card.png"))));
            item3_button.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("img/card.png"))));
        } catch (Exception ex) {
            System.out.println(ex+ "KUY");
        }

        panel.setLayout(new FlowLayout());
        panel.add(item1_button);
        panel.add(space1);
        panel.add(item2_button);
        panel.add(space2);
        panel.add(item3_button);
        panel.setBackground(new Color(0,0,0,0));

        //this.add(head);
        all_panel.add(head, BorderLayout.NORTH);
        all_panel.add(panel, BorderLayout.CENTER);
        this.add(all_panel);
        this.setSize(650, 450);
        this.setResizable(false);
        //this.setVisible(true);

    }

    public JButton getItem1_button() {
        return item1_button;
    }

    public void setItem1_button(JButton item1_button) {
        this.item1_button = item1_button;
    }

    public JButton getItem2_button() {
        return item2_button;
    }

    public void setItem2_button(JButton item2_button) {
        this.item2_button = item2_button;
    }

    public JButton getItem3_button() {
        return item3_button;
    }

    public void setItem3_button(JButton item3_button) {
        this.item3_button = item3_button;
    }


}
