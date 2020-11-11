package Controllers;

import View.MainJFrame;

public class MainJFrameController {

    private static MainJFrame mainJFrame;
    private static MenuController menuController;
    private static InGameController inGameController;

    public MainJFrameController() {
        createComponents();
        setComponentstoView();
        mainJFrame.createAndShowGUI(1200, 748);
    }

    public void createComponents(){

        mainJFrame = new MainJFrame();

        menuController = new MenuController();

        inGameController = new InGameController();

    }

    public void setComponentstoView(){
        mainJFrame.getAll_card_panel().add(menuController.getMenuJPanel(), "MENU");
        mainJFrame.getAll_card_panel().add(inGameController.getInGameJPanel(), "GAME");
    }

    public static MainJFrame getMainJFrame() {
        return mainJFrame;
    }

    public static void setMainJFrame(MainJFrame mainJFrame) {
        MainJFrameController.mainJFrame = mainJFrame;
    }

    public static MenuController getMenuController() {
        return menuController;
    }

    public static void setMenuController(MenuController menuController) {
        MainJFrameController.menuController = menuController;
    }

    public static InGameController getInGameController() {
        return inGameController;
    }

    public static void setInGameController(InGameController inGameController) {
        MainJFrameController.inGameController = inGameController;
    }
}
