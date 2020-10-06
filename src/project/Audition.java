/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;
import javax.swing.*;

/**
 *
 * @author Administrator
 */
public class Audition extends JPanel{
    
    Image arrow_up, arrow_down, arrow_left, arrow_right, empty, wrong;
    private int x , y, state, width;
    private int[] random;
    private static boolean is_show = false, time_run = false;
    
    public Audition(){
        arrow_up = new ImageIcon(getClass().getResource("img/arrow/arrow_up.png")).getImage();
        arrow_down = new ImageIcon(getClass().getResource("img/arrow/arrow_down.png")).getImage();
        arrow_left = new ImageIcon(getClass().getResource("img/arrow/arrow_left.png")).getImage();
        arrow_right = new ImageIcon(getClass().getResource("img/arrow/arrow_right.png")).getImage();
        empty = new ImageIcon(getClass().getResource("img/empty.png")).getImage();
        wrong = new ImageIcon(getClass().getResource("img/x.png")).getImage();
    }
    
    public static int[] addX(int n, int arr[], int x) 
    { 
        int i; 
        int newarr[] = new int[n + 1]; 
  
        for (i = 0; i < n; i++) 
            newarr[i] = arr[i]; 
  
        newarr[n] = x; 
  
        return newarr; 
    } 
    
    public int[] draw(Graphics g, int[] is_ran, int max_time, int now_time) {
        x = 100;
        y = 100;
        if (is_ran[0] == 1){
            for (int i = 0; i < 10; i++){
                int rand = (int)(Math.random() * 4) + 1;
                random = addX(i, random, rand);
            }
            state = 0;
            System.out.println(Arrays.toString(random));
        }
        
        if (time_run && random[state] == is_ran[1]){
            random[state] = 0;
            if (state <= 9){
                state++;
            }
            else{
                
            }
            System.out.println(Arrays.toString(random));
        }
        else if (time_run && (random[state] != is_ran[1] && is_ran[1] != 0)){
            random[state] = 5;
            is_ran[1] = 0;
            if (state <= 9){
                state++;
            }
        }
        
        if (state > 9){
            time_run = false;            
        }
        
        if (is_show){
            g.setColor(new Color(120,120,120));
            g.fillRect(100, 100, 1000, 100);
            
            g.setColor(new Color(0,255,0));
            if (now_time >= max_time){
                time_run = false;
                width = 0;
            }
            else if(!time_run){
                width = width;
            }
            else{
                width = (int) (1000 - (1000 * (((double)now_time) / ((double)max_time))));
            }
            g.fillRect(100, 200, width, 10);
            for (int i = 0; i < random.length; i++){
                switch (random[i]){ 
                    case 0: g.drawImage(empty, x, y, 100, 100, this); break;
                    case 1: g.drawImage(arrow_up, x, y, 100, 100, this); break;
                    case 2: g.drawImage(arrow_down, x, y, 100, 100, this); break;
                    case 3: g.drawImage(arrow_left, x, y, 100, 100, this); break;
                    case 4: g.drawImage(arrow_right, x, y, 100, 100, this); break;
                    case 5: g.drawImage(wrong, x, y, 100, 100, this); break;
                    default: break;
                }
                x += 100;
            }
        }
        
        is_ran[1] = 0;
        return is_ran;
    }

    public static void setIs_show(boolean is_show) {
        Audition.is_show = is_show;
    }

    public static void setTime_run(boolean time_run) {
        Audition.time_run = time_run;
    }
    
}
