package Main;

import View.MainJFrame;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        try{
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {}
        MainJFrame.createAndShowGUI(1200, 732);
    }

}
