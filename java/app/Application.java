package app;

import controller.MenuController;

public class Application {
    public static void main(String[] args) {
        MenuController controller = new MenuController();
        controller.start();
    }
}
