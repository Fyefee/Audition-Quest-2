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
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import java.util.Timer;
import java.util.TimerTask;

public class Run extends JPanel implements Runnable{

    private Thread th;
    private boolean running = false, is_press = true;
    public int[] is_ran = {1, 0};
    private int click = 0;
    
    Character c1 = new Knight();
    Character c2 = new Knight();
    Audition audition = new Audition();
    Background bg = new Background();
    
    public Timer timer;
    private int nano = 1000000000, msp1 = 10000000;
    public long start = System.nanoTime(), now;

    public Run() throws IOException {
        System.out.println("ดีจ้า");
        new Window(1200, 750, "Kuy", this);
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
            th.join();
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
        c1.draw(g, 300);
        c2.draw(g, 100);
        is_ran = audition.draw(g, is_ran, 1000, (int)((System.nanoTime() - start) / msp1));
        is_ran[0] = 0;
        
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

    
    public static void main(String[] args) throws IOException {
        new Run();
    }
    class KeyInner implements KeyListener {
        @Override
        public void keyTyped(KeyEvent ke) {}

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_UP && is_press) {
                System.out.println("up"); 
                is_ran[1] = 1;
                is_press = false;
            } else if (e.getKeyCode() == KeyEvent.VK_DOWN && is_press) {
                System.out.println("down"); 
                is_ran[1] = 2;
                is_press = false;   
            } else if (e.getKeyCode() == KeyEvent.VK_LEFT && is_press) {
                System.out.println("left"); 
                is_ran[1] = 3;
                is_press = false;  
            } else if (e.getKeyCode() == KeyEvent.VK_RIGHT && is_press) {
                System.out.println("right"); 
                is_ran[1] = 4;
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
   
}
