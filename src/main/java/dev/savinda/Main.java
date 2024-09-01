package dev.savinda;

import dev.savinda.controller.Controller;
import dev.savinda.model.ViewTextColor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        if (args.length > 0) {
            readFile(args);
            return;
        }

        startConsoleApp();
    }

    static void startConsoleApp() {
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

    static void readFile(String[] args) {
        Controller controller = new Controller();

        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                controller.fromArray(Arrays.asList(values));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}