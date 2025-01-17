package dev.savinda.controller;

import dev.savinda.controller.impl.CalculateCreditController;
import dev.savinda.controller.impl.MainMenuController;

import java.util.List;

public class Controller {
    protected IMenuController currentMenu = new MainMenuController();

    public void mainMenu() {
        this.currentMenu = new MainMenuController();
    }

    public void render() {
        this.currentMenu.render();
    }

    public void execute(String input) {
        if (currentMenu instanceof MainMenuController) {
            switch (input) {
                case "1":
                    this.currentMenu = new CalculateCreditController();
                    return;
                case "2":
                    System.exit(0);
                default:
                    System.out.println("Invalid input. Please try again.");
                    return;
            }
        }
        boolean result = this.currentMenu.execute(input);
        if (!result) {
            mainMenu();
        }
    }

    public void fromArray(List<String> args) {
        if (args.size() != 6) {
           throw new IllegalArgumentException("Invalid number of arguments");
        }

        IMenuController controller = new CalculateCreditController();
        for (String arg : args) {
            controller.execute(arg);
        }
    }
}
