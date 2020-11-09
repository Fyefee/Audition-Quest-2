package project;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URISyntaxException;
import javax.swing.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import java.util.Timer;
import java.util.TimerTask;

public class Run extends JPanel implements Runnable{

    private Thread th;
    private boolean running = false, is_press = true;
    private int click = 0;
    private static int max_time;

    //public static Character c1 = new Knight();
    //public static Character c2 = new Archer();
    //public static Character m1 = new Slime(1);
    //public static Character m2 = new Slime(2);
    public static Audition audition = new Audition();
    public Background bg = new Background();

    public Timer timer;
    private int nano = 1000000000, msp1 = 10000000;
    public static long start = System.nanoTime(), now;

    public Run() throws IOException, FontFormatException {
        new Window(1205, 759, "Kuy", this);
        addKeyListener(new KeyInner());
        setFocusable(true);
        requestFocus();
    }

    public synchronized void start(){
        th = new Thread(this);
        th.start();
        running = true;
    }

    public synchronized void stop(){
        try{
            running = false;
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public void run() {
        while (running) {
            if((System.nanoTime() - start) % msp1 == 0){
                repaint();
                requestFocusInWindow();
            }
        }
        stop();
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        bg.draw(g);
        c1.draw(g);
        c2.draw(g);
        m1.draw(g);
        m2.draw(g);
        audition.draw(g, max_time, (int)((System.nanoTime() - start) / msp1));
        Audition.setPress_button(0);

        g.dispose();

    }

    @Override
        public Dimension getPreferredSize() {
            return new Dimension(1200,520);
        }

    public void actionPerformed(ActionEvent e) {
    }

    public void mouseExited(MouseEvent me) {
    }


    public static void main(String[] args) throws IOException, FontFormatException {
        new Run();
    }
    class KeyInner implements KeyListener {
        @Override
        public void keyTyped(KeyEvent ke) {}

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_UP && is_press) {
                Audition.setPress_button(1);
                is_press = false;
            } else if (e.getKeyCode() == KeyEvent.VK_DOWN && is_press) {
                Audition.setPress_button(2);
                is_press = false;
            } else if (e.getKeyCode() == KeyEvent.VK_LEFT && is_press) {
                Audition.setPress_button(3);
                is_press = false;
            } else if (e.getKeyCode() == KeyEvent.VK_RIGHT && is_press) {
                Audition.setPress_button(4);
                is_press = false;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch( keyCode ) {
                case KeyEvent.VK_UP:
                    is_press = true;
                    break;
                case KeyEvent.VK_DOWN:
                    is_press = true;
                    break;
                case KeyEvent.VK_LEFT:
                    is_press = true;
                    break;
                case KeyEvent.VK_RIGHT :
                    is_press = true;
                    break;
            }
        }
    }

    public static int getMax_time() {
        return max_time;
    }

    public static void setMax_time(int max_time) {
        Run.max_time = max_time;
    }

}
