/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
/**
 *
 * @author Administrator
 */
public class Window implements ActionListener, MouseListener{
    
    private JFrame frame;
    private JButton b1;
    private JPanel top_panel, bottom_panel, card_bottom_panel, bottom_panel_2, in_game_panel, all_card_panel;
    
    //Set Attribute in Menu
    private JPanel menu_panel, menu_button_panel, empty_panel_top;
    private JButton menu_button_play;
            
    private CardLayout c1 = new CardLayout(), c_frame = new CardLayout();
    private boolean in_audition = false;
    
    final static String MENU = "MENU";
    final static String IN_GAME = "IN_GAME";
            
    public Window(int width, int height, String title, Run run) throws IOException {
        
        //set frame
        frame = new JFrame(title);
        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));
        
        all_card_panel = new JPanel();
        all_card_panel.setLayout(c_frame);
        
        empty_panel_top = new JPanel();
        empty_panel_top.setPreferredSize(new Dimension(1200, 100));
        //MENU PANEL
        menu_panel = new JPanel();
        menu_panel.setLayout(new BorderLayout());
        
        menu_button_panel = new JPanel();
        menu_button_panel.setLayout(new FlowLayout());
        
        menu_button_play = new JButton("Start");
        menu_button_play.addActionListener(this);
        menu_button_panel.add(menu_button_play);
        
        menu_panel.add(empty_panel_top, BorderLayout.NORTH);
        menu_panel.add(menu_button_panel, BorderLayout.CENTER);
        
        //IN-GAME PANEL
        in_game_panel = new JPanel();
        in_game_panel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        
        top_panel = new JPanel();
        bottom_panel = new JPanel();
        bottom_panel.setLayout(new GridLayout(1, 3));
        bottom_panel.setPreferredSize(new Dimension(1200, 195));
        
        card_bottom_panel = new JPanel();
        card_bottom_panel.setLayout(c1);
        card_bottom_panel.setPreferredSize(new Dimension(1200, 195));
        
        JPanel button_panel = new JPanel();
        button_panel.setLayout(new GridLayout(2, 2));
        
        bottom_panel_2 = new JPanel();
        bottom_panel_2.setLayout(new GridLayout(1, 3));
        bottom_panel_2.setPreferredSize(new Dimension(1200, 195));
        
        //Empty (hp) Panel;
        JPanel player_hp_panel = new JPanel();
        JPanel mon_hp_panel = new JPanel();
        player_hp_panel.setBackground(new Color(64,72,80));
        mon_hp_panel.setBackground(new Color(64,72,80));
        bottom_panel.add(player_hp_panel);
        bottom_panel.add(mon_hp_panel);

        b1 = new JButton();
        b1.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("img/b1.png"))));
        b1.addMouseListener(this);
        b1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Audition.setIs_show(true);
                Audition.setTime_run(true);
                run.start = System.nanoTime();
                //c1.show(card_bottom_panel, "b");
                run.is_ran[0] = 1;
            }
        });
        b1.setFocusable(false);
        JButton b2 = new JButton();
        b2.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("img/b2.png"))));
        b2.setFocusable(false);
        JButton b3 = new JButton();
        b3.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("img/b3.png"))));
        b3.setFocusable(false);
        JButton b4 = new JButton();
        b4.setIcon(new ImageIcon(ImageIO.read(getClass().getResource("img/b4.png"))));
        b4.setFocusable(false);
        
        button_panel.add(b1);
        button_panel.add(b2);
        button_panel.add(b3);
        button_panel.add(b4);
        bottom_panel.add(button_panel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        
        top_panel.add(run);
        top_panel.setBorder( BorderFactory.createEmptyBorder(-5, -5, -5, 0) );
        in_game_panel.add(top_panel);
        card_bottom_panel.add("a", bottom_panel);
        card_bottom_panel.add("b", bottom_panel_2);
        c1.show(card_bottom_panel, "a");
        in_game_panel.add(card_bottom_panel);
        
        all_card_panel.add(in_game_panel, IN_GAME);
        all_card_panel.add(menu_panel, MENU);
        c_frame.show(all_card_panel, MENU);
        
        frame.add(all_card_panel);
        
        frame.setVisible(true);
        run.start();
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
      
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(menu_button_play)) {//กดเริ่มเกมใหม่
            c_frame.show(all_card_panel, IN_GAME);
            frame.requestFocusInWindow();
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
}
