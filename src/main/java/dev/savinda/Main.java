package dev.savinda;

import dev.savinda.controller.Controller;
import dev.savinda.model.ViewTextColor;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        Controller controller = new Controller();

        while (true) {
            try {
                controller.render();
                String input = reader.readLine();
                if (input.equalsIgnoreCase("exit")) {
                    break;
                }
                if (input.equalsIgnoreCase("back")) {
                    controller.mainMenu();
                    continue;
                }
                controller.execute(input);
            } catch (Exception e) {
                System.out.printf("%sError: %s%s\n", ViewTextColor.RED, e.getMessage(), ViewTextColor.RESET);
            }
        }
    }
}