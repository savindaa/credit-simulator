package dev.savinda.controller.impl;

import dev.savinda.controller.IMenuController;
import dev.savinda.view.IActionView;
import dev.savinda.view.impl.MainMenuView;

public class MainMenuController implements IMenuController {
    @Override
    public void render() {
        IActionView view = new MainMenuView();
        view.render();
    }

    @Override
    public boolean execute(String input) {
        return true;
    }
}
