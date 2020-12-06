package Controllers;

import View.MainJFrame;
import View.MeleeCharacterSelectPanel;

public class MainJFrameController {

    private static MainJFrame mainJFrame;
    private static MenuController menuController;
    private static InGameController inGameController;
    private static SelectCharacterController selectCharacterController;

    private Thread th;

    public MainJFrameController() {
        createComponents();
        setComponentstoView();
        mainJFrame.createAndShowGUI(1200, 748);
    }

    public void createComponents(){

        mainJFrame = new MainJFrame();

        menuController = new MenuController();

        inGameController = new InGameController();

        selectCharacterController = new SelectCharacterController();

        th = new Thread(inGameController);
        th.start();
    }

    public void setComponentstoView(){
        mainJFrame.getAll_card_panel().add(menuController.getMenuJPanel(), "MENU");
        mainJFrame.getAll_card_panel().add(inGameController.getInGameJPanel(), "GAME");
        mainJFrame.getAll_card_panel().add(inGameController.getStageJPanel(), "STAGE");
        mainJFrame.getAll_card_panel().add(selectCharacterController.getMeleeCharacterSelectPanel(), "SELECT_MELEE");

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
