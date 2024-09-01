package dev.savinda.view;

public interface IActionView {
    void render();

    void renderError(Exception e);
}
